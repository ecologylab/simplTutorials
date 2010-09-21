//RssState.java

package tutorials.rss;

import ecologylab.serialization.ElementState;

public class Rss extends ElementState
{
	@simpl_scalar	float		version;
	@simpl_composite		Channel		channel;

	public Rss() {}

	public Channel getChannel() 
	{
		return channel;
	}
}
