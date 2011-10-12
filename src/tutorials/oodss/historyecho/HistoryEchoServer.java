package tutorials.oodss.historyecho;
import java.io.IOException;
import java.net.InetAddress;

import ecologylab.collections.Scope;
import ecologylab.net.NetTools;
import ecologylab.oodss.distributed.server.DoubleThreadedNIOServer;
import ecologylab.oodss.messages.DefaultServicesTranslations;
import ecologylab.serialization.SimplTypesScope;

/** 
 * HistoryEchoServer: A sample server implemented via OODSS.
 * Intended to be used as a tutorial application.
 */
public class HistoryEchoServer
{
	private static final int idleTimeout = -1;
	private static final int MTU = 40000;
	
	public static void main(String[] args) throws IOException
	{
		/*
		 *  get base translations with static accessor
		 */
		SimplTypesScope baseServices = DefaultServicesTranslations.get();
		
		/* 
		 * Classes that must be translated by the translation scope
		 * in order for the server to communicate w/ the client
		 */
		Class[] historyEchoClasses = { HistoryEchoRequest.class,
				 HistoryEchoResponse.class };
		
		/*
		 * compose translations, to create the �histEchoTrans�
		 * space inheriting the base translations
		 */
		SimplTypesScope histEchoTranslations = SimplTypesScope.get("histEchoTrans",
				baseServices, historyEchoClasses);	
		
		/* 
		 * Creates a scope for the server to use as an application scope
		 * as well as individual client session scopes.
		 */
		Scope applicationScope = new Scope();
		
		/* Acquire an array of all local ip-addresses */
		InetAddress[] locals = NetTools.getAllInetAddressesForLocalhost();
		
		/* 
		 * Create the server and start the server so that it can
		 * accept incoming connections.
		 */
		DoubleThreadedNIOServer historyServer =
			DoubleThreadedNIOServer.getInstance(2108,
															locals,
															histEchoTranslations,
															applicationScope,
															idleTimeout,
															MTU);
		historyServer.start();
	}
	
}
