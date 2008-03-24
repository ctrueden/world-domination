//
// Person.java
//

package worlddom.game;

import java.util.Vector;

/**
 * Base class holding details common to PCs and NPCs.
 * An instance of this class represents a particular PC or NPC. Called "Person"
 * rather than "Character" to avoid confusion with java.lang.Character.
 */
public class Person {

  // -- Fields --

  /** Name of the character's player, or null for an NPC. */
  public String player;

  /** Name of the character. */
  public String name;

  public Race race;

  public Gender gender;

  public int age;

  /** Character class. */
  public Job job;

  public int level;

  public int strength;
  public int vitality;
  public int speed;
  public int stealth;
  public int skill;
  public int magic;
  public int faith;
  public int luck;
  public int charm;

  public int curHP;
  public int maxHP;

  public int attack() { return strength + gear.attack(); }
  public int defense() { return vitality + gear.defense(); }
  public int hit() { return skill + gear.hit(); }
  public int crit() { return luck + gear.crit(); }
  public int evade() { return speed + gear.evade(); }

  public int honor;
  public int fame;
  public int renown;

  public Gear gear;

  public Spellbook spells;

  public Person lord;
  public Vector<Person> vassals = new Vector<Person>();

  public Province location;
  public Vector<Province> governed = new Vector<Province>();
  public Vector<Province> owned = new Vector<Province>();

}
