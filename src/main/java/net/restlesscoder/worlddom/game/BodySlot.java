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
