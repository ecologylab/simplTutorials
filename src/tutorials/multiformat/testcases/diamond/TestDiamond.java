package tutorials.multiformat.testcases.diamond;

import java.io.IOException;
import java.io.OutputStream;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.ElementState.FORMAT;
import ecologylab.serialization.TranslationScope.GRAPH_SWITCH;


public class TestDiamond
{

	/**
	 * @param args
	 * @throws SIMPLTranslationException
	 */
	public static void main(String[] args) throws SIMPLTranslationException
	{
		final StringBuilder sb = new StringBuilder();
		OutputStream outputStream = new OutputStream()
		{
			@Override
			public void write(int b) throws IOException
			{
				sb.append((char) b);
			}
		};

		ClassC classC = new ClassC();
		ClassD test = new ClassD(new ClassA(classC), new ClassB(classC));

		test.serialize(System.out, FORMAT.XML);
		System.out.println();
		System.out.println();
		test.serialize(System.out, FORMAT.JSON);

		System.out.println();
		System.out.println();

		test.serialize(outputStream, FORMAT.JSON);
		System.out.println(sb);

		System.out.println();
		ClassD data = (ClassD) TranslationScope.get("container", ClassD.class, ClassX.class,
				ClassC.class, ClassA.class, ClassB.class).deserializeCharSequence(sb, FORMAT.JSON);
		data.serialize(System.out, FORMAT.XML);
		System.out.println();
		System.out.println();
		data.serialize(System.out, FORMAT.JSON);

//		String text =  "{'foo':'bar','coolness':2.0,'altitude':39000,'pilot':{'firstName':'Buzz','lastName':'Aldrin'},'mission':'apollo 11'}";//sb.toString().replace('"', '\'');
//		JSONObject json = (JSONObject) JSONSerializer.toJSON(text); 
//		
//		System.out.println(json.toString());

		// TranslationScope.graphSwitch = GRAPH_SWITCH.ON;
		//
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
}
