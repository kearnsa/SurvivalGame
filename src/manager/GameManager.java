package manager;

import java.awt.Color;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JFrame;

import document.Map;
import document.Team;
import document.World;
import document.building.Baracks;
import document.building.Farm;
import document.building.House;
import document.building.Outpost;
import document.building.PowerStation;
import view.Controls;
import view.GameLobby;
import view.rtsGraph;

public class GameManager {

	public GameManager() 
	{
		createLobby();
		createControls();
		makeTestGame();
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
	
	public void makeTestGame()
	{
		World world = new World(new Map(20, 20, new Vector<PowerStation>()));
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
	
}
