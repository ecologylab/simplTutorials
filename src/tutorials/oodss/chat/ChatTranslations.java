package tutorials.oodss.chat;

import ecologylab.oodss.messages.DefaultServicesTranslations;
import ecologylab.serialization.SimplTypesScope;

public class ChatTranslations
{
	public final static String	TRANSLATION_SPACE_NAME	= "ChatTranslations";

	public static SimplTypesScope get()
	{
		return SimplTypesScope.get(TRANSLATION_SPACE_NAME,
				DefaultServicesTranslations.get(), ChatRequest.class,
				ChatUpdate.class);
	}
}
