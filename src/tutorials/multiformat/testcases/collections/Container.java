package tutorials.multiformat.testcases.collections;

import java.util.ArrayList;

import ecologylab.serialization.ElementState;

public class Container extends ElementState
{
	//@simpl_nowrap
	@simpl_collection("objectsA")
	private ArrayList<ClassA>		aObjects		= new ArrayList<ClassA>();

//	 @simpl_nowrap
	@simpl_collection("myints")
	private ArrayList<Integer>	myIntegers	= new ArrayList<Integer>();

	public Container()
	{

	}

	public void initializeInstance()
	{
		for (int i = 1; i < 11; i++)
		{
			ClassA objA = new ClassA(i, i * 2);

			aObjects.add(objA);
		}

		myIntegers.add(10);
		myIntegers.add(11);
		myIntegers.add(12);
		myIntegers.add(13);
		myIntegers.add(14);
		myIntegers.add(15);
		myIntegers.add(16);
		myIntegers.add(17);
		myIntegers.add(18);
		myIntegers.add(19);

	}

	public void setAobjects(ArrayList<ClassA> aobjects)
	{
		aObjects = aobjects;
	}

	public ArrayList<ClassA> getAobjects()
	{
		return aObjects;
	}

}
