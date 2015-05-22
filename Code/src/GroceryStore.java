import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Component;
/**
 * The GroceryStore class is the class that has the grocery store and has different foods for the user to buy
 * and feed their critter.
 *
 * @author Jasmine Ou and Laura Wong
 * @version 2 05.21.15
 * 
 * <p>
 * <b>name: GroceryStore.java </b>
 *
 * <p>
 * <b>Instance variables: </b>
 * <p>
 * <b>foodItem [][]</b> 2D Food array that stores all the different foods in the grocery store with 5 rows and 12 columns.
 * <p>
 * <b>blank </b> Food item that indicates no food selected in the grocery store.
 * <p>
 * <b>selectedItem </b> Food variable that indicates the selected food chosen and is initialized to the blank food variable.
 * <p>
 * <b>itemName</b> Creates an instance of the JLabel class with the String title "Item Name" to display the selected item's name.
 * <p>
 * <b>itemPrice</b> Creates an instance of the JLabel class with the String title "Price" to display the selected item's price.
 * <b>
 * <p>buyIt</b> Creates an instance of the JButton class with the String title "BUY".
 * <b>
 * <p>exit</b> Creates an instance of the JButton class with the String title "EXIT".
 * <b>
 * <p>spinnerModel</b> A Spinner Model that creates an instance of the SpinneNumberModel class with a minimum of 1, incrementation of 1 and maximum of 10.
 * <b>
 * <p>spinner</b> Creates an instance of the JSpinner class using the spinnerModel to let the user select the quantity of an item.
 */
public class GroceryStore extends JPanel implements MouseListener
{
  
  Food[][] foodItem=new Food[5][12];
  Food blank=new Food ("Item Name", "Price","shoppingBasket.png");
  Food selectedItem=blank;
  JLabel itemName=new JLabel("Item Name");
  JLabel itemPrice=new JLabel("0");
  JButton buyIt=new JButton("BUY");
  JButton exit=new JButton ("EXIT");
  SpinnerModel spinnerModel = new SpinnerNumberModel(1,1,10,1);
  JSpinner spinner = new JSpinner(spinnerModel);
  
  /**
   * The GroceryStore constructor adds a MouseListener to the JPanel, sets the Layout to null, sets the location of all the two JButtons, two JLabels and JSpinner. 
   * An ActionListener is added to each button which can either buy an item or exit the store.
   * All JComponents are added to the JPanel. The stockStore method is called.
   */
  public GroceryStore()
  {
    addMouseListener(this);
    setLayout(null);
    
    itemName.setBounds(20,435,100,100);
    itemPrice.setBounds(400,435,100,100);
    
    buyIt.setBounds(520,470,70,50);
    buyIt.setBackground(new Color(102,255,198));
    buyIt.addActionListener (new ActionListener ()
                               {
      public void actionPerformed (ActionEvent e)
      {
        itemName.setText("Bought it");
      }
    }
    );
    
    exit.setBounds(600,470,70,50);
    exit.setBackground(new Color(239,58,68));
    exit.addActionListener (new ActionListener ()
                              {
      public void actionPerformed (ActionEvent e)
      {
        itemName.setText("exit");
      }
    }
    );
    
    spinner.setBounds(442,473,58,24);
    
    add(spinner);
    add(itemName);
    add(itemPrice);
    add(buyIt);
    add(exit);
    stockStore();
  }
  
  /**
   * Stocks the Grocery store with food by adding Food objects to the foodItems array from reading in a text file. 
   * The try block is for reading the foods.txt file and to catch the IOException.
   * The for loop starts from 0 and increments by 1 while x is smaller than 5.
   * The nested for loop starts from 0 and increments by 1 while y is smaller than 12.
   * 
   * <p>
   * <b>Local Variable Dictionary: </b>
   * <p>
   * <b> in </b> Creates an instance of the BufferedReader class for file reading.
   * <p>
   * <b> name </b> String that stores the Food's name.
   * <p>
   * <b> price </b> String that stores the Food's name.
   * <p>
   * <b> foodGroup </b> String that stores the Food's foodGroup.
   * <p>
   * <b> icon </b> String that stores the Food icon's file name.
   * <p>
   * <b> nutrientValue </b> An int that stores the Food's nutrientValue.
   * <p>
   * <b> x </b> An int loop variable that starts from 0 and increments by 1 while x is smaller than 5 for as the row number in the 2D array foodItems.
   * <p>
   * <b> y </b> An int loop variable that starts from 0 and increments by 1 while y is smaller than 12 for as the column number in the 2D array foodItems.
   * 
   * @exception IOException if stream to foods.txt cannot be written to or closed.
   */
  public void stockStore()
  {
    BufferedReader in;
    String name,price,foodGroup,icon;
    int nutrientValue;
    try
    {
      in=new BufferedReader(new FileReader("foods.txt"));
      for (int x=0;x<5;x++)
      {
        for (int y=0;y<12;y++)
        {
          name=in.readLine();
          price=in.readLine();
          foodGroup=in.readLine();
          nutrientValue=Integer.parseInt(in.readLine());
          icon=in.readLine()+".png";
          foodItem[x][y]=new Food (name,price,foodGroup,nutrientValue,icon);
        }
      } 
    }
    catch (IOException e)
    {
    }
  }
  
