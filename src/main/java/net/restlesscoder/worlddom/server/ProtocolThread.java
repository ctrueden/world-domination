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
