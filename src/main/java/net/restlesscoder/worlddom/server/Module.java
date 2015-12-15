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

/**
 * A module encompasses logic for a particular piece of the game.
 * Each instance of module corresponds to a specific client of a particular
 * game server instance.
 */
public abstract class Module {

  // -- Fields --

  /** The game server. */
  protected GameServer server;

  /** The ID of the client. */
  protected int clientId;

  /** The instance of the module which activated this currently active one. */
  protected Module parent;

  /** Label to describe the module in a menu, if applicable. */
  protected String menuLabel;

  /** Shortcut to access the module from a menu, if applicable. */
  protected char menuShortcut;

  /** State variable for flagging the state of the module, if applicable. */
  protected int state;

  /** Indicates whether cooked input mode is enabled. */
  private boolean cooked;

  /** Buffer for accumulating characters line by line in cooked mode. */
  private StringBuffer buf = new StringBuffer();

  // -- Constructor --

  public Module(GameServer server, int clientId, Module parent) {
    this.server = server;
    this.clientId = clientId;
    this.parent = parent;
  }

  // -- Module API methods --

  /** Informs the module that it's been activated. */
  public abstract void activate();

  /** Instructs the module to handle some input from the client. */
  public abstract void processInput(String input);

  /** By default all characters can access a module. */
  public boolean canAccess(Person person) { return true; }

  /** Sends output back to the game server from the active module. */
  public void output(String output) { server.output(clientId, output); }

  /** Recieves input from the game server's client connection. */
  public void receiveInput(String input) {
    if (cooked) {
      // accumulate characters into the line buffer
      while (true) {
        int nl = input.indexOf("\n");
        if (nl < 0) {
          buf.append(input);
          output(input);
          break;
        }
        else {
          String pre = input.substring(0, nl);
          String post = input.substring(nl + 1);
          buf.append(pre);
          output(pre + "\n");
          String line = buf.toString();
          buf.setLength(0);
          processInput(line);
          input = post;
        }
      }
    }
    else {
      // pass along input to the module
      processInput(input);
    }
  }

  /**
   * Toggles between raw and cooked input modes.
   *
   * In raw mode, input is passed directly to the module, with nothing
   * echoed back to the client automatically.
   *
   * In cooked mode, input is accumulated line by line, and echoed to the
   * console automatically until cooked mode is disabled.
   */
  public void setCooked(boolean cooked) {
    this.cooked = cooked;
    if (!cooked && buf.length() > 0) {
      // flush accumulated characters from the buffer
      String line = buf.toString();
      buf.setLength(0);
      processInput(line);
    }
  }

  /** Gets the client's active character. */
  public Person character() {
    return server.getCharacter(clientId);
  }

}
