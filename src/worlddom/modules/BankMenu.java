//
// BankMenu.java
//

package worlddom.modules;

import worlddom.server.GameServer;
import worlddom.server.Module;

/** Module for the bank. */
public class BankMenu extends Menu {

  // -- Constructor --

  public BankMenu(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
    description = "Welcome to the bank, where you put your money.";
    Unimplemented un = new Unimplemented(server, clientId, this);

    items.add(new MenuItem(un, "(D)eposit money", 'd'));
    items.add(new MenuItem(un, "(W)ithdraw money", 'w'));
    items.add(new MenuItem(un, "(S)tore items in the vault", 's'));
    items.add(new MenuItem(un, "(T)ake items from the vault", 't'));
    items.add(new MenuItem(un, "(R)ob the bank", 'r'));
  }

}
