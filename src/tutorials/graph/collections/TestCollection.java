package tutorials.graph.collections;

import java.io.IOException;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.TranslationScope.GRAPH_SWITCH;

public class TestCollection
{
	/**
	 * @param args
	 * @throws SIMPLTranslationException
	 * @throws IOException
	 */
	public static void main(String[] args) throws SIMPLTranslationException, IOException
	{
		Container test = new Container();
		StringBuilder output = new StringBuilder();
		
		TranslationScope.graphSwitch = GRAPH_SWITCH.ON;

		test.initializeInstance();
		test.serialize(output);

		System.out.println("Initialized object serialized into XML representation.");
		System.out.println(output);

		Container deserializedTest = (Container) TranslationScope
				.get("testcase1", Container.class, ClassA.class).deserializeCharSequence(output);

		System.out.println("Deserilized object serialized into XML representation");
		deserializedTest.serialize(System.out);
	}
}
