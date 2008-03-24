//
// ClientConnection.java
//

package worlddom.server;

import worlddom.game.Person;
import worlddom.modules.Login;

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
