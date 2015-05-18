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
public class SplashScreen extends JPanel 
{
  Color lightBlue = new Color(51,174,210);
  int x;
  int y;
  int temp = 0;
  String c = "";
  
  //@overide
  public void paintComponent(Graphics g)
  {
    theSplashScreen(g);
  }
  
  public void delay(int delayNum)
  {
    try 
    {
      Thread.sleep (delayNum); 
    } 
    catch (Exception e) 
    {
    }
  }
  
  public void theSplashScreen(Graphics g)
  {
    if (x <= 200)
    {    
      Image image = new ImageIcon ("CompanyNameSplashScreen.jpg").getImage();
      g.drawImage(image, 0, 0,this);
      move();   
      delay(10);
      repaint();
      g.dispose();
    }
    else
    {
      Image image2 = new ImageIcon ("MainMenuBackgroundBlue.jpg").getImage();
      g.drawImage(image2, 0, 0,this);
      // x = temp;
      // y = temp;      
      if (x >= 200 && x < 550)
      {    
        move();
        g.setColor (Color.RED);
        g.fillRect(200, y-200, 300, 150);
        delay(2);
        repaint();
      }
      else if (x >= 550 && x < 800)
      {
        move();
        g.setColor (Color.RED);
        g.fillRect(200, (350 - (y-549)), 300, 150);
        delay(2);
        repaint();
      }
      else if (x >= 800 && x < 1050)
      {
        move();
        g.setColor (Color.RED);
        g.fillRect(200, (350 - (y-549)), 300, 150);
        delay(2);
        repaint();
      }
    }
  }
  
  public void move () 
  {
    x += 1;
    y += 1;
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

