package tutorials.polymorphic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import tutorials.polymorphic.rogue.entity.threat.OrbitingThreat;
import tutorials.polymorphic.rogue.entity.threat.PatrollingThreat;
import tutorials.polymorphic.rogue.entity.threat.RepellableThreat;
import tutorials.polymorphic.rogue.entity.threat.SingleSeekerThreat;
import tutorials.polymorphic.rogue.entity.threat.Threat;
import tutorials.polymorphic.rogue.game2d.entity.Entity;
import tutorials.polymorphic.rogue.gamedata.GameData;
import ecologylab.serialization.Format;
import ecologylab.serialization.StringFormat;
import ecologylab.serialization.SimplTypesScope;

public class PolymorphicTutorial
{

	private static String readFileAsString(String filePath) throws java.io.IOException
	{
		StringBuffer fileData = new StringBuffer(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1)
		{
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
			
			SimplTypesScope.enableGraphSerialization();
			/*
			 * Get translation scope
			 */
			SimplTypesScope tScope = get();

			String fileData = readFileAsString("src/tutorials/polymorphic/GameData.xml");

			System.out.println("----ORIGNIAL DATA----");
			System.out.println(fileData);

			/*
			 * Translating back from sample gameData file
			 */
			GameData<?> gameData = (GameData<?>) tScope.deserialize(fileData, StringFormat.XML);

			/*
			 * Translating the game data back to XML
			 */
			SimplTypesScope.serialize(gameData, new File("ecologylab/tutorials/polymorphic/output.xml"), Format.XML);
			

			// Again to console
			System.out.println("----DESERIALIZED DATA----");
			SimplTypesScope.serialize(gameData, System.out, StringFormat.XML);

//			System.out.println();
//
//			final StringBuilder sb = new StringBuilder();
//			OutputStream outputStream = new OutputStream()
//			{
//				@Override
//				public void write(int b) throws IOException
//				{
//					sb.append((char) b);
//				}
//			};
//
//			gameData.serialize(outputStream, Format.JSON);
//			System.out.println(sb);
//
//			System.out.println();
//			GameData<?> data = (GameData<?>) tScope.deserializeCharSequence(sb, Format.JSON);
//
//			data.serialize(System.out, Format.XML);
//			System.out.println();
//			System.out.println();
//			data.serialize(System.out, Format.JSON);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/*
	 * Creating Translation Scope of all the classes used by game data object
	 */
	private static SimplTypesScope get()
	{

		SimplTypesScope tScope = SimplTypesScope.get("gamedata", GameData.class, Threat.class,
				SingleSeekerThreat.class, OrbitingThreat.class, RepellableThreat.class,
				PatrollingThreat.class, Entity.class);

		return tScope;
	}
}
