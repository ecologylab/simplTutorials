/*
 * Created on Feb 12, 2005
 */

package tutorials.polymorphic.rogue.game2d.entity;



import ecologylab.xml.ElementState;

/**
 * Entity represents various objects in the Rogue Signals game. It is the basis from which the other
 * Entities in the game are derived.
 * 
 * Entity objects have a location (x, y as doubles), an id (String), and four state booleans:
 * connected (whether or not the client is connected to the server), in (whether or not the Entity
 * is in the game or out), safe, and inactive (whether or not the client is considered disconnected
 * by the server).
 * 
 * @author Zachary O. Toups (toupsz@cs.tamu.edu)
 */
public class Entity extends ElementState
{
	/**
	 * In case the Entity needs to be animated for some reason; this can be modified.
	 */
	protected int								animState	= 0;

	@simpl_scalar
	protected String						m_id;

	@simpl_scalar
	protected boolean						online		= false;

	/**
	 * The Entity can interact with and be acted upon by the game and other entities.
	 */
	@simpl_scalar
	protected boolean						m_in				= false;

	@simpl_scalar
	protected boolean						safe			= false;

	/**
	 * The order in which the seeker joined the game. This is used to determine the seeker's color when
	 * it is drawn on the screen.
	 */
	@simpl_scalar
	protected int								ord				= 0;

	public Entity()
	{
		super();
	}
}