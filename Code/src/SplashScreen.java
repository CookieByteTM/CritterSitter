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
 * @version 3 05.29.15
 * 
 * <p>
 * <b>name: DisplayScreen.java </b>
 *
 * <p>
 * <b>Instance variables: </b>
 * <p>
 * <b>insets </b> This is the inset variable for positioning the buttons and label.
 * <p>
 * <b>size </b> This is the dimension variable for positioning and getting the size of the buttons and the label.
 * <p>
 * <b>x </b> This int variable is used for the animations.
 * <p>
 * <b>y </b> This int variable is used for the animations as well.
 */
public class SplashScreen extends JPanel 
{
  int x;
  int y;
  Insets insets = getInsets();
  Dimension size;
  
  /**
   * The paintComponent method is used to paint all the things on the splash screen and main menu.
   * The if statement is used if the variable x does not equal -1, so it will do the splash screen or else it will not do the splash screen.
   * 
   * @param g is the Graphics parameter.
   */
  public void paintComponent(Graphics g)
  {
    if (x != -1)
    {
      theSplashScreen(g);
    }
  }
  
  /**
   * The animate method is used to animate the splash screen by calling the move method, repainting it and putting it to a certain delay number.
   * 
   * @param delayNumber this is the int number of the delay the programmer wants.
   */
  public void animate (int delayNumber)
  {
    CritterSitterApp.delay(delayNumber);
    move();  
    repaint();
  }
  
  /**
   * The theSplashScreen method is used to actually create the splash screen by dividing it into different sectors of the x values to do different things.
   * The first if statement is used to draw the background image for a while so the user knows that the program was created by the company CookieByte
   * The next if statement is used to draw the blue background for the rest of the duration of the splash screen.
   * The nested ifs that follow (8) are used to make the critter sitter text "bounce" up and down.
   * The last nested ifs (8) is used to ensure the title stays on the screen and that the loading comes with the cookie being eaten.
   * The final if statement is used to see if the value is equal to a certain number before it continues to the rest of the program.
   * 
   * @param g is the graphics parameter.
   * 
   * <p>
   * <b>Local variables: </b>
   * <p>
   * <b>image </b> This is the first image that appears.
   * <p>
   * <b>image2 </b> This is the second image (the blue background) that appears.
   */
  public void theSplashScreen(Graphics g)
  {
    Image gameName = new ImageIcon ("images/SplashScreen/SplashScreenGameName.jpg").getImage();
    if (x <= 200)
    {    
      Image image = new ImageIcon ("images/SplashScreen/CompanyNameSplashScreen.jpg").getImage();
      g.drawImage(image, 0, 0,this);
      animate(10);
      g.dispose();
    }
    else
    {
      Image image2 = new ImageIcon ("images/SplashScreen/MainMenuBackgroundBlue.jpg").getImage();
      g.drawImage(image2, 0, 0,this);    
      if (x >= 200 && x < 550)
      {    
      g.drawImage(gameName, 185, y-200, this);
        animate(2);
      }
      else if (x >= 550 && x < 800)
      {
      g.drawImage(gameName, 185, (350 - (y-549)), this);
        animate(2);
      }
      else if (x >= 800 && x < 1050)
      {
      g.drawImage(gameName, 185, (99 + (y-799)), this);
        animate(1);
      }
      else if (x >= 1050 && x < 1200)
      {
      g.drawImage(gameName, 185, (350 - (y-1049)), this);
        animate(1);
      }
      else if (x >= 1200 && x < 1350)
      {
      g.drawImage(gameName, 185, (199 + (y-1199)), this);
        animate(1);
      }
      else if (x >= 1350 && x < 1370)
      {
      g.drawImage(gameName, 185, (350 - (y-1349)), this);
        animate(5);
      }
      else if (x >= 1370 && x < 1380)
      {
      g.drawImage(gameName, 185, (329 + (y-1369)), this);
        animate(5);
      }
      else if(x >= 1380 && x < 1680)
      {
      g.drawImage(gameName, 185, 340 - (y-1379), this);
        animate(5);
      }
      else
      {
      g.drawImage(gameName, 185, 39, this);
        if (x >= 1680 && x <1780)
        {
          g.setColor (Color.BLACK);
          g.setFont (new Font ("Calibri", Font.BOLD, 35));
          g.drawString("Loading " + (x-1679) + " %", 285, 460);
          animate(2);
        }
        if (x >= 1680 && x < 1694)
        {
          Image cookie1 = new ImageIcon ("images/SplashScreen/cookie1box.jpg").getImage();
          g.drawImage(cookie1, 285, 230,this);     
          animate(50);
        }
        else if (x >= 1694 && x < 1708)
        {
          Image cookie2= new ImageIcon ("images/SplashScreen/cookie2box.jpg").getImage();
          g.drawImage(cookie2, 285, 230,this);      
          animate(50);
        }
        else if (x >= 1708 && x < 1722)
        {
          Image cookie3 = new ImageIcon ("images/SplashScreen/cookie3box.jpg").getImage();
          g.drawImage(cookie3, 285, 230,this); 
          animate(100);
        }
        else if (x >= 1722 && x < 1736)
        {
          Image cookie4= new ImageIcon ("images/SplashScreen/cookie4box.jpg").getImage();
          g.drawImage(cookie4, 285, 230,this);     
          animate(100);
        }       
        else if (x >= 1736 && x < 1750)
        {
          Image cookie5 = new ImageIcon ("images/SplashScreen/cookie5box.jpg").getImage();
          g.drawImage(cookie5, 285, 230,this);    
          animate(100);
        }
        else if (x >= 1750 && x < 1764)
        {
          Image cookie6= new ImageIcon ("images/SplashScreen/cookie6box.jpg").getImage();
          g.drawImage(cookie6, 285, 230,this);     
          animate(100);
        }   
        else 
          if (x >= 1764 && x < 1780)
        {
          Image cookie7 = new ImageIcon ("images/SplashScreen/cookie7box.jpg").getImage();
          g.drawImage(cookie7, 285, 230,this);        
          animate(100);
          if (x == 1778)
          {
            x = -1;
          }
        }
      }
    }
  }
  
  
  /**
   * The move method controls the animations of the splash screen.
   */
  public void move () 
  {
    x += 1;
    y += 1;
  }
}

