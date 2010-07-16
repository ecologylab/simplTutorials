package tutorials.graph.cyclic;

import ecologylab.serialization.ElementState;

public class ClassA extends ElementState
{
	@simpl_scalar
	private int x;
	
	@simpl_scalar 
	private int y;
	
	@simpl_composite
	private ClassB classB;	
	
	@simpl_composite
	private ClassA classA;
	
	public ClassA()
	{
		
	}

	public ClassA(ClassB classB)
	{
		setX(1);
		setY(2);
		setClassB(classB);
		setClassA(this);
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

	public void setClassB(ClassB classB)
	{
		this.classB = classB;
	}

	public ClassB getClassB()
	{
		return classB;
	}

	public void setClassA(ClassA classA)
	{
		this.classA = classA;
	}

	public ClassA getClassA()
	{
		return classA;
	}
}
