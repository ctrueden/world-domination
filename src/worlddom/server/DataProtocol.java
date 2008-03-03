//
// DataProtocol.java
//

package worlddom.server;

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