  /**
   * The displaySelectedItem method displays the name and price of the food the user has chosen by setting text to the itemName and itemPrice JLabels.
   */
  public void displaySelectedItem ()
  {
    itemName.setText(selectedItem.getName());
    itemPrice.setText(selectedItem.getPrice());
    //itemPrice.setText(spinner.getValue()+"");
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
   * The calcTotal method is used to calculate the total number of points the user needs to pay for each purchase of one type of item.
   * 
   * <p>
   * <b>Local Variables: </b>
   * <p>
   * <b>total </b> int that stores how much the user needs to pay for each purchase of one type of item.
   * 
   * @returns int of the total number of points the user needs to pay for each purchase of one type of item.
   */
  private int calcTotal ()
  {
    int total = 0;
    /*with quantity*/
    return total;
  } 
  
  /**
   * The correctRow method is used to determine whether the user clicked in the row specified in the parameters or not.
   * The if statement checks if the user clicked within the 60 by 60 square of a food icon starting from the indicated top most pixel.
   * 
   * @returns true if the user clicked the specified row, else false.
   * @param clickY int of the y coordinate of the user's mouse click.
   * @param iconY int of an icon's top most y coordinate.
   */
  private boolean correctRow(int clickY, int iconY)
  {
    if (clickY>=iconY&&clickY<=iconY+60)
      return true;
    return false;
  }
  
  
  /**
   * The correctCol method is used to determine whether the user clicked in the column specified in the parameters or not.
   * The if statement checks if the user clicked within the 60 by 60 square of a food icon starting from the indicated left most pixel.
   * 
   * @returns true if the user clicked the specified column, else false.
   * @param clickX int of the x coordinate of the user's mouse click.
   * @param iconX int of an icon's left most x coordinate.
   */
  private boolean correctCol(int clickX, int iconX)
  {
    if (clickX>=iconX&&clickX<=iconX+60)
      return true;
    return false;
  }
  
  
  /**
   * The mouseClicked method coordinates the proper response to the user's mouse clicks. 
   * The first for loop starts from 0, increments by 90 each time while row is less than or equal to 360 in order to go through the rows.
   * The if statement checks if the user's mouse click is in the row of the loop variable and it breaks the loop.
   * If true, the  nested for loop starts from 0, increments by 63 each time while row is less than or equal to the foodItem array row's length plus one times 63.
   * Or else, the Food blank is assigned to the selectedItem variable.
   * The next if statement checks if the user's mouse click is in the column of the loop variable.
   * If true, the one spot of the Food 2D array is assigned to the selectedItem variable and it breaks the loop.
   * 
   * <p>
   * <b>Local Variables: </b>
   * <p>
   * <b>row </b> int loop variable that starts from 0, increments by 90 each time while row is less than or equal to 360.
   * <p>
   * <b>col </b> int loop variable that starts from 0, increments by 63 each time while row is less than or equal to the foodItem array row's length plus one times 63.
   *
   * 
   * @param e MouseEvent that stores the user's mouse actions.
   */
  public void mouseClicked(MouseEvent e) 
  {
    for (int row=0;row<=360;row+=90)
    {
      if (correctRow(e.getY(),row+15))
      {
        for (int col=0; col<=(foodItem[row/90].length+1)*63; col+=63)
        {
          if (correctCol(e.getX(),col+8))
          {
            selectedItem=foodItem[row/90][col/63];
            break;
          }
        }
        break;
      }
      else
      {
        selectedItem=blank;
      }
    }
    repaint();
    displaySelectedItem();
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
  public void mouseReleased(MouseEvent e) {}
  
  /**
   * Overrided paintComponent method of the Graphics class to draw background and food icons on to the JPanel. The pictures include the store's background and the food icons.
   * 
   * <p>
   * <b>Local Variable Dictionary: </b>
   * <p>
   * <b> bg </b> An Image the creates an instance of the ImageIcon class that stores the store's background image.
   * <p>
   * <b> foodIcon </b> An Image the creates an instance of the ImageIcon class that stores the selectedItem's corresponding food icon.
   * 
   * @param g An instance of the Graphics class.
   */
  @Override
  public void paintComponent(Graphics g)
  {
    Image bg = new ImageIcon ("GroceryStoreBG.jpg").getImage();
    g.drawImage(bg, 0, 0,this);
    Image foodIcon = new ImageIcon (selectedItem.getIcon()).getImage();
    g.drawImage(foodIcon, 701, 467,this);
  } 
}
