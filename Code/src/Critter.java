import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Component;
import java.util.*;
/**
 * The Critter class is the class that creates the actual critter.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 3 05.29.15
 * 
 * <p>
 * <b>name: Critter.java </b>
 *
 * <p>
 * <b>Instance variables: </b>
 * <p>
 * <b>name </b> This String variable is used to save the critter's name.
 * <p>
 * <b>colour </b> This String variable is used to store the critter's colour.=
 * <p>
 * <b>disease </b> This String variable is used to store the disease the critter has now.
 * <p>
 * <b>carbCount </b> This int variable is used to store the number of carbohydrates in the critter.
 * <p>
 * <b>fruitVegCount </b> This int variable is used to store the number of fruits and vegetables in the critter.
 * <p>
 * <b>dairyCount </b> This int variable is used to store the number of dairy in the critter.
 * <p>
 * <b>proteinCount </b> This int variable is used to store the number of protein in the critter.
 * <p>
 * <b>waterCount </b> This int variable is used to store the number of water in the critter.
 * <p>
 * <b>sugar </b> This int variable is used to store the number of sugar in the critter.
 * <p>
 * <b>growthStage </b> This int variable is used to store the level of growth the critter is at currently.
 * <p>
 * <b>hungerLevel </b> This int variable is used to store the the level of hunger the critter is at.
 * <p>
 * <b>isHealthy </b> This boolean variable is used to see if the critter is healthy or not (set to true, because it's healthy when born).
 */
public class Critter
{
  private ArrayList<Food>stomach=new ArrayList<Food>();
  private String name, colour, disease;
  private int carbCount, fruitVegCount, dairyCount, proteinCount, waterCount, sugarCount, growthStage, hungerLevel;
  private boolean isHealthy = true;
  int []fullness=new int [3];
  int [][]foodGroupCount=new int [3][5];
  
  /**
   * The Critter constructor creates a critter sitter with the specified colour.
   * 
   * @param colour This String variable is used to store the critter's colour.
   */
  public Critter (String colour)
  {
    this.colour = colour;
  }
  
  private double calcPercentage(int meal, int foodGroup)
  {
    double percentage=0;
    if (fullness[meal]!=0)
    {
        percentage=foodGroupCount[meal][foodGroup]/(double)fullness[meal]*100;
     }
      return percentage;
  }
  
  public int getFoodGroupCount(int meal, int foodGroup)
  {
    return foodGroupCount[meal][foodGroup];
  }
  
  public void setFoodGroupCount(int nutrientValue,int meal, int foodGroup)
  {
    foodGroupCount[meal][foodGroup]+=nutrientValue;
  }
  
  public Food getStomach(int index)
  {
    return stomach.get(index);
  }
  
 //last index overloaded
  public Food getStomach()
  {
    return stomach.get(stomach.size()-1);
  }
  
  public void addStomach(Food food, int meal)
  {
    stomach.add(food);
    fullness[meal]+=food.getNutrientValue();
  }
  
  public int getFullness(int meal)
  {
    return fullness[meal];
  }
  
  /**
   * the getName method is used to get the critter's name.
   * 
   * @return name the String variable of the critter's name.
   */
  public String getName()
  {
    return name;
  }
  
  /**
   * the getGrowthStage method is used to get the critter's growth stage.
   * 
   * @return growthStage the int variable of the critter's growth stage.
   */
  public int getGrowthStage()
  {
    return growthStage;
  }
  
  /**
   * the setGrowthStage method is used to set the critter's new growth stage.
   * 
   * @param growthStage This is the int number of the new growth stage for the critter.
   */
  public void setGrowthStage(int growthStage)
  {
    this.growthStage = growthStage;
  }
  }