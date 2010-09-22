package tutorials.multiformat.testcases.polymorphic;

import ecologylab.serialization.simpl_inherit;

@simpl_inherit
public class PrefInteger extends Pref
{
	@simpl_scalar
	public int	intValue;

	public PrefInteger()
	{

	}
}
