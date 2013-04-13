package server;

import java.net.Socket;
import java.util.logging.Logger;

import clients.Client;

/**
 *
 * @author Warren
 */
public class ClientConnection 
{
    protected Socket clientSocket;
    
    protected Transmitter transmitter;
    protected Receiver receiver;
    
    
    public ClientConnection (Socket clientSocket)
    {
        this.clientSocket = clientSocket;
        
        try
        {
            receiver = new Receiver(clientSocket.getInputStream());
            transmitter = new Transmitter(clientSocket.getOutputStream());
        }
        
        catch (Exception e)
        {
            Logger.getLogger(Client.class.toString() + " Couldn't establish Transmitter" +
                    "or Receiver in ClientConnection constructor: " + e.getMessage());
        }   
    }
    
    public Receiver getReceiver ()
    {
        return this.receiver;
    }
    
    public Transmitter getTransmitter ()
    {
        return this.transmitter;
    }
}