/*
 * Created on Jul 6, 2005
 */
package tutorials.polymorphic.rogue.gamedata;

import java.util.ArrayList;

import tutorials.polymorphic.rogue.entity.threat.OrbitingThreat;
import tutorials.polymorphic.rogue.entity.threat.PatrollingThreat;
import tutorials.polymorphic.rogue.entity.threat.RepellableThreat;
import tutorials.polymorphic.rogue.entity.threat.SingleSeekerThreat;
import tutorials.polymorphic.rogue.entity.threat.Threat;
import ecologylab.serialization.ElementState;

/**
 * GameData encapsulates all of the logical information about the game and is shared between the
 * clients and the server.
 * 
 * Although most of the information stored by GameData is changed on the server, serialized, and
 * sent to clients, some of it is not. Since some of this data is static, it is initialized when the
 * game starts, and does not change. Variables that are not serialized are described in detail in
 * their documentation.
 * 
 * @author Zachary O. Toups (zach@ecologylab.net)
 */


//GameData.java

public class GameData<T extends Threat> extends
		ElementState
{
	@simpl_scalar
	protected long																timestamp;

	/** Number of game cycles remaining. */
	@simpl_scalar
	protected int																cycRem;

	/**
	 * Indicates that, if the game is running, it should be paused; by default, the game starts this
	 * way and a user needs to activate it.
	 */
	@simpl_scalar
	protected boolean															paused	= false;

	@simpl_scalar
	protected boolean															loaded	= false;

	/** Game state flag indicating that the game has ended (favorably or unfavorably). */
	@simpl_scalar
	protected boolean															over										= false;

	/**
	 * Game state flag indicating that the game is currently executing play cycles.
	 */
	@simpl_scalar
	protected boolean															running									= false;

	/** Game state flag indicating that the players have won the game. */
	@simpl_scalar
	protected boolean															won											= false;

	/** List of Threat objects. */
	
	@simpl_classes(
	{ Threat.class, SingleSeekerThreat.class, OrbitingThreat.class, RepellableThreat.class,
			PatrollingThreat.class })
	@simpl_collection
	protected ArrayList<T>										threats									= new ArrayList<T>();


	@simpl_scalar
	protected double															score										= 0;

	/** No-argument constructor, required for ElementState. */
	public GameData()
	{
		super();
	}
}
