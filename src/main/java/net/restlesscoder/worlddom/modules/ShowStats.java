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
import net.restlesscoder.worlddom.server.GameServer;
import net.restlesscoder.worlddom.server.Module;

public class ShowStats extends Info {

  // -- Constructor --

  public ShowStats(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
  }

  // -- Module API methods --

  public void activate() {
    StringBuffer sb = new StringBuffer();

    Person pc = server.getCharacter(clientId);
    sb.append("Strength: " + pc.strength + "\n");
    sb.append("Vitality: " + pc.vitality + "\n");
    sb.append("Speed: " + pc.speed + "\n");
    sb.append("Stealth: " + pc.stealth + "\n");
    sb.append("Skill: " + pc.skill + "\n");
    sb.append("Magic: " + pc.magic + "\n");
    sb.append("Faith: " + pc.faith + "\n");
    sb.append("Luck: " + pc.luck + "\n");
    sb.append("Charm: " + pc.charm + "\n");
    sb.append("HP: " + pc.curHP + "/" + pc.maxHP + "\n");
    sb.append("Press any key to continue.");

    output(sb.toString());
  }

}
