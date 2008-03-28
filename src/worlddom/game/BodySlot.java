//
// BodySlot.java
//

package worlddom.game;

public class BodySlot {

  // -- Constants --

  public static BodySlot lHand = new BodySlot("L.hand");
  public static BodySlot rHand = new BodySlot("R.hand");
  public static BodySlot torso = new BodySlot("Torso");
  public static BodySlot head = new BodySlot("Head");
  public static BodySlot neck = new BodySlot("Neck");
  public static BodySlot legs = new BodySlot("Legs");
  public static BodySlot feet = new BodySlot("Feet");
  public static BodySlot hands = new BodySlot("Hands");
  public static BodySlot eyes = new BodySlot("Eyes");
  public static BodySlot ears = new BodySlot("Ears");
  public static BodySlot nose = new BodySlot("Nose");

  // -- Fields --

  /** Name of the slot. */
  public String name;

  // -- Constructor --

  public BodySlot(String name) { this.name = name; }

}
