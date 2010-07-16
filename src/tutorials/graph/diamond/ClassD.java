package tutorials.graph.diamond;

import ecologylab.serialization.ElementState;

public class ClassD extends ElementState
{
	@simpl_composite
	private ClassA classA;
	
	@simpl_composite
	private ClassB classB;
	
	public ClassD()
	{

	}
	
	public ClassD(ClassA classA, ClassB classB)
	{
		this.setClassA(classA);
		this.setClassB(classB);
	}

	public void setClassA(ClassA classA)
	{
		this.classA = classA;
	}

	public ClassA getClassA()
	{
		return classA;
	}

	public void setClassB(ClassB classB)
	{
		this.classB = classB;
	}

	public ClassB getClassB()
	{
		return classB;
	}
}
