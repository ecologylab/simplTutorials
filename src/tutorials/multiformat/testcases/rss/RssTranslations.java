//RssTranslations.java

package tutorials.multiformat.testcases.rss;

import ecologylab.generic.Debug;
import ecologylab.serialization.TranslationScope;

public class RssTranslations extends Debug
{
   public static TranslationScope get()
   {
	   return TranslationScope.get("rss", Rss.class, Channel.class, Item.class);
   } 
}
