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

public class ProtocolThread extends Thread {

  // -- Fields --

  private GameServer server;
  private DataProtocol protocol;
  private boolean alive;

  // -- Constructor --

  public ProtocolThread(GameServer server, DataProtocol protocol) {
    super("ProtocolThread-" + protocol);
    this.server = server;
    this.protocol = protocol;
    alive = true;
  }

  // -- ProtocolThread API methods --

  public void quit() { alive = false; }

  // -- Thread API methods --

  public void run() {
    while (alive) {
      Object handle = protocol.listen();
      if (handle != null) server.addClient(protocol, handle);
      // NB: If a busy wait is happening here, it is a bug in the protocol
      // implementation -- they are supposed to sleep before returning an
      // immediate null.
    }
  }

}
