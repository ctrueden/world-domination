//
// OldManMenu.java
//

package worlddom.modules;

import worlddom.server.GameServer;
import worlddom.server.Module;

/** Module for the old man's house. */
public class OldManMenu extends Menu {

  // -- Constructor --

  public OldManMenu(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
    description = "Welcome to the old man's house. Respect the elderly.";
    Unimplemented un = new Unimplemented(server, clientId, this);

    items.add(new MenuItem(un, "(L)isten to the old man ramble", 'l'));
    items.add(new MenuItem(un, "(K)ill the old man", 'k'));
  }

}
