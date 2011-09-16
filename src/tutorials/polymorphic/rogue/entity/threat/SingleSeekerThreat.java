/**
 * 
 */
package tutorials.polymorphic.rogue.entity.threat;

import ecologylab.serialization.annotations.simpl_inherit;
import ecologylab.serialization.annotations.simpl_scalar;
import ecologylab.serialization.annotations.simpl_tag;

/**
 * @author Zachary O. Toups (toupsz@ecologylab.net)
 * 
 */

@simpl_inherit
@simpl_tag("sst")
public class SingleSeekerThreat extends Threat
{
	@simpl_scalar
	int	targetOrd;

	/**
	 * Default Constructor
	 */
	public SingleSeekerThreat()
	{
	}
}
