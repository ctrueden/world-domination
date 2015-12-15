package net.restlesscoder.worlddom.modules;

import net.restlesscoder.worlddom.server.GameServer;
import net.restlesscoder.worlddom.server.Module;

/** Module for the smithy. */
public class SmithMenu extends Menu {

  // -- Constructor --

  public SmithMenu(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
    description = "Welcome to the smithy, home of the blacksmith.";
    Unimplemented un = new Unimplemented(server, clientId, this);

    items.add(new MenuItem(un, "Buy (W)eapon", 'w'));
    items.add(new MenuItem(un, "Buy (A)rmor", 'a'));
  }

}
