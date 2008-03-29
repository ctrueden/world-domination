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
    description = p.description;
    Unimplemented un = new Unimplemented(server, clientId, this);

    items.add(new MenuItem(un, "(B)ank", 'b'));
    items.add(new MenuItem(un, "(C)hurch", 'c'));
    items.add(new MenuItem(un, "(G)eneral store", 'g'));
    items.add(new MenuItem(un, "Guild (H)all", 'h'));
    items.add(new MenuItem(un, "(I)nn & tavern", 'i'));
    items.add(new MenuItem(un, "(M)agic boutique", 'm'));
    items.add(new MenuItem(un, "(O)ld Man's house", 'o'));
    items.add(new MenuItem(un, "(P)awn shop", 'p'));
    items.add(new MenuItem(un, "(R)oyal palace", 'r'));
    items.add(new MenuItem(un, "(S)mithy", 's'));
    items.add(new MenuItem(un, "(T)ravel elsewhere", 't'));
    items.add(new MenuItem(un, "Den of (V)ice", 'v'));
  }

}
