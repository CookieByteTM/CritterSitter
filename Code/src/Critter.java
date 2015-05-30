import java.util.*;
/**
 * The Critter class is the class that creates the actual critter.
 *
 * @author Jasmine Ou
 * @version 3 05.29.15
 * 
 * <p>
 * <b>name: Critter.java </b>
 *
 * <p>
 * <b>Instance variables: </b>
 * <p>
 * <b>stomach</b>An ArrayList of Food objects that stores the food that the critter is fed.
 * <p>
 * <b>fullness[]</b>An array of 3 doubles that stores the fullness level of the critter for each of the three meals.
 * <p>
 * <b>foodGroupCount[][]</b>A 2D array of 3 rows and 5 columns that stores the total nutrient value of a certain food group consumed for a certain meal.
 * <p>
 * <b>colour</b> This String variable is used to store the critter's colour.
 * <p>
 * <b>critterState </b> This String variable is used to store the critter's state of either healthy (""), "Sick" or "Asleep".
 * <p>
 * <b>growthStage </b> This String variable is used to store the level of growth the critter is at currently of either "Baby", "Teen" or "Adult".
 * <p>
 * <b>isHealthy </b> This boolean variable is used to see if the critter is healthy or not.
 */
public class Critter
{
  private ArrayList<Food>stomach=new ArrayList<Food>();
  private double []fullness=new double [3];
  private double [][]foodGroupCount=new double [3][6];
  private String colour,critterState,growthStage;
  private boolean isHealthy = true;
  
  /**
   * The Critter constructor creates a critter sitter with the specified colour.
   * 
   * @param colour This String variable is used to store the critter's colour.
   */
  public Critter (String colour)
  {
    this.colour = colour;
    critterState="";
    growthStage="Baby";
  }
  
  /**
   * The getMessage method gets what the critter will say depending on the time and its state.
   * If it is breakfast time and they did not eat anything for breakfast yet, return "Feed me breakfast!".
   * If it is lunch time and they did not eat anything for lunch yet, return "Feed me lunch!".
   * If it is dinner time and they did not eat anything for dinner yet, return "Feed me dinner!".
   * 
   * <p>
   * <b>Local Variable Dictionary: </b>
   * <p>
   * <b> message </b> The String of the message that the critter will say
   * 
   * @param hour is the integer to store the hour number.
   * @return message is the String that the critter will say.
   */
  public String getMessage(int hour)
  {
    String message="\u266B I'm fluffy and I know it \u266B";
    // (int)(Math.random() * (max - min) + 1) + min;
    int randNum=(int)(Math.random()*2);
    if (randNum==0)
    {
      if ((hour==9||hour==10)&&fullness[0]==0)
      {
        message= "Feed me breakfast!";
      }
      else if ((hour==12||hour==13)&&fullness[1]==0)
      {
        message= "Feed me lunch!";
      }
      else if ((hour==18||hour==19)&&fullness[2]==0)
      {
        message= "Feed me dinner!";
      }
      else if ((hour==10||hour==11)||hour>=13&&hour<=17)
      {
        message= "I want to \nplay outside!";
      }
      else 
      {
        if (critterState.equals("Asleep"))
        {
          message="zZzZ";
        }
      }
    }
    else
    {
      if (hour>=9&&hour<=11)
      {
        message= "Good Morning!";
      }
      else 
      {
        if (hour==20)
        {
          message="I'm sleepy...";
        }
      }
    }
    return message;
  }
  
  public void newDay()
  {
    for (int x=0;x<3;x++)
    {
      fullness[x]=0;
      for (int y=0;y<6;y++)
      {
        foodGroupCount[x][y]=0;
      }
    }
    if (isHealthy)
      critterState="";
  }
  
  public void newLevel()
  {
    newDay();
    critterState="";
    growthStage="Baby";
  }
  
