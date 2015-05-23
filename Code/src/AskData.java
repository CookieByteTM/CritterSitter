import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * The askName class is the class that extends the JPanel and ask the user for their name. It implements action listener for the buttons.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 3 05.29.15
 * 
 * <p>
 * <b>name: askName.java </b>
 * 
 * <p>
 * <b>Instance Variables: </b>
 * <p>
 * <b>name </b>This is the string variable to store the user's name.
 * <p>
 * <b>difficultyNum </b>This is an int variable that keeps track of the number of virtual days.
 * <p>
 * <b>critter </b>This is a string variable that keeps track of the colour of the user's critter.
 * <p>
 * <b>userName </b>This is the user name text field where the user enters their user name.
 * <p>
 * <b>critterChoice </b>This is the text field where the user chooses which critter they want.
 */
public class AskData extends JPanel implements ActionListener
{
  String name = "";
  int difficultyNum = 3;
  String critter = "";
  JTextField userName = new JTextField (50);
  JTextField critterChoice = new JTextField (20);
  
  /**
   * the paintComponent method is used to create the graphics.
   * 
   * <p>
   * <b>Local variables: </b>
   * <p>
   * <b>lightYellow </b> This creates the colour called lightYellow.
   * <p>
   * <b>character1 </b> This creates the image of the first character.
   * <p>
   * <b>character2 </b> This creates the image of the second character.
   * <p>
   * <b>character3 </b> This creates the image of the third character.
   * <p>
   * <b>character4 </b> This creates the image of the fourth character.
   * <p>
   * <b>character5 </b> This creates the image of the fifth character.
   * 
   * @param g this is the graphics variable that will be used to create the background colour for screen.
   */
  public void paintComponent (Graphics g)
  {
    Color lightYellow = new Color (245, 239, 107);
    g.setColor(lightYellow);
    g.fillRect (0, 0, 771, 537);
    
    Image character1 = new ImageIcon ("RedCritter.jpg").getImage();
    g.drawImage(character1, 47, 380,this);
    Image character2 = new ImageIcon ("OrangeCritter.jpg").getImage();
    g.drawImage(character2, 185, 380,this);
    Image character3 = new ImageIcon ("YellowCritter.jpg").getImage();
    g.drawImage(character3, 323, 380,this);
    Image character4 = new ImageIcon ("BlueCritter.jpg").getImage();
    g.drawImage(character4, 477, 380,this);
    Image character5 = new ImageIcon ("PurpleCritter.jpg").getImage();
    g.drawImage(character5, 604, 380,this);
  }
  
