package tutorials.multiformat.testcases.diamond;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.ElementState.FORMAT;
import ecologylab.serialization.TranslationScope.GRAPH_SWITCH;
import ecologylab.serialization.tlv.Utils;

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

		TranslationScope translationScope = TranslationScope.get("container", ClassD.class,
				ClassX.class, ClassC.class, ClassA.class, ClassB.class);

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
		ClassD data = (ClassD) translationScope.deserializeCharSequence(sb, FORMAT.JSON);
		data.serialize(System.out, FORMAT.XML);
		System.out.println();
		System.out.println();
		data.serialize(System.out, FORMAT.JSON);
		
		System.out.println();
		System.out.println();
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
		
		test.serialize(dataOutputStream, FORMAT.TLV);
		
		Utils.writeHex(System.out, byteArrayOutputStream.toByteArray());		

		System.out.println();
		System.out.println();
		
		ClassD deDiamond = (ClassD)translationScope.deserializeByteArray(byteArrayOutputStream.toByteArray(), FORMAT.TLV);
		deDiamond.serialize(System.out, FORMAT.XML);

	}
}
