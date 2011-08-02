package tutorials.graph.cyclic;

import java.io.IOException;
import java.io.OutputStream;

import org.codehaus.jackson.JsonParseException;

import tutorials.graph.collections.ClassA;
import tutorials.graph.collections.Container;

import ecologylab.serialization.ElementState;
import ecologylab.serialization.ElementStateJSONPushHandler;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.TranslationContext;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.ElementState.FORMAT;
import ecologylab.serialization.TranslationScope.GRAPH_SWITCH;

public class TestCyclic
{

	/**
	 * @param args
	 * @throws SIMPLTranslationException
	 * @throws IOException
	 */
	public static void main(String[] args) throws SIMPLTranslationException, IOException
	{

		ClassB test = new ClassB();
		test.initializeInstance();
		TranslationScope translationScope = TranslationScope.get("testcyclic", ClassA.class,
				ClassB.class);

		testDeSerialization(test, translationScope, FORMAT.JSON, true);
	}

	public static void testDeSerialization(ElementState test, TranslationScope translationScope,
			FORMAT format, boolean setGraphSwitch) throws SIMPLTranslationException, JsonParseException, IOException
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
