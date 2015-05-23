/**
 * The Food class is the class that makes each individiual food, assigns the name, price, food group, nutrient value and icon.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 2 05.21.15
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
 * <b>price </b> This is a String variable for the price of the food.
 * <p>
 * <b>nutrientValue </b> This is an int variable for the number of nutrient values for this food.
 */
public class Food
{
  private String name, price,foodGroup, icon;
  private int nutrientValue;
  
  /**
   * The Food constructor makes the new food object with the designated name, price, food group, nutrient value and image.
   * 
   * @param name This is a String variable for the food's name.
   * @param price This is an String variable for the price of the food.
   * @param foodGroup This is a String variable for the food's food group.
   * @param nutrientValue This is an int variable for the number of nutrient values for this food.
   * @param icon This is a String variable for the name of the picture of the food.
   */
  public Food (String name, String price, String foodGroup, int nutrientValue, String icon)
  {
    this.name = name;
    this.price = price;
    this.foodGroup = foodGroup;
    this.nutrientValue = nutrientValue;
    this.icon = icon; //the name or location of the picture of the food e.g. chickenLeg.jpg
  }
  
  /**
   * The Food constructor makes the new Food object with the designated name, price and image.
   * 
   * @param name This is a String variable for the food's name.
   * @param price This is an String variable for the price of the food.
   * @param icon This is a String variable for the name of the picture of the food.
   */
  public Food (String name, String price, String icon)
  {
    this.name = name;
    this.price = price;
    this.icon = icon; 
  }
  
  /**
   * The Food constructor makes the new Food object.
   */
  public Food()
  {
  }
  
  /**
   * The getName method gets the name of the food.
   * 
   * @return name which is the String value of the name of the food.
   */
  public String getName ()
  {
    return name;
  }
  
  /**
   * The getPrice method gets the price of the food.
   * 
   * @return price which is the String value of the price of the food.
   */
  public String getPrice ()
  {
    return price;
  }
  
  /**
   * The getFoodGroup method gets the food group of the food.
   * 
   * @return foodGroup which is the String value of the food group of the food.
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
   * @return icon which is the String name of the icon of the food.
   */
  public String getIcon ()
  {
    return icon;
  }
}
