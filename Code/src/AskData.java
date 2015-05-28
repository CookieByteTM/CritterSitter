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
  String name = "username";
  int difficultyNum = 3;
  String critter = "Red";
  JTextField userName = new JTextField (50);
  JButton okButton = new JButton ("Ok");
  boolean ok;
  
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
    g.drawImage(new ImageIcon ("images/AskDataBG.png").getImage(), 0, 0,this);
    
    g.drawImage(new ImageIcon ("images/Critter/Red/RedCritter.png").getImage(), 590, 150,this);
    g.drawImage(new ImageIcon ("images/Critter/Blue/BlueCritter.png").getImage(), 590, 221,this);
    g.drawImage(new ImageIcon ("images/Critter/Purple/PurpleCritter.png").getImage(), 590, 290,this);
    g.drawImage(new ImageIcon ("images/Critter/Orange/OrangeCritter.png").getImage(), 590, 360,this);
    g.drawImage(new ImageIcon ("images/Critter/Yellow/YellowCritter.png").getImage(), 590, 435,this);
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
   * <b>fourButton </b> This is is the four button for 5 virtual days in the difficulty.
   * <p>
   * <b>fiveButton </b> This is is the five button for 7 virtual days in the difficulty.
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
    JLabel askCritter = new JLabel ("Please choose your critter:");
    askCritter.setBounds(489,105,190,20);
    size = userName.getPreferredSize();
    userName.setBounds (25 + insets.left, 120 + insets.top, 420,size.height);  
    userName.setText("username");
    add(askCritter);
    add (askTheName);
    add (userName);
    
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
    
    JRadioButton fourButton = new JRadioButton("4 Days");
    fourButton.setMnemonic(KeyEvent.VK_4);
    fourButton.setActionCommand("4 Days");
    
    JRadioButton fiveButton = new JRadioButton("5 Days");
    fiveButton.setMnemonic(KeyEvent.VK_5);
    fiveButton.setActionCommand("5 Days");
    
    //Group the radio buttons.
    ButtonGroup group = new ButtonGroup();
    group.add(threeButton);
    group.add(fourButton);
    group.add(fiveButton);
    
    //Register a listener for the radio buttons.
    threeButton.addActionListener(this);
    fourButton.addActionListener(this);
    fiveButton.addActionListener(this);
    
    JPanel radioPanel = new JPanel(new GridLayout(0, 1));
    radioPanel.add(threeButton);
    radioPanel.add(fourButton);
    radioPanel.add(fiveButton);
    add(radioPanel, BorderLayout.LINE_START);
    size = radioPanel.getPreferredSize();
    radioPanel.setBounds (25 + insets.left, 210 + insets.top, size.width, size.height); 
    setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    
    //Create the radio buttons.
    JRadioButton redButton = new JRadioButton("Red");
    redButton.setActionCommand("Red");
    redButton.setBounds(498,180,79,20);
    redButton.setSelected(true);
    
    JRadioButton blueButton = new JRadioButton("Blue");
    blueButton.setActionCommand("Blue");
    blueButton.setBounds(498,250,79,20);
    blueButton.setSelected(true);
    
    JRadioButton purpleButton = new JRadioButton("Purple");
    purpleButton.setActionCommand("Purple");
    purpleButton.setBounds(498,319,79,20);
    purpleButton.setSelected(true);
    
    JRadioButton orangeButton = new JRadioButton("Orange");
    orangeButton.setActionCommand("Orange");
    orangeButton.setBounds(498,387,79,20);
    orangeButton.setSelected(true);
    
    JRadioButton yellowButton = new JRadioButton("Yellow");
    yellowButton.setActionCommand("Yellow");
    yellowButton.setBounds(498,455,79,20);
    yellowButton.setSelected(true);
    
    
    //Group the radio buttons.
    ButtonGroup colourGroup = new ButtonGroup();
    colourGroup.add(redButton);
    colourGroup.add(blueButton);
    colourGroup.add(purpleButton);
    colourGroup.add(orangeButton);
    colourGroup.add(yellowButton);
    
    //Register a listener for the radio buttons.
    redButton.addActionListener(this);
    blueButton.addActionListener(this);
    purpleButton.addActionListener(this);
    orangeButton.addActionListener(this);
    yellowButton.addActionListener(this);
    
    add(redButton);
    add(blueButton);
    add(purpleButton);
    add(orangeButton);
    add(yellowButton);
    
    okButton.setBounds(337,493,60,30);
    add(okButton);
  }
  
  public void setButtonsActionListener(ActionListener al)
  {
    okButton.addActionListener(al);
    okButton.setActionCommand("Ok");
  }
  
  public String getName()
  {
    return name;
  }
  
  public int getDifficultyNum()
  {
    return difficultyNum;
  }
  
  public String getCritter()
  {
    return critter;
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
        userName.requestFocusInWindow();
        ok=false;
      }
      else
      {
        name = userName.getText(); 
        ok=true;
      }
    }
    else if (ae.getActionCommand ().equals ("Red"))
    {
      critter = "Red";
    }
    else if (ae.getActionCommand ().equals ("Blue"))
    {
      critter = "Blue";
    }
    else if (ae.getActionCommand ().equals ("Purple"))
    {
      critter = "Purple";
    }
    else if (ae.getActionCommand ().equals ("Orange"))
    {
      critter = "Orange";
    }
    else if (ae.getActionCommand ().equals ("Yellow"))
    {
      critter = "Yellow";
    }
    else if (ae.getActionCommand ().equals ("3 Days"))
    {
      difficultyNum = 3;
    }
    else if (ae.getActionCommand ().equals ("4 Days"))
    {
      difficultyNum = 5;
    }
    else
      if (ae.getActionCommand ().equals ("5 Days"))
    {
      difficultyNum = 7;
    }
  }
  
  public boolean getOk()
  {
    return ok;
  }
}

