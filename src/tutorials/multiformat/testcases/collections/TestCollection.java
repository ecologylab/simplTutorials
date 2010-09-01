package tutorials.multiformat.testcases.collections;

import java.io.IOException;
import java.io.OutputStream;

import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.ElementState.FORMAT;

public class TestCollection
{
	/**
	 * @param args
	 * @throws SIMPLTranslationException
	 * @throws IOException
	 */
	public static void main(String[] args) throws SIMPLTranslationException, IOException
	{
//		Container test = new Container();
//		StringBuilder output = new StringBuilder();
//		
//		TranslationScope.graphSwitch = GRAPH_SWITCH.ON;
//
//		test.initializeInstance();
//		test.serialize(output);
//
//		System.out.println("Initialized object serialized into XML representation.");
//		System.out.println(output);
//
//		Container deserializedTest = (Container) TranslationScope
//				.get("testcase1", Container.class, ClassA.class).deserializeCharSequence(output);
//
//		System.out.println("Deserilized object serialized into XML representation");
//		deserializedTest.serialize(System.out);
		
		Container test = new Container();
		test.initializeInstance();
		
		
		final StringBuilder sb = new StringBuilder();
		OutputStream outputStream = new OutputStream()
		{
			@Override
			public void write(int b) throws IOException
			{
				sb.append((char) b);
			}
		};
		
		test.serialize(System.out, FORMAT.XML);
		System.out.println();
		System.out.println();
		test.serialize(System.out, FORMAT.JSON);
		
		System.out.println();
		System.out.println();
		
		test.serialize(outputStream, FORMAT.JSON);
		System.out.println(sb);
		
		System.out.println();
		Container data = (Container)TranslationScope.get("container", Container.class, ClassA.class, ClassB.class).deserializeCharSequence(sb, FORMAT.JSON);
		data.serialize(System.out, FORMAT.XML);
		System.out.println();
		System.out.println();
		data.serialize(System.out, FORMAT.JSON);
	}
}
