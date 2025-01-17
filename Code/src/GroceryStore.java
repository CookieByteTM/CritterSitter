import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.event.*;
/**
 * The GroceryStore class is the class that has the grocery store and has different foods for the user to buy
 * and feed their critter.
 *
 * @author Jasmine Ou
 * @version 3 05.29.15
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
 * <b>itemPrice</b> Creates an instance of the JLabel class with the String title "$0" to display the selected item's price.
 * <p>
 * <b>ptsLabel</b> Creates an instance of the JLabel class
 * <p>
 * <b>totalPrice</b> Creates an instance of the JLabel class with the String title "$0" to display the selected item's price.
 * <p>
 * <b>buyIt</b> Creates an instance of the JButton class with the String title "BUY".
 * <p>
 * <b>exit</b> Creates an instance of the JButton class with the String title "EXIT".
 * <p>
 * <b>spinnerModel</b> A Spinner Model that creates an instance of the SpinneNumberModel class with a minimum of 1, incrementation of 1 and maximum of 12.
 * <p>
 * <b>spinner</b> Creates an instance of the JSpinner class using the spinnerModel to let the user select the quantity of an item.
 * <p>
 * <b>confirmPurchaseDialog</b> Integer that stores the value of the user's choice in the JOptionPane shown.
 * <p>
 * <b>quantity</b> Integer that stores the quantity of the food item.
 */
public class GroceryStore extends JPanel implements MouseListener
{
  Food[][] foodItem=new Food[5][12];
  Food blank=new Food ("Item Name", "0","images/Food/shoppingBasket.png");
  Food selectedItem=blank;
  JLabel itemName=new JLabel("Item Name");
  JLabel itemPrice=new JLabel("$0");
  JLabel ptsLabel;
  JLabel totalPrice=new JLabel ("$0");
  JButton buyIt=new JButton("BUY");
  JButton exit=new JButton ("EXIT");
  SpinnerModel spinnerModel = new SpinnerNumberModel(1,1,12,1);
  JSpinner spinner = new JSpinner(spinnerModel);
  int confirmPurchaseDialog;
  int quantity=1;
  
  /**
   * The GroceryStore constructor adds a MouseListener to the JPanel, sets the Layout to null, sets the location of all the two JButtons, two JLabels and JSpinner. 
   * An ActionListener is added to each button which can either buy an item or exit the store.
   * All JComponents are added to the JPanel. The stockStore method is called.
   */
  public GroceryStore()
  {
    addMouseListener(this);
    setLayout(null);
    
    ptsLabel=new JLabel (""+CritterSitterApp.home.getPoints());
    
    itemName.setBounds(300,436,300,100);
    itemPrice.setBounds(459,436,100,100);
    totalPrice.setBounds(544,465,100,100);
    ptsLabel.setBounds(394,465,100,100);
    
    buyIt.setBounds(612,473,70,50);
    buyIt.setBackground(new Color(102,255,198));
    buyIt.setEnabled(false);
    buyIt.addActionListener (new ActionListener ()
                               {
      public void actionPerformed (ActionEvent e)
      {
        if (quantity<=CritterSitterApp.home.getFridgeSpace()&&calcTotal()<=CritterSitterApp.home.getPoints())
        {
          confirmPurchase();
          if (confirmPurchaseDialog==0)
          {
            CritterSitterApp.home.addFood(selectedItem,quantity);
            CritterSitterApp.home.setPoints(CritterSitterApp.home.getPoints()-calcTotal());
            repaint();
          }
        }
        else
          errorMessage();
      }
    }
    );
    
    exit.setBounds(13,472,70,50);
    exit.setBackground(new Color(239,58,68));
    exit.setFocusPainted(false);
    add(exit);
    
    spinner.setBounds(542,474,58,24);
    spinner.addChangeListener(new ChangeListener() 
                                {
      public void stateChanged(ChangeEvent e) 
      {
        quantity=(int)spinner.getValue();
        totalPrice.setText("$"+calcTotal());
      }
    });
    
    add(itemName);
    add(itemPrice);
    add(totalPrice);
    add(ptsLabel);
    add(buyIt);
    add(spinner);
    
    stockStore();
  }
  
