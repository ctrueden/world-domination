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

/** Module for the smithy. */
public class SmithMenu extends Menu {

  // -- Constructor --

  public SmithMenu(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
    description = "Welcome to the smithy, home of the blacksmith.";
    Unimplemented un = new Unimplemented(server, clientId, this);

    items.add(new MenuItem(un, "Buy (W)eapon", 'w'));
    items.add(new MenuItem(un, "Buy (A)rmor", 'a'));
  }

}
