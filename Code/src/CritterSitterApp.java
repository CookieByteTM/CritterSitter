import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * The CritterSitterApp is the driver class that creates CritterSitterApp as well as executes the program.
 * It also extends JFrame, so it creates the frame.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 2 05.22.15
 * 
 * <p>
 * <b>name: CritterSitterApp.java </b>
 *
 * <p>
 * <b>Instance variables: </b>
 */
public class CritterSitterApp extends JFrame
{
  JDialog myDialog;
  
  /**
   * CritterSitterApp method is used to create the CritterSitterApp object in RAM while passing the String title, this also creates 3 menu items of Quit, Help and About which can be accessed through the 2 menus of File and Help respectively.It also adds the 5 items to the actual menu which is created and called 'myMenus'.Finally, this method sets the performance window to 400, 400 and visible to the user.It also ensures the window will closed when the user pushes the 'x' button.
   */
  public CritterSitterApp()
  {
    super ("Critter Sitter");
    
    add(new SplashScreen());
    //add(new AskName());
      
    setSize (778, 566);
    setVisible (true);
    setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
    setResizable(false);
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
