/*
 * Created on Feb 12, 2005
 */

package tutorials.polymorphic.rogue.game2d.entity.goal;

import java.awt.geom.Rectangle2D;

import tutorials.polymorphic.rogue.game2d.entity.Entity;
import ecologylab.serialization.annotations.simpl_inherit;
import ecologylab.serialization.annotations.simpl_scalar;
import ecologylab.serialization.annotations.simpl_tag;

/**
 * Goal represents a goal location. Goals can be collected by SeekerAvatar objects if the
 * SeekerAvatar passes over the Goal in the game space.
 * 
 * Whether or not a goal has been collected is indicated by whether or not its state is in (an in
 * goal has not been collected yet). The other flags in its state have no meaning.
 * 
 * @author Zachary O. Toups (zach@ecologylab.net)
 */
@simpl_inherit
@simpl_tag("g")
public class Goal extends Entity implements GoalConstants, Comparable<Goal>
{
	

	protected Rectangle2D.Double	uncertaintyZone	= null;

	protected int									group;

	@simpl_scalar
	protected int								numReqSkr				= 1;

	@simpl_scalar
	protected int									cycToCol;

	protected int 								sectorSize				= 200;
	/**
	 * @return the numReqSeekers
	 */
	public int getNumReqSkr()
	{
		return numReqSkr;
	}

	/**
	 * No-argument constructor, required for ElementState.
	 * 
	 */
	public Goal()
	{
		super();
	}

	@Override
	public int compareTo(Goal o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}