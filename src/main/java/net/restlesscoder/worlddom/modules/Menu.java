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

import java.util.Vector;
import net.restlesscoder.worlddom.server.GameServer;
import net.restlesscoder.worlddom.server.Module;

public class Menu extends Module {

  // -- Fields --

  /** Initial description to show before the menu. */
  public String description;

  /** Menu items accessible from the menu. */
  public Vector<MenuItem> items = new Vector<MenuItem>();

  // -- Constructor --

  public Menu(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
  }

  // -- Module API methods --

  public void activate() {
    StringBuffer sb = new StringBuffer();
    sb.append(description);
    int pad = 0;
    int count = 0;
    for (MenuItem item : items) {
      if (item.label != null) {
        if (count % 2 == 0) sb.append("\n");
        else for (int j=0; j<pad; j++) sb.append(" ");
        sb.append(item.label);
        pad = 40 - item.label.length();
        count++;
      }
    }
    sb.append("\nEnter your choice: ");
    output(sb.toString());
  }

  public void processInput(String input) {
    if (input == null || input.length() == 0) return;
    char c = input.charAt(0);
    for (MenuItem item : items) {
      if (c == item.shortcut) {
        output(input.toUpperCase() + "\n");
        server.setModule(clientId, item.module);
        break;
      }
    }
  }

  // -- Utility methods --

  public static String makeLabel(String label, int index) {
    return label.substring(0, index) + "(" +
      label.substring(index, index + 1).toUpperCase() + ")" +
      label.substring(index + 1);
  }

}
