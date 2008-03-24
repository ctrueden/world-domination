//
// Province.java
//

package worlddom.game;

import java.util.Vector;

public class Province {

  // -- Fields --

  /** Name of the province. */
  public String name;

  public Vector<Province> neighbors = new Vector<Province>();

  public Character owner;
  public Character governor;

  public Food food = new Food();

  public int patriotism;
  public int liberty;
  public int happiness;
  public int health;

  public int taxRate;

  /** Number of unnamed civilians. */
  public int populace;

  /** Number of unnamed soldiers. */
  public int troops;

  /** List of named civilians. */
  public Vector<Character> civilians = new Vector<Character>();

  /** List of named soldiers. */
  public Vector<Character> soldiers = new Vector<Character>();

  // -- Constructor --

  public Province(String name) { this.name = name; }

  // -- Province API methods --

  public String healthLevel() {
    if (health >= 100) return "perfect";
    if (health >= 90) return "great";
    if (health >= 80) return "not ungreat";
    if (health >= 70) return "goodish";
    if (health >= 60) return "fair";
    if (health >= 50) return "unfair";
    if (health >= 40) return "poor but clean";
    if (health >= 30) return "poor and filthy";
    if (health >= 20) return "downtrodden but proud";
    if (health >= 10) return "pestilent";
    return "oozing";
  }

  public String taxLevel() {
    if (taxRate >= 100) return "totalitarian";
    if (taxRate >= 90) return "Stalinesque";
    if (taxRate >= 80) return "extreme";
    if (taxRate >= 70) return "killer";
    if (taxRate >= 60) return "brutal";
    if (taxRate >= 50) return "exhorbitant";
    if (taxRate >= 40) return "wicked";
    if (taxRate >= 30) return "high";
    if (taxRate >= 20) return "modest";
    if (taxRate >= 10) return "no schools";
    if (taxRate > 0) return "no roads";
    return "free lunch";
  }

}
