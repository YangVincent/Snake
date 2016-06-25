import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;
import java.awt.geom.*;

public class SnakePanel extends JPanel
{
    private static final int DRAWING_SIZE = 600;
    private int foodX, foodY;
    private static final int SUBDIVISIONS = 20;
	private static final int SUBDIVISION_SIZE = DRAWING_SIZE / SUBDIVISIONS;
	Snake game;
	public SnakePanel(Snake g)
	{
		setBackground(Color.CYAN);
		game = g;
	}
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.GRAY);
        g.fillRect(0, 8*SUBDIVISION_SIZE, 4*SUBDIVISION_SIZE, SUBDIVISION_SIZE);
        g2.setPaint(Color.GRAY);
        //g.setColor(Color.RED);
        for (int i = 1; i <= SUBDIVISIONS; i++) 
        {
           int x = i * SUBDIVISION_SIZE;
         //  g2.drawLine(x, 0, x, getSize().height);
        }
        for (int i = 1; i <= SUBDIVISIONS; i++) 
        {
           int y = i * SUBDIVISION_SIZE;
         //  g2.drawLine(0, y, getSize().width, y);
        }
        int[][] grid = game.getGrid();
        for (int i = 0; i < SUBDIVISIONS; i++)
        {
        	for (int j = 0; j < SUBDIVISIONS; j++)
        	{
        		g.setColor(Color.RED);
        		g2.setPaint(Color.RED);
        		if (grid[i][j]>0)
        		{
            		//System.out.println("reached finally");
        			int x = i*SUBDIVISION_SIZE;
        			int y = j*SUBDIVISION_SIZE;
        			g2.drawRoundRect(x, y, SUBDIVISION_SIZE, SUBDIVISION_SIZE, 5, 5);
        			//g.fillRect(x, y, SUBDIVISION_SIZE, SUBDIVISION_SIZE);
        			//game.setPaint(true);//check this later
        			if (grid[i][j] == 2)
        			{
        				g2.setPaint(Color.ORANGE);
            			g2.fillRoundRect(x, y, SUBDIVISION_SIZE, SUBDIVISION_SIZE, 5, 5);
            			//draw line here
            			x = game.getX();
            			y = game.getY();
            			int t, u;
            			if (x>10 && y>10)
            			{
            				t = x;
            				u = y;
            			}
            			else if (x < 10 && y > 10)
            			{
            				t=x+1;
            				u=y;
            			}
            			else if (x > 10 && y < 10)
            			{
            				t = x;
            				u = y+1;
            			}
            			else //right
            			{
            				t = x+1;
            				u = y+1;
            			}
            			g2.setPaint(Color.ORANGE);
            			g2.drawLine(t*SUBDIVISION_SIZE, u*SUBDIVISION_SIZE, 10*SUBDIVISION_SIZE, 10*SUBDIVISION_SIZE);//fix this
            			
        			}
        			
        		}
        		if (grid[i][j]==-1)
        		{
        			g.setColor(Color.BLUE);
        		//	System.out.println("color is " + g.getColor());
        			g.fillRect(i*SUBDIVISION_SIZE, j*SUBDIVISION_SIZE, SUBDIVISION_SIZE, SUBDIVISION_SIZE);
        			repaint();
        			g.setColor(Color.RED);
        		//	System.out.println("color is " + g.getColor());
        		}
        		/**else
        		{
        			g2.setPaint(Color.WHITE);
        			int x = i*SUBDIVISION_SIZE;
        			int y = j*SUBDIVISION_SIZE;
        			g.fillRect(x, y, SUBDIVISION_SIZE, SUBDIVISION_SIZE);
        			g2.setPaint(Color.GRAY);
        			game.setPaint(true);
        		}*/
        	}
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.BOLD, 28));
        g.drawString("Score: "+game.getScore(), 10, 9*SUBDIVISION_SIZE-5);
        g.setColor(Color.GRAY);
        repaint();
   /**     if (game.getPaint())
        {
        	repaint();
        	//System.out.println("repaintedlalalaljfeklfjewklfjelwjfewjfewfew");
        }*/
        	//g.fillRect(0, 0, SUBDIVISION_SIZE, SUBDIVISION_SIZE);
     }
	public void setFoodX(int x)
	{
		foodX=x;
	}
	public void setFoodY(int y)
	{
		foodY=y;
	}
	
}
