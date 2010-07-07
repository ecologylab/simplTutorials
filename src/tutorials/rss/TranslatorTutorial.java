//TranslatorTutorial.java

package tutorials.rss;

import java.io.File;

import translators.cocoa.CocoaTranslator;
import ecologylab.serialization.TranslationScope;


public class TranslatorTutorial 
{

	public static void main(String[] args) 
	{

		/*
		 * We create an instance of CocaTranslator which will translate
		 * our annotated java source code to Objective-C header file.
		 */
		CocoaTranslator c = new CocoaTranslator();
		
		/*
		 * We create an object of Translation scope of all the java files for which,
		 * We need to create the Translation Scope XML file.
		 */
		TranslationScope tScope	= RssTranslations.get();
		try 
		{
			/*
			 * Call translateToObjC supplied with the path where we want our header files 
			 * to be generated
			 */
			c.translateToObjC(new File ("/output"), tScope);
			
			/*
			 * Call translateToXML will serialize the internal data structures of 
			 * ecologylab.serialization which should be used by objective-c version ecologylab.serialization
			 */
			tScope.serialize(new File("/output/rss_translationScope.xml"));
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
