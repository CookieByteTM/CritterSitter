import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Component;
import java.util.*;
/**
 * The CritterHome class is the class that creates the critter sitter (or the user in this case) who will take care of the critter.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 3 05.29.15
 * 
 * <p>
 * <b>name: CritterHome.java </b>
 *
 * <p>
 * <b>Instance variables: </b>
 * <p>
 * <b>userName </b> This String variable is used to save the user's name.
 * <p>
 * <b>points </b> This int variable is used to store the number of points of the user.
 * <p>
 * <b>difficulty </b> This int variable is used to store the user's difficulty level.
 * <p>
 * <b>critterCharacter </b> This int variable is used to sstore the character number of the critter.
 * <p>
 * <b>fridge </b> This Food array is used to see what food is in the user's fridge.
 * <p>
 * <b>hour </b> This double variable is used to store the hour of the virtual day.
 * <p>
 * <b>day </b> This int variable is used to store the number of the virtual day.
 */
public class CritterHome extends JPanel implements MouseListener, MouseMotionListener
{
  private String userName;
  private int points;
  private int difficulty;
  private String critterColour;
  private ArrayList<Food>fridge=new ArrayList<Food>();
  private Food selectedItem=new Food();
  private int day;
  private int fridgeDialog=-1;
  private int leaveDialog;
  private int selectedIndex;
  JButton storeButton=new JButton("Grocery Store");
  JButton recButton=new JButton("Play Outside");
  JButton menuButton=new JButton("Main Menu");
  JButton docButton=new JButton("Doctor");
  JButton infoButton=new JButton("Pamphlet");
  boolean hoverDoor, hoverCritter, hoverCalendar; 
  Critter myCritter;
  boolean eaten;
  Timer clock;
  int hour,minute;
  JLabel timeLbl=new JLabel("00:00");
  
  /**
   * The CritterHome constructor creates a critter sitter with the specified name, difficulty and character.
   * 
   * @param userName This String variable is used to save the user's name. 
   * @param difficulty This int variable is used to store the user's difficulty level.
   * @param critterColour This String variable is used to store the critter's colour.
   */
  public CritterHome (String userName, int difficulty, String critterColour)
  {
    addMouseListener(this);
    addMouseMotionListener(this);
    setLayout(null);
    
    this.userName = userName;
    this.difficulty = difficulty;
    this.critterColour = critterColour;
    
    myCritter=new Critter(critterColour);
    
    clock = new Timer(500, new ActionListener() {
  public void actionPerformed(ActionEvent evt) {
   if (minute==59)
   {
     minute=0;
     hour++;
   }
   else
   {
     minute++;
   }
   if (minute<10)
   {
   timeLbl.setText(hour+":0"+minute);
   }
   else
   {
   timeLbl.setText(hour+":"+minute);
   }
      }
  });
    
    timeLbl.setBounds(640,300,90,20);
    add(timeLbl);
    clock.start();
  }
  
  public void setButtonsActionListener(ActionListener al)
  {
    storeButton.addActionListener(al);
    recButton.addActionListener(al);
    menuButton.addActionListener(al);
    docButton.addActionListener(al);
    infoButton.addActionListener(al);
    
    storeButton.setActionCommand("Store");
    recButton.setActionCommand("Recreation");
    menuButton.setActionCommand("Menu");
    docButton.setActionCommand("Doctor");
    infoButton.setActionCommand("Pamphlet");
  }
  
  public void addFood(Food food,int quantity)
  {
    for (int x=0;x<quantity;x++)
    {
      fridge.add(food);
    }
    repaint();
  }
  
  public int getFridgeSpace()
  {
    return 12-fridge.size();
  }
  
  /**
   * The getUserName method gets the user's name.
   * 
   * @return userName the String variable of the user's name.
   */
  public String getUserName ()
  {
    return userName;
  }
  
