package tutorials.graph.collections;

import ecologylab.serialization.ElementState;

public class ClassA extends ElementState
{
	@simpl_scalar
	private int u;
	
	@simpl_scalar
	private int w;
	
	public ClassA()
	{
		setU(55);
		setW(54);
	}

	public void setU(int u)
	{
		this.u = u;
	}

	public int getU()
	{
		return u;
	}

	public void setW(int w)
	{
		this.w = w;
	}

	public int getW()
	{
		return w;
	}

}
