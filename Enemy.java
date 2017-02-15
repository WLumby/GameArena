public class Enemy
{
	
	private double xPosition; 		//x position of the enemy paddle
	private double yPosition; 		//y position of the enemy paddle
	private double width; 			//width of the enemy paddle
	private double height;			//height of the enemy paddle
	private String colour = "RED";	//colour of the enemy paddle
	private int difficulty;
	private int hsp = 0;
	private int vsp = 0;
	
	Rectangle badPaddle = new Rectangle(560, 240, 5, 20, "RED");
	
	xPosition = badPaddle.getXPosition();
	yPosition = badPaddle.getYPosition();
	width = badPaddle.getWidth();
	height = badPaddle.getHeight();
	
	public void setXPosition(double x)
	{
		badPaddle.setXPosition(x);
	}
	
	public void setYPosition(double y)
	{
		badPaddle.setXPosition(y);
	}
	
	public Enemy(int diff)
	{
		difficulty = diff;
	}
	
	
	while (true)
	{
		myGameArena.pause();
		hsp = 0;
		vsp = 0;
		
		if (myBall.getYPosition() > yPosition)
		{
			vsp = 1;
		}
		if (myBall.getYPosition() < yPosition)
		{
			vsp = -1;
		}
		
		setXPosition(xPosition + hsp);
		setYPosition(yPosition + vsp);
		
	}
	
	
}