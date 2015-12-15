/*
 * #%L
 * World Domination fantasy door game.
 * %%
 * Copyright (C) 2008 - 2015 Curtis Rueden
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */
package net.restlesscoder.worlddom.server;

import net.restlesscoder.worlddom.game.Game;
import net.restlesscoder.worlddom.game.Person;

/** The server that manages the running instance of the game. */
public class GameServer {

  // -- Constants --

  public static final String GAME_FILE = "game.xml";

  private static final int MAX_CLIENTS = 10000;

  // -- Fields --

  /** Helper class for saving and restoring game state. */
  private GameSaver saver;

  /** Root game state object. */
  private Game game;

  /** Clients table. */
  private ClientConnection[] clients;

  /** Data protocols defining how clients can connect to the server. */
  private DataProtocol[] protocols;

  /** Threads that wait for incoming connections according to each protocol. */
  private Thread[] protoThreads;

  // -- Constructor --

  public GameServer() {
    saver = new GameSaver();

    // load game state
    System.out.println("Loading game state...");
    game = saver.restoreState(GAME_FILE);

    // spin threads
    clients = new ClientConnection[MAX_CLIENTS];
    protocols = new DataProtocol[] {
      new SocketProtocol(7654)
    };
    // each protocol has a thread dedicated to listening for new connections
    protoThreads = new Thread[protocols.length];
    for (int i=0; i<protocols.length; i++) {
      protoThreads[i] = new ProtocolThread(this, protocols[i]);
      protoThreads[i].start();
    }
    System.out.println("Game server is up and running.");
  }

  // -- GameServer API methods --

  /** Informs the server of a new client connection. */
  public int addClient(DataProtocol protocol, Object handle) {
    synchronized (clients) {
      int id = -1;
      for (int i=0; i<MAX_CLIENTS; i++) {
        if (clients[i] == null) {
          id = i;
          break;
        }
      }
      if (id < 0) {
        System.out.println("Too many connections");
        return -1;
      }
      else {
        // create client connection, add to clients table, and listen for data
        ClientConnection conn =
          new ClientConnection(this, id, protocol, handle);
        clients[id] = conn;
        conn.start();
        return id;
      }
    }
  }

  /** Informs teh server of a client disconnected. */
  public void removeClient(int id) {
    synchronized (clients) {
      clients[id] = null;
    }
  }

  /** Sets the active module for the given client. */
  public synchronized void setModule(int id, Module module) {
    synchronized (clients) {
      clients[id].activate(module);
    }
  }

  /** Responds to input from a particular client. */
  public void input(int clientId, String input) {
    synchronized (clients) {
      // delegate input handling to the client's active module instance
      clients[clientId].module.receiveInput(input);
    }
  }

  /** Sends output to a particular client. */
  public void output(int clientId, String output) {
    synchronized (clients) {
      clients[clientId].send(output);
    }
  }

  /** Gets the root game state object. */
  public Game getGame() { return game; }

  /** Called by the Login module to set the PC for the given client ID. */
  public void setCharacter(int clientId, Person p) {
    synchronized (clients) {
      clients[clientId].character = p;
    }
  }

  /** Gets the PC for the given client ID. */
  public Person getCharacter(int clientId) {
    synchronized (clients) {
      return clients[clientId].character;
    }
  }

  // -- Main method --

  public static void main(String[] args) { new GameServer(); }

}
