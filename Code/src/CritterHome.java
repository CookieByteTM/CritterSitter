import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
/**
 * The CritterHome class is the class that creates the home of the Critter which has a critter. 
 *
 * @author Jasmine Ou
 * @version 3 05.29.15
 * 
 * <p>
 * <b>name: Critter Home.java </b>
 *
 * <p>
 * <b>Instance variables: </b>
 * <p>
 * <b>userName </b> This String variable is used to save the user's name.
 * <p>
 * <b>message </b> This String variable is used to store what the critter will say.
 * <p>
 * <b>points </b> This int variable is used to store the number of points of the user.
 * <p>
 * <b>level </b> This int variable is used to store the user's selected level.
 * <p>
 * <b>selectedIndex </b> The int variable of the index of the food item's location in the fridge. 
 * <p>
 * <b>day </b> This int variable is used to store the virtual day number which is initalized to 1.
 * <p>
 * <b>hour </b> This int variable is used to store the virtual hour number.
 * <p>
 * <b>minute </b> This int variable is used to store the virtual minute number.
 * <p>
 * <b>meal </b> This int variable is used to store the meal number where 0 is breakfast, 1 is lunch and 2 is dinner.
 * <p>
 * <b>fridgeDialog </b> This int variable is used to store the user's choice when they click on the fridge's food. 
 * <p>
 * <b>hoverDoor </b> This boolean variable to store whether the user's mouse entered the picture of the door or not.
 * <p>
 * <b>hoverCritter </b> This boolean variable to store whether the user's mouse entered the picture of the critter or not.
 * <p>
 * <b>hoverCalendar </b> This boolean variable to store whether the user's mouse entered the picture of the calendar or not.
 * <p>
 * <b>hoverFridge </b> This boolean variable to store whether the user's mouse entered the picture of the fridge or not.
 * <p>
 * <b>eaten </b> This boolean variable to store whether the critter just ate something or not.
 * <p>
 * <b>fridge </b> An ArrayList of Food objects in the fridge. 
 * <p>
 * <b>selectedItem </b> The Food object that the user selected from their fridge.
 * <p>
 * <b>storeButton </b> This creates an instance of the JButton class with the string title "GroceryStore" passed in. 
 * <p>
 * <b>recButton </b> This creates an instance of the JButton class with the string title "Play Outside" passed in. 
 * <p>
 * <b>menuButton </b> This creates an instance of the JButton class with the string title "Main Menu" passed in. 
 * <p>
 * <b>docButton </b> This creates an instance of the JButton class with the string title "Doctor" passed in. 
 * <p>
 * <b>infoButton </b> This creates an instance of the JButton class with the string title "Pamphlet" passed in.
 * <p>
 * <b>nextDayButton </b> This creates an instance of the JButton class with the string title "Next Day" passed in.
 * <p>
 * <b>dietButton </b> This creates an instance of the JButton class with the string title "Today's Diet" passed in.
 * <p>
 * <b>nextLevelButton </b> This creates an instance of the JButton class with the string title "Next Level" passed in.
 * <p>
 * <b>doneButton </b> This creates an instance of the JButton class with the string title "Done" passed in.
 * <p>
 * <b>homeDialog </b> This creates an instance of the JDialog class for displaying a menu of choices to the user.
 * <p>
 * <b>dietDialog </b> This creates an instance of the JDialog class for displaying what the critter ate for the day. 
 * <p>
 * <b>myCritter </b> This creates an instance of the Critter class.
 * <p>
 * <b>clock </b> This creates an instance of the Timer class. 
 * <p>
 * <b>scheduled </b> The boolean array with 4 rows and 12 columns to store the accessibility of items during certain hours of the day. The rows are store, doctor, fridge and recreation. The columns start from hour 9 and ends at hour 20. 
 *
 */
