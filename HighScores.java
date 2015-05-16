import java.io.*;

public class HighScores
{
    String[] currentScores;
    BufferedReader in;

    public void displayScores ()
    {
	int numScores = 0
	    try
	{
	    in = new BufferedReader (new FileReader ("HighScores.txt"));
	    if ((line = in.readLine ()) != null)
		numScores = Integer.parseInt (line);
	    for (int x = 0 ; x < numScores ; x++)
	    {
		// c.print (' ', 10);
		// c.print (input.readLine ()
		//         , 27);
		// c.print (input.readLine ());
		// c.print (' ', 27);
		// c.println (x + 1);
	    }
	}
	catch (IOException e)
	{
	}
    }


    public void processAndUpdateScores (int score)
    {
	int numScores = 1;
	String[] playerName = new String [11]; //ASSUMING IT IS TOP TEN SCORES
	int[] score = new int [11];
	score[0]=score;//the lates score is added to array to be sorted
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
