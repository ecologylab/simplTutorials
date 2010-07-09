package tutorials.polymorphic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

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
	
	private static String readFileAsString(String filePath)
  throws java.io.IOException{
      StringBuffer fileData = new StringBuffer(1000);
      BufferedReader reader = new BufferedReader(
              new FileReader(filePath));
      char[] buf = new char[1024];
      int numRead=0;
      while((numRead=reader.read(buf)) != -1){
          String readData = String.valueOf(buf, 0, numRead);
          fileData.append(readData);
          buf = new char[1024];
      }
      reader.close();
      return fileData.toString();
  }

	
	public static void main(String[] args) 
	{
		try 
		{
			/*
			 * Get translation scope
			 */
			TranslationScope tScope = get();
			
			String fileData = readFileAsString("src/tutorials/polymorphic/GameData.xml");
			
			System.out.println("----ORIGNIAL DATA----");
			System.out.println(fileData);
			
			/*
			 * Translating back from sample gameData file
			 */
			GameData<?> gameData = (GameData<?>) tScope.deserializeCharSequence(fileData);
			
			/*
			 * Translating the game data back to XML 
			 */
			gameData.serialize(new File("ecologylab/tutorials/polymorphic/output.xml"));
			
			//Again to console
			System.out.println("----DESERIALIZED DATA----");
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
