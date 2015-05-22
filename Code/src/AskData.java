import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * The askName class is the class that extends the JPanel and ask the user for their name.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 2 05.22.15
 * 
 * <p>
 * <b>name: askName.java </b>
 */
public class AskData extends JPanel 
{
  String name = "";
  /**
   * the paintComponent method is used to create the graphics.
   * 
   * <p>
   * <b>Local variables: </b>
   * <p>
   * <b>lightYellow </b> This creates the colour called lightYellow.
   * 
   * @param g this is the graphics variable that will be used to create the background colour for screen.
   */
  public void paintComponent (Graphics g)
  {
    Color lightYellow = new Color (245, 239, 107);
    
    g.setColor(lightYellow);
    g.fillRect (0, 0, 771, 537);
  }
  
  /**
   * the fields method is used to ask for the user's name.
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
   * <b>insets </b> This is the inset variable for positioning the buttons and label.
   * <p>
   * <b>size </b> This is the dimension variable for positioning and getting the size of the buttons and the label.
   */
  public AskData()
  {
    setLayout(null);
    Insets insets = getInsets();
    Dimension size;
    
    JTextField userName = new JTextField (50);
    JLabel askTheName = new JLabel ("Please enter your name below: ");
    askTheName.setFont (new Font ("Serif", Font.PLAIN, 15));
    size = askTheName.getPreferredSize();
    askTheName.setBounds (25 + insets.left, 100 + insets.top, size.width, size.height);
    size = userName.getPreferredSize();
    userName.setBounds (25 + insets.left, 120 + insets.top, size.width, size.height);    
    add (askTheName);
    add (userName);
    
    JButton okButton = new JButton ("Ok!");
    add(okButton);
    size = okButton.getPreferredSize();
    okButton.setBounds (590 + insets.left, 115 + insets.top, size.width, size.height); 
    okButton.addActionListener (new ActionListener ()
                                  {
      public void actionPerformed (ActionEvent e)
      {
        name = userName.getText();
        if (name.length() < 0 )
        {
          JOptionPane.showMessageDialog(null, "Please input a user name!");
        }
      }
    }
    );  
    
    JLabel difficultyField = new JLabel ("Please choose the difficulty (the number of virtual days: ");
    difficultyField.setFont (new Font ("Serif", Font.PLAIN, 15));
    size = difficultyField.getPreferredSize();
    difficultyField.setBounds (25 + insets.left, 140 + insets.top, size.width, size.height);
    //https://docs.oracle.com/javase/tutorial/uiswing/components/slider.html
  }
}

