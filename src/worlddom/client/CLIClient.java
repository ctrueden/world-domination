//
// CLIClient.java
//

package worlddom.client;

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
