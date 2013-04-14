package clients;


import game.GameManager;

import java.net.Socket;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import server.Receiver;
import server.Transmitter;


public class ClientChris {

	public ClientChris()
	{
		GameManager gm = new GameManager();
	}
	
/*
 * Unit Production:
 * 
 * Make Map a Singleton
 * Unit Menu: on button click, execute Command 
 * 		makeUnit(String "name of unit", Selectable placeToTryCreatingUnit).
 * ----------------------------------
 * Make GameLobby a singleton.
 * Make World a singleton.
 * Make Lead Player a singleton
 * 
 */
	
	
	
    
    //           -------------------------------------- Main Method ----------------------------------------------------
	
	public static void main(String[] args)
	{		
		new ClientChris();
	}


}
