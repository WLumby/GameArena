public class Enemy
{
	
	private double xPosition; 		//x position of the enemy paddle
	private double yPosition; 		//y position of the enemy paddle
	private double width; 			//width of the enemy paddle
	private double height;			//height of the enemy paddle
	private String colour = "RED";	//colour of the enemy paddle
	private int difficulty;
	private int vsp = 0;
	
	Rectangle badPaddle = new Rectangle(560, 240, 5, 20, "RED");
	
	public void setXPosition(double x)
	{
		badPaddle.setXPosition(x);
	}
	
	public void setYPosition(double y)
	{
		badPaddle.setXPosition(y);
	}
	
	public double getXPosition()
	{
		return xPosition;
	}
	
	public double getYPosition()
	{
		return yPosition;
	}
	
	public Enemy(int diff)
	{
		difficulty = diff;
		xPosition = badPaddle.getXPosition();
		yPosition = badPaddle.getYPosition();
		width = badPaddle.getWidth();
		height = badPaddle.getHeight();
		
	}
	
	
	public void enemyMove(double ballY)
	{
		vsp = 0;
		
		if (ballY > yPosition)
		{
			vsp = (1 + difficulty);
		}
		if (ballY < yPosition)
		{
			vsp = (-1 - difficulty);
		}
		
		setYPosition(yPosition + vsp);
		
	}
	
	
}