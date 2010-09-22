package tutorials.multiformat.testcases.polymorphic;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

import ecologylab.serialization.ElementState;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.ElementState.FORMAT;
import ecologylab.serialization.tlv.Utils;

public class Configuration extends ElementState
{
	@simpl_classes(
	{ Pref.class, PrefDouble.class, PrefInteger.class })
	@simpl_composite
	public Pref							pref;

	@simpl_classes(
	{ Pref.class, PrefDouble.class, PrefInteger.class })
	@simpl_collection
	public ArrayList<Pref>	prefs;

	public Configuration()
	{

	}

	public static void main(String args[]) throws SIMPLTranslationException
	{
		TranslationScope translationScope = TranslationScope.get("configuration", Configuration.class,
				PrefInteger.class, PrefDouble.class, Pref.class);

		Configuration configuration = new Configuration();

		PrefInteger prefInteger = new PrefInteger();
		prefInteger.name = "integer_pref";
		prefInteger.intValue = 2;

		PrefDouble prefDouble = new PrefDouble();
		prefDouble.name = "double_pref";
		prefDouble.doubleValue = 5;

		Pref pref = new Pref();
		pref.name = "only_pref";

		ArrayList<Pref> prefList = new ArrayList<Pref>();
		prefList.add(pref);
		prefList.add(prefInteger);
		prefList.add(prefDouble);

		configuration.pref = prefInteger;
		configuration.prefs = prefList;

		configuration.serialize(System.out, FORMAT.XML);

		System.out.println();
		System.out.println();

		configuration.serialize(System.out, FORMAT.JSON);

		System.out.println();
		System.out.println();

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

		configuration.serialize(dataOutputStream, FORMAT.TLV);

		Utils.writeHex(System.out, byteArrayOutputStream.toByteArray());

		System.out.println();
		System.out.println();

		Configuration deConfiguration = (Configuration) translationScope.deserializeByteArray(
				byteArrayOutputStream.toByteArray(), FORMAT.TLV);
		
		deConfiguration.serialize(System.out, FORMAT.XML);
		System.out.println();
		deConfiguration.serialize(System.out, FORMAT.JSON);
	}
}
