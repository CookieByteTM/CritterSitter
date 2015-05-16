/**
 * The Pamphlet class is the class that shows the graphics of the pamphlet that is always
 * accessible to the user. It is in the corner of the screen and it shows the picture of the
 * critter the user has, the genetic diseases it is prone to, and how to sustain a healthy diet.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 1 05.15.15
 * 
 * <p>
 * <b>name: Pamphlet.java </b>
 *
 * <p>
 * <b>Instance variables: </b>
 * <p>
 * <b>critter </b> This is a Critter variable that stores the different critter information.
 */
public class Pamphlet
{
  private Critter critter;
  
  /**
   * The Pamplet constructor creates the pamphlet with the specific critter.
   * 
   * @param critter the critter object.
   */
  public Pamphlet (Critter critter)
  {
    this.critter = critter;
  }
  
  /**
   * The flipNext method flips the page of the pamphlet forwards.
   */
  public void flipNext ()
  {
  }
  
  /**
   * The flipBack method flips the page of the pamphlet backwards.
   */
  public void flipBack ()
  {
  }
  
  /**
   * The close method closes the pamphlet.
   */
  public void close ()
  {
  }
}
