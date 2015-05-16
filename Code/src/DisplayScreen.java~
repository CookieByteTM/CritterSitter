import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class DisplayScreen extends JPanel 
{
  BufferedImage backgroundImage;
  BufferedImage logo;
  
  public DisplayScreen()
  {
    button();
    repaint();
  }
  
  @Override
  public void paintComponent(Graphics g) 
  {
    try 
    {
      backgroundImage = ImageIO.read(new File("E:\\School\\2014-2015\\ICS4U\\final Project\\CookieByte Critter Sitter Software\\splashscreenbackground.jpg"));
      //logo = ImageIO.read(new File("E:\\School\\2014-2015\\ICS4U\final Project\\CookieByte Critter Sitter Software\\character2.jpg"));
    } 
    catch (IOException e) 
    {
      e.printStackTrace();
    }
    
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    // g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));
    int x = (getWidth() - backgroundImage.getWidth()) / 2;
    int y = (getHeight() - backgroundImage.getHeight()) / 2;
    g2d.drawImage(backgroundImage, x, y, this);
    
    //g2d.setComposite(AlphaComposite.SrcOver.derive(1f - alpha));
    x = (getWidth() - logo.getWidth()) / 2;
    y = (getHeight() - logo.getHeight()) / 2;
    g2d.drawImage(logo, 60, y, this);
    g2d.dispose();
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

