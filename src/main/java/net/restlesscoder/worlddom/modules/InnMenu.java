package net.restlesscoder.worlddom.modules;

import net.restlesscoder.worlddom.server.GameServer;
import net.restlesscoder.worlddom.server.Module;

/** Module for the inn/tavern. */
public class InnMenu extends Menu {

  // -- Constructor --

  public InnMenu(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
    description = "Welcome to the inn, which is also a tavern, " +
      "where people hang out.";
    Unimplemented un = new Unimplemented(server, clientId, this);

    items.add(new MenuItem(un, "(I)nn & tavern", 'i'));
    items.add(new MenuItem(un, "(T)alk to bartender", 't'));
    items.add(new MenuItem(un, "(P)erform [bards only]", 'p'));
    items.add(new MenuItem(un, "(L)isten to rumors", 'l'));
  }

}
