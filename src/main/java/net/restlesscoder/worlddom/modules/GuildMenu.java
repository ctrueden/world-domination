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

import net.restlesscoder.worlddom.server.GameServer;
import net.restlesscoder.worlddom.server.Module;

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
