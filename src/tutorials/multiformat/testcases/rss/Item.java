//Item.java

package tutorials.multiformat.testcases.rss;

import java.util.ArrayList;

import ecologylab.net.ParsedURL;
import ecologylab.serialization.ElementState;
import ecologylab.serialization.Hint;

public class Item extends ElementState
{
   @simpl_scalar @simpl_hints(Hint.XML_LEAF) String			title;
   @simpl_scalar @simpl_hints(Hint.XML_LEAF) String			description;
   @simpl_scalar @simpl_hints(Hint.XML_LEAF) ParsedURL		link;
   @simpl_scalar @simpl_hints(Hint.XML_LEAF) ParsedURL		guid;
   @simpl_scalar @simpl_hints(Hint.XML_LEAF) String			author;
   
   @simpl_nowrap
   @simpl_collection("category") 
   ArrayList<String>		categorySet;
   
   public Item() {}

   public void setTitle(String string) 
   {
	   title = string;
   }
	
   public void setDescription(String string)
   {
	   description = string;
	   
   }
	
   public void setAuthor(String string) 
   {
	   author = string;
		
   }
	
   public void setLink(ParsedURL parsedURL) 
   {
	  link = parsedURL;	
   }
}
