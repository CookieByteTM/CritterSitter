import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * The CritterSitterApp is the driver class that creates CritterSitterApp
 as well as executes the program.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 1 05.15.15
 */
public class CritterSitterApp extends JFrame implements ActionListener
{
  JDialog myDialog;
  
  public CritterSitterApp()
  {
    super ("Critter Sitter");
    
    ImageIcon pic = new ImageIcon("splashscreenbackground.jpg");
    JLabel map = new JLabel(pic);
    
    JMenuItem quitItem = new JMenuItem ("Quit");
    JMenuItem helpItem = new JMenuItem ("Help");
    JMenuItem aboutItem = new JMenuItem ("About");
    JMenu fileMenu = new JMenu ("File");
    JMenu helpMenu = new JMenu ("Help");
    fileMenu.add (quitItem);
    helpMenu.add (helpItem);
    helpMenu.add (aboutItem);
    
    JMenuBar myMenus = new JMenuBar ();
    helpItem.addActionListener (this);
    quitItem.addActionListener (this);
    aboutItem.addActionListener (this);
    myMenus.add (fileMenu);
    myMenus.add (helpMenu);
    
    setJMenuBar (myMenus);
    setSize (780, 590);
    setVisible (true);
    setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
    setResizable(false);
    add(new DisplayScreen());
    add(map);
  }
  
  public CritterSitterApp (String title, String label, int xSize)
  {
    dialog (title, label, xSize);
  }
  
  public void actionPerformed (ActionEvent ae)
  {    
    if (ae.getActionCommand ().equals ("Quit"))
    {
      System.exit (0);
    }
    else if (ae.getActionCommand ().equals ("Help"))
    {
      dialog ("Help Me!", "Help Me!", 100);
    }
    else
      if (ae.getActionCommand ().equals ("About"))
    {
      dialog ("About Game", "Here is some information regarding the game...", 750);
    }
  }
  
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