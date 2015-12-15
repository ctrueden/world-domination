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
package net.restlesscoder.worlddom.game;

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

  //public int attack() { return strength + gear.attack(); }
  //public int defense() { return vitality + gear.defense(); }
  //public int hit() { return skill + gear.hit(); }
  //public int crit() { return luck + gear.crit(); }
  //public int evade() { return speed + gear.evade(); }

  /**
   * A measure of how many people know who you are;
   * the quality of being leading, important, or well-known.
   */
  public int prominence;

  /**
   * The position one occupies or the standing that one has in the opinion
   * of others, in respect to attainments, integrity, and the like.
   * Zero is neutral; higher means a good reputation, lower means a bad one.
   */
  public int reputation;

  /**
   * The combination of moral and other traits which make one the kind of
   * person one actually is (as contrasted with what others think of one).
   * Zero is neutral; higher means a good character, lower means a bad one.
   */
  public int character;

  public Gear gear;

  public Spellbook spells;

  public Person lord;
  public Vector<Person> vassals = new Vector<Person>();

  public Province location;
  public Vector<Province> governed = new Vector<Province>();
  public Vector<Province> owned = new Vector<Province>();

}
