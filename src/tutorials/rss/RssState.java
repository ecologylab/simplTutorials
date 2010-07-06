//RssState.java

package tutorials.rss;

import ecologylab.xml.ElementState;

public class RssState extends ElementState
{
	@xml_attribute	float		version;
	@xml_nested		Channel		channel;

	public RssState() {}

	public Channel getChannel() 
	{
		return channel;
	}
}