  /**
   * the fields method is used to ask for the user's name.
   * 
   * <p>
   * <b>Local variables: </b>
   * <p>
   * <b>askTheName </b> This is the label that asks the user for their name.
   * <p>
   * <b>okButton </b> This is a the ok button that submits all the user's inputs and saves it.
   * <p>
   * <b>difficultyLabel </b> This is the difficulty label that asks the user for it's difficulty.
   * <p>
   * <b>threeButton </b> This is is the three button for 3 virtual days in the difficulty.
   * <p>
   * <b>insets </b> This is the inset variable for positioning the buttons and label.
   * <p>
   * <b>size </b> This is the dimension variable for positioning and getting the size of the buttons and the label.
   * <p>
   * <b>fiveButton </b> This is is the five button for 5 virtual days in the difficulty.
   * <p>
   * <b>sevenButton </b> This is is the seven button for 7 virtual days in the difficulty.
   * <p>
   * <b>group </b> This is a group of buttons for the radio buttons.
   * <p>
   * <b>radioPanel </b> This is a radio panel where the radio buttons are added on to.
   */
  public AskData()
  {
    setLayout(null);
    Insets insets = getInsets();
    Dimension size;
    
    JLabel askTheName = new JLabel ("Please enter your name below: ");
    askTheName.setFont (new Font ("Serif", Font.PLAIN, 15));
    size = askTheName.getPreferredSize();
    askTheName.setBounds (25 + insets.left, 100 + insets.top, size.width, size.height);
    size = userName.getPreferredSize();
    userName.setBounds (25 + insets.left, 120 + insets.top, size.width, size.height);    
    add (askTheName);
    add (userName);
    
    JButton okButton = new JButton ("Ok");
    add(okButton);
    size = okButton.getPreferredSize();
    okButton.setBounds (350 + insets.left, 500 + insets.top, size.width, size.height); 
    okButton.addActionListener (this); 
    
    JLabel difficultyLabel = new JLabel ("Please choose the difficulty (the number of virtual days): ");
    difficultyLabel.setFont (new Font ("Serif", Font.PLAIN, 15));
    size = difficultyLabel.getPreferredSize();
    difficultyLabel.setBounds (25 + insets.left, 180 + insets.top, size.width, size.height);
    add(difficultyLabel);

    //Create the radio buttons.
    JRadioButton threeButton = new JRadioButton("3 Days");
    threeButton.setMnemonic(KeyEvent.VK_3);
    threeButton.setActionCommand("3 Days");
    threeButton.setSelected(true);
    
    JRadioButton fiveButton = new JRadioButton("5 Days");
    fiveButton.setMnemonic(KeyEvent.VK_5);
    fiveButton.setActionCommand("5 Days");
    
    JRadioButton sevenButton = new JRadioButton("7 Days");
    sevenButton.setMnemonic(KeyEvent.VK_7);
    sevenButton.setActionCommand("7 Days");
    
    //Group the radio buttons.
    ButtonGroup group = new ButtonGroup();
    group.add(threeButton);
    group.add(fiveButton);
    group.add(sevenButton);
    
    //Register a listener for the radio buttons.
    threeButton.addActionListener(this);
    fiveButton.addActionListener(this);
    sevenButton.addActionListener(this);
    
    JPanel radioPanel = new JPanel(new GridLayout(0, 1));
    radioPanel.add(threeButton);
    radioPanel.add(fiveButton);
    radioPanel.add(sevenButton);
    add(radioPanel, BorderLayout.LINE_START);
    size = radioPanel.getPreferredSize();
    radioPanel.setBounds (25 + insets.left, 210 + insets.top, size.width, size.height); 
    setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    
    JLabel characterSelectionLabel = new JLabel ("Please enter the character number (red = 1, orange = 2, yellow = 3, blue = 4 and purple = 5): ");
    characterSelectionLabel.setFont (new Font ("Serif", Font.PLAIN, 15));
    size = characterSelectionLabel.getPreferredSize();
    characterSelectionLabel.setBounds (25 + insets.left, 310 + insets.top, size.width, size.height);
    size = critterChoice.getPreferredSize();
    critterChoice.setBounds (25 + insets.left, 340 + insets.top, size.width, size.height);    
    add(characterSelectionLabel);
    add (critterChoice);
  }
  
  /**
   * This method is used when there is an action performed by the user through an input device. 
   * The first if statement is used to see if the user clicked the ok button or the three different day buttons.
   * The nested if in the "ok" pushed if statement is used if the user inputted a username or not, if not then a message comes up indicating that they need to input a value.
   * The try block is used to parse the integer value to see if the user inputted an inteer or not. 
   * The if statement in the try block is used to check if the user inputted a number within the desinated range (1, 2, 3, 4 or 5).
   * The if statement in the else is used to store the colour of the critter that was chosen.
   * The last if statement is used in the else to see if the user clicked the 7 days button.
   *
   * @param ae  This creates an instance of the ActionEvent class and helps to see if an action has been performed.
   */
  public void actionPerformed (ActionEvent ae)
  {    
    if (ae.getActionCommand ().equals ("Ok"))
    {
      if (userName.getText().length() == 0 )
      {
        JOptionPane.showMessageDialog(null, "Please input a user name!");
      }
      else
       name = userName.getText(); 
      try
      {
        int number = Integer.parseInt (critterChoice.getText());
        if (number <= 0 || number >= 6)
        {
          JOptionPane.showMessageDialog(null, "Please input a number either 1, 2, 3, 4 or 5!");
          critterChoice.setText ("");
          critterChoice.requestFocusInWindow();
        }
        else
        {
         if (number == 1)
           critter = "red";
         else if (number == 2)
           critter = "orange";
         else if (number == 3)
           critter = "yellow";
         else if (number == 4)
           critter = "blue";
         else
           critter = "purple";
        } 
      }
      catch (NumberFormatException n)
      {
        JOptionPane.showMessageDialog(null, "Please input a number!");
        critterChoice.setText ("");
        critterChoice.requestFocusInWindow();
      } 
      System.out.println(name);
      System.out.println(difficultyNum);
      System.out.println(critter);
    }
    else if (ae.getActionCommand ().equals ("3 Days"))
    {
      difficultyNum = 3;
    }
    else if (ae.getActionCommand ().equals ("5 Days"))
    {
      difficultyNum = 5;
    }
    else
      if (ae.getActionCommand ().equals ("7 Days"))
    {
      difficultyNum = 7;
    }
  }
}

