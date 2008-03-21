//
// GUIClient.java
//

package worlddom.client;

import java.awt.BorderLayout;
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

  private JTextArea textArea;

  // -- Constructor --

  public GUIClient(String url, int port) throws IOException {
    socket = new Socket(url, port);
    alive = true;

    textArea = new JTextArea(25, 80);
    textArea.setEditable(false);
    JScrollPane areaScroll = new JScrollPane(textArea);
    areaScroll.setVerticalScrollBarPolicy(
      JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    textArea.addKeyListener(this);

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
    textArea.append(data);
  }

  // -- Main method --

  public static void main(String[] args) throws IOException {
    new GUIClient("localhost", 7654);
  }

}
