import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * The CritterSitterApp is the driver class that creates CritterSitterApp as well as executes the program.
 * It also extends JFrame, so it creates the frame and adds panels to it using CardLayout. 
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
 * <b> cards </b> This creates an instance of the JPanel class to store all the cards for CardLayout.
 * <p>
 * <b> card4 </b> This creates an instance of the JPanel class for home.
 * <p>
 * <b> card5 </b> This creates an instance of the JPanel class for groceryStore.
 * <p>
 * <b> card7 </b> This creates an instance of the JPanel class for recreation.
 * <p>
 * <b> home</b> This creates an instance of the CritterHome class.
 * <p>
 * <b> askData</b> This creates an instance of the AskData class.
 * <p>
 * <b> mainMenu</b> This creates an instance of the MainMenu class.
 * <p>
 * <b> groceryStore</b> This creates an instance of the GroceryStore class.
 * <p>
 * <b> recreation</b> This creates an instance of the Recreation class.
 */
public class CritterSitterApp extends JFrame
{
  JPanel cards;
  JPanel card4;
  JPanel card5;
  JPanel card7;
  static CritterHome home;
  static AskData askData;
  MainMenu mainMenu;
  Recreation recreation;
  GroceryStore groceryStore;
  
  /**
   * CritterSitterApp method is used to create the CritterSitterApp object in RAM while passing the String title "CritterSitter". 
   * Finally, this method sets the performance window to 778 x 566, is visible to the user and not resizeable.
   * It also ensures the window will do nothing when the user pushes the 'x' button.
   * Instead, a WindowListener is added to the frame and the exitOn method in mainMenu is called.
   * ActionListeners are used to make sure that clicking a button in one of the panels of CardLayout will lead to the correct one. 
   * 
   * For the mainMenu's ActionListener, the first if statement checks if the action command is "Play".
   * Else, the if statement checks if the action command is "HighScores" which will diplay the HighScores panel.
   * The nexted if statement of the first if statement checks if home is not initalized yet which then displays a JOptionPane to the user.
   * If the user chooses to continue their game, the CritterHome panel is shown.
   * If the user wants a new game, the AskData panel is shown and home is reinitalized.
   * 
   * For the askData's ActionListener, the first if statement checks if the action command is "Ok".
   * If so, the next if statement checks the user satisfied all conditions when entering data which will then call startGame and display the card4.
   * 
   * Cards 1,2,3,6,7 and 8 are added to the JPanel set to the layout of CardLayout, which is added to the frame.
   * 
   * <p>
   * <b>Local Variable Dictionary: </b>
   * <p>
   * <b> card1 </b> This creates an instance of the SplashScreen class as a JPanel.
   * <p>
   * <b> card2 </b> This stores the MainMenu JPanel.
   * <p>
   * <b> card3 </b> This creates an instance of the Doctor class as a JPanel.
   * <p>
   * <b> card6 </b> This creates an instance of the Pamphlet class as a JPanel.
   * <p>
   * <b> card7 </b> This creates an instance of the Recreation class as a JPanel.
   * <p>
   * <b> card8 </b> This creates an instance of the AskData class as a JPanel.
   * <p>
   * <b> cl </b> This is the card layout used for program flow.
   * <p>
   * <b> n </b> This is the integer that stores the user's choice for the JOptionPane.
   * <p>
   * <b> options </b> This is the Object array of the String options in the JOptionPane.
   */
  public CritterSitterApp()
  {
    super ("CritterSitter");
    
    mainMenu=new MainMenu();
    mainMenu.setButtonsActionListener(new ActionListener()
                                        {
      public void actionPerformed(ActionEvent e)
      {
        CardLayout cl = (CardLayout)(cards.getLayout());
        int n=1;
        if (e.getActionCommand().equals("Play"))
        {
          if (home==null)
          {
              cl.show(cards,"AskData");
          }
          else
          {
            Object [] options={"Continue Saved Game","New Game"};
             n=JOptionPane.showOptionDialog(null, "Do you want to start a new game?", "Play Game",JOptionPane.YES_NO_OPTION,
                                               JOptionPane.PLAIN_MESSAGE,null,options,options[0]);
            if (n==0)
            {
              home.clock.start();
              cl.show(cards,"CritterHome");
            }
            else
            {
              askData=new AskData();
              home=null;
            }
          }
        }
        else
        {
          if (e.getActionCommand().equals("HighScores"))
          {
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
            home.clock.start();
            cl.show(cards,"CritterHome");
          }
        }
      }
    }
    );
    
    JPanel card1 = new SplashScreen();
    JPanel card2 = mainMenu;
    JPanel card3=new Doctor();
    JPanel card8=askData;
    
    cards = new JPanel(new CardLayout());
    //cards.add(card1, "SplashScreen");
    cards.add(card2, "MainMenu");
    cards.add(card3,"Doctor");
    cards.add(card8,"AskData");
    
    add(cards, BorderLayout.CENTER);
    setSize (778, 566);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        mainMenu.onExit();
      }
    });
    setResizable(false);
    setVisible (true);
  }
  
  /**
   * The startGame method starts the game by intializing and adding more cards of the critter's home and grocery store.
   */
  public void startGame()
  {
    home=new CritterHome(askData.getName(),askData.getDifficultyNum(),askData.getCritter());
    groceryStore=new GroceryStore();
    recreation=new Recreation();
    card4=home;
    card5=groceryStore;
    card7=recreation;
    cards.add(card4,"CritterHome");
    cards.add(card5,"GroceryStore");
    cards.add(card7, "Recreation");
    startListeners();
  }
  
  /**
   * The startListeners method adds the ActionListeners to the buttons in home and groceryStore.
   * 
   * For the home's ActionListener, the first if statement checks if the action command is "Store", which will then diplay the card5.
   * Else, if the action command is "Recreation" card7 is displayed.
   * Else, if the action command is "Doctor" card3 is displayed.
   * Else, if the action command is "Pamphlet" card6 is displayed.
   * Else, if the action command is "Menu" card2 is displayed.
   * Then the leaveDialog is disposed of.
   * 
   * For the groceryStore's ActionListener, the first if statement checks if the action command is "Exit", which will then diplay the card4.
   */
  public void startListeners()
  {
    home.setButtonsActionListener(new ActionListener()
                                    {
      public void actionPerformed(ActionEvent e)
      {
        CardLayout cl = (CardLayout)(cards.getLayout());
        if (e.getActionCommand().equals("Store"))
        {
          cl.show(cards,"GroceryStore");
          groceryStore.repaint();
        }
        else if (e.getActionCommand().equals("Recreation"))
        {
          cl.show(cards,"Recreation");
        }
        else if (e.getActionCommand().equals("Doctor"))
        {
          cl.show(cards,"Doctor");
        }
        else
        {
          home.clock.stop();
          if (e.getActionCommand().equals("Menu"))
          {
            JOptionPane.showMessageDialog(null,"Your game will be saved as long as \nyou do not quit from the main menu.");
          }
          else
          {
            home=null;
            askData.reset();
          }
          cl.show(cards,"MainMenu");
        }
        if (home!=null)
          home.homeDialog.dispose();
      }
    });
    
    groceryStore.setButtonsActionListener (new ActionListener ()
                                             {
      public void actionPerformed (ActionEvent e)
      {
        if (e.getActionCommand().equals("Exit"))
        {
          CardLayout cl = (CardLayout)(cards.getLayout());
          home.clock.start();
          cl.show(cards,"CritterHome");
        }
      }
    }
    );
  }
  
  /**
   * The delay method delays the program by the number of miliseconds indicated.
   * The try block is for Thread.sleep
   * <p>
   * <b> Exception </b> Exception e when an error occurs with Thread.sleep
   * @param delayNum the integer of the number of miliseconds to delay the program by.
   */
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
