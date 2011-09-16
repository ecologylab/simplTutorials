/**
 * 
 */
package tutorials.polymorphic.rogue.entity.threat;

import ecologylab.serialization.annotations.simpl_inherit;
import ecologylab.serialization.annotations.simpl_tag;

/**
 * A special predator that finds a goal and stays near it.
 * 
 * @author Zachary O. Toups (zach@ecologylab.net)
 */

@simpl_inherit
@simpl_tag("ot")
public class OrbitingThreat extends Threat
{
	/** Constructor stub for XML translation. */
	public OrbitingThreat()
	{
	}
}
