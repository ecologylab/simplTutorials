//RssState.java

package tutorials.multiformat.testcases.rss;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import ecologylab.net.ParsedURL;
import ecologylab.serialization.ElementState;
import ecologylab.serialization.SIMPLTranslationException;

public class Rss extends ElementState
{
	@simpl_scalar	float		version;
	@simpl_composite		Channel		channel;

	public Rss() {}

	public Channel getChannel() 
	{
		return channel;
	}
	
	public static void main(String[] args) throws MalformedURLException, SIMPLTranslationException
	{
		final StringBuilder sb = new StringBuilder();
		OutputStream outputStream = new OutputStream()
		{
			@Override
			public void write(int b) throws IOException
			{
				sb.append((char) b);
			}
		};
		
		
		Rss rssState = new Rss();
		Channel channel = new Channel();
		Item item1 = new Item();
		Item item2 = new Item();
		
		ArrayList<String> categorySet = new ArrayList<String>();
		
		rssState.version = 1.0f;
		
		channel.title = "testTitle";
		channel.description = "testDescription";
		channel.link = new ParsedURL(new URL("http://www.google.com"));
		
		categorySet.add("category1");
		categorySet.add("category2");
		
		item1.title = "testItem1";
		item1.description = "testItem1Description";
		item1.categorySet = categorySet;
		
		item2.title = "testItem2";
		item2.description = "testItem2Description";
		
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		
		channel.items = items;
		rssState.channel = channel;
		
		rssState.serialize(System.out, FORMAT.XML);
		System.out.println();
		System.out.println();
		rssState.serialize(System.out, FORMAT.JSON);

		System.out.println();
		System.out.println();

		rssState.serialize(outputStream, FORMAT.JSON);
		System.out.println(sb);

		System.out.println();
		Rss data = (Rss) RssTranslations.get().deserializeCharSequence(sb, FORMAT.JSON);
		data.serialize(System.out, FORMAT.XML);
		System.out.println();
		System.out.println();
		data.serialize(System.out, FORMAT.JSON);
	}
}
