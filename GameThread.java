
public class GameThread extends Thread
{
	Snake game;
	int currentSpeed;
	long currentTime;
	int pastScore;
	public GameThread(Snake g)
	{
		game = g;
		currentSpeed=250;
		pastScore=0;
	}
	public void run()
	{
		pastScore=game.getScore();
		currentTime=System.currentTimeMillis();
		while(true)
		{
			if (System.currentTimeMillis()>=currentTime+currentSpeed)
			{
				game.call();
				currentTime=System.currentTimeMillis();
				if (game.getScore()>pastScore && currentSpeed>25)
				{
					pastScore++;
					currentSpeed-=5;
				}
			}
	
		}

	}
}
