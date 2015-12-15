package net.restlesscoder.worlddom.game;

import java.util.Vector;

/** Class for a squad made up of field units. */
public class FieldSquad {

  /** Nickname for the squad. */
  public String name;

  /** List of field units in the squad. */
  public Vector<FieldUnit> units = new Vector<FieldUnit>();

}
