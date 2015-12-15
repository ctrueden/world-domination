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

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import javax.swing.*;

/** Simple GUI game client that connects using sockets protocol. */
public class GUIClient implements KeyListener, WindowListener {

  // -- Fields --

  private Socket socket;
  private InputStream in;
  private OutputStream out;
  private boolean alive;

  private JTextArea textPane;

  // -- Constructor --

  public GUIClient(String url, int port) throws IOException {
    socket = new Socket(url, port);
    alive = true;

    textPane = new JTextArea(25, 80);
    textPane.setEditable(false);
    textPane.setFont(new Font("Monospaced", Font.PLAIN, 12));
    JScrollPane areaScroll = new JScrollPane(textPane);
    areaScroll.setVerticalScrollBarPolicy(
      JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    textPane.addKeyListener(this);

    JFrame frame = new JFrame("GUI Game Client - " + url + ":" + port);
    JPanel pane = new JPanel();
    frame.setContentPane(pane);
    pane.setLayout(new BorderLayout());
    pane.add(areaScroll, BorderLayout.CENTER);
    frame.addWindowListener(this);
    frame.setLocation(100, 100);
    frame.pack();

    in = socket.getInputStream();

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
        System.out.println("Closing socket");
        try {
          socket.close();
        }
        catch (IOException exc) {
          exc.printStackTrace();
        }
      }
    }.start();

    frame.setVisible(true);
  }

  // -- KeyListener API methods --

  public void keyPressed(KeyEvent e) { }

  public void keyReleased(KeyEvent e) { }

  public void keyTyped(KeyEvent e) {
    char value = e.getKeyChar();
    if (value != KeyEvent.CHAR_UNDEFINED) {
      try {
        out.write(value);
      }
      catch (IOException exc) {
        exc.printStackTrace();
      }
    }
  }

  // -- WindowListener API methods --

  public void windowDeactivated(WindowEvent e) { }

  public void windowActivated(WindowEvent e) { }

  public void windowDeiconified(WindowEvent e) { }

  public void windowIconified(WindowEvent e) { }

  public void windowClosed(WindowEvent e) { }

  public void windowClosing(WindowEvent e) {
    alive = false;
    e.getWindow().dispose();
  }

  public void windowOpened(WindowEvent e) { }

  // -- Helper methods --

  private void output(String data) {
    textPane.append(data);
    textPane.setCaretPosition(textPane.getDocument().getLength());
  }

  // -- Main method --

  public static void main(String[] args) throws IOException {
    new GUIClient("localhost", 7654);
  }

}
