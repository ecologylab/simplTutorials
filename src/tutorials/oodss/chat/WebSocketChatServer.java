package tutorials.oodss.chat;

import java.net.UnknownHostException;

import ecologylab.collections.Scope;
import ecologylab.oodss.distributed.server.WebSocketOodssServer;
import ecologylab.serialization.SimplTypesScope;

public class WebSocketChatServer {
	public static void main(String[] args) throws UnknownHostException
	{
		/*
		 * get base translations with static accessor
		 */
		SimplTypesScope webSocketChatTranslations = ChatTranslations.get();
		
		/*
		 * Creates a scope for the server to use as an application scope as well
		 * as individual client session scopes.
		 */
		Scope applicationScope = new Scope();
		
		int serverPort = 2018;
		
		/*
		 * Create the server and start the server so that it can accept incoming
		 * connections.
		 */
		WebSocketOodssServer chatServer = new WebSocketOodssServer(serverPort, webSocketChatTranslations, applicationScope);

		chatServer.start();
	}
}
