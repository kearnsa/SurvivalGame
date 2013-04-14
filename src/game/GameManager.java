package game;

import java.awt.Color;
import java.awt.Point;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import clients.Client;

import document.Map;
import document.Team;
import document.World;
import document.building.Baracks;
import document.building.Farm;
import document.building.House;
import document.building.Outpost;
import document.building.PowerStation;
import server.Receiver;
import server.Transmitter;
import view.Controls;
import view.GameLobby;
import view.rtsGraph;

public class GameManager implements Runnable {
    
	public static String serverIP = "127.0.0.1";
    public static String serverPort = "4000";
    
    protected Socket serverSocket;
    
    protected Transmitter transmitter;
    protected Receiver receiver;
    
    boolean running;
	
    
    
	public GameManager() 
	{
		setUpGameConnection();
		createLobby();
		createControls();
		makeTestGame();
	}

	public void startGame(Map map, Vector<Team> teams)
	{
		World world = new World(map, teams);
		
		rtsGraph graph = new rtsGraph(world);
		
        JFrame f = new JFrame("2D RTS View");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(graph);
        f.setSize(1000,1000);
        f.setLocation(500, 0);
        f.setVisible(true);
        
        
	}
	
	
	//     ---------------------------   Helper Methods   --------------------------------------
	
	private void createLobby()
	{
		GameLobby lobby = new GameLobby();
	}
	
	private void createControls()
	{
		Controls controls = new Controls();
	}
	
	private void makeTestGame()
	{
		World world = new World(new Map(20, 20, new Vector<PowerStation>()), new Vector<Team>());
		Team team = new Team("Chris", Color.red);
		Team team2 = new Team("Aisling", Color.blue);
		world.addTeam(team);
		world.addTeam(team2);
		
		rtsGraph graph = new rtsGraph(world);
		
        JFrame f = new JFrame("2D RTS View");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(graph);
        f.setSize(1000,1000);
        f.setLocation(500, 0);
        f.setVisible(true);
        
        Point p = new Point();
        p.x = 0;
        p.y = 0;
        
        PowerStation ps1 = new PowerStation(p, world.getMap());
        ps1.setOwner(team);
        
        p.x = 2;
        p.y = 2;
        PowerStation ps2 = new PowerStation(p, world.getMap());
        ps2.setOwner(team2);
        
        p.x = 0;
        p.y = 4;
        Baracks baracks = new Baracks(team, p, world.getMap());
        baracks.makeSoldier();
        baracks.makeSoldier();
        baracks.makeSoldier();
        baracks.makeSoldier();
        baracks.makeSoldier();
        baracks.makeSoldier();
        
        p.x = 7;
        p.y = 7;
        Farm farm = new Farm(team2, p, world.getMap());
        
        farm.makeFarmer();
        farm.makeFarmer();
        farm.makeFarmer();
        farm.makeFarmer();
        farm.makeFarmer();
        
        p.x = 8;
        p.y = 0;
        House house = new House(team, p, world.getMap());
        house.makeCivilian();
        house.makeCivilian();
        house.makeCivilian();
        
        p.x = 6;
        p.y = 0;
        Outpost op = new Outpost(team2, p, world.getMap());
        op.makeHunter();
        op.makeSurvivalist();
        
        System.out.println(world.getMap().displayTest());
        
	}

	private void setUpGameConnection()
	{
		Integer serverPortInt = Integer.parseInt(serverPort);
	       
        try
        {
            serverSocket = new Socket(serverIP, serverPortInt);
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to connect to server at "
                    + serverIP + " : " + serverPort);
            
            System.exit(0);
        }
        
        try
        {
            transmitter = new Transmitter(serverSocket.getOutputStream());
            receiver = new Receiver(serverSocket.getInputStream());
        }
        
        catch (Exception e)
        {
            Logger.getLogger(Client.class.toString() + " Couldn't establish Transmitter" +
                    "or Receiver in Client constructor: " + e.getMessage());
            
            System.exit(0);
        }
        
        running = true;
        
        new Thread(this).start();
	}
	
    @Override
    public void run ()
    {
        while (running)
        {
            if (receiver.hasMessages())
            {
                String message = receiver.getNextMessage();
                
                System.out.println("From server: " + message);
            }
        }
    }
	
}
