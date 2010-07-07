package tutorials.polymorphic;

import java.io.File;

import tutorials.polymorphic.rogue.entity.threat.OrbitingThreat;
import tutorials.polymorphic.rogue.entity.threat.PatrollingThreat;
import tutorials.polymorphic.rogue.entity.threat.RepellableThreat;
import tutorials.polymorphic.rogue.entity.threat.SingleSeekerThreat;
import tutorials.polymorphic.rogue.entity.threat.Threat;
import tutorials.polymorphic.rogue.game2d.entity.Entity;
import tutorials.polymorphic.rogue.gamedata.GameData;
import ecologylab.serialization.TranslationScope;


public class PolymorphicTutorial 
{
	
	public static void main(String[] args) 
	{
		try 
		{
			/*
			 * Get translation scope
			 */
			TranslationScope tScope = get();
			File inputGameData = new File("src/tutorials/polymorphic/GameData.xml");
			
			/*
			 * Translating back from sample gameData file
			 */
			Object gd = tScope.deserialize(inputGameData);
			GameData<?> gameData = null;
			
			if(gd instanceof GameData<?>)
				gameData = (GameData<?>) tScope.deserialize(inputGameData);
			else
				System.out.println("Invalid object returned by translateFromXML");
			
			/*
			 * Translating the game data back to XML 
			 */
			gameData.serialize(new File("ecologylab/tutorials/polymorphic/output.xml"));
			
			//Again to console
			gameData.serialize(System.out);
			
			
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
