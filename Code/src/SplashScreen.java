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
	g.fillRect(200, y-200, 370, 150);
	animate(2);
      }
      else if (x >= 550 && x < 800)
      {
	g.setColor (Color.RED);
	g.fillRect(200, (350 - (y-549)), 370, 150);
	animate(2);
      }
      else if (x >= 800 && x < 1050)
      {
	g.setColor (Color.RED);
	g.fillRect(200, (99 + (y-799)), 370, 150);
	animate(1);
      }
      else if (x >= 1050 && x < 1200)
      {
	g.setColor (Color.RED);
	g.fillRect(200, (350 - (y-1049)), 370, 150);
	animate(1);
      }
      else if (x >= 1200 && x < 1350)
      {
	g.setColor (Color.RED);
	g.fillRect(200, (199 + (y-1199)), 370, 150);
	animate(1);
      }
      else if (x >= 1350 && x < 1370)
      {
	g.setColor (Color.RED);
	g.fillRect(200, (350 - (y-1349)), 370, 150);
	animate(5);
      }
      else if (x >= 1370 && x < 1380)
      {
	g.setColor (Color.RED);
	g.fillRect(200, (329 + (y-1369)), 370, 150);
	animate(5);
      }
      else if(x >= 1380 && x < 1680)
      {
	g.setColor (Color.RED);
	g.fillRect(200, 340 - (y-1379), 370, 150);
	animate(5);
      }
      else
      {
	g.setColor (Color.RED);
	g.fillRect(200, 39, 370, 150);
	if (x >= 1680 && x <1780)
	{
	  g.setColor (Color.BLACK);
	  g.setFont (new Font ("Calibri", Font.BOLD, 35));
	  g.drawString("Loading " + (x-1679) + " %", 305, 460);
	  animate(2);
	}
	if (x >= 1680 && x < 1694)
	    {
	      Image cookie1 = new ImageIcon ("cookie1box.jpg").getImage();
	      g.drawImage(cookie1, 285, 230,this);     
	      animate(50);
	    }
	  else if (x >= 1694 && x < 1708)
	  {
	    Image cookie2= new ImageIcon ("cookie2box.jpg").getImage();
	    g.drawImage(cookie2, 285, 230,this);      
	    animate(50);
	  }
	  else if (x >= 1708 && x < 1722)
	  {
	    Image cookie3 = new ImageIcon ("cookie3box.jpg").getImage();
	    g.drawImage(cookie3, 285, 230,this); 
	    animate(100);
	  }
	  else if (x >= 1722 && x < 1736)
	  {
	    Image cookie4= new ImageIcon ("cookie4box.jpg").getImage();
	    g.drawImage(cookie4, 285, 230,this);     
	    animate(100);
	  }       
	  else if (x >= 1736 && x < 1750)
	  {
	    Image cookie5 = new ImageIcon ("cookie5box.jpg").getImage();
	    g.drawImage(cookie5, 285, 230,this);    
	    animate(100);
	  }
	  else if (x >= 1750 && x < 1764)
	  {
	    Image cookie6= new ImageIcon ("cookie6box.jpg").getImage();
	    g.drawImage(cookie6, 285, 230,this);     
	    animate(100);
	  }   
	  else
	    if (x >= 1764 && x < 1780)
	  {
	    Image cookie7 = new ImageIcon ("cookie7box.jpg").getImage();
	    g.drawImage(cookie7, 285, 230,this);        
	    animate(100);
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

