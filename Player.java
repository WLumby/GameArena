public class Player
{
	private double xPosition;			// The X coordinate of centre of goodPaddle
	private double yPosition;			// The Y coordinate of centre of goodPaddle
	private double width;				// The width of goodPaddle
	private double height;				// The height of goodPaddle
	private String colour = "Blue";	// The colour of goodPaddle
	private int playerSpeed = 0;
	
	Rectangle goodPaddle = new Rectangle(40, 240, 5, 20, "BLUE");
	
	public Player()
	{
		xPosition = goodPaddle.getXPosition();
		yPosition = goodPaddle.getYPosition();
		width = goodPaddle.getWidth();
		height = goodPaddle.getHeight();
	}
	
	public void setXPosition(double x)
	{
		goodPaddle.setXPosition(x);
	}
	
	public void setYPosition(double y)
	{
		goodPaddle.setYPosition(y);
	}
	
	public void playerMove()
	{
		playerSpeed = 0;
		
		if (upPressed())
		{
			playerSpeed = - 1;
		}

		if (downPressed())
		{
			playerSpeed = 1;
		}
			
		setYPosition(yPosition + playerSpeed);
	}
	
}