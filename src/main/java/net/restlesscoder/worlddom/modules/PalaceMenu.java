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

import net.restlesscoder.worlddom.game.Person;
import net.restlesscoder.worlddom.game.Province;
import net.restlesscoder.worlddom.server.GameServer;
import net.restlesscoder.worlddom.server.Module;

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
