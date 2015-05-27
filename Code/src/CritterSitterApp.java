import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * The CritterSitterApp is the driver class that creates CritterSitterApp as well as executes the program.
 * It also extends JFrame, so it creates the frame.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 3 05.29.15
 * 
 * <p>
 * <b>name: CritterSitterApp.java </b>
 *
 * <p>
 * <b>Instance variables: </b>
 * <p>
 * <b>myDialog </b> This JDialog variable is used to make the different dialog boxes.
 */
public class CritterSitterApp extends JFrame
{
  JDialog myDialog;
  JPanel cards;
  static CritterHome home;
  AskData askData;
  JPanel card4;
  JPanel card5;
  MainMenu mainMenu;
  GroceryStore groceryStore;
  
  /**
   * CritterSitterApp method is used to create the CritterSitterApp object in RAM while passing the String title. Finally, this method sets the performance window to 400, 400 and visible to the user.It also ensures the window will closed when the user pushes the 'x' button.
   */
  public CritterSitterApp()
  {
    super ("Critter Sitter");
    
    Critter myCritter;
    
    mainMenu=new MainMenu();
    mainMenu.setButtonsActionListener(new ActionListener()
                                        {
      public void actionPerformed(ActionEvent e)
      {
        if (e.getActionCommand().equals("Play"))
        {
          CardLayout cl = (CardLayout)(cards.getLayout());
          cl.show(cards,"AskData");
        }
        else
        {
          if (e.getActionCommand().equals("HighScores"))
          {
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards,"HighScores");
          }
        }
      }
    });
    
    askData=new AskData();
    askData.setButtonsActionListener (new ActionListener ()
                                        {
      public void actionPerformed (ActionEvent e)
      {
        if (e.getActionCommand().equals("Ok"))
        {
          askData.actionPerformed (e);
          if (askData.getOk())
          {
          startGame();
          CardLayout cl = (CardLayout)(cards.getLayout());
          cl.show(cards,"CritterHome");
          }
        }
      }
    }
    );
    
   
    
    JPanel card1 = new SplashScreen();
    JPanel card2 = mainMenu;
    JPanel card3=new Doctor();
    JPanel card6=new Pamphlet();
    JPanel card7=new Recreation();
    JPanel card8=askData;
    
    cards = new JPanel(new CardLayout());
    //cards.add(card1, "SplashScreen");
    cards.add(card2, "MainMenu");
    cards.add(card3,"Doctor");
    cards.add(card6,"Pamphlet");
    cards.add(card7, "Recreation");
    cards.add(card8,"AskData");
    
    add(cards, BorderLayout.CENTER);
    setSize (778, 566);
    setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
    setResizable(false);
    setVisible (true);
  }
  
  public void startGame()
  {
    home=new CritterHome(askData.getName(),askData.getDifficultyNum(),askData.getCritter());
    groceryStore=new GroceryStore();
    card4=home;
    card5=groceryStore;
    cards.add(card4,"CritterHome");
    cards.add(card5,"GroceryStore");
    startListeners();
  }
  
  public void startListeners()
  {
    home.setButtonsActionListener(new ActionListener()
                                    {
      public void actionPerformed(ActionEvent e)
      {
        if (e.getActionCommand().equals("Store"))
        {
          CardLayout cl = (CardLayout)(cards.getLayout());
          cl.show(cards,"GroceryStore");
        }
        else if (e.getActionCommand().equals("Recreation"))
        {
          CardLayout cl = (CardLayout)(cards.getLayout());
          cl.show(cards,"Recreation");
        }
        else if (e.getActionCommand().equals("Doctor"))
        {
          CardLayout cl = (CardLayout)(cards.getLayout());
          cl.show(cards,"Doctor");
        }
        else if (e.getActionCommand().equals("Pamphlet"))
        {
          CardLayout cl = (CardLayout)(cards.getLayout());
          cl.show(cards,"Pamphlet");
        }
        else
        {
          if (e.getActionCommand().equals("Menu"))
          {
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards,"MainMenu");
          }
        }
      }
    });
    
    groceryStore.setButtonsActionListener (new ActionListener ()
                                             {
      public void actionPerformed (ActionEvent e)
      {
        if (e.getActionCommand().equals("Exit"))
        {
          CardLayout cl = (CardLayout)(cards.getLayout());
          cl.show(cards,"CritterHome");
        }
      }
    }
    );
  }
  
  public static void delay(int delayNum)
  {
    try 
    {
      Thread.sleep (delayNum); 
    } 
    catch (Exception e) 
    {
    }
  }
  
  /** Description of main(String [] args)
    * This method calls the CritterSitterApp constructor to
    * create the application.
    *
    * @param args [ ]  String array that allows command line
    * parameters to be used when executing the program.
    */
  public static void main (String[] args)
  {
    new CritterSitterApp();
  }
}
