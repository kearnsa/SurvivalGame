package server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Warren Geiler
 */
public class DoorMan implements Runnable
{
    protected Server server;
    protected ServerSocket socket;
    protected boolean running;
    
    
    public DoorMan (ServerSocket socket, Server server)
    {
        this.socket = socket;
        this.server = server;
        
        running = true;
        
        new Thread(this).start();
    }
    
    @Override
    public void run ()
    {
        while (running)
        {
            if (socket.isClosed())
            {
                break;
            }
            
            try
            {
                Socket clientSocket = socket.accept();
                
                ClientConnection clientConnection = new ClientConnection(clientSocket);
                
                server.newClient(clientConnection);
            }
            
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
