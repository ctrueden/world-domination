//
// ClientConnection.java
//

package worlddom.server;

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

  // -- Constructor --

  public ClientConnection(GameServer server, int id,
    DataProtocol protocol, Object handle)
  {
    this.server = server;
    this.id = id;
    this.protocol = protocol;
    this.handle = handle;
    alive = true;
    System.out.println("New client connection #" + id);//TEMP
  }

  // -- ClientConnection API methods --

  public void send(String data) {
    protocol.send(handle, data);
  }

  public void quit() { alive = false; }

  // -- Thread API methods --

  public void run() {
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
  }

}