  /**
   * The setButtonsActionListener method adds an ActionListener to each button and sets their action commands. 
   * 
   * @param al is the ActionListener passed in to be added to the buttons.
   */
  public void setButtonsActionListener(ActionListener al)
  {
    exit.addActionListener(al);
    exit.setActionCommand("Exit");
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
   * <b> foodGroup </b> Integer that stores the Food's foodGroup.
   * <p>
   * <b> icon </b> String that stores the Food icon's file name.
   * <p>
   * <b> nutrientValue </b> A double that stores the Food's nutrientValue.
   * <p>
   * <b> x </b> An int loop variable that starts from 0 and increments by 1 while x is smaller than 5 for as the row number in the 2D array foodItems.
   * <p>
   * <b> y </b> An int loop variable that starts from 0 and increments by 1 while y is smaller than 12 for as the column number in the 2D array foodItems.
   * 
   * <p>
   * <b>Exception </b> IOException e when an error occurs with file io where the file cannot be read.
   */
  public void stockStore()
  {
    BufferedReader in;
    String name,price,icon;
    double nutrientValue;
    int foodGroup;
    try
    {
      in=new BufferedReader(new FileReader("text/foods.txt"));
      for (int x=0;x<5;x++)
      {
        for (int y=0;y<12;y++)
        {
          name=in.readLine();
          price=in.readLine();
          foodGroup=Integer.parseInt(in.readLine());
          nutrientValue=Double.parseDouble(in.readLine());
          icon="images/Food/"+in.readLine()+".png";
          foodItem[x][y]=new Food (name,price,foodGroup,nutrientValue,icon);
        }
      } 
    }
    catch (IOException e)
    {
    }
  }
  
  /**
   * The confirmPurchase method creates and displays a JOptionPane to ask the user to confirm their purchase.
   * <p>
   * <b>Local Variable Dictionary: </b>
   * <p>
   * <b> options[] </b> Object of the options of the confirmPurchaseDialog.
   * <p>
   * <b> confirmPurchaseDialog </b> The JOptionPane OptionDialog to ask the user to confirm their purchase.
   */
  public void confirmPurchase()
  {
    Object[] options = {"Confirm Purchase","Cancel"};
    confirmPurchaseDialog = JOptionPane.showOptionDialog(this, "Are you sure of your purchase?\n"+selectedItem.getName()
                                                           +".........."+spinner.getValue()+"\n"+"Points to Spend.........."+calcTotal(),                                   
                                                         "Confirm Purchase",
                                                         JOptionPane.YES_NO_OPTION,
                                                         JOptionPane.QUESTION_MESSAGE,
                                                         new ImageIcon(selectedItem.getIcon()),    
                                                         options, 
                                                         options[0]);
  }
  
  /**
   * The errorMessage method creates and displays a JOptionPane to inform the user of an error.
   * If the quantity of food to be bought is larger than the available fridge space, message adds a string the inform the user that there is not enough room in the fridge.
   * If the total price is more than their points, then message adds a string the inform the user thatthey do not have enough points.
   * 
   * <p>
   * <b>Local Variable Dictionary: </b>
   * <p>
   * <b> message </b> String that stores the error message.
   */
  public void errorMessage()
  {
    String message="";
    if (quantity>CritterSitterApp.home.getFridgeSpace())
    {
      message="You do not have enough space in your fridge.\n";
    }
    if(calcTotal()>CritterSitterApp.home.getPoints())
    {
      message+="You do not have enough points.";
    }
    JOptionPane.showMessageDialog(this, message);
  }
  
  /**
   * The calcTotal method is used to calculate the total number of points the user needs to pay for each purchase of one type of item.
   * 
   * @returns int of the total number of points the user needs to pay for each purchase of one type of item.
   */
  private int calcTotal ()
  {
    return Integer.parseInt(selectedItem.getPrice())*quantity;
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
   * @return false if it is the wrong row, else, true.
   * @param clickX int of the x coordinate of the user's mouse click.
   * @param iconX int of an icon's left most x coordinate.
   */
  public static boolean correctCol(int clickX, int iconX)
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
            totalPrice.setText("$"+calcTotal());
            buyIt.setEnabled(true);
            break;
          }
        }
        break;
      }
      else
      {
        selectedItem=blank;
        buyIt.setEnabled(false);
        totalPrice.setText("");
      }
    }
    repaint();
    itemName.setText(selectedItem.getName());
    itemPrice.setText("$"+selectedItem.getPrice());
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
   * 
   * @param g An instance of the Graphics class.
   */
  @Override
  public void paintComponent(Graphics g)
  {
    Image bg = new ImageIcon ("images/Food/GroceryStoreBG.jpg").getImage();
    g.drawImage(bg, 0, 0,this);
    g.drawImage(new ImageIcon(selectedItem.getIcon()).getImage(), 701, 467,this);
    ptsLabel.setText("$"+CritterSitterApp.home.getPoints());
  } 
}
