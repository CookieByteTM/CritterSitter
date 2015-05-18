/**
 * The CritterSitter class is the class that creates the critter sitter (or the user in this case) who will take care of the critter.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 1 05.15.15
 * 
 * <p>
 * <b>name: CritterSitterApp.java </b>
 *
 * <p>
 * <b>Instance variables: </b>
 * <p>
 * <b>userName </b> This String variable is used to save the user's name.
 * <p>
 * <b>points </b> This int variable is used to store the number of points of the user.
 * <p>
 * <b>difficulty </b> This int variable is used to store the user's difficulty level.
 * <p>
 * <b>critterCharacter </b> This int variable is used to sstore the character number of the critter.
 * <p>
 * <b>fridge </b> This Food array is used to see what food is in the user's fridge.
 * <p>
 * <b>hour </b> This double variable is used to store the hour of the virtual day.
 * <p>
 * <b>day </b> This int variable is used to store the number of the virtual day.
 */
public class CritterSitter 
{
  private String userName;
  private int points;
  private int difficulty;
  private int critterCharacter;
  private Food[] fridge;
  private double hour;
  private int day;
  
  /**
   * The CritterSitter constructor creates a critter sitter with the specified name, difficulty and character.
   * 
   * @param userName This String variable is used to save the user's name. 
   * @param difficulty This int variable is used to store the user's difficulty level.
   * @param critterCharacter This int variable is used to sstore the character number of the critter.
   */
  public CritterSitter (String userName, int difficulty, int critterCharacter)
  {
    this.userName = userName;
    this.difficulty = difficulty;
    this.critterCharacter = critterCharacter;
  }
  
  /**
   * The getUserName method gets the user's name.
   * 
   * @return userName the String variable of the user's name.
   */
  public String getUserName ()
  {
    return userName;
  }
  
  /**
   * The getDifficulty method gets the user's difficulty.
   * 
   * @return difficulty the int variable of the user's difficulty.
   */
  public int getDifficulty ()
  {
    return difficulty;
  }
  
  /**
   * The getCritterCharacter method gets the user's critterCharacter.
   * 
   * @return critterCharacter the int variable of the user's critterCharacter.
   */
  public int getCritterCharacter ()
  {
    return critterCharacter;
  }
  
  /**
   * The getPoints method gets the user's points.
   * 
   * @return points the int variable of the user's points.
   */ 
  public int getPoints ()
  {
    return points;
  }
  
  /**
   * The setPoints method sets the user's points.
   * 
   * @param points This is the points that it will be set to.
   */ 
  public void setPoints (int points)
  {
    this.points = points;
  }
  
  /**
   * The getHour method gets the user's virtual hour.
   * 
   * @return hour the int variable of the user's virtual hour.
   */ 
  public double getHour ()
  {
    return hour;
  }
  
  /**
   * The getDay method gets the user's virtual day.
   * 
   * @return day the int variable of the user's virtual day.
   */ 
  public int getDay ()
  {
    return day;
  }
  
  /**
   * The passTime method passes time on the user's virtual day.
   * 
   * @param numHours This int variable is used to indicate the number of hours.
   */ 
  public void passTime(int numHours)
  {
    /*add hours and if it goes on to the next day, increment day and rest time to morning*/
  }
}
