public class Driver
{
	public static void main(String[] args)
	{
		
		GameArena myGameArena = new GameArena(600, 480);
		Enemy badPaddle = new Enemy(1);
		Ball myBall = new Ball(300, 240, 5, "WHITE");
		
		myGameArena.addBall(myBall);
		//Player goodPaddle = new Player();
		
		while (true)
		{
			myGameArena.pause();
			double ballYPosition = myBall.getYPosition();
			badPaddle.enemyMove(ballYPosition);
		}
	}
}