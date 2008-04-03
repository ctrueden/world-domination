//
// ProvinceMenu.java
//

package worlddom.modules;

import worlddom.game.Province;
import worlddom.server.GameServer;
import worlddom.server.Module;

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
  }

}
