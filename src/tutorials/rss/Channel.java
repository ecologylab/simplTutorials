//Channel.java

package tutorials.rss;

import java.util.ArrayList;

import ecologylab.net.ParsedURL;
import ecologylab.xml.ElementState;
import ecologylab.xml.Hint;

public class Channel extends ElementState
{
   @simpl_scalar @simpl_hints(Hint.XML_LEAF) String		title;
   @simpl_scalar @simpl_hints(Hint.XML_LEAF) String		description;
   @simpl_scalar @simpl_hints(Hint.XML_LEAF) ParsedURL	link;
   
   @simpl_nowrap
   @simpl_collection("item") 
   ArrayList<Item> 		items;
   
   public Channel() { }

   public ArrayList<Item> getItems() 
   {
	   return items;
   }
}
