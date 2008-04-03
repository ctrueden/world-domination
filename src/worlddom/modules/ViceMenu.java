//
// ViceMenu.java
//

package worlddom.modules;

import worlddom.server.GameServer;
import worlddom.server.Module;

/** Module for the den of vice. */
public class ViceMenu extends Menu {

  // -- Constructor --

  public ViceMenu(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
    description = "Welcome to the den of vice, " +
      "where you can do things that people frown upon.";
    Unimplemented un = new Unimplemented(server, clientId, this);

    items.add(new MenuItem(un, "(J)ump around", 'j'));
    items.add(new MenuItem(un, "(G)et up", 'g'));
    items.add(new MenuItem(un, "Get (U)p", 'u'));
    items.add(new MenuItem(un, "Get (D)own", 'd'));
  }

}
