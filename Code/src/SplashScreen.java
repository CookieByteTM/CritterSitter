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
    Image gameName = new ImageIcon ("name.jpg").getImage();
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
      g.drawImage(gameName, 200, y-200, this);
        animate(2);
      }
      else if (x >= 550 && x < 800)
      {
      g.drawImage(gameName, 200, (350 - (y-549)), this);
        animate(2);
      }
      else if (x >= 800 && x < 1050)
      {
      g.drawImage(gameName, 200, (99 + (y-799)), this);
        animate(1);
      }
      else if (x >= 1050 && x < 1200)
      {
      g.drawImage(gameName, 200, (350 - (y-1049)), this);
        animate(1);
      }
      else if (x >= 1200 && x < 1350)
      {
      g.drawImage(gameName, 200, (199 + (y-1199)), this);
        animate(1);
      }
      else if (x >= 1350 && x < 1370)
      {
      g.drawImage(gameName, 200, (350 - (y-1349)), this);
        animate(5);
      }
      else if (x >= 1370 && x < 1380)
      {
      g.drawImage(gameName, 200, (329 + (y-1369)), this);
        animate(5);
      }
      else if(x >= 1380 && x < 1680)
      {
      g.drawImage(gameName, 200, 340 - (y-1379), this);
        animate(5);
      }
      else
      {
      g.drawImage(gameName, 200, 39, this);
        if (x >= 1680 && x <1780)
        {
          g.setColor (Color.BLACK);
          g.setFont (new Font ("Calibri", Font.BOLD, 35));
          g.drawString("Loading " + (x-1679) + " %", 285, 460);
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
          if (x == 1778)
          {
            x = -1;
          }
        }
      }
    }
    if (x == -1)
    {
      mainMenu(g);
    }
  }
  
  /**
   * the mainMenu method is used to create the 4 buttons and controls what they do as well as the graphics in the menu.
   * 
   * <p>
   * <b>Local variables: </b>
   * <p>
   * <b>introductionLabel </b> This is the introduction label.
   * <p>
   * <b>playButton </b> This is a play button, that when pushed, plays the game.
   * <p>
   * <b>highScoresButton </b> This is a high scores button, that when pushed, shows the high scores.
   * <p>
   * <b>instructionsButton </b> This is an instructions button, that when pushed, shows the instructions of the game.
   * <p>
   * <b>quitButton </b> This is a quit button, that when pushed, quits the game. 
   * <p>
   * <b>doctorSkin </b> This creates the colour called doctorSkin.
   * <p>
   * <b>lightPink </b> This creates the colour called lightPink.
   * <p>
   * <b>xpoints </b> This is an int array that keeps the x points in the polygon array.
   * <p>
   * <b>ypoints </b> This is an int array that keeps the y points in the polygon array.
   * <p>
   * <b>doctorBlue </b> This creates the colour called doctorBlue.
   * <p>
   * <b>insets </b> This is the inset variable for positioning the buttons and label.
   * <p>
   * <b>size </b> This is the dimension variable for positioning and getting the size of the buttons and the label.
   * 
   * @param g This is the Graphics variable that is used to paint onto the panel.
   */  
  public void mainMenu(Graphics g)
  {
    Color doctorSkin = new Color (247, 224, 155);
    Color lightPink = new Color (255, 145, 162);
    Color doctorBlue = new Color (210, 247, 241);
    int xpoints[] = {510, 550, 590};
    int ypoints[] = {205, 255, 205};
    
    g.setColor (lightPink);
    g.fillRect (0, 0, 771, 537);
    
    g.setColor (Color.BLACK);
    g.fillRect (510, 400, 30, 100);
    g.fillRect (560, 400, 30, 100);
    g.setColor (Color.WHITE);
    g.fillRoundRect (485, 205, 130, 200, 65, 65);
    g.setColor (doctorBlue);
    g.fillPolygon (xpoints, ypoints, 3);
    g.setColor (Color.BLACK);
    g.drawOval (517, 180, 65, 80);
    g.drawLine (535, 257, 525, 300);
    g.fillOval (518, 295, 20, 20);
    g.setColor (doctorSkin);
    g.fillOval (500, 130, 100, 100);
    g.setColor (Color.BLACK);
    g.fillRect (505, 145, 90, 20);
    g.fillOval (530, 175, 10, 15);
    g.fillOval (560, 175, 10, 15);
    g.drawArc (537, 190, 30, 30, 180, 180);
    g.drawLine (570, 270, 600, 270);
    g.drawLine (570, 270, 570, 300);
    g.drawLine (600, 270, 600, 300);
    g.drawLine (570, 300, 585, 315);
    g.drawLine (600, 300, 585, 315);
    g.fillOval (485, 490, 55, 20);
    g.fillOval (560, 490, 55, 20);
    g.drawLine (495, 240, 495, 355);
    g.drawLine (605, 240, 605, 355);
    g.drawLine (505, 345, 490, 365);
    g.drawLine (595, 345, 610, 365);
    g.setColor (Color.BLUE);
    g.fillRoundRect (590, 265, 7, 15, 15, 15);
    g.setColor (Color.RED);
    g.fillRoundRect (580, 265, 7, 15, 15, 15);
    g.setColor (Color.lightGray);
    g.fillOval (533, 135, 35, 35);
    buttons();
    
  }
  
  public void buttons()
  {
    setLayout (null);
    Insets insets = getInsets();
    Dimension size;
    
    JLabel introductionLabel = new JLabel ("Welcome to Critter Sitter! An educational and fun game to learn about nutrition! Please choose an option: ");
    add(introductionLabel);
    size = introductionLabel.getPreferredSize();
    introductionLabel.setBounds (80 + insets.left, 100 + insets.top, size.width, size.height);
    
    JButton playButton = new JButton ("Play");
    add(playButton);
    size = playButton.getPreferredSize();
    playButton.setBounds (355 + insets.left, 155 + insets.top, size.width, size.height);
    playButton.addActionListener (new ActionListener ()
                                    {
      public void actionPerformed (ActionEvent e)
      {
        System.out.println("play");
      }
    }
    );
    
    JButton highScoresButton = new JButton ("High Scores");
    add(highScoresButton);
    size = highScoresButton.getPreferredSize();
    highScoresButton.setBounds (332 + insets.left, 195 + insets.top, size.width, size.height);
    highScoresButton.addActionListener (new ActionListener ()
                                          {
      public void actionPerformed (ActionEvent e)
      {
        System.out.println("high scores");
      }
    }
    );
    
    JButton instructionsButton = new JButton ("Instructions");
    add(instructionsButton);
    size = instructionsButton.getPreferredSize();
    instructionsButton.setBounds (332 + insets.left, 235 + insets.top, size.width, size.height);
    instructionsButton.addActionListener (new ActionListener ()
                                            {
      public void actionPerformed (ActionEvent e)
      {
        //JOptionPane pane = new JOptionPane("Please read the instructions below: \n Hello and welcome to CritterSitter. First you will see our magnificent splash screen. \n Once that is done you will arrive at the main menu where you can choose to see the high scores, read the instructions, quit and play the game. \n If you click the high scores you will go to a different page with the top 10 high scores. \n If you click the instructions a window (this window) will pop-up and tell you how to play. \n If you click quit you will exit the game and see a good bye window. \n Finally, if you click the play button, you will go to a different screen where you input your username. Next you will choose your \n difficulty of either 3, 5 or 7 days as well as the character of the 5 choices.  \n Once done, you will visit the adoption centre where the doctor will show you the statistics of the game and “talk” to you. \n Afterwards you will go to the home screen where it will give you a small tutorial of what each of the things do.");
        JOptionPane.showMessageDialog(null, "Please read the instructions below: \n Hello and welcome to CritterSitter. First you will see our magnificent splash screen. \n Once that is done you will arrive at the main menu where you can choose to see the high scores, read the instructions, quit and play the game. \n If you click the high scores you will go to a different page with the top 10 high scores. \n If you click the instructions a window (this window) will pop-up and tell you how to play. \n If you click quit you will exit the game and see a good bye window. \n Finally, if you click the play button, you will go to a different screen where you input your username. Next you will choose your \n difficulty of either 3, 5 or 7 days as well as the character of the 5 choices.  \n Once done, you will visit the adoption centre where the doctor will show you the statistics of the game and “talk” to you. \n Afterwards you will go to the home screen where it will give you a small tutorial of what each of the things do.");
        //pane.setBounds(0, 0, 100, 100);   
        //pane.setVisible(true);
      }
    }
    );
    
    JButton quitButton = new JButton ("Quit");
    add(quitButton);
    size = quitButton.getPreferredSize();
    quitButton.setBounds (355 + insets.left, 275 + insets.top, size.width, size.height);
    quitButton.addActionListener (new ActionListener ()
                                    {
      public void actionPerformed (ActionEvent e)
      {
        JOptionPane.showMessageDialog(null, "Thank you for playing and come again soon! Bye!");
        System.exit(0);
      }
    }
    );
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

