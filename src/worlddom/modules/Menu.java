//
// Menu.java
//

package worlddom.modules;

import java.util.Vector;
import worlddom.server.GameServer;
import worlddom.server.Module;

public class Menu extends Module {

  // -- Fields --

  /** Initial description to show before the menu. */
  public String description;

  /** Menu items accessible from the menu. */
  public Vector<MenuItem> items = new Vector<MenuItem>();

  // -- Constructor --

  public Menu(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
  }

  // -- Module API methods --

  public void activate() {
    StringBuffer sb = new StringBuffer();
    sb.append(description);
    int pad = 0;
    int count = 0;
    for (MenuItem item : items) {
      if (item.label != null) {
        if (count % 2 == 0) sb.append("\n");
        else for (int j=0; j<pad; j++) sb.append(" ");
        sb.append(item.label);
        pad = item.label.length();
        count++;
      }
    }
    sb.append("\nEnter your choice: ");
    output(sb.toString());
  }

  public void processInput(String input) {
    if (input == null || input.length() == 0) return;
    char c = input.charAt(0);
    for (MenuItem item : items) {
      if (c == item.shortcut) {
        output(input.toUpperCase() + "\n");
        server.setModule(clientId, item.module);
        break;
      }
    }
  }

  // -- Utility methods --

  public static String makeLabel(String label, int index) {
    return label.substring(0, index) + "(" +
      label.substring(index, index + 1).toUpperCase() + ")" +
      label.substring(index + 1);
  }

}
