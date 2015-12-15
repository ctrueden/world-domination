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

import net.restlesscoder.worlddom.game.Person;
import net.restlesscoder.worlddom.modules.Login;

public class ClientConnection extends Thread {

  // -- Fields --

  /** The game server associated with this client connection. */
  private GameServer server;

  /** The ID number of this client connection. */
  private int id;

  /** The protocol to use for communication with the client. */
  private DataProtocol protocol;

  /** A protocol-specific handle (e.g., for SocketProtocol, the socket). */
  private Object handle;

  /** Whether the client connection is still active. */
  private boolean alive;

  /** Active module for this client. */
  protected Module module;

  /**
   * Active character for this client, assigned by
   * the Login module via the game server.
   */
  protected Person character;

  // -- Constructor --

  public ClientConnection(GameServer server, int id,
    DataProtocol protocol, Object handle)
  {
    this.server = server;
    this.id = id;
    this.protocol = protocol;
    this.handle = handle;
    alive = true;
    module = new Login(server, id);
    System.out.println("Client #" + id + " connected");
  }

  // -- ClientConnection API methods --

  public void send(String data) {
    protocol.send(handle, data);
  }

  public void activate(Module module) {
    this.module = module;
    module.activate();
  }

  public void quit() { alive = false; }

  // -- Thread API methods --

  public void run() {
    module.activate();
    while (alive) {
      String data = protocol.receive(handle);
      if (data != null) server.input(id, data);
      try {
        Thread.sleep(100);
      }
      catch (InterruptedException exc) {
        exc.printStackTrace();
      }
    }
    System.out.println("Client #" + id + " disconnected");
    server.removeClient(id);
  }

}
