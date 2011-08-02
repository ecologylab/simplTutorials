package tutorials.graph.collections;

import java.util.ArrayList;

import ecologylab.serialization.ElementState;

public class Container extends ElementState
{
	@simpl_nowrap
	@simpl_collection("objectsA")
	private ArrayList<ClassA>	aObjects	= new ArrayList<ClassA>();

	public Container()
	{

	}

	public Container initializeInstance()
	{
		ClassA objA = new ClassA();

		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);

		aObjects.add(new ClassA());
		aObjects.add(new ClassA());

		return this;
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
