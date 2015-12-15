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

public class Food {

  public int grain;
  public int fruit;
  public int veggies;
  public int meat;

  /** Number of (grain-producing) fields. */
  public int fields;

  /** Number of (fruit-producing) orchards. */
  public int orchards;

  /** Number of (veggie-producing) gardens. */
  public int gardens;

  /** Number of (meat-producing) farms. */
  public int farms;

}
