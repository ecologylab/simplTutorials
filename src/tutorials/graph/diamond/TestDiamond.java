package tutorials.graph.diamond;

import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.TranslationScope;

public class TestDiamond
{

	/**
	 * @param args
	 * @throws SIMPLTranslationException
	 */
	public static void main(String[] args) throws SIMPLTranslationException
	{
		ClassC classC = new ClassC();
		ClassD test = new ClassD(new ClassA(classC), new ClassB(classC));

		StringBuilder output = new StringBuilder();

		test.serialize(output);

		System.out.println("Initialized object serialized into XML representation.");
		System.out.println(output);

		ClassD deserializedTest = (ClassD) TranslationScope.get("testcase1", ClassA.class,
				ClassB.class, ClassC.class, ClassD.class, ClassX.class).deserializeCharSequence(output);

		System.out.println("Deserilized object serialized into XML representation");
		deserializedTest.serialize(System.out);
	}

}
