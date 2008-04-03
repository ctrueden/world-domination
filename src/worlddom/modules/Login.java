//
// Login.java
//

package worlddom.modules;

import worlddom.game.Game;
import worlddom.game.Person;
import worlddom.server.GameServer;
import worlddom.server.Module;

/** Core module for managing user login/authentication. */
public class Login extends Module {

  // -- Constants --

  private static final int NAME_ENTRY = 0;
  private static final int DONE = 1;

  // -- Fields --

  private Person character;

  // -- Constructor --

  public Login(GameServer server, int clientId) {
    super(server, clientId, null);
  }

  // -- Module API methods --

  public void activate() {
    setCooked(true);
    state = NAME_ENTRY;
    doOutput();
  }

  public void processInput(String input) {
    switch (state) {
      case NAME_ENTRY:
        Game g = server.getGame();
        // search for matching
        Person match = null;
        for (Person p : g.characters) {
          if (input.equals(p.player)) {
            match = p;
            break;
          }
        }
        if (match == null) {
          output("Sorry, invalid player name.\n");
        }
        else {
          character = match;
          state = DONE;
        }
        break;
    }
    doOutput();
  }

  // -- Helper methods --

  private void doOutput() {
    switch (state) {
      case NAME_ENTRY:
        output("Please enter your name: ");
        break;
      case DONE:
        output("Logging in...\n");
        // set active character
        server.setCharacter(clientId, character);
        // activate province module
        ProvinceMenu pm = new ProvinceMenu(server, clientId, this);
        server.setModule(clientId, pm);
        break;
    }
  }

}
