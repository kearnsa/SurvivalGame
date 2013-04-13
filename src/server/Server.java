package server;

import java.net.ServerSocket;
import java.util.logging.Logger;

/**
 *
 * @author Chris Maltzan
 */
public class Server 
{
    protected int serverPort = 4000;
    protected ServerSocket serverSocket;
    
    protected DoorMan doorMan;
    
    
    public Server ()
    {      
        try
        {
            serverSocket = new ServerSocket(serverPort);
        }
        
        catch (Exception e)
        {
            e.printStackTrace();
            
            System.exit(0);
        }
        
        System.out.println("Server running at: " + serverSocket.getInetAddress().getHostAddress() +
                " : " + serverPort);
        
        doorMan = new DoorMan(serverSocket, this);
    }
    
    public static void main (String[] args)
    {
        new Server();
    }
    
    public void newClient (ClientConnection clientConnection)
    {
        System.out.println("new client connection from: " + 
                clientConnection.clientSocket.getInetAddress().getHostAddress());
        
        clientConnection.getTransmitter().writeOut("Welcome to the Game Lobby.");
        clientConnection.getTransmitter().writeOut("Please create your team and initiate the game when you are ready.");
    }
}