package net.restlesscoder.worlddom.modules;

import net.restlesscoder.worlddom.server.GameServer;
import net.restlesscoder.worlddom.server.Module;

/** Module for the pawn shop. */
public class PawnShopMenu extends Menu {

  // -- Constructor --

  public PawnShopMenu(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
    description = "Welcome to the pawn shop, where you can sell your stuff.";
    Unimplemented un = new Unimplemented(server, clientId, this);

    items.add(new MenuItem(un, "(T)alk to proprietor", 't'));
    items.add(new MenuItem(un, "(K)ill proprietor", 'k'));
    items.add(new MenuItem(un, "(S)ell stolen goods", 's'));
  }

}
