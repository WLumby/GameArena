public class Driver
{
	public static void main(String[] args)
	{
		//difficulty increases the speed at which the enemy paddle moves
		double difficulty = 0.5;
		
		//default points value
		double enemyPoints = 0;
		double playerPoints = 0;
		int reset = 0;
		
		//default speeds
		double vspEnemy = 0;
		double vspPlayer = 0;
		double vspBall = 2;
		double hspBall = 2;
		
		//declare co-ordinate tracking variables
		double ballY;
		double ballX;
		double badPaddleY;
		double playerY;
		
		//Create the game arena
		GameArena myGameArena = new GameArena(600, 480);
		
		//Create the enemy paddle and add it to the arena
		Rectangle badPaddle = new Rectangle(560, 240, 5, 40, "RED");
		myGameArena.addRectangle(badPaddle);
		
		//Create a player paddle and add it to the arena
		Rectangle player = new Rectangle(40, 240, 5, 40, "BLUE");
		myGameArena.addRectangle(player);
		
		//Create the ball and add it the arena
		Ball myBall = new Ball(300, 240, 5, "WHITE");
		myGameArena.addBall(myBall);
		
		
		//Loop forever
		while (true)
		{
			//Pause to take a step
			myGameArena.pause();
			
			//Grab positions of all objects
			ballY = myBall.getYPosition();
			ballX = myBall.getXPosition();
			badPaddleY = badPaddle.getYPosition();
			playerY = player.getYPosition();
			
			//Setting default speeds to 0 before calculations take place
			vspEnemy = 0;
			vspPlayer = 0;
			
			//Checking for key presses for player movement
			if (myGameArena.upPressed() && (player.getYPosition() > 5))
			{
				vspPlayer = -3;
			}
			else if (myGameArena.downPressed() && (player.getYPosition() < 475))
			{
				vspPlayer = 3;
			}
		
			//Enemy tracking the ball and moving towards matching y co-ords
			if (ballY > badPaddleY)
			{
				vspEnemy = (1 + difficulty);
			}
			if (ballY < badPaddleY)
			{
				vspEnemy = (-1 - difficulty);
			}
			
			//detecting if the ball has hit the edge
			if (ballY >= 480)
			{
				vspBall = -2;
			}
			else if (ballY <= 0)
			{
				vspBall = 2;
			}
			
			if (ballX <= 0)
			{
				reset = 1;
				enemyPoints++;
				myBall.setXPosition(300);
				myBall.setYPosition(240);
				vspBall = 2;
				hspBall = 2;
			}
			else if (ballX >= 600)
			{
				reset = 1;
				playerPoints++;
				myBall.setXPosition(300);
				myBall.setYPosition(240);
				vspBall = -2;
				hspBall = -2;
			}
			
			//check for collisions between the ball and player/enemy paddles
			Ball b = myBall;
			Rectangle e = badPaddle;
			Rectangle r = player;
			
			if (b.getXPosition() < e.getXPosition() + e.getWidth() &&
			b.getXPosition() + b.getSize() * 2 > e.getXPosition() &&
			b.getYPosition() < e.getYPosition() + e.getHeight() &&
			b.getYPosition() + b.getSize() * 2 > e.getYPosition())
			{
				hspBall = -2;
			}
			else if (b.getXPosition() < r.getXPosition() + r.getWidth() &&
			b.getXPosition() + b.getSize() * 2 > r.getXPosition() &&
			b.getYPosition() < r.getYPosition() + r.getHeight() &&
			b.getYPosition() + b.getSize() * 2 > r.getYPosition())
			{
				hspBall = 2;
			}
		
			//Moving all the objects
			badPaddle.setYPosition(badPaddleY + vspEnemy);
			player.setYPosition(playerY + vspPlayer);
			
			if (reset == 0)
			{
				myBall.setYPosition(ballY + vspBall);
				myBall.setXPosition(ballX + hspBall);
			}
			else if (reset == 1)
			{
				reset = 0;
			}
			
		}
	}
	
}
