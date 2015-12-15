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

/** Module for the magic boutique module. */
public class MagicMenu extends Menu {

  // -- Constructor --

  public MagicMenu(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
    description = "Welcome to the magic boutique, where you can purchase " +
      "reality-bending powers beyond normal, straight reality.";
    Unimplemented un = new Unimplemented(server, clientId, this);

    items.add(new MenuItem(un, "Buy (S)pell", 's'));
    items.add(new MenuItem(un, "Buy (P)otion", 'p'));
    items.add(new MenuItem(un, "Buy (C)harm", 'c'));
    items.add(new MenuItem(un, "Buy (R)elic", 'r'));
  }

}
