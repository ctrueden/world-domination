//
// Gear.java
//

package worlddom.game;

import java.util.Vector;

public class Gear {

  // -- Fields --

  /** List of items. */
  public Vector<Item> items = new Vector<Item>();

  public int attack() { return weapon == null ? 0 : weapon.attack; }
  public int defense() { return armor == null ? 0 : armor.defense; }
  public int hit() { return weapon == null ? 0 : weapon.hit; }
  public int crit() { return weapon == null ? 0 : weapon.crit; }
  public int evade() { return armor == null ? 0 : armor.evade; }

}
