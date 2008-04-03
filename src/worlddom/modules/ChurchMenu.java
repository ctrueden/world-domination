//
// ChurchMenu.java
//

package worlddom.modules;

import worlddom.server.GameServer;
import worlddom.server.Module;

/** Module for the church. */
public class ChurchMenu extends Menu {

  // -- Constructor --

  public ChurchMenu(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
    description = "Welcome to the church, God's home away from home.";
    Unimplemented un = new Unimplemented(server, clientId, this);

    items.add(new MenuItem(un, "(R)esurrect a fallen character", 'r'));
    items.add(new MenuItem(un, "(T)ithe to the church", 't'));
  }

}
