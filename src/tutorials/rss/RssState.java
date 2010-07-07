//RssState.java

package tutorials.rss;

import ecologylab.serialization.ElementState;

public class RssState extends ElementState
{
	@simpl_scalar	float		version;
	@simpl_composite		Channel		channel;

	public RssState() {}

	public Channel getChannel() 
	{
		return channel;
	}
}
