package tutorials.multiformat.testcases.circle;

import ecologylab.serialization.ElementState;

public class Point extends ElementState
{
	@simpl_scalar
	private int x;
	
	@simpl_scalar
	private int y;
	
	public Point()
	{
		
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	public int getX()
	{
		return x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public int getY()
	{
		return y;
	}
	
}
