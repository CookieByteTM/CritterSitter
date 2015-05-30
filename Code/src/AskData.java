import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

/**
 * The AskData class is the class that extends the JPanel and ask the user for their name. It implements action listener for the buttons.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 3 05.29.15
 * 
 * <p>
 * <b>name: AskName.java </b>
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
 * <b>okButton </b>This is the button for the user to enter all their data.
 * <p>
 * <b>ok </b>This is a boolean variable that indicates if the ok button was pushed or not.
 */
public class AskData extends JPanel implements ActionListener
{
  private String name = "username";
  private int difficultyNum=1;
  private String critter = "Red";
  JTextField userName = new JTextField (50);
  JButton okButton = new JButton ("Ok");
  private boolean ok;
  
  /**
   * the AskData constructor is used to create the fields, buttons and labels for the user to enter their information.
   * 
   * <p>
   * <b>Local variables: </b>
   * <p>
   * <b>askTheName </b> This is the label that asks the user for their name.
   * <p>
   * <b>difficultyLabel </b> This is the difficulty label that asks the user for it's difficulty.
   * <p>
   * <b>easyButton </b> This is is the easy button for the easy level.
   * <p>
   * <b>insets </b> This is the inset variable for positioning the buttons and label.
   * <p>
   * <b>size </b> This is the dimension variable for positioning and getting the size of the buttons and the label.
   * <p>
   * <b>mediumButton </b> This is is the medium button for the medium level.
   * <p>
   * <b>hardButton </b> This is is the hard button for the hard level.
   * <p>
   * <b>difficultyGroup </b> This is a group of buttons for the difficulty radio buttons.
   * <p>
   * <b>radioPanel </b> This is a radio panel where the radio buttons are added on to.
   * <p>
   * <b>redButton </b>This is the button for the red critter.
   * <p>
   * <b>blueButton </b>This is the button for the blue critter.
   * <p>
   * <b>purpleButton </b>This is the button for the purple critter.
   * <p>
   * <b>orangeButton </b>This is the button for the orange critter.
   * <p>
   * <b>yellowButton </b>This is the button for the yellow critter.
   * <p>
   * <b>colorGroup </b> This is a group of buttons for the different coloured critter radio button options.
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
    askCritter.setBounds(489, 105, 190, 20);
    size = userName.getPreferredSize();
    userName.setBounds (25 + insets.left, 120 + insets.top, 420,size.height);  
    userName.setText("username");
    add(askCritter);
    add (askTheName);
    add (userName);
    
    JLabel difficultyLabel = new JLabel ("Please select a level: ");
    difficultyLabel.setFont (new Font ("Serif", Font.PLAIN, 15));
    size = difficultyLabel.getPreferredSize();
    difficultyLabel.setBounds (25 + insets.left, 180 + insets.top, size.width, size.height);
    add(difficultyLabel);
    
    //Create the radio buttons.
    JRadioButton easyButton = new JRadioButton("Easy (3 Days)");
    easyButton.setMnemonic(KeyEvent.VK_3);
    easyButton.setActionCommand("easy");
    easyButton.setSelected(true);
    
    JRadioButton mediumButton = new JRadioButton("Medium (4 Days)");
    mediumButton.setMnemonic(KeyEvent.VK_4);
    mediumButton.setActionCommand("medium");
    
    JRadioButton hardButton = new JRadioButton("Hard (5 Days)");
    hardButton.setMnemonic(KeyEvent.VK_5);
    hardButton.setActionCommand("hard");
    
    //Group the radio buttons.
    ButtonGroup difficultyGroup = new ButtonGroup();
    difficultyGroup.add(easyButton);
    difficultyGroup.add(mediumButton);
    difficultyGroup.add(hardButton);
    
    //Register a listener for the radio buttons.
    easyButton.addActionListener(this);
    mediumButton.addActionListener(this);
    hardButton.addActionListener(this);
    
    JPanel radioPanel = new JPanel(new GridLayout(0, 1));
    radioPanel.add(easyButton);
    radioPanel.add(mediumButton);
    radioPanel.add(hardButton);
    add(radioPanel, BorderLayout.LINE_START);
    size = radioPanel.getPreferredSize();
    radioPanel.setBounds (25 + insets.left, 210 + insets.top, size.width, size.height); 
    
    //Create the radio buttons.
    JRadioButton redButton = new JRadioButton("Red");
    redButton.setActionCommand("Red");
    redButton.setBounds(498, 180, 79, 20);
    redButton.setSelected(true);
    
    JRadioButton blueButton = new JRadioButton("Blue");
    blueButton.setActionCommand("Blue");
    blueButton.setBounds(498, 250, 79, 20);
    
    JRadioButton purpleButton = new JRadioButton("Purple");
    purpleButton.setActionCommand("Purple");
    purpleButton.setBounds(498, 319, 79, 20);
    
    JRadioButton orangeButton = new JRadioButton("Orange");
    orangeButton.setActionCommand("Orange");
    orangeButton.setBounds(498, 387, 79, 20);
    
    JRadioButton yellowButton = new JRadioButton("Yellow");
    yellowButton.setActionCommand("Yellow");
    yellowButton.setBounds(498, 455, 79, 20);
    
    
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
    
    okButton.setBounds(335, 493, 60, 30);
    add(okButton);
  }
  
  /**
   * The setButtonsActionListener method is used to add action listener to the ok button as well as set its action command to "ok".
   * 
   * @param al This is the ActionListener varaible.
   */
  public void setButtonsActionListener(ActionListener al)
  {
    okButton.addActionListener(al);
    okButton.setActionCommand("Ok");
  }
  
