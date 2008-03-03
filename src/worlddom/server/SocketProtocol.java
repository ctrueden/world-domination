//
// SocketProtocol.java
//

package worlddom.server;

import java.io.*;
import java.net.*;

/** Client/server communication protocol using sockets. */
public class SocketProtocol implements DataProtocol {

  // -- Fields --

  private ServerSocket serverSocket;

  // -- Constructor --

  public SocketProtocol(int port) {
    try {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(250);
    }
    catch (IOException exc) {
      exc.printStackTrace();
    }
  }

  // -- DataProtocol API methods --

  /* @see worlddom.server.DataProtocol#listen() */
  public Object listen() {
    try {
      return serverSocket.accept();
    }
    catch (SocketTimeoutException exc) { }
    catch (IOException exc) {
      exc.printStackTrace();
    }
    return null;
  }

  /* @see worlddom.server.DataProtocol#send(Object, String) */
  public void send(Object handle, String data) {
    Socket socket = (Socket) handle;
    try {
      OutputStream out = socket.getOutputStream();
      out.write(data.getBytes());
    }
    catch (IOException exc) {
      exc.printStackTrace();
    }
  }

  /* @see worlddom.server.DataProtocol#receive(Object) */
  public String receive(Object handle) {
    Socket socket = (Socket) handle;
    try {
      InputStream in = socket.getInputStream();
      int avail = in.available();
      byte[] data = new byte[avail];
      if (data.length > 0) in.read(data);
      return new String(data);
    }
    catch (IOException exc) {
      exc.printStackTrace();
    }
    return null;
  }

  /* @see worlddom.server.DataProtocol#close(Object) */
  public void close(Object handle) {
    Socket socket = (Socket) handle;
    try {
      socket.close();
    }
    catch (IOException exc) {
      exc.printStackTrace();
    }
  }

  // -- Object API methods --

  public String toString() {
    return "Sockets";
  }

}
