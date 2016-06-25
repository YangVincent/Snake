import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class SnakeListener implements KeyListener
{
	Snake game;
	boolean firstTime;
	public SnakeListener(Snake g)
	{
		game=g;
		firstTime=true;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("reached");
		int keyCode = e.getKeyCode();
		boolean unchangable = game.getUnchangable();
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.VK_UP && !unchangable)
		{
			if (game.getDir()!=3)
			{
				game.setDir(1);
				game.setUnchangable(true);
			}
		}
		else if (keyCode==KeyEvent.VK_RIGHT && !unchangable)
		{
			if (game.getDir()!=4)
			{
				game.setDir(2);
				game.setUnchangable(true);
			}
		}
		else if (keyCode==KeyEvent.VK_LEFT && !unchangable)
		{
			if (game.getDir()!=2)
			{
				game.setDir(4);
				game.setUnchangable(true);
			}
		}
		else if (keyCode==KeyEvent.VK_DOWN && !unchangable)
		{
			if (game.getDir()!=1)
			{
				game.setDir(3);
				game.setUnchangable(true);
			}
		}
		else if (keyCode==KeyEvent.VK_SPACE){
			if (firstTime)
			{
				game.makeGrid();
				game.startGame();
				game.setLength(3);
				firstTime=false;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}

}
