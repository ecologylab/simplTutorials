package tutorials.graph.diamond;

import java.io.IOException;
import java.io.OutputStream;

import org.codehaus.jackson.JsonParseException;

import ecologylab.serialization.ElementState;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.ElementState.FORMAT;
import ecologylab.serialization.TranslationScope.GRAPH_SWITCH;

public class TestDiamond
{

	/**
	 * @param args
	 * @throws SIMPLTranslationException
	 * @throws IOException 
	 * @throws JsonParseException 
	 */
	public static void main(String[] args) throws SIMPLTranslationException, JsonParseException, IOException
	{
		ClassC classC = new ClassC();
		ClassD test = new ClassD(new ClassA(classC), new ClassB(classC));

		TranslationScope.graphSwitch = GRAPH_SWITCH.ON;

		TranslationScope translationScope = TranslationScope.get("testcase1", ClassA.class,
				ClassB.class, ClassC.class, ClassD.class, ClassX.class);

		testDeSerialization(test, translationScope, FORMAT.JSON, true);

		// StringBuilder output = new StringBuilder();
		//
		// test.serialize(output);
		//
		// System.out.println("Initialized object serialized into XML representation.");
		// System.out.println(output);
		//
		// ClassD deserializedTest = (ClassD) TranslationScope.get("testcase1", ClassA.class,
		// ClassB.class, ClassC.class, ClassD.class, ClassX.class).deserializeCharSequence(output);
		//
		// System.out.println("Deserilized object serialized into XML representation");
		// deserializedTest.serialize(System.out);
	}

	public static void testDeSerialization(ElementState test, TranslationScope translationScope,
			FORMAT format, boolean setGraphSwitch) throws SIMPLTranslationException, JsonParseException,
			IOException
	{
		System.out.println();

		if (setGraphSwitch)
		{
			TranslationScope.setGraphSwitch();
		}

		final StringBuilder output = new StringBuilder();
		OutputStream outputStream = new OutputStream()
		{
			@Override
			public void write(int b) throws IOException
			{
				output.append((char) b);
			}
		};

		ElementState deserializedObject = null;

		test.serialize(outputStream, format);

		System.out.println("Initialized object serialized into " + format + " representation.");
		System.out.println();

		System.out.println(output);

		System.out.println();

		deserializedObject = translationScope.deserializeCharSequence(output, format);

		System.out.println("Deserilized object serialized into " + format + "  representation");
		System.out.println();
		deserializedObject.serialize(System.out, format);

		System.out.println();

	}
}
