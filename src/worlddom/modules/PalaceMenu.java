//
// PalaceMenu.java
//

package worlddom.modules;

import worlddom.game.Person;
import worlddom.game.Province;
import worlddom.server.GameServer;
import worlddom.server.Module;

/** Module for the royal palace. */
public class PalaceMenu extends Menu {

  // -- Constructor --

  public PalaceMenu(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
    Person person = server.getCharacter(clientId);
    Province p = person.location;
    description = "Welcome to the royal palace, seat of power for " + p.name;
    Unimplemented un = new Unimplemented(server, clientId, this);

    if (person == p.owner) {
      // you own the province
      items.add(new MenuItem(un, "(B)arracks", 'b'));
      // + (H)ire soldiers
      // + (R)elease soldiers
      items.add(new MenuItem(un, "Court (V)izier", 'v'));
      // + ?
      items.add(new MenuItem(un, "(W)ar room", 'w'));
      // + (A)ttack a neighboring province
      // + (S)py on another province
      // + s(A)botage another province
      items.add(new MenuItem(un, "(B)uild structures [?]", 'b'));
      items.add(new MenuItem(un, "(F)eed the people [raises morale]", 'f'));
    }
    else {
      // you don't own the province
      items.add(new MenuItem(un, "(S)neak in to the palace", 's'));
      items.add(new MenuItem(un, "(M)ount a frontal assault", 'm'));
    }
  }

}
