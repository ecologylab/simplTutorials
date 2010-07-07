/**
 * 
 */
package tutorials.polymorphic.rogue.entity.threat;

import ecologylab.serialization.simpl_inherit;
import ecologylab.serialization.ElementState.xml_tag;

/**
 * A special predator that finds a goal and stays near it.
 * 
 * @author Zachary O. Toups (zach@ecologylab.net)
 */

@simpl_inherit
@xml_tag("ot")
public class OrbitingThreat extends Threat
{
	/** Constructor stub for XML translation. */
	public OrbitingThreat()
	{
	}
}
