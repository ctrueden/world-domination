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

/**
 * A character class, internally called a "job"
 * to avoid confusion with Java classes.
 */
public class Job {

  public static Job commoner;

  // -- Fields --

  /** Name of the class. */
  public String name;

  /** Alternate name of the class for a female character, if applicable. */
  public String femaleName;

  /** Which class this one becomes if more martial is added. */
  public Job martial;

  /** Which class this one becomes if more arcane is added. */
  public Job arcane;

  /** Which class this one becomes if more divine is added. */
  public Job divine;

  /** Which class this one becomes if more shadow is added. */
  public Job shadow;

  /** Which class this one becomes if ultimate power is achieved. */
  public Job ultimate;

}
