import javax.swing.*;
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
public class CritterHome extends JPanel implements MouseListener
{
  private String userName;
  private int points;
  private int difficulty;
  private int critterCharacter;
  private ArrayList<Food>fridge=new ArrayList<Food>();
  private Food selectedItem=new Food();
  private double hour;
  private int day;
  int handleFoodDialog;
  
  /**
   * The CritterHome constructor creates a critter sitter with the specified name, difficulty and character.
   * 
   * @param userName This String variable is used to save the user's name. 
   * @param difficulty This int variable is used to store the user's difficulty level.
   * @param critterCharacter This int variable is used to sstore the character number of the critter.
   */
  public CritterHome (String userName, int difficulty, int critterCharacter)
  {
    
    this.userName = userName;
    this.difficulty = difficulty;
    this.critterCharacter = critterCharacter;
  }
  
  public CritterHome()
  {
    addMouseListener(this);
    setLayout(null);
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
   * The getCritterCharacter method gets the user's critterCharacter.
   * 
   * @return critterCharacter the int variable of the user's critterCharacter.
   */
  public int getCritterCharacter ()
  {
    return critterCharacter;
  }
  
  /**
   * The getPoints method gets the user's points.
   * 
   * @return points the int variable of the user's points.
   */ 
  public int getPoints ()
  {
    return points;
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
  
  /**
   * The handleFood method creates and displays a JOptionPane to ask the user to decide what to do with the food.
   * <p>
   * <b>Local Variable Dictionary: </b>
   * <p>
   * <b> options[] </b> Object of the options of the handleFoodDialog.
   * <p>
   * <b> handleFood </b> The JOptionPane OptionDialog to ask the user to decide what to do with the food.
   */
  public void handleFood()
  {
    Object[] options = {"Feed Critter","Throw Out"};
    handleFoodDialog = JOptionPane.showOptionDialog(this, selectedItem.getName()+"\nFood Group: "+selectedItem.getFoodGroup()
						      +"\nNutritional Value: "+selectedItem.getNutrientValue(),                                   
						    "Feed Critter",
						    JOptionPane.YES_NO_OPTION,
						    JOptionPane.QUESTION_MESSAGE,
						    new ImageIcon(selectedItem.getIcon()),    
						    options, 
						    options[0]);
  }
  
  public void mouseClicked(MouseEvent e) 
  {
    for (int col=0; col<=fridge.size()*12; col+=63)
    {
      if (GroceryStore.correctCol(e.getX(),col+8)&&e.getY()>=8&&e.getY()<=68)
      {
	selectedItem=fridge.get(col/63);
	handleFood();
	break;
      }
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
  public void mouseEntered(MouseEvent e) {}
  
  /**
   * The mouseExited method listens for a mouse exit.
   * @param e MouseEvent that stores the user's mouse actions.
   */
  @Override
  public void mouseExited(MouseEvent e) {}
  
  /**
   * The mouseReleased method listens for a mouse release.
   * @param e MouseEvent that stores the user's mouse actions.
   */
  @Override
  public void mouseReleased(MouseEvent e){}
  
  @Override
  public void paintComponent(Graphics g)
  {
    Image bg = new ImageIcon ("CritterHomeBG.jpg").getImage();
    g.drawImage(bg, 0, 0,this);
    for (int x=0;x<fridge.size();x++)
    {
      //JOptionPane.showMessageDialog(this, "Eggs are not supposed to be green.");
      g.drawImage(new ImageIcon((fridge.get(x)).getIcon()).getImage(),x*63+8, 8,this);
    }
  } 
}
