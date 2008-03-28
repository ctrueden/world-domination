//
// Game.java
//

package worlddom.game;

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
