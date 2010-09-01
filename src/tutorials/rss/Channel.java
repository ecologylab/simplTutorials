//Channel.java

package tutorials.rss;

import java.util.ArrayList;

import ecologylab.net.ParsedURL;
import ecologylab.serialization.ElementState;
import ecologylab.serialization.Hint;

public class Channel extends ElementState
{
  @simpl_nowrap
  @simpl_collection("item") 
  ArrayList<Item> 		items;
  
  @simpl_scalar @simpl_hints(Hint.XML_LEAF) String		title;
  @simpl_scalar @simpl_hints(Hint.XML_LEAF) String		description;
  @simpl_scalar @simpl_hints(Hint.XML_LEAF) ParsedURL	link;
     
   public Channel() { }

   public ArrayList<Item> getItems() 
   {
	   return items;
   }
}
