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

import net.restlesscoder.worlddom.game.Province;
import net.restlesscoder.worlddom.server.GameServer;
import net.restlesscoder.worlddom.server.Module;

/** Module for the current province's main menu. */
public class ProvinceMenu extends Menu {

  // -- Constructor --

  public ProvinceMenu(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
    Province p = server.getCharacter(clientId).location;
    description = p.description;

    BankMenu bank = new BankMenu(server, clientId, this);
    ChurchMenu church = new ChurchMenu(server, clientId, this);
    StoreMenu store = new StoreMenu(server, clientId, this);
    GuildMenu guild = new GuildMenu(server, clientId, this);
    InnMenu inn = new InnMenu(server, clientId, this);
    MagicMenu magic = new MagicMenu(server, clientId, this);
    OldManMenu oldMan = new OldManMenu(server, clientId, this);
    PawnShopMenu pawnShop = new PawnShopMenu(server, clientId, this);
    PalaceMenu palace = new PalaceMenu(server, clientId, this);
    SmithMenu smith = new SmithMenu(server, clientId, this);
    ViceMenu vice = new ViceMenu(server, clientId, this);
    Unimplemented un = new Unimplemented(server, clientId, this);

    items.add(new MenuItem(bank, "(B)ank", 'b'));
    items.add(new MenuItem(church, "(C)hurch", 'c'));
    items.add(new MenuItem(store, "(G)eneral store", 'g'));
    items.add(new MenuItem(guild, "Guild (H)all", 'h'));
    items.add(new MenuItem(inn, "(I)nn & tavern", 'i'));
    items.add(new MenuItem(magic, "(M)agic boutique", 'm'));
    items.add(new MenuItem(oldMan, "(O)ld man's house", 'o'));
    items.add(new MenuItem(pawnShop, "(P)awn shop", 'p'));
    items.add(new MenuItem(palace, "(R)oyal palace", 'r'));
    items.add(new MenuItem(smith, "(S)mithy", 's'));
    items.add(new MenuItem(un, "(T)ravel elsewhere", 't'));
    items.add(new MenuItem(vice, "Den of (V)ice", 'v'));

    ShowStats showStats = new ShowStats(server, clientId, this);
    items.add(new MenuItem(showStats, "Sho(w) Stats", 'w'));
  }

}