  /**
   * The calcPercentage method calculates the percentage of consumption for a foodGroup compared to the their fullness for the meal.
   * 
   * <p>
   * <b>Local Variable Dictionary: </b>
   * <p>
   * <b> percentage </b> The double value of the percentage of the foodGroupCount to the total fullness.
   * 
   * @param meal is the integer that stores the meal number where 0 is breakfast, 1 is lunch and 2 is dinner.
   * @param foodGroup is the integer that stores the foodGroup number where O is fruits and vegetables, 1 is grains, 2 is dairy, 3 is protein, 4 is sugars and fats and 5 is water.
   * @return percentage which is the double value of the percentage.
   */ 
  public double calcPercentage(int meal, int foodGroup)
  {
    double percentage=0;
    if (fullness[meal]!=0)
    {
      percentage=foodGroupCount[meal][foodGroup]/fullness[meal]*100;
    }
    return percentage;
  }
  
  /**
   * The getFoodGroupCount method returns the integer foodGroupCount for the specified meal and food group.
   * 
   * @param meal is the integer that stores the meal number where 0 is breakfast, 1 is lunch and 2 is dinner.
   * @param foodGroup is the integer that stores the foodGroup number where O is fruits and vegetables, 1 is grains, 2 is dairy, 3 is protein, 4 is sugars and fats and 5 is water.
   * @return foodGroupCount[][] which is the double that stores the total nutrient value of a foodGroup consumed for one specific meal. 
   */
  public double getFoodGroupCount(int meal, int foodGroup)
  {
    return foodGroupCount[meal][foodGroup];
  }
  
  /**
   * The setFoodGroupCount method adds nutrientValue to the foodGroupCount for a specific meal and foodGroup.
   * 
   * @param nutrientValue is the double value that stores how much the food item will fill the critter up.
   * @param meal is the integer that stores the meal number where 0 is breakfast, 1 is lunch and 2 is dinner.
   * @param foodGroup is the integer that stores the foodGroup number where O is fruits and vegetables, 1 is grains, 2 is dairy, 3 is protein, 4 is sugars and fats and 5 is water..
   */
  public void setFoodGroupCount(double nutrientValue,int meal, int foodGroup)
  {
    foodGroupCount[meal][foodGroup]+=nutrientValue;
  }
  
  /**
   * The getStomach method gets the Food stored in the stomach at a specific index. 
   * 
   * @return the Food object that was last fed to the critter.
   */
  public Food getStomach()
  {
    return stomach.get(stomach.size()-1);
  }
  
  /**
   * The addStomach method adds food the the stomach and increments their fullness of a specific meal.
   * 
   * @param food is the Food object to be added to the stomach.
   * @param meal is the integer represetning the meal that the nutrientValue should be added to.
   */
  public void addStomach(Food food, int meal)
  {
    stomach.add(food);
    fullness[meal]+=food.getNutrientValue();
  }
  
  /**
   * The getFullness method gets the double of the fullness for a specific meal.
   * 
   * @param meal is the integer that stores the meal number where 0 is breakfast, 1 is lunch and 2 is dinner.
   * @return an double of the fullness of the critter for a specific meal. 
   */
  public double getFullness(int meal)
  {
    return fullness[meal];
  }
  
  /**
   * The getGrowthStage method is used to get the critter's growth stage.
   * 
   * @return growthStage the String variable of the critter's growth stage.
   */
  public String getGrowthStage()
  {
    return growthStage;
  }
  
  /**
   * The setGrowthStage method is used to set the critter's new growth stage.
   * 
   * @param growthStage This is the String of the new growth stage for the critter.
   */
  public void setGrowthStage(String growthStage)
  {
    this.growthStage = growthStage;
  }
  
  /**
   * The getColour method is used to get the critter's colour.
   * 
   * @return colour the String variable of the critter's colour.
   */
  public String getColour()
  {
    return colour;
  }
  
  /**
   * The getCritterState method is used to get the critter's state.
   * 
   * @return critterState This is the String variable of the critter's state.
   */
  public String getCritterState()
  {
    return critterState;
  }
  
  /**
   * The setCritterState method is used to set the critter's new critter state.
   * 
   * @param critterState This is the String variable of the critter's state.
   */
  public void setCritterState(String critterState)
  {
    this.critterState = critterState;
  }
  }