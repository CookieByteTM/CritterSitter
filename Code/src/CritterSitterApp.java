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
  static CritterHome home=new CritterHome();
  
  /**
   * CritterSitterApp method is used to create the CritterSitterApp object in RAM while passing the String title. Finally, this method sets the performance window to 400, 400 and visible to the user.It also ensures the window will closed when the user pushes the 'x' button.
   */
  public CritterSitterApp()
  {
    super ("Critter Sitter");
    
//    JPanel comboBoxPane = new JPanel(); //use FlowLayout
//    String comboBoxItems[] = { "Store", "Home" };
//    JComboBox cb = new JComboBox(comboBoxItems);
//    cb.setEditable(false);
//    cb.addItemListener(this);
//    comboBoxPane.add(cb);
    home.setPoints(7);
    JPanel card1 = new GroceryStore();
    
    JButton exit=new JButton ("EXIT");
    exit.setBounds(13,472,70,50);
    exit.setBackground(new Color(239,58,68));
    exit.setFocusPainted(false);
    exit.addActionListener (new ActionListener ()
			      {
      public void actionPerformed (ActionEvent e)
      {
	CardLayout cl = (CardLayout)(cards.getLayout());
	cl.show(cards,"Home");
      }
    }
    );
    card1.add(exit);
    
    JPanel card2 = home;
    
    JButton store=new JButton ("Grocery Store");
    store.setBounds(600,470,70,50);
    store.setBackground(new Color(239,58,68));
    store.addActionListener (new ActionListener ()
			       {
      public void actionPerformed (ActionEvent e)
      {
	CardLayout cl = (CardLayout)(cards.getLayout());
	cl.show(cards,"Grocery Store");
      }
    }
    );
    card2.add(store);
    
    cards = new JPanel(new CardLayout());
    cards.add(card1, "Grocery Store");
    cards.add(card2, "Home");
    
    //add(comboBoxPane, BorderLayout.PAGE_START);
    add(cards, BorderLayout.CENTER);
    
    setSize (778, 566);
    setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
    setResizable(false);
    setVisible (true);
  }
  
//  public void itemStateChanged(ItemEvent evt) {
//    CardLayout cl = (CardLayout)(cards.getLayout());
//    cl.show(cards, (String)evt.getItem());
//  }
  
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
