//
// GuildMenu.java
//

package worlddom.modules;

import worlddom.server.GameServer;
import worlddom.server.Module;

/** Module for the guild hall. */
public class GuildMenu extends Menu {

  // -- Constructor --

  public GuildMenu(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
    description = "Welcome to the guild hall, where specialists gather.";
    Unimplemented un = new Unimplemented(server, clientId, this);

    items.add(new MenuItem(un, "(A)ssassin's guild", 'a'));
    items.add(new MenuItem(un, "(B)ounty house", 'b'));
    // + receive money for having slain mighty beasts (trade in monster parts)
    // + receive money for having captured a character
    //  - start with random bounties on various NPCs
    items.add(new MenuItem(un, "(T)emple of the mind", 't'));
    // + (S)end psionic message to another player
    items.add(new MenuItem(un, "(M)ercenary guild", 'm'));
    // + hire (E)lite troops
    // + hire (S)quad leaders?
  }

}
