package tutorials.polymorphic;

import java.io.File;

import tutorials.polymorphic.rogue.entity.threat.OrbitingThreat;
import tutorials.polymorphic.rogue.entity.threat.PatrollingThreat;
import tutorials.polymorphic.rogue.entity.threat.RepellableThreat;
import tutorials.polymorphic.rogue.entity.threat.SingleSeekerThreat;
import tutorials.polymorphic.rogue.entity.threat.Threat;
import tutorials.polymorphic.rogue.game2d.entity.Entity;
import tutorials.polymorphic.rogue.gamedata.GameData;
import ecologylab.serialization.ClassDescriptor;
import ecologylab.serialization.Format;
import ecologylab.serialization.StringFormat;
import ecologylab.serialization.TranslationScope;
import ecologylab.translators.cocoa.CocoaTranslator;

public class TranslatorTutorial
{
	public static void main(String[] args) 
	{

		/*
		 * We create an instance of CocaTranslator which will translate
		 * our annotated java source code to Objective-C header file.
		 */
		CocoaTranslator c = new CocoaTranslator();
		
		TranslationScope.enableGraphSerialization();
		
		/*
		 * We create an object of Translation scope of all the java files for which,
		 * We need to create the Translation Scope XML file.
		 */
		TranslationScope tScope	= get();
		try 
		{
			
			/*
			 * Call translateToObjC supplied with the path where we want our header files 
			 * to be generated
			 */
			c.translateToObjC(new File ("output"), tScope);
			
			/*
			 * Call translateToXML will serialize the internal data structures of 
			 * ecologylab.serialization which should be used by objective-c version ecologylab.serialization
			 */
			ClassDescriptor.serialize(tScope, new File("output/gamedata_translationScope.xml"), Format.XML);		
			ClassDescriptor.serialize(tScope, System.out, StringFormat.XML);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Creating Translation Scope of all the classes used by game data object
	 */
	private static TranslationScope get()
	{

		
		TranslationScope tScope = TranslationScope.get("gamedata", GameData.class,
				Threat.class, SingleSeekerThreat.class, OrbitingThreat.class, RepellableThreat.class,
				PatrollingThreat.class, Entity.class);
		
		return tScope;
	}
}
