/**
 * The GroceryStore class is the class that has the grocery store and has different foods for the user to buy
 * and feed their critter.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 1 05.15.15
 * 
 * <p>
 * <b>name: GroceryStore.java </b>
 *
 * <p>
 * <b>Instance variables: </b>
 * <p>
 * <b>foodItem </b> This is a Food array that stores all the different foods in the grocery store.
 * <p>
 * <b>selectedItem </b> This is a Food variable that indicates the selected food chosen.
 * <p>
 * <b>foodPic </b> This is a String array that stores the names of the pictures for each designated food.
 * <p>
 * <b>total </b> This is an int variable that keeps track of the total the user needs to pay.
 */
public class GroceryStore
{
  Food[] foodItem;
  Food selectedItem;
  String[] foodPic;
  int total;
  
  /**
   * The getAndDisplaySelectedItem method is used to determine and get the food the user has chosen.
   */
  public void getAndDisplaySelectedItem ()
  {
    /*user mousewhere to determine selected item then display information in cashier*/
  }
  
  /**
   * The changeQuantity method is used to change the number of selected food they want.
   */
  public void changeQuantity ()
  {
    /*up and down arrows...also change total price*/
  }
  
  /**
   * The checkOut method is used to add the food the user has chosen to their fridge and decrement the points the CritterSitter has.
   */
  public void checkOut ()
  {
    /*decrement CritterSitter points and add food to fridge*/
  }
  
  /**
   * The exit method is used to exit the grocery store.
   */
  public void exit ()
  {
  }
  
  /**
   * The calcTotal method is used to calculate the total the user has accumulated.
   * 
   * <p>
   * <b>Local Variables: </b>
   * <p>
   * <b>total </b> This is the int variable for the total.
   */
  private int calcTotal ()
  {
    int total = 0;
    /*with quantity*/
    return total;
  }
}
