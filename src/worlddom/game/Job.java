//
// Job.java
//

package worlddom.game;

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