public class CritterHome extends JPanel implements MouseListener, MouseMotionListener
{
  private String userName;
  private String message="Good Morning!";
  private int points, level,selectedIndex,hour, minute,meal;
  private int day=1;
  private int fridgeDialog=-1;
  private boolean hoverDoor, hoverCritter, hoverCalendar, hoverFridge,eaten; 
  private ArrayList<Food>fridge=new ArrayList<Food>();
  private Food selectedItem=new Food();
  JButton storeButton=new JButton("Grocery Store");
  JButton recButton=new JButton("Play Outside");
  JButton menuButton=new JButton("Main Menu");
  JButton docButton=new JButton("Doctor");
  JButton infoButton=new JButton("Pamphlet");
  JButton nextDayButton=new JButton("Next Day");
  JButton dietButton=new JButton("Today's Diet");
  JButton nextLevelButton=new JButton("Next Level");
  JButton doneButton=new JButton("Done");
  JLabel ptsLabel;
  JDialog homeDialog;
  Critter myCritter;
  Timer clock;
  boolean [][]scheduled={{true,true,true,true,true,false,false,false,true,true,false,true},{false,false,true,false,false,true,true,true,false,false,false,false},
    {true,true,false,true,true,false,false,false,false,true,true,false},{false,true,true,false,true,true,true,true,true,false,false,false}};
  
  /**
   * The CritterHome constructor creates a CritterHome with the specified userName and level.
   * It adds a MouseListener and a MouseMotionListener to the JPanel and sets the layout to null.
   * The Timer, clock, has an ActionListener that increments time in minutes and hours. 
   * The first if statement checks if minute is 59. If so, hour is incremented, else, minute is incremented.
   * The clock is started. 
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
    level = difficulty;
    
    myCritter=new Critter(critterColour);
    giveAllowance();
    
    ptsLabel=new JLabel("$"+points);
    ptsLabel.setBounds(675,387,68,27);
    add(ptsLabel);
    
    hour=9;//9
    
    clock = new Timer(500, new ActionListener() {//500
      public void actionPerformed(ActionEvent evt) 
      {
        if (hour==21)
        {
          clock.stop();
          if(day==level+2)//last day
          {
            endLevel();
            level++;
          }
          else
            endDay();
        }
        else
        {
          
          if (minute==59)
          {
            minute=0;
            hour++;
          }
          else
          {
            minute++;
          }
          repaint();
        }
        if (hour!=21)
        {
          if (!scheduled[0][hour-9])
          {
            storeButton.setEnabled(false);
          }
          else
          {
            storeButton.setEnabled(true);
          }
          
          if (!scheduled[1][hour-9])
          {
            docButton.setEnabled(false);
          }
          else
          {
            docButton.setEnabled(true);
          }
          
          if (!scheduled[3][hour-9])
          {
            recButton.setEnabled(false);
          }
          else
          {
            recButton.setEnabled(true);
          }
        }
        if((hour==12||hour==18)&&minute==0)
          meal++;
      }
    });
    clock.start();
    
    nextDayButton.addActionListener (new ActionListener ()
                                       {
      public void actionPerformed (ActionEvent e)
      {
        myCritter.newDay();
        if (!myCritter.getGrowthStage().equals("Adult"))
        {
          if (myCritter.getGrowthStage().equals("Baby"))
            myCritter.setGrowthStage("Teen");
          else
            myCritter.setGrowthStage("Adult");
        }
        day++;
        newDay();
      }
    }
    );
    
    nextLevelButton.addActionListener (new ActionListener ()
                                         {
      public void actionPerformed (ActionEvent e)
      {
        newLevel();
      }
    }
    );
  }
  
  public void newLevel()
  {
    day=1;
    points=0;
    myCritter.newLevel();
    newDay();
  }
  public void newDay()
  {
    giveAllowance();
    hour=9;//9
    meal=0;
    clock.start();
    repaint();
    homeDialog.dispose();
  }
  
  public void endDay()
  {
    JButton [] options = {nextDayButton,dietButton,menuButton};
    JOptionPane endDayPane=new JOptionPane("End of Day "+day, JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION,new ImageIcon("images/Critter/doneDay.png"), options);
    homeDialog = endDayPane.createDialog(this, "Day "+day);
    homeDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    homeDialog.setVisible(true);
  }
  
  public void endLevel()
  {
    JButton [] options = {nextLevelButton,dietButton,doneButton};
    if (level==3)
      nextLevelButton.setEnabled(false);
    JOptionPane endLevelPane=new JOptionPane("Congratulations "+userName+"!\nYou have completed Level "+level+".\nPress 'Next Level' only if you want to proceed to the next level.", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION,new ImageIcon("images/Critter/yay.jpg"), options);
    homeDialog = endLevelPane.createDialog(this, "End of Level "+level);
    homeDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    homeDialog.setVisible(true);
  }
  /**
   * The setButtonsActionListener method adds an ActionListener to each button and sets their action commands. 
   * 
   * @param al is the ActionListener passed in to be added to the buttons.
   */
  public void setButtonsActionListener(ActionListener al)
  {
    storeButton.addActionListener(al);
    recButton.addActionListener(al);
    menuButton.addActionListener(al);
    docButton.addActionListener(al);
    infoButton.addActionListener(al);
    doneButton.addActionListener(al);
    
    storeButton.setActionCommand("Store");
    recButton.setActionCommand("Recreation");
    menuButton.setActionCommand("Menu");
    docButton.setActionCommand("Doctor");
    infoButton.setActionCommand("Pamphlet");
    doneButton.setActionCommand("Done");
  }
  