  /**
   * The getDifficulty method gets the user's difficulty.
   * 
   * @return difficulty the int variable of the user's difficulty.
   */
  public int getDifficulty ()
  {
    return difficulty;
  }
  
  /**
   * The getCritterCharacter method gets the critter's colour
   * 
   * @return critterCharacter the String variable of the critter's colour
   */
  public String getCritterColour ()
  {
    return critterColour;
  }
  
  /**
   * The getPoints method gets the user's points.
   * 
   * @return points the int variable of the user's points.
   */ 
  public int getPoints ()
  {
    //return points;
    return 50;
  }
  
  /**
   * The setPoints method sets the user's points.
   * 
   * @param points This is the points that it will be set to.
   */ 
  public void setPoints (int points)
  {
    this.points = points;
  }
  
  /**
   * The getHour method gets the user's virtual hour.
   * 
   * @return hour the int variable of the user's virtual hour.
   */ 
  public double getHour ()
  {
    return hour;
  }
  
  /**
   * The getDay method gets the user's virtual day.
   * 
   * @return day the int variable of the user's virtual day.
   */ 
  public int getDay ()
  {
    return day;
  }
  
  /**
   * The passTime method passes time on the user's virtual day.
   * 
   * @param numHours This int variable is used to indicate the number of hours.
   */ 
  public void passTime(int numHours)
  {
    /*add hours and if it goes on to the next day, increment day and rest time to morning*/
  }
  
  public void handleFridgeDialog()
  {
    if (fridgeDialog!=JOptionPane.CLOSED_OPTION)
    {
      if (fridgeDialog==0)
      {
        if (myCritter.getFullness(0)+selectedItem.getNutrientValue()>10)
          JOptionPane.showMessageDialog(this, "Your critter is too full to eat this!");
        else
        {
          myCritter.addStomach(selectedItem,0);//meal
          eaten=true;
        }
      }
      if (eaten=true||fridgeDialog==1)
      {
      fridge.remove(selectedIndex);
      repaint();
      }
    }
  }
  
  public void fullnessBar(Graphics g)
  {
    g.setColor(Color.blue);
    g.fillRect(15,497,myCritter.getFullness(0)*74,28);//meal
  }
  
  /**
   *
   * The mouseReleased method listens for a mouse release.
   *
   * The handleFodDialog creates and displays a JOptionPane to ask the user to decide what to do with the food.
   * <p>
   * <b>Local Variable Dictionary: </b>
   * <p>
   * <b> options[] </b> Object of the options of the fridgeDialog.
   * <p>
   * <b> handleFood </b> The JOptionPane OptionDialog to ask the user to decide what to do with the food.
   * 
   * @param e MouseEvent that stores the user's mouse actions.
   */
  public void mouseClicked(MouseEvent e) 
  {
    for (int col=0; col<fridge.size()*63; col+=63)
    {
      if (GroceryStore.correctCol(e.getX(),col+8)&&e.getY()>=8&&e.getY()<=68)
      {
        selectedItem=fridge.get(col/63);
        selectedIndex=col/63;
        Object []options = {"Feed Critter","Throw Out"};
        fridgeDialog = JOptionPane.showOptionDialog(this, selectedItem.getName()+"\nFood Group: "+selectedItem.getFoodGroup()
                                                      +"\nNutritional Value: "+selectedItem.getNutrientValue(),                                   
                                                    "My Fridge",
                                                    JOptionPane.YES_NO_OPTION,
                                                    JOptionPane.PLAIN_MESSAGE,
                                                    new ImageIcon(selectedItem.getIcon()),    
                                                    options, 
                                                    options[0]);
        handleFridgeDialog();
      }
    }
    if (e.getX()>=26&&e.getX()<=135&&e.getY()>=275&&e.getY()<=405)
    {
      JButton []options = {storeButton,recButton,docButton,infoButton,menuButton};
      leaveDialog = JOptionPane.showOptionDialog(this, "Where do you want to go? \nClose the GPS once you \nhave reached your desired \ndestination.",                                   
                                                 "GPS",
                                                 JOptionPane.DEFAULT_OPTION,
                                                 JOptionPane.QUESTION_MESSAGE,
                                                 new ImageIcon("images/Critter/gps.jpg"),    
                                                 options, 
                                                 options[0]);
    }
  }
  
