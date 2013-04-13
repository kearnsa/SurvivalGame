package server;

import java.io.OutputStream;
import java.io.PrintWriter;


public class Transmitter 
{
    protected PrintWriter writer;
    protected OutputStream outStream;
    
    public Transmitter (OutputStream outStream)
    {
        this.outStream = outStream;
        
        writer = new PrintWriter(outStream);
    }
    
    public void shutDown ()
    {
        writer.close();
    }
    
    public void writeOut (String message)
    {
        writer.println(message);
        writer.flush();
    }
}