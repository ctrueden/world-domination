//
// Info.java
//

package worlddom.modules;

import java.util.Vector;
import worlddom.server.GameServer;
import worlddom.server.Module;

/** Generic module type for displaying information to the player. */
public abstract class Info extends Module {

  // -- Constructor --

  public Info(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
  }

  // -- Module API methods --

  public void processInput(String input) {
    if (input == null || input.length() == 0) return;
    output("\n");
    server.setModule(clientId, parent);
  }

}
