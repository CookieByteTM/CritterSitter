/**
 * The Recreation class is the class that lets the user play the 'mini-game' of fetch
 * where the user's critter goes to a designated shape and then answers a question at that
 * shape regarding healthy food choices and nutrition. If the user answers the question in correctly
 * the critter does not return with the object, and if they DO answer the question correctly,
 * the critter DOES return with the object.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 2 05.22.15
 * 
 * <p>
 * <b>name: Recreation.java </b>
 *
 * <p>
 * <b>Instance variables: </b>
 * <p>
 * <b>quiz </b> This creates a 2D array of the quiz questions and answers.
 * <p>
 * <b>isCorrect </b> This creates a boolean variable that indicates if the user's answer is correct or not.
 */
public class Recreation
{
  private String[] [] quiz = {{"Question", "Choice A", "Choice B", "Choice C", "Answer (refer to col number 2,3 or 4)"}};
  private boolean isCorrect;
  
  /**
   * The playFetch method is used to play the game.
   */
  public void playFetch ()
  {
    /*ask the question, run there, run back*/
  }
  
  /**
   * The displayRec method is used to show the graphics of the recreation game.
   */
  public void displayRec ()
  {
    /*Graphics go here*/
  }
  
  /**
   * The generateQuestion method is used to come up with the questions from the 2D array of quiz.
   * 
   * <p>
   * <b>Local variables: </b>
   * <p>
   * <b>question </b> This is the question the user will be asked.
   * 
   * @return question which is the String variable of the question that the user will be asked.
   */
  public String generateQuestion ()
  {
    String question = "";
    /*return random row from 2D quiz array as question to be asked*/
    return question;
  }
  
    /**
   * The getIsCorrect method is used to get the true or false if the user got the question right or not.
   * 
   * @return isCorrect which is the boolean variable that tells us if the user's input was right or wrong.
   */
  public boolean getIsCorrect ()
  {
    return isCorrect;
  }
}


