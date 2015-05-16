/**
 * The Food class is the class that makes each individiual food, assigns the name, food group, icon, price and nutrient value.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 1 05.15.15
 * 
 * <p>
 * <b>name: Food.java </b>
 *
 * <p>
 * <b>Instance variables: </b>
 * <p>
 * <b>name </b> This is a String variable for the food's name.
 * <p>
 * <b>foodGroup </b> This is a String variable for the food's food group.
 * <p>
 * <b>icon </b> This is a String variable for the name of the picture of the food.
 * <p>
 * <b>price </b> This is an int variable for the price of the food.
 * <p>
 * <b>nutrientValue </b> This is an int variable for the number of nutrient values for this food.
 */
public class Food
{
  private String name, foodGroup, icon;
  private int price, nutrientValue;
  
  
  /**
   * The Food constructor makes the new food object with the designated name, price, food group, nutrient value and image.
   * 
   * @param name This is a String variable for the food's name.
   * @param foodGroup This is a String variable for the food's food group.
   * @param icon This is a String variable for the name of the picture of the food.
   * @param price This is an int variable for the price of the food.
   * @param nutrientValue This is an int variable for the number of nutrient values for this food.
   */
  public Food (String name, int price, String foodGroup, int nutrientValue, String icon)
  {
    this.name = name;
    this.price = price;
    this.foodGroup = foodGroup;
    this.nutrientValue = nutrientValue;
    this.icon = icon; //the name or location of the picture of the food e.g. chickenLeg.jpg
  }
  
  /**
   * The getName method gets the name of the food.
   * 
   * @return name which is the string value of the name of the food.
   */
  public String getName ()
  {
    return name;
  }
  
  /**
   * The getPrice method gets the price of the food.
   * 
   * @return price which is the int value of the price of the food.
   */
  public int getPrice ()
  {
    return price;
  }
  
  /**
   * The getFoodGroup method gets the food group of the food.
   * 
   * @return foodGroup which is the string value of the food group of the food.
   */
  public String getFoodGroup ()
  {
    return foodGroup;
  }
  
  /**
   * The getNutrientValue method gets the nutrient value of the food.
   * 
   * @return nutrientValue which is the int value of the nutrient value of the food.
   */
  public int getNutrientValue ()
  {
    return nutrientValue;
  }
  
  /**
   * The getIcon method gets the icon of the food
   * 
   * @return icon which is the string value of the icon of the food.
   */
  public String getIcon ()
  {
    return icon;
  }
}