  /**
   * The mousePressed method listens for a mouse press.
   * @param e MouseEvent that stores the user's mouse actions.
   */
  @Override
  public void mousePressed(MouseEvent e) {}
  
  /**
   * The mouseEntered method listens for a mouse enter.
   * @param e MouseEvent that stores the user's mouse actions.
   */
  @Override
  public void mouseEntered(MouseEvent e) 
  {
  }
  
  /**
   * The mouseExited method listens for a mouse exit.
   * @param e MouseEvent that stores the user's mouse actions.
   */
  @Override
  public void mouseExited(MouseEvent e) 
  {
    
  }
  
  /**
   * The mouseReleased method listens for a mouse release.
   * @param e MouseEvent that stores the user's mouse actions.
   */
  @Override
  public void mouseReleased(MouseEvent e){}
  
  /**
   * The mouseMoved method listens for a mouse movement.
   * @param e MouseEvent that stores the user's mouse actions.
   */
  @Override
  public void mouseMoved(MouseEvent e) {
    
    if (e.getX()>=26&&e.getX()<=135&&e.getY()>=275&&e.getY()<=405)
    {
      hoverDoor=true;
    }
    else
    {
      hoverDoor=false;
    }
    if (e.getX()>=200&&e.getX()<=540&&e.getY()>=140&&e.getY()<=470)
    {
      hoverCritter=true;
    }
    else
    {
      hoverCritter=false;
    }
     if (e.getX()>=605&&e.getX()<=760&&e.getY()>=85&&e.getY()<=260)
    {
      hoverCalendar=true;
    }
    else
    {
      hoverCalendar=false;
    }
    repaint();
  }
  
  /**
   * The mouseDragged method listens for a mouse drag.
   * @param e MouseEvent that stores the user's mouse actions.
   */
  @Override
  public void mouseDragged(MouseEvent e){}
  
  @Override
  public void paintComponent(Graphics g)
  {
    Image bg = new ImageIcon ("images/Critter/EmptyHomeBG.jpg").getImage();
    Image glowDoor=new ImageIcon ("images/Critter/GlowDoor.png").getImage();
    Image speechBubble=new ImageIcon ("images/Critter/SpeechBubble.png").getImage();
    Image morningView=new ImageIcon ("images/Critter/morning.png").getImage();
    Image critter=new ImageIcon ("images/Critter/"+critterColour+"/"+critterColour+"Adult.png").getImage();
    Image schedulePic=new ImageIcon ("images/Critter/Schedule.png").getImage();
    g.drawImage(bg, 0, 0,this);
    g.drawImage(morningView,4,70,this);
    g.drawImage(critter,200,140,this);
    
    if (hoverDoor)
    {
      g.drawImage(glowDoor, 0, 250,this);
    }
    if (hoverCritter)
    {
      g.drawImage(speechBubble, 30, 355,this);
    }
    if (hoverCalendar)
    {
      g.drawImage(schedulePic, 17, 85,this);
    }
    
    if (eaten=true&&fridgeDialog==0)
    {
      g.drawImage(speechBubble, 30, 355,this);
      g.drawImage(new ImageIcon((myCritter.getStomach()).getIcon()).getImage(),85, 385,this);
      fullnessBar(g);
      eaten=false;
      fridgeDialog=-1;
    }
    
    for (int x=0;x<fridge.size();x++)
    {
      g.drawImage(new ImageIcon((fridge.get(x)).getIcon()).getImage(),x*63+8, 8,this);
    }
  } 
}
