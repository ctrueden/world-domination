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

public class Province {

  // -- Fields --

  /** Name of the province. */
  public String name;

  /** Introduction to this province. */
  public String description;

  /** List of provinces adjacent to this one. */
  public Vector<Province> neighbors = new Vector<Province>();

  /** Character under whose empire this province falls. */
  public Person owner;

  /**
   * Character who governs the province.
   * Must be either the owner himself, or one of the owner's vassals.
   */
  public Person governor;

  /** Captain of the (palace and city) guard. */
  public Person captain;

  /** Court wizard. */
  public Person vizier;

  /** Members of the governor's elite guard. */
  public Vector<Person> elite = new Vector<Person>();

  public Food food = new Food();

  /** A measure of the people's fervor for their nation. */
  public int patriotism;

  /**
   * A measure of the people's freedom.
   * High means more free; low means more oppressed.
   * Oppressed people tend to become unhappy more quickly.
   */
  public int liberty;

  /** A measure of the people's support for the current administration. */
  public int happiness;

  /**
   * A measure of the people's physical well-being.
   * Healthy people make better soldiers;
   * unhealthy people tend to die more frequently.
   */
  public int health;

  public int taxRate;

  /** Number of unnamed civilians. */
  public int populace;

  /** Number of unnamed soldiers. */
  public int troops;

  /** List of named civilians. */
  public Vector<Person> civilians = new Vector<Person>();

  /** List of named soldiers. */
  public Vector<Person> soldiers = new Vector<Person>();

  /**
   * List of wanted characters. The military is specifically on the lookout
   * for these people; if caught within the province, they are taken into
   * custody.
   */
  public Vector<Person> wanted = new Vector<Person>();

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
    if (taxRate >= 50) return "exorbitant";
    if (taxRate >= 40) return "wicked";
    if (taxRate >= 30) return "high";
    if (taxRate >= 20) return "modest";
    if (taxRate >= 10) return "no schools";
    if (taxRate > 0) return "no roads";
    return "free lunch";
  }

}
