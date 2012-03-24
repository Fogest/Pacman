import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// implementing mouse listener so i can receive mouse events
public class MouseEvents extends JPanel implements MouseListener
{
  int x = 10;
  int y = 10;
  
  public void paintComponent(Graphics g)
  {
    g.clearRect(0,0,getWidth(),getHeight());
    g.setColor(Color.red);
    g.fillOval(x,y,30,30);
  }
  
  public void start()
  {
  }
  
  public static void main (String[] args)
  {
    JFrame frame = new JFrame("Mouse Testing");
    frame.setSize(300,300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    MouseEvents panel = new MouseEvents();
    frame.getContentPane().add(panel);
    frame.setVisible(true);
    
    // adding the mouse listener to the panel so i don't count the x and y coordinates of the frame
    // this is different from the keyboard listener example
    panel.addMouseListener(panel); 
    panel.start();
  }
  
  //Mouse Listener Stuff
  //The mouse has been clicked
    public void mouseClicked(MouseEvent paramMouseEvent){
      // get the X and Y of where the mouse was clicked
      int clickX = (int)paramMouseEvent.getPoint().getX();
      int clickY = (int)paramMouseEvent.getPoint().getY();
      
      // update out circle to move spots
      x = clickX;
      y = clickY;
      repaint(); // repaint the changed made to our picture
    }
    
    // the mouse has entered the screen
    public void mouseEntered(MouseEvent paramMouseEvent) {
    }
    // the mouse has left the screen
    public void mouseExited(MouseEvent paramMouseEvent) {
    }
    // a mouse button has been pressed down
    public void mousePressed(MouseEvent paramMouseEvent) {
    }
    // a mouse button has been released from being pressed
    public void mouseReleased(MouseEvent paramMouseEvent) {
    }
    // the mouse has changed position
    public void mouseMoved(MouseEvent paramMouseEvent) {
    }
    // the mouse has clicked, moved, and released
    public void mouseDragged(MouseEvent paramMouseEvent) {
    }

}