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
    description = "Welcome to " + p.name + ", where anything is possible.\n";
    Unimplemented un = new Unimplemented(server, clientId, this);
    items.add(new MenuItem(un, "(D)o something fantastic", 'd'));
    items.add(new MenuItem(un, "(N)ever give up", 'n'));
    items.add(new MenuItem(un, "(S)top being such an ass", 's'));
    items.add(new MenuItem(un, "(T)ravel to another province", 't'));
    items.add(new MenuItem(un, "(V)isit the local tavern", 'v'));
  }
  // Tavern
  //  - Talk to bartender
  //  - Kill bartender
  //  - Bards can perform
  // Old Man's house
  //  - Talk to old man
  //  - Kill old man
  //  - See province stats? (including some stats palace doesn't even know)
  // Royal Palace
  //  - Attack a neighboring province
  //  - Hire or release soldiers
  //  - Sabotage another province
  //  - Spy on another province
  //  - Build structures
  //  - "Give food" -- raise morale
  //  - Court vizier?
  //  - Barracks -- where army stays?
  // Wonder of the World
  // Pawn shop
  // Blacksmith
  //  - sells weapons, armor, shields, helms...
  //  - crafts custom weapons and armor?
  // Magic shop
  //  - sells spells, potions, charms, accessories
  // Rumor mill

}
