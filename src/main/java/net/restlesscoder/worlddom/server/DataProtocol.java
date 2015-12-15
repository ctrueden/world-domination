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

public interface DataProtocol {

  /**
   * Listens for an incoming connection using this protocol, returning a
   * protocol-specific handle to the new connection (e.g., for SocketProtocol,
   * the socket). Depending on the protocol, can block until a connection is
   * received, or return null after a specified timeout. However, it is the
   * responsibility of the protocol to avoid busy wait loops by sleeping a
   * bit before returning an immediate null.
   */
  Object listen();

  /**
   * This method sends a string of data to the client. It is called by the
   * game server for a variety of reasons. Most typically it is in response
   * to user input from the client (via {@link #receive()}), but sometimes in
   * response to the actions of another client, or to time elapsing (e.g.,
   * connection timeout).
   */
  void send(Object handle, String data);

  /**
   * This method blocks until some input is received from the client. If the
   * client disconnects or otherwise disappears, this method returns null.
   * Depending on the protocol, may return the empty string if no input is
   * currently available.
   */
  String receive(Object handle);

  /**
   * Performs any close, dispose, disconnect, etc.,
   * operations relevant to the given protocol handle.
   */
  void close(Object handle);

}
