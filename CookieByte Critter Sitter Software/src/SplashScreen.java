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
  Color lightBlue = new Color(51, 174, 210);
  int x;
  int y;
  
  //@overide
  public void paintComponent(Graphics g)
  {
    theSplashScreen(g);
  }
  
  public void animate (int delayNumber)
  {
    CritterSitterApp.delay(delayNumber);
    move();  
    repaint(); 
  }
  
  public void theSplashScreen(Graphics g)
  {
    if (x <= 200)
    {    
      Image image = new ImageIcon ("CompanyNameSplashScreen.jpg").getImage();
      g.drawImage(image, 0, 0,this);
      animate(10);
      g.dispose();
    }
    else
    {
      Image image2 = new ImageIcon ("MainMenuBackgroundBlue.jpg").getImage();
      g.drawImage(image2, 0, 0,this);    
      if (x >= 200 && x < 550)
      {    
        g.setColor (Color.RED);
        g.fillRect(200, y-200, 300, 150);
        animate(2);
      }
      else if (x >= 550 && x < 800)
      {
        g.setColor (Color.RED);
        g.fillRect(200, (350 - (y-549)), 300, 150);
        animate(2);
      }
      else if (x >= 800 && x < 1050)
      {
        g.setColor (Color.RED);
        g.fillRect(200, (99 + (y-799)), 300, 150);
        animate(1);
      }
      else if (x >= 1050 && x < 1200)
      {
        g.setColor (Color.RED);
        g.fillRect(200, (350 - (y-1049)), 300, 150);
        animate(1);
      }
      else if (x >= 1200 && x < 1350)
      {
        g.setColor (Color.RED);
        g.fillRect(200, (199 + (y-1199)), 300, 150);
        animate(1);
      }
      else if (x >= 1350 && x < 1370)
      {
        g.setColor (Color.RED);
        g.fillRect(200, (350 - (y-1349)), 300, 150);
        animate(5);
      }
      else if (x >= 1370 && x < 1380)
      {
        g.setColor (Color.RED);
        g.fillRect(200, (329 + (y-1369)), 300, 150);
        animate(5);
      }
      else if(x >= 1380 && x < 1680)
      {
        g.setColor (Color.RED);
        g.fillRect(200, 340 - (y-1379), 300, 150);
        animate(10);
      }
      else
      {
        g.setColor (Color.RED);
        g.fillRect(200, 39, 300, 150);
        g.fillRect(300, 230, 170, 170);
        if (x >= 1680 && x <1780)
        {
          g.setColor (Color.BLACK);
          g.setFont (new Font ("Helvetica", Font.BOLD, 25));
          g.drawString("Loading" + (x-1679) + "%", 270, 350);
          animate(2);
        }
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

