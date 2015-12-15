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
package net.restlesscoder.worlddom.client;

import java.io.*;
import java.net.Socket;

/** Command line game client that connects using sockets protocol. */
public class CLIClient {

  // -- Fields --

  private Socket socket;
  private InputStream in;
  private OutputStream out;
  private boolean alive;

  // -- Constructor --

  public CLIClient(String url, int port) throws IOException {
    socket = new Socket(url, port);
    alive = true;

    in = socket.getInputStream();
    new Thread("InputThread") {
      public void run() {
        while (alive) {
          try {
            int value = System.in.read();
            out.write((char) value);
          }
          catch (IOException exc) {
            exc.printStackTrace();
          }
          /*
          try {
            Thread.sleep(100);
          }
          catch (InterruptedException exc) {
            exc.printStackTrace();
          }
          */
        }
      }
    }.start();

    out = socket.getOutputStream();
    new Thread("OutputThread") {
      public void run() {
        while (alive) {
          try {
            int avail = in.available();
            byte[] data = new byte[avail];
            in.read(data);
            output(new String(data));
          }
          catch (IOException exc) {
            exc.printStackTrace();
          }
          try {
            Thread.sleep(100);
          }
          catch (InterruptedException exc) {
            exc.printStackTrace();
          }
        }
      }
    }.start();
  }

  // -- Helper methods --

  private void output(String data) {
    System.out.print(data);
  }

  // -- Main method --

  public static void main(String[] args) throws IOException {
    new CLIClient("localhost", 7654);
  }

}