  /**
   * 
   * The addFood method adds food to the fridge by quantity and repaints the fridge graphics.   
   * The for loop starts from 0, runs while less than quantity and increments by one each in order to add the correct amount of the food Object to the fridge.
   * 
   * <p>
   * <b>Local Variable Dictionary: </b>
   * <p>
   * <b> x </b> The integer for loop variable that starts from 0, runs while less than quantity and increments by one each in order to add the correct amount of the food Object to the fridge.
   * 
   * @param food is the Food object to be added to the fridge
   * @param quantity is the integer amount of the Food object to be added to the fridge.
   */
  public void addFood(Food food,int quantity)
  {
    for (int x=0;x<quantity;x++)
    {
      fridge.add(food);
    }
    repaint();
  }
  
  public void giveAllowance()
  {
    if(level==1)
    {
      points+=20;
    }
    else if(level==2)
    {
      points+=15;
    }
    else
    {
      points+=10;
    }
  }
  
  /**
   * The getFridgeSpace method gets the remaining fridge space where its maximum capacity is 12 items.
   * 
   * @return the integer storing the remaining fridge space.
   */
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
   * The getLevel method gets the user's level.
   * 
   * @return level the int variable of the user's level.
   */
  public int getLevel ()
  {
    return level;
  }
  
  /**
   * The getPoints method gets the user's points.
   * 
   * @return points the int variable of the user's points.
   */ 
  public int getPoints ()
  {
    //return points;
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
   * The getDay method gets the user's virtual day.
   * 
   * @return day the int variable of the user's virtual day.
   */ 
  public int getDay ()
  {
    return day;
  }
  
  /**
   * The getHour method gets the user's virtual hour.
   * 
   * @return hour the int variable of the user's virtual hour.
   */ 
  public int getHour ()
  {
    return hour;
  }
  
  /**
   * The getMinute method gets the user's virtual minute.
   * 
   * @return minute the int variable of the user's virtual minute.
   */ 
  public int getMinute ()
  {
    return minute;
  }
  
  /**
   * The handleFridgeDialog method handles the user's choice in the fridge dialog.
   * The first if statement checks if the user did not close the dialog.
   * If true, the next if statement checks if the user chose to feed their critter.
   * If true, the next if statement checks if the critter is too full to eat more food,
   * which means that the nutrient value of the food and the critter's fullness level exceeds 10.
   * If true, a JOptionPane tells the user that the critter is too full to eat anymore.
   * Else, the food is added to the stomach is eaten is set to true.
   * The next if statement checks if eaten is true or if the user chose to throw out the food.
   * If true, the food will be removed from the fridge and repaint the graphics. 
   * 
   */
  public void handleFridgeDialog()
  {
    if (fridgeDialog!=JOptionPane.CLOSED_OPTION)
    {
      if (fridgeDialog==0)
      {
        if (myCritter.getFullness(meal)+selectedItem.getNutrientValue()>10)//meal
        {
          JOptionPane.showMessageDialog(this, "Your critter is too full to eat this!");
          fridgeDialog=0;
          eaten=false;
        }
        else
        {
          myCritter.addStomach(selectedItem,meal);//meal
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
  
  /**
   * The fullnessBar method displays the bar that represents how full the critter is per meal.
   * 
   * @param g is the Graphics class to be used to display graphics.
   * 
   */
  public void fullnessBar(Graphics g)
  {
    Color [] colours={Color.green,Color.yellow,new Color(154,53,255),Color.red,Color.pink,Color.cyan};
    g.setFont(new Font(Font.SERIF,Font.BOLD,12));
    double currentXPoint=15.0;
    double width=0.0;
    double count=0.0;
    for (int x=0;x<6;x++)
    {
      if((count=(myCritter.getFoodGroupCount(meal,x)))!=0)
      {
        g.setColor(colours[x]);
        width=count*74;
        g.fillRect((int)currentXPoint,497,(int)width,28);
        currentXPoint+=width;
        g.setColor(Color.white);
        g.drawString(((int)(myCritter.calcPercentage(meal,x))+"%"),(int)(currentXPoint-width/2)-10,516);//47
      }
    }
  }
  
  /**
   * The endDay method is for displaying a dialog of options to the user at the end of a day.
   * 
   * <p>
   * <b>Local Variable Dictionary: </b>
   * <p>
   * <b> options [] </b> An array of instances of the JButton class for the options of the endDayDialog.
   * <p>
   * <b> endDayPane </b> An instance of the JOptionPane for the end of a day.
   */
  /**
   * The mouseClicked method listens for a mouse release.
   *
   * The first if statement checks if the fridge is scheduled to be accessible.
   * The for loop starts from 0, runs while less than the size of the fridge times 63 and increments by 63 each time.
   * That for loop is for checking through every icon in the fridge.
   * The first if statement checks if the user clicked one of the food icons.
   * If true, the selectedItem and selectedIndex variables are assigned according to the Food item clicked.
   * Then the fridgeDialog is shown to ask if the user wants to feed or throw out the food.
   * The next if statement checks if the user clicked on the door.
   * If true, the leaveDialog asks the user where they want to go by showing a menu of options to choose from. 
   * 
   * <p>
   * <b>Local Variable Dictionary: </b>
   * <p>
   * <b> fridgeOptions [] </b> Object of the options of the fridgeDialog.
   * <p>
   * <b> col </b> The integer loop variable that starts from 0, runs while less than the size of the fridge times 63 and increments by 63 each time.
   * <p>
   * <b> options [] </b> An array of instances of the JButton class for the options of the leaveDialog.
   * <p>
   * <b> leaveOptionPane </b> An instance of the JOptionPane that asks the user where they want to go.
   * <p>
   * <b> foodGroup </b> The String storing the food group of the food item.
   * 
   * @param e MouseEvent that stores the user's mouse actions.
   */
  public void mouseClicked(MouseEvent e) 
  {
    String foodGroup="";
    if (scheduled[2][hour-9])
    {
      for (int col=0; col<fridge.size()*63; col+=63)
      {
        if (GroceryStore.correctCol(e.getX(),col+8)&&e.getY()>=8&&e.getY()<=68)
        {
          selectedItem=fridge.get(col/63);
          selectedIndex=col/63;
          
          if (selectedItem.getFoodGroup()==0)
            foodGroup="Fruits and Vegetables";
          else if (selectedItem.getFoodGroup()==1)
            foodGroup="Grains";
          else if (selectedItem.getFoodGroup()==2)
            foodGroup="Dairy";
          else if (selectedItem.getFoodGroup()==3)
            foodGroup="Meats and Alternatives";
          else if (selectedItem.getFoodGroup()==4)
            foodGroup="Sugars and Fats";
          else
          {
            if (selectedItem.getFoodGroup()==5)
              foodGroup="Water";
          }
          
          Object [] fridgeOptions = {"Feed Critter","Throw Out"};
          fridgeDialog = JOptionPane.showOptionDialog(this, selectedItem.getName()+"\nFood Group: "+foodGroup
                                                        +"\nNutritional Value: "+selectedItem.getNutrientValue(),                                   
                                                      "My Fridge",
                                                      JOptionPane.YES_NO_OPTION,
                                                      JOptionPane.PLAIN_MESSAGE,
                                                      new ImageIcon(selectedItem.getIcon()),    
                                                      fridgeOptions, 
                                                      fridgeOptions[0]);
          //handleFridgeDialog();
          
          if (fridgeDialog!=JOptionPane.CLOSED_OPTION)
          {
            if (fridgeDialog==0)
            {
              if (myCritter.getFullness(meal)+selectedItem.getNutrientValue()>10)//meal
              {
                JOptionPane.showMessageDialog(this, "Your critter is too full to eat this!");
                fridgeDialog=0;
                eaten=false;
              }
              else
              {
                myCritter.addStomach(selectedItem,meal);//meal
                myCritter.setFoodGroupCount(selectedItem.getNutrientValue(),meal, selectedItem.getFoodGroup());
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
      }
    }
    if (e.getX()>=26&&e.getX()<=135&&e.getY()>=275&&e.getY()<=405)
    {
      JButton []options = {storeButton,recButton,docButton,infoButton,menuButton};
      JOptionPane leaveOptionPane=new JOptionPane("Where do you want to go?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, new ImageIcon("images/Critter/gps.jpg"), options);
      homeDialog = leaveOptionPane.createDialog(this, "GPS Navigator Menu");
      homeDialog.setVisible(true);
    }
  }
  
  
  /**
   * The mouseMoved method listens for a mouse movement.
   * The first if statement checks if the user hovered over the door and if true, sets hoverDoor to true, else, false. 
   * The first if statement checks if the user hovered over the critter and if true, sets hoverCritter to true, else, false. 
   * The first if statement checks if the user hovered over the calendar and if true, sets hoverCalendar to true, else, false. 
   * 
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
    if (e.getX()>=8&&e.getX()<=763&&e.getY()>=7&&e.getY()<=70)
    {
      hoverFridge=true;
    }
    else
    {
      hoverFridge=false;
    }
    repaint();
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
  public void mouseEntered(MouseEvent e){}
  
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
  
  /**
   * The mouseDragged method listens for a mouse drag.
   * @param e MouseEvent that stores the user's mouse actions.
   */
  @Override
  public void mouseDragged(MouseEvent e){}
  
  /**
   * Paints the graphics on to the JPanel.
   * If hour is between 12 and 14, timeOfDay is Noon. 
   * Else if hour is between 15 and 17, timeOfDay is Afternoon.
   * Else if hour is 18 or 19, timeOfDay is Evening.
   * Else, if hour is 20, timeOfDay is LateNight and critterType is Asleep.
   * If hoverDoor is true, the door is drawn with a glowing edge.
   * If hoverCritter is true, the speech bubble is drawn.
   * If hoverCalendar is true, the schedule is drawn.
   * If eaten is true and the user chooses to feed the critter in the fridgeDialog, the speech bubble displays the food eaten.
   * If the hour is one or more, 
   * If minute has one digit, a leading zero image is drawn before the corresponding minute image.
   * Else, both minute digits are displayed with the correct image numbers
   * If hour has one digit, a leading zero image is drawn before the corresponding hour image.
   * Else, both hour digits are displayed with the correct image numbers
   * The for loop starts from 0, runs while less than the amount of food in the fridge and increments by one each time.
   * If it is not the 21st hour and the fridge is not hovered, then a fridge door is displayed.
   * A fridge door with a sticky is displayed if it is locked, else, a plain one is displayed. 
   * 
   * <p>
   * <b>Local Variable Dictionary: </b>
   * <p>
   * <b> x</b> The integer loop variable that starts from 0, runs while less than the amount of food in the fridge and increments by one each time in order to display all the food in the fridge.
   * <p>
   * <b>speechBubble</b> This creates an instance of the Image class to store the image of the speech bubble. 
   * <p>
   * <b>timeOfDay </b>The String that stores the time of day.
   * <p>
   * <b>regHour </b> The integer that stores the hour for a twelve hour clock which is initialized to hour.
   */
  @Override
  public void paintComponent(Graphics g)
  {
    Image speechBubble=new ImageIcon ("images/Critter/SpeechBubble.png").getImage();
    String timeOfDay="Morning";
    int regHour=hour;
    
    g.drawImage(new ImageIcon ("images/Critter/EmptyHomeBG.jpg").getImage(), 0, 0,this);
    
    ptsLabel.setText("$"+points);
    
    g.setFont(new Font("Cooper Black", Font.PLAIN, 30));
    g.drawString("DAY",650,176);
    g.setFont(new Font("Elephant", Font.PLAIN, 50));
    g.drawString(""+day,670,228);
    
    if(hour>=12&&hour<=14)
    {
      timeOfDay="Noon";
    }
    else if(hour>=15&&hour<=17)
    {
      timeOfDay="Afternoon";
    }
    else if(hour==18||hour==19)
    {
      timeOfDay="Evening";
    }
    else
    {
      if(hour>=20)
      {
        timeOfDay="LateNight";
        myCritter.setCritterState("Asleep");
      }
    }
    
    //draw critter
    g.drawImage(new ImageIcon ("images/Critter/"+myCritter.getColour()+"/"+myCritter.getCritterState()+myCritter.getColour()+myCritter.getGrowthStage()+".png").getImage(),200,140,this);
    
    //draw window view
    g.drawImage(new ImageIcon ("images/Critter/"+timeOfDay+".png").getImage(),4,70,this);
    
    if (hoverDoor)
    {
      g.drawImage(new ImageIcon ("images/Critter/GlowDoor.png").getImage(), 0, 250,this);
    }
    if (hoverCritter)
    {
      g.drawImage(speechBubble, 30, 355,this);
      g.setFont(new Font(Font.SERIF,Font.PLAIN,12));
      g.drawString(message,52,412);
    }
    else
    {
      if (!hoverCritter)
      {
        message=myCritter.getMessage(hour);
      }
    }
    if (hoverCalendar)
    {
      g.drawImage(new ImageIcon ("images/Critter/Schedule.png").getImage(), 17, 85,this);
    }
    
    if (eaten=true&&fridgeDialog==0)
    {
      g.drawImage(speechBubble, 30, 355,this);
      g.drawImage(new ImageIcon((myCritter.getStomach()).getIcon()).getImage(),85, 385,this);
      eaten=false;
      fridgeDialog=-1;
    }
    
    fullnessBar(g);
    
    if (hour>12)
    {
      regHour=hour-12;
    }
    
    if (regHour<10)
    {
      g.drawImage(new ImageIcon("images/Critter/0.png").getImage(),632,289,this);
      g.drawImage(new ImageIcon("images/Critter/"+regHour+".png").getImage(),656,289,this);
    }
    else
    {
      g.drawImage(new ImageIcon("images/Critter/"+hour/10+".png").getImage(),632,289,this);
      g.drawImage(new ImageIcon("images/Critter/"+hour%10+".png").getImage(),656,289,this);
    }
    
    
    if (minute<10)
    {
      g.drawImage(new ImageIcon("images/Critter/0.png").getImage(),696,289,this);
      g.drawImage(new ImageIcon("images/Critter/"+minute+".png").getImage(),720,289,this);
    }
    else
    {
      g.drawImage(new ImageIcon("images/Critter/"+minute/10+".png").getImage(),696,289,this);
      g.drawImage(new ImageIcon("images/Critter/"+minute%10+".png").getImage(),720,289,this);
    }
    
    for (int x=0;x<fridge.size();x++)
    {
      g.drawImage(new ImageIcon((fridge.get(x)).getIcon()).getImage(),x*63+8, 8,this);
    }
    
    if (hour!=21&&hoverFridge==false)
    {
      if (scheduled[2][hour-9]==false)
        g.drawImage(new ImageIcon("images/Critter/fridgeDoor.png").getImage(),8,7,this);
      else
        g.drawImage(new ImageIcon("images/Critter/fridgeDoorNorm.png").getImage(),8,7,this);
    }
  } 
}
