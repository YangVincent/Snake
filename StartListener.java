import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartListener implements ActionListener
{
	Snake game;

	public StartListener(Snake g)
	{
		game=g;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg) {
		// TODO Auto-generated method stub
		System.out.println("it has beendone.");
		game.makeGrid();
		
		game.startGame();
		
	}
	public Snake getSnake()
	{
		return game;
	}
}
