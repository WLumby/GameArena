import java.util.*;

public class Driver
{
	public static void main(String[] args)
	{
		//difficulty increases the speed at which the enemy paddle moves
		double difficulty = 1.0;
		
		//default points value
		int enemyPoints = 0;
		int playerPoints = 0;
		int reset = 0;

		//making the random speed/direction of the ball
		Random vertSp = new Random();
		double randomV = vertSp.nextDouble()*(2.5 - 1.5) + 1.5;
		
		Random horizSp = new Random();
		double randomH = horizSp.nextDouble()*(2.5 - 1.5) + 1.5;
		
		//default speeds
		double vspEnemy = 0;
		double vspPlayer = 0;
		double vspBall = randomV;
		double hspBall = randomH;
		
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
				vspBall = randomV * -1;
			}
			else if (ballY <= 0)
			{
				vspBall = randomV;
			}
			
			if (ballX <= 0)
			{
				reset = 1;
				enemyPoints++;
				if (enemyPoints > playerPoints)
				{
					myBall.setColour("RED");
				}
				else if (enemyPoints == playerPoints)
				{
					myBall.setColour("WHITE");
				}
				System.out.println(playerPoints + "-" + enemyPoints);
				myBall.setXPosition(300);
				myBall.setYPosition(240);
				vspBall = randomV;
				hspBall = randomH;
			}
			else if (ballX >= 600)
			{
				reset = 1;
				playerPoints++;
				if (playerPoints > enemyPoints)
				{
					myBall.setColour("BLUE");
				}
				else if (enemyPoints == playerPoints)
				{
					myBall.setColour("WHITE");
				}
				System.out.println(playerPoints + "-" + enemyPoints);
				myBall.setXPosition(300);
				myBall.setYPosition(240);
				vspBall = randomV * -1;
				hspBall = randomH * -1;
			}
			
			//check for collisions between the ball and player/enemy paddles
			Ball b = myBall;
			Rectangle e = badPaddle;
			Rectangle r = player;
			
			if (b.getXPosition() - 2 < e.getXPosition() + e.getWidth() &&
			b.getXPosition() + b.getSize() * 2 > e.getXPosition() - 2 &&
			b.getYPosition() - 2 < e.getYPosition() + e.getHeight() &&
			b.getYPosition() + b.getSize() * 2 > e.getYPosition() - 2)
			{
				hspBall = randomH * -1;
			}
			else if (b.getXPosition() - 5 < r.getXPosition() + r.getWidth() &&
			b.getXPosition() + b.getSize() * 2 > r.getXPosition() - 5 &&
			b.getYPosition() - 5 < r.getYPosition() + r.getHeight() &&
			b.getYPosition() + b.getSize() * 2 > r.getYPosition() - 5)
			{
				hspBall = randomH;
			}
		
			//Moving all the objects and re-randomizing the direction of the ball
			badPaddle.setYPosition(badPaddleY + vspEnemy);
			player.setYPosition(playerY + vspPlayer);
			
			if (reset == 0)
			{
				myBall.setYPosition(ballY + vspBall);
				myBall.setXPosition(ballX + hspBall);
				randomV = vertSp.nextDouble()*(2.5 - 1.5) + 1.5;
				randomH = horizSp.nextDouble()*(2.5 - 1.5) + 1.5;
			}
			else if (reset == 1)
			{
				reset = 0;
			}			
		}
	}
	
}
