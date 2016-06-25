
/**
 * Represents a song
 */
public class RewardSound extends Thread
{
	private EasySound sound;

	public RewardSound(String fileName)
	{
		sound = new EasySound(fileName);
	}
	public void play()
	{
		sound.play();
	}
	public void end()
	{
		sound.end();
	}
	public void run()
	{
		play();
	}
	
}
