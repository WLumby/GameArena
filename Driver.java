public class Driver
{
	public static void main(String[] args)
	{
		int difficulty = 1;
		
		int vspEnemy = 0;
		int vspPlayer = 0;
		int vspBall = 1;
		int hspBall = 0;
		
		double ballY;
		double badPaddleY;
		double playerY;
		
		GameArena myGameArena = new GameArena(600, 480);
		
		Rectangle badPaddle = new Rectangle(560, 240, 5, 40, "RED");
		myGameArena.addRectangle(badPaddle);
		
		Rectangle player = new Rectangle(40, 240, 5, 40, "BLUE");
		myGameArena.addRectangle(player);
		
		Ball myBall = new Ball(300, 240, 5, "WHITE");
		myGameArena.addBall(myBall);
		
		
		while (true)
		{
			myGameArena.pause();
			
			ballY = myBall.getYPosition();
			badPaddleY = badPaddle.getYPosition();
			playerY = player.getYPosition();
			
			vspEnemy = 0;
			vspPlayer = 0;
		
			
			
			if (ballY > badPaddleY)
			{
				vspEnemy = (1 + difficulty);
			}
			if (ballY < badPaddleY)
			{
				vspEnemy = (-1 - difficulty);
			}
		
			badPaddle.setYPosition(badPaddleY + vspEnemy);
			myBall.setYPosition(ballY + vspBall);
			
			
			
			
		}
	}
	
}
