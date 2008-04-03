//
// MagicMenu.java
//

package worlddom.modules;

import worlddom.server.GameServer;
import worlddom.server.Module;

/** Module for the magic boutique module. */
public class MagicMenu extends Menu {

  // -- Constructor --

  public MagicMenu(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
    description = "Welcome to the magic boutique, where you can purchase " +
      "reality-bending powers beyond normal, straight reality.";
    Unimplemented un = new Unimplemented(server, clientId, this);

    items.add(new MenuItem(un, "Buy (S)pell", 's'));
    items.add(new MenuItem(un, "Buy (P)otion", 'p'));
    items.add(new MenuItem(un, "Buy (C)harm", 'c'));
    items.add(new MenuItem(un, "Buy (R)elic", 'r'));
  }

}
