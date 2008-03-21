//
// GameServer.java
//

package worlddom.server;

/** The server that manages the running instance of the game. */
public class GameServer {

  // -- Constants --

  private static final int MAX_CLIENTS = 10000;

  // -- Fields --

  /** Clients table. */
  private ClientConnection[] clients;

  /** Data protocols defining how clients can connect to the server. */
  private DataProtocol[] protocols;

  /** Threads that wait for incoming connections according to each protocol. */
  private Thread[] protoThreads;

  // -- Constructor --

  public GameServer() {
    clients = new ClientConnection[MAX_CLIENTS];
    protocols = new DataProtocol[] {
      new SocketProtocol(7654)
    };
    // each protocol has a thread dedicated to listening for new connections
    protoThreads = new Thread[protocols.length];
    for (int i=0; i<protocols.length; i++) {
      protoThreads[i] = new ProtocolThread(this, protocols[i]);
      protoThreads[i].start();
    }
    System.out.println("Game server is up and running.");
  }

  // -- GameServer API methods --

  /** Informs the server of a new client connection. */
  public synchronized int addClient(DataProtocol protocol, Object handle) {
    int id = -1;
    for (int i=0; i<MAX_CLIENTS; i++) {
      if (clients[i] == null) {
        id = i;
        break;
      }
    }
    if (id < 0) {
      System.out.println("Too many connections");
      return -1;
    }
    else {
      // create client connection, add to clients table, and listen for data
      ClientConnection conn = new ClientConnection(this, id, protocol, handle);
      clients[id] = conn;
      conn.start();
      return id;
    }
  }

  /** Informs teh server of a client disconnected. */
  public synchronized void removeClient(int id) {
    clients[id] = null;
  }

  /** Responds to input from a particular client. */
  public synchronized void input(int clientId, String input) {
    //TEMP - echo message back to client - BUT IN UPPERCASE
    output(clientId, input.toUpperCase());
  }

  /** Sends output to a particular client. */
  public synchronized void output(int clientId, String output) {
    if (clientId < 0 || clientId >= MAX_CLIENTS || clients[clientId] == null) {
      System.out.println("Invalid client id: " + clientId);
    }
    else clients[clientId].send(output);
  }

  // -- Main method --

  public static void main(String[] args) {
    new GameServer();
  }

}
