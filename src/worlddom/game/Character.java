//
// Character.java
//

package worlddom.game;

import java.util.Vector;

/**
 * Base class holding details common to PCs and NPCs.
 * An instance of this class represents a particular PC or NPC.
 */
public class Character {

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
  public int leadership;//?

  public int curHP;
  public int maxHP;

  public int honor;
  public int fame;
  public int renown;

  public Province location;

  public Gear gear;

  public Spellbook spells;

  public Character lord;

  public Vector<Province> governed;
  public Vector<Province> owned;

}
