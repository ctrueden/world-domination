//
// ProvinceMenu.java
//

package worlddom.modules;

import worlddom.game.Game;
import worlddom.game.Person;
import worlddom.game.Province;
import worlddom.server.GameServer;
import worlddom.server.Module;

/** Module for the current province's main menu. */
public class ProvinceMenu extends Menu {

  // -- Constructor --

  public ProvinceMenu(GameServer server,
    int clientId, Module parent, Province p)
  {
    super(server, clientId, parent);
  }

  // -- Module API methods --

  public void activate() {
    doOutput();
  }

  public void processInput(String input) {
    if (input == null || input.equals("")) return;
    output(input);
    doOutput();
  }

  // -- Helper methods --

  private void doOutput() {
    StringBuffer sb = new StringBuffer();
    sb.append("ProvinceMenu: eventually there will be some choices here.\n");
    sb.append("Enter your choice: ");
    output(sb.toString());
  }

}
