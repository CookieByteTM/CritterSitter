import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 */
public class MainMenu extends JPanel
{
  int x = 0;
  //public MainMenu()
  //{
  //  buttons();
  // }
  
  public void paintComponent(Graphics g)
  {
    buttons();
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
        JOptionPane.showMessageDialog(null, "Please read the instructions below: \n Hello and welcome to CritterSitter. First you will see our magnificent splash screen. \n Once that is done you will arrive at the main menu where you can choose to see the high scores, read the instructions, quit and play the game. \n If you click the high scores you will go to a different page with the top 10 high scores. \n If you click the instructions a window (this window) will pop-up and tell you how to play. \n If you click quit you will exit the game and see a good bye window. \n Finally, if you click the play button, you will go to a different screen where you input your username. Next you will choose your \n difficulty of either 3, 5 or 7 days as well as the character of the 5 choices.  \n Once done, you will visit the adoption centre where the doctor will show you the statistics of the game and “talk” to you. \n Afterwards you will go to the home screen where it will give you a small tutorial of what each of the things do.");
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
  
}

