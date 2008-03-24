//
// Menu.java
//

package worlddom.modules;

import java.util.Vector;
import worlddom.server.GameServer;
import worlddom.server.Module;

public class Menu extends Module {

  // -- Fields --

  private String description;

  /** List of modules accessible from the menu. */
  private Vector<Module> modules = new Vector<Module>();

  // -- Constructor --

  public Menu(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
  }

  // -- Module API methods --

  public void activate() {
    // CTR START HERE
  }

  public void processInput(String input) {
    // TODO
  }

  // -- Utility methods --

  public static String makeLabel(String label, int index) {
    return label.substring(0, index) + "(" +
      label.substring(index, index + 1).toUpperCase() + ")" +
      label.substring(index + 1);
  }

}
