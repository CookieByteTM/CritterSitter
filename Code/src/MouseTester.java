import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class MouseTester extends JPanel implements MouseListener
{
  JLabel textLabel=new JLabel();
  
  public MouseTester()
  {
    addMouseListener(this);
    add(textLabel);
  }
  
  public void eventOutput(String message) 
  {
    textLabel.setText(message);
  }
  
  public void mouseClicked(MouseEvent e) 
  {
    String message="";
    if (e.getX()<390)
      message="Icecream";
    else
      message="Cookies";
    eventOutput(message);
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
