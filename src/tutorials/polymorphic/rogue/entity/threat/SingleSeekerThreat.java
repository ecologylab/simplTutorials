/**
 * 
 */
package tutorials.polymorphic.rogue.entity.threat;

import ecologylab.serialization.simpl_inherit;
import ecologylab.serialization.ElementState.xml_tag;

/**
 * @author Zachary O. Toups (toupsz@ecologylab.net)
 * 
 */

@simpl_inherit
@xml_tag("sst")
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
