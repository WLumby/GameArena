public class Score
{
	int playerPoints = 0;
	int enemyPoints = 0;
	GameArena thisGameArena;
	
	public void updateScore(int playerPoints, int enemyPoints)
	{
		this.playerPoints = playerPoints;
		this.enemyPoints = enemyPoints;
		
		if (playerPoints == 0)
		{
			Rectangle zeroP1 = new Rectangle(100, 100, 10, 50, "WHITE");
			Rectangle zeroP2 = new Rectangle(150, 100, 10, 50, "WHITE");
			Rectangle zeroP3 = new Rectangle(125, 75, 40, 10, "WHITE");
			Rectangle zeroP4 = new Rectangle(125, 125, 40, 10, "WHITE");
			
			thisGameArena.addRectangle(zeroP1);
			thisGameArena.addRectangle(zeroP2);
			thisGameArena.addRectangle(zeroP3);
			thisGameArena.addRectangle(zeroP4);
		}
		/*if (playerPoints == 1)
		{
			thisGameArena.removeRectangle(zeroP1);
			thisGameArena.removeRectangle(zeroP2);
			thisGameArena.removeRectangle(zeroP3);
			thisGameArena.removeRectangle(zeroP4);
		}
		*/
		
		if (enemyPoints == 0)
		{
			Rectangle zeroE1 = new Rectangle(500, 100, 10, 50, "WHITE");
			Rectangle zeroE2 = new Rectangle(450, 100, 10, 50, "WHITE");
			Rectangle zeroE3 = new Rectangle(475, 75, 40, 10, "WHITE");
			Rectangle zeroE4 = new Rectangle(475, 125, 40, 10, "WHITE");
			
			thisGameArena.addRectangle(zeroE1);
			thisGameArena.addRectangle(zeroE2);
			thisGameArena.addRectangle(zeroE3);
			thisGameArena.addRectangle(zeroE4);
		}
		/*if (enemyPoints == 1)
		{
			thisGameArena.removeRectangle(zeroE1);
			thisGameArena.removeRectangle(zeroE2);
			thisGameArena.removeRectangle(zeroE3);
			thisGameArena.removeRectangle(zeroE4);
		}
		*/
	}
	
	public Score(GameArena myGameArena)
	{
		thisGameArena = myGameArena;
	}
	
}