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
public class GroceryStore extends JPanel implements MouseListener
{
  /*Tasks: 
   * Foods.text
   * 60x60 icons
   * file io to create Food objects
   * make grid layout of food icons for MouseListener co-ords
   * new BG with food icons (photoshop)
   */
//  Food iceCream=new Food ("Ice Cream", "3","Dairy", 5, "icecream.png");
//  Food cookie=new Food ("Cookie", "1","Carbohydrate", 3, "cookie.png");
//  Food grilledTrout=new Food ("Grilled Trout", "1","Carbohydrate", 3, "grilledTrout.png");
Food blank=new Food ("Item Name", "0","Dairy", 0, "shoppingBasket.png");
//  Food[][] foodItem={{iceCream,grilledTrout,iceCream,grilledTrout,iceCream,grilledTrout,iceCream,grilledTrout,iceCream,grilledTrout,iceCream,grilledTrout},{cookie,grilledTrout,cookie,grilledTrout,cookie,grilledTrout,cookie,grilledTrout,cookie,grilledTrout,cookie,grilledTrout}};
Food[][] foodItem=new Food[5][12];
  Food selectedItem=blank;
  String[] foodPic;
  int total;
  JLabel itemName=new JLabel("Item Name");
  JLabel itemPrice=new JLabel("0");
  SpinnerModel spinnerModel = new SpinnerNumberModel(1,1,10,1);
  JSpinner spinner = new JSpinner(spinnerModel);
  JButton buyIt=new JButton("BUY");
  JButton exit=new JButton ("EXIT");
  Font customFont;
  
  //@overide
  public void paintComponent(Graphics g)
  {
    storeBG(g);
    Image image = new ImageIcon (selectedItem.getIcon()).getImage();
    g.drawImage(image, 701, 467,this);
  }
  
  public void storeBG(Graphics g)
  {
    Image image = new ImageIcon ("GroceryStoreBGTester.jpg").getImage();
    g.drawImage(image, 0, 0,this);
  }
  
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
    
//    Font font=new Font(Font.createFont(Font.TRUETYPE_FONT, new File("DS-DIGI.ttf"));
//    try
//    {
//     font = Font.createFont(Font.TRUETYPE_FONT, new File("DS-DIGI.ttf"));
//    }
//    catch (IOException|FontFormatException e) {}
//    itemName.setFont(font);
    
    
    spinner.setBounds(442,473,58,24);
    add(spinner);
    add(itemName);
    add(itemPrice);
    add(buyIt);
    add(exit);
    stockStore();
  }
  /**
   * The getAndDisplaySelectedItem method is used to determine and get the food the user has chosen.
   */
  public void displaySelectedItem ()
  {
    itemName.setText(selectedItem.getName());
    itemPrice.setText(selectedItem.getPrice());
    //itemPrice.setText(spinner.getValue()+"");
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
  
  private boolean correctRow(int clickY, int iconY)
  {
    if (clickY>=iconY&&clickY<=iconY+60)
      return true;
    return false;
  }
  
  private boolean correctCol(int clickX, int iconX)
  {
    if (clickX>=iconX&&clickX<=iconX+60)
      return true;
    return false;
  }
  
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
  
  @Override
  public void mousePressed(MouseEvent e) {}
  @Override
  public void mouseEntered(MouseEvent e) {}
  @Override
  public void mouseExited(MouseEvent e) {}
  @Override
  public void mouseReleased(MouseEvent e) {}
  
  }
