import java.io.*;
/**
 * The HighScores class is the class that generates and outputs the high scores
 * of the top 10 games won on an output file.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 2 05.22.15
 * 
 * <p>
 * <b>name: HighScores.java </b>
 *
 * <p>
 * <b>Instance variables: </b>
 * <p>
 * <b>currentScores </b> This is a String array that stores the current high scores.
 * <p>
 * <b>in </b> This is a BufferedReader variable that allows reading files to be done.
 */
public class HighScores
{
  String[] currentScores;
  BufferedReader in;
  
  /**
   * The displayScores method reads the high scores from the file HighScores.txt, ensures that there are scores in there and displays them.
   * 
   * <p>
   * <b>Local variables: </b>
   * <p>
   * <b>numScores </b> This is an int variable that counts the number of scores in the file.
   * 
   * 
   */
  //exception IOException e an IOException.
//  public void displayScores ()
//  {
//    int numScores = 0;
//      try
//    {
//      in = new BufferedReader (new FileReader ("HighScores.txt"));
//      if ((line == in.readLine ()) != null)
//        numScores = Integer.parseInt (line);
//      for (int x = 0 ; x < numScores ; x++)
//      {
//        // c.print (' ', 10);
//        // c.print (input.readLine ()
//        //         , 27);
//        // c.print (input.readLine ());
//        // c.print (' ', 27);
//        // c.println (x + 1);
//      }
//    }
//    catch (IOException e)
//    {
//    }
//  }
  
  /**
   * The updateScores method processes and updates the scores by sorting them.
   * 
   * <p>
   * <b>Local variables: </b>
   * <p>
   * <b>numScores </b> This is an int variable that counts the number of scores in the file.
   * <p>
   * <b>playerName </b> This is a String array that keeps track of the player names
   * <p>
   * <b>scoreArray </b> This is an int array that keeps track of the player's scores.
   * <p>
   * <b>out </b> This is a PrintWriter variable that lets printing to files allowed.
   * 
   * @param score This is the score that will be used for the highscorers (if in the top 10).
   * //exception IOException e an IOException.
   */
  public void updateScores (int score)
  {
    int numScores = 1;
    String[] playerName = new String [11]; //ASSUMING IT IS TOP TEN SCORES
    int[] scoreArray = new int [11];
    scoreArray[0]=score;//the lates score is added to array to be sorted
    PrintWriter out;
    /*
     try
     {
     in = new BufferedReader (new FileReader ("HighScores.txt"));
     if ((line = in.readLine ()) != null)
     {
     if (!line.equals ("11"))
     {
     numScores += Integer.parseInt (line);
     }
     else
     {
     numScores = 11;
     }
     }
     for (int e = 1 ; e < numScores ; e++)
     {
     playerName [e] = in.readLine ();
     score [e] = Integer.parseInt (in.readLine ());
     }
     for (int x = z - 1 ; x > 0 ; x--)
     {
     first = 0;   //initialize to first array number
     for (int y = 1 ; y <= x ; y++) //find smallest value of array
     {
     if (score [y] > score [first])
     first = y;
     }
     temp = score [first];    //exchange the smallest value of array with the first position
     temp2 = playerName [first];
     score [first] = score [x];
     playerName [first] = playerName [x];
     score [x] = temp;
     playerName [x] = temp2;
     }
     }
     catch (IOException e)
     {
     }
     try
     {
     out = new PrintWriter (new FileWriter ("HighScores.txt"));
     if (numScores == 11)
     out.println (10);
     else
     out.println (numScores);
     for (w = 0 ; w < 10 && w < numScores ; w++)
     {
     out.println (playerName [w]);
     out.println (score [w]);
     }
     out.close ();
     }
     catch (IOException e)
     {
     }
     */
    
  }
}
