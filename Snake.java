import java.io.File;

public class Snake 
{
	//FIELDS
	int[][] grid;
	int score;
	final int FOOD=-1;
	boolean unchangable;
	//int currentIteration;
	int length;
	//JPanel panel;
	boolean gameStart;
	boolean needPaint;
	int currentCoord;
	final int NORTH=1;
	final int SOUTH = 3;
	final int EAST = 2;
	final int WEST = 4;
	int dir;
	int x;
	int y;
	//CONSTRUCTOR
	public Snake()
	{
		score=0;
		unchangable=false;
		//currentIteration=0;
		grid = new int[20][20];
		length=2;
		gameStart=false;
		currentCoord=0;
		dir=2;
		needPaint=true;
	}
	
	//METHODS
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void makeGrid()
	{
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 20; j++)
			{
				grid[i][j] = 0;
			}
		}
	}
	public int getScore()
	{
		return score;
	}
	public void setUnchangable(boolean b)
	{
		unchangable=b;
	}
	public boolean getUnchangable()
	{
		return unchangable;
	}
	public void startGame()
	{
		x=0;
		y=0;
		grid[x][y] = 1;
		gameStart=true;
		dir=2;
		runGame();
		length++;
		int tempX=(int)(Math.random()*20);
		int tempY=(int)(Math.random()*20);
		while (tempX==0&&tempY==0)
		{
			tempX=(int)(Math.random()*20);
			tempY=(int)(Math.random()*20);	
		}
		grid[5][5]=FOOD;
	}
	public void setDir(int d)
	{
		this.dir=d;
	}
	public int getDir()
	{
		return this.dir;
	}
	public boolean getGameStart()
	{
		return gameStart;
	}
	public void setLength(int i)
	{
		length=i;
	}
	public void runGame()
	{
		GameThread runner = new GameThread(this);
		runner.start();
	}
	public void call()
	{
		unchangable=false;
		if (dir==EAST)
		{
			
			if (x==19)
				System.exit(0);
			else if (grid[x+1][y]>=1)
				System.exit(0);
			else 
				x++;
		}
		else if (dir==SOUTH)
		{
			if (y==19)
				System.exit(0);
			else if (grid[x][y+1]>=1)
				System.exit(0);
			else
				y++;
		}
		else if (dir==WEST)
		{
			if (x==0)
				System.exit(0);
			else if (grid[x-1][y]>=1)
				System.exit(0);
			x--;
		}
		else if (dir==NORTH)
		{
			if (y==0)
				System.exit(0);
			else if (grid[x][y-1]>=1)
				System.exit(0);
			y--;
		}
		updateBoard();
	}
	private void updateBoard()
	{
		if (grid[x][y]==FOOD)
		{
            /*String filePath = new File("").getAbsolutePath().concat("/Ding.wav");
            System.out.println("filepath is " + filePath);
			new RewardSound(filePath).start();*/
			score++;
			length++;
			int randX=(int) (Math.random()*20);
			int randY=(int) (Math.random()*20);
			while (grid[randX][randY] != grid[x][y] && grid[randX][randY]>0)
			{
				randX=(int) (Math.random()*20);
				randY=(int) (Math.random()*20);
			}
			grid[randX][randY] = FOOD;
		}
		grid[x][y]=1;
		for(int i = 0; i<20; i++)
		{
			for(int j = 0; j < 20; j++)
			{
				if (grid[i][j]>length)
				{
					grid[i][j]=0;
					
				}
				if (grid[i][j]!=0 && grid[i][j] != FOOD)
					grid[i][j]++;	
			}
		}
	}
	public void setPaint(boolean b)
	{
		needPaint=b;
	}
	public boolean getPaint()
	{
		return needPaint;
	}
	public int[][] getGrid()
	{
		return grid;
	}
}
