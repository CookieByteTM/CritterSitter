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
  int x;
  int y;
  
  //@overide
  public void paintComponent(Graphics g)
  {
    splashScreen(g);
  }
  
  public void delay(int delayNum)
  {
    try {
      Thread.sleep (delayNum); 
    } 
    catch (Exception e) 
    {
    }
  }
  
  public void splashScreen(Graphics g)
  {
    Image image = new ImageIcon ("CompanyNameSplashScreen.jpg").getImage();
    g.drawImage(image,2,2,this);  
    move();   
    g.drawRect(x,y,100,100);
    delay(5);
    repaint();   
  }
  
  public void move () 
  {
    x += 5;
    y += 5;
  } // end method move
  
  
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

