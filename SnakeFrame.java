import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.geom.*;
import javax.swing.*;

public class SnakeFrame extends JFrame {

   private static final int DRAWING_SIZE = 600;
   private static final int SUBDIVISIONS = 20;
   private static final int SUBDIVISION_SIZE = DRAWING_SIZE / SUBDIVISIONS;
   private JPanel panel;
   
   public SnakeFrame() {
	  super("Snake!");
      System.out.println("Press space to start");
      setSize(DRAWING_SIZE, DRAWING_SIZE +23);
      setResizable(false);
      Snake game = new Snake();
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      panel = new SnakePanel(game);
      
      panel.setBackground(Color.WHITE);
   
      this.add(panel);
      this.addKeyListener(new SnakeListener(game));
      
   }
   private JPanel getPanel()
   {
	   return panel;
   }
   public static void main(String[] args) {
      (new SnakeFrame()).setVisible(true);
   }
}
