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

public class Game {

  public Vector<Person> characters = new Vector<Person>();
  public World world;

  /** Base class from which other classes are defined. */
  public Job baseJob;

  public Game() { }

  public void addCharacter(Person c) { }
  public Person getCharacter(String name) { return null; }
  public void removeCharacter(Person c) { }

  public void addProvince(Province p) { }
  public Province getProvince(String name) { return null; }
  public void removeProvince(Person p) { }

}
