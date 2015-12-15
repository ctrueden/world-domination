/*
 * #%L
 * World Domination fantasy door game.
 * %%
 * Copyright (C) 2008 - 2015 Curtis Rueden
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */
package net.restlesscoder.worlddom.modules;

import net.restlesscoder.worlddom.game.Game;
import net.restlesscoder.worlddom.game.Person;
import net.restlesscoder.worlddom.server.GameServer;
import net.restlesscoder.worlddom.server.Module;

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
