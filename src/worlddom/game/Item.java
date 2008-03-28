//
// Item.java
//

package worlddom.game;

import java.util.Vector;

public class Item {

  // -- Fields --

  /** Name of the item. */
  public String name;

  public boolean equipped;

  public Vector<BodySlot> slots = new Vector<BodySlot>();

  public int attack;
  public int defense;
  public int hit;
  public int crit;
  public int evade;

}
