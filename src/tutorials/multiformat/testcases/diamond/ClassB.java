package tutorials.multiformat.testcases.diamond;

import ecologylab.serialization.ElementState;

public class ClassB extends ElementState
{
	@simpl_scalar
	private int			x;

	@simpl_scalar
	private int			y;

	@simpl_composite
	private ClassC	classC;
	
	@simpl_composite
	private ClassX 	classX;

	public ClassB()
	{
	}

	public ClassB(ClassC classC)
	{
		setX(1);
		setY(2);
		this.setClassC(classC);
		setClassX(new ClassX());
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

	public void setClassC(ClassC classC)
	{
		this.classC = classC;
	}

	public ClassC getClassC()
	{
		return classC;
	}

	public void setClassX(ClassX classX)
	{
		this.classX = classX;
	}

	public ClassX getClassX()
	{
		return classX;
	}
}
