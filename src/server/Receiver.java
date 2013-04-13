package server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Receiver implements Runnable
{
    protected boolean running;
    protected InputStream inStream;
    protected BufferedReader reader;
    
    protected ArrayList<String> messageBuffer;
    protected final Object messageBufferLock = new Object();
    
    
    public Receiver (InputStream inStream)
    {
        this.inStream = inStream;
        
        reader = new BufferedReader(new InputStreamReader(inStream));
        
        messageBuffer = new ArrayList<String>();
        
        running = true;
        new Thread(this).start();
    }
    
    public String getNextMessage ()
    {
        synchronized (messageBufferLock)
        {
            if (messageBuffer.size() < 1)
                return null;
            
            return messageBuffer.remove(0);
        }
    }
    
    public boolean hasMessages ()
    {
        synchronized (messageBufferLock)
        {
            return messageBuffer.size() > 0;
        }
    }
    
    @Override
    public void run ()
    {
        while (running)
        {
            try
            {
                String message = reader.readLine();
                
                if (message == null)
                    continue;
                
                if (message.length() < 0)
                    continue;
                
                synchronized (messageBufferLock)
                {
                    messageBuffer.add(message);
                }
            }
            
            catch (Exception e)
            {
                Logger.getLogger(Receiver.class.toString(), "Error in run(): " +
                        e.getMessage());
            }
        }
    }
    
    public void shutDown ()
    {
        running = false;
        
        try
        {
            inStream.close();
        }
        
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}