//
// StoreMenu.java
//

package worlddom.modules;

import worlddom.server.GameServer;
import worlddom.server.Module;

/** Module for the general store. */
public class StoreMenu extends Menu {

  // -- Constructor --

  public StoreMenu(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
    description = "Welcome to the general store, seller of boring things.";
    Unimplemented un = new Unimplemented(server, clientId, this);

    items.add(new MenuItem(un, "Buy (I)tem", 'i'));
  }

}
