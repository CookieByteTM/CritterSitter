import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * The DisplayScreen class is the class that extends the JPanel and all the graphics goes on it.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 1 05.15.15
 * 
 * <p>
 * <b>name: DisplayScreen.java </b>
 *
 * <p>
 * <b>Instance variables: </b>
 */
public class DisplayScreen extends JPanel 
{
  //BufferedImage backgroundImage;
 // BufferedImage logo;
  
  /**
   * The DisplayScreen constructor is used to create the background image.
   */
  public DisplayScreen()
  {
    ImageIcon pic = new ImageIcon("CompanyNameSplashScreen.jpg");
    JLabel background = new JLabel(pic);
    this.add(background);
   // button();
    //repaint();
  }
  
  
  public void button()
  {
    JButton calculate = new JButton ("Calculate");
    add (calculate);
    calculate.addActionListener (new ActionListener ()
                                   {
      public void actionPerformed (ActionEvent e)
      {
        System.out.println ("YESSS!");
      }
    }
    );
  }
}

