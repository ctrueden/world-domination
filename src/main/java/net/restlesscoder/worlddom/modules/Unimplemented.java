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

/** Placeholder module for managing features that are not yet written. */
public class Unimplemented extends Module {

  // -- Constructor --

  public Unimplemented(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
  }

  // -- Module API methods --

  public void activate() {
    output("This feature is not yet implemented.\n");
    server.setModule(clientId, parent);
  }

  public void processInput(String input) { }

}
