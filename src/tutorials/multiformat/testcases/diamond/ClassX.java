package tutorials.multiformat.testcases.diamond;

import ecologylab.serialization.ElementState;

public class ClassX extends ElementState
{
	@simpl_scalar
	private int u;
	
	@simpl_scalar
	private int w;
	
	public ClassX()
	{
		setU(44);
		setW(33);
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
