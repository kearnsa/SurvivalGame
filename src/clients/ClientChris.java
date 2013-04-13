package clients;


import java.net.Socket;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import manager.GameManager;
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
 * Unit Menu: on button click, execute Command makeUnit(String "name of unit", Selectable placeToTryCreatingUnit).
 */
	
	
	
    
    //           -------------------------------------- Main Method ----------------------------------------------------
	
	public static void main(String[] args)
	{		
		new ClientChris();
	}


}
