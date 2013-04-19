package server;

/*
 * Valid formats for a game update:
 * 
 * Command:<Command Object Type> <ParamCategory>:<Param> ... <ParamCategory>:<Param>
 */

/**
 * Interprets messages to and from the server.
 * 
 * All messages sent to and received from the server are in a String format. All messages
 * which can be sent or received from the server are commands. Command.toString() will create 
 * the appropriate message to send. After a String is received by the server, it must be 
 * interpreted such that an identical Command may be generated.
 */
public class ServerInterpreter {

	public ServerInterpreter() {
		// TODO Auto-generated constructor stub
	}

}