  /**
   * This getName method is used to return the user's name.
   * 
   * @return name This is the user's String name.
   */
  public String getName()
  {
    return name;
  }
  
  /**
   * This getDifficultyNum method is used to return the user's difficulty choice. It needs to be static in order to be accessed through the recreation class.
   * 
   * @return difficultyNum This is the user's int difficulty number.
   */
  public int getDifficultyNum()
  {
    return difficultyNum;
  }
  
  /**
   * This getCritter method is used to return the user's critter colour choice.
   * 
   * @return critter This is the String color of the critter.
   */
  public String getCritter()
  {
    return critter;
  }
  
  public void reset()
  {
    userName.setText("username");
  }
  /**
   * This method is used when there is an action performed by the user through an input device. 
   * The first if statement is used to see if the user clicked the ok button, the 3 different day buttons and the 5 different colour buttons.
   * The nested if in the "ok" pushed if statement is used if the user inputted a username or not, if not then a message comes up indicating that they need to input a value.
   * The if statement in the else is used to store the colour of the critter that was chosen.
   * The last if statement is used in the else to see if the user clicked the hard level button.
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
        ok = false;
      }
      else
      {
        name = userName.getText(); 
        ok = true;
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
    else if (ae.getActionCommand ().equals ("easy"))
    {
      difficultyNum = 1;
    }
    else if (ae.getActionCommand ().equals ("medium"))
    {
      difficultyNum = 2;
    }
    else
      if (ae.getActionCommand ().equals ("hard"))
    {
      difficultyNum = 3;
    }
  }
  
  /**
   * This getOk method is used to return to see if the user can proceed to the next screen without error
   * 
   * @return true if there are no errors for the user input.
   */
  public boolean getOk()
  {
    return ok;
  }
  
  /**
   * The paintComponent method is used to create the graphics.
   * 
   * @param g this is the graphics variable that will be used to create the background colour for screen.
   */
  @Override
  public void paintComponent (Graphics g)
  {
    g.drawImage(new ImageIcon ("images/AskDataBG.png").getImage(), 0, 0,this);
    g.drawImage(new ImageIcon ("images/Critter/Red/RedCritter.png").getImage(), 590, 150,this);
    g.drawImage(new ImageIcon ("images/Critter/Blue/BlueCritter.png").getImage(), 590, 221,this);
    g.drawImage(new ImageIcon ("images/Critter/Purple/PurpleCritter.png").getImage(), 590, 290,this);
    g.drawImage(new ImageIcon ("images/Critter/Orange/OrangeCritter.png").getImage(), 590, 360,this);
    g.drawImage(new ImageIcon ("images/Critter/Yellow/YellowCritter.png").getImage(), 590, 435,this);
  }
}

