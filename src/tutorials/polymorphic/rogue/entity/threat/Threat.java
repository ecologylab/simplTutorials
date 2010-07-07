/*
 * Created on Feb 13, 2005
 */

package tutorials.polymorphic.rogue.entity.threat;


import tutorials.polymorphic.rogue.game2d.entity.Entity;
import ecologylab.serialization.simpl_inherit;
import ecologylab.serialization.ElementState.xml_tag;

/**
 * Threats are Targetters that hunt down SeekerAvatars in the game. Their in-game behavior is to
 * search (by looking in circles) for nearby SeekerAvatars, and then moving to touch those
 * SeekerAvatars (and thus make them out).
 * 
 * @author Zachary O. Toups (zach@ecologylab.net)
 * @author William Hamilton (bill@ecologylab.net)
 */
@simpl_inherit
@xml_tag("t")
public class Threat extends Entity
{
	/**
	 * No-argument constructor, required for ElementState.
	 */
	public Threat()
	{
		super();
	}
}