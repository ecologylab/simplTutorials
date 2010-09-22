package tutorials.multiformat.testcases.polymorphic;

import ecologylab.serialization.simpl_inherit;

@simpl_inherit
public class PrefDouble extends Pref
{
	@simpl_scalar
	public double	doubleValue;

	public PrefDouble()
	{

	}
}
