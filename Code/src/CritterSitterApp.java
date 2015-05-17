import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * The CritterSitterApp is the driver class that creates CritterSitterApp as well as executes the program.
 * It also extends JFrame, so it creates the frame.
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
 * <b>myDialog </b> This JDialog variable is used to make the different dialog boxes.
 */
public class CritterSitterApp extends JFrame implements ActionListener
{
  JDialog myDialog;
  
  /**
   * CritterSitterApp method is used to create the CritterSitterApp object in RAM while passing the String title, this also creates 3 menu items of Quit, Help and About which can be accessed through the 2 menus of File and Help respectively.It also adds the 5 items to the actual menu which is created and called 'myMenus'.Finally, this method sets the performance window to 400, 400 and visible to the user.It also ensures the window will closed when the user pushes the 'x' button.
   */
  public CritterSitterApp()
  {
    super ("Critter Sitter");
    setSize (780, 590);
    setVisible (true);
    setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
    setResizable(false);
//    add(new DisplayScreen());
//    try 
//    {
//      Thread.sleep (100); 
//    } 
//    catch (Exception e) 
//    {
//    }
//    repaint();
    // ^above stuff works
    add(new SplashScreen());
  }
  
  //do we need this method?
  public CritterSitterApp (String title, String label, int xSize)
  {
    dialog (title, label, xSize);
  }
  
  /**
   * This method is used if the a button was clicked.It will create a new performance window with a title and specific dimensions and layout, and if the button created is clicked, it will close the output console.
   * The first block of code is used to set-up the new performance window with the strin title, the xSize x 100 dimensions, no resizable function and the layout to FlowLayout.
   * The next block of code is used to create the actual button with the string "Close", it also indicates that if an action was performed to dispose the new window created and add the button to the performance console with the visible setting.
   * The last block of code is used to create the new JLabel called labels with the passed in string label to font serif to a certain size, this is then added.
   * 
   * @param title is used to pass in the string title of the output window
   * @param label is used to pass in the label text for the window
   * @param xSize is passed in to change the width of the output console depending on the length of the label. 
   * 
   * <p>
   * <b>Local variables: </b>
   * <p>
   * <b>closeButton </b> This variable is used to create the new button with the string "Close".
   */
  public void dialog (String title, String label, int xSize)
  {
    
    myDialog = new JDialog (this, title);
    myDialog.setSize (xSize, 100); 
    myDialog.setResizable (false);
    myDialog.setLayout (new FlowLayout ());
    
    JButton closeButton = new JButton ("Close");
    closeButton.addActionListener (new ActionListener ()
                                     {
      public void actionPerformed (ActionEvent e)
      {
        myDialog.dispose ();
      }
    }
    );
    JLabel labels;
    labels = new JLabel (label);
    labels.setFont (new Font ("Serif", Font.PLAIN, 16));
    myDialog.add (labels);
    myDialog.add (closeButton);
    myDialog.setLocationRelativeTo (this);
    myDialog.setVisible (true);
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
