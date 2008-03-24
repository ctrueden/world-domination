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
    description = "Welcome to " + p.name + ", where anything is possible.\n";
    items.add(new MenuItem(null, "(D)o something fantastic", 'd'));
    items.add(new MenuItem(null, "(N)ever give up", 'n'));
    items.add(new MenuItem(null, "(S)top being such an ass", 's'));
    items.add(new MenuItem(null, "(T)ravel to another province", 't'));
    items.add(new MenuItem(null, "(V)isit the local tavern", 'v'));
  }

}
