package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;

import javax.swing.JPanel;

import document.Map;
import document.Team;
import document.World;
import document.building.Building;
import document.building.PowerStation;

public class rtsGraph extends JPanel{
	private World world;
	private Vector<Team> teams;
	private Map map;
	
	private double hPixWindow;
	private double wPixWindow;
	private double hScale;
	private double wScale;
	
	
	public rtsGraph(World world){
		this.world = world;
		teams = world.getTeams();
		map = world.getMap();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
	    hPixWindow = getHeight();
	    wPixWindow = getWidth();
	    
	    hScale = hPixWindow / map.getHeight();
	    wScale = wPixWindow / map.getWidth();
	    
	    
	    //For all Power Stations
	    for (int i = 0; i < map.getPowerStations().size(); i++)
	    {
	    	PowerStation ps = map.getPowerStation(i);

	    	int xCoord = (int)(ps.getArea().x * wScale);
	    	int yCoord = (int)(ps.getArea().y * hScale);
	    	int bWidth = (int)(ps.getArea().width * wScale);
	    	int bHeight = (int)(ps.getArea().height * hScale);
	    	
	    	
	    	g2.fillRect(xCoord, yCoord, bWidth, bHeight);
	    }
	    
	    //For all Teams
	    for (int i = 0; i < teams.size(); i++)
	    {
	    	Team t = teams.get(i);
	    	for(int j = 0; j < t.getBuildings().size(); j++)
	    	{
	    		Building b = t.getBuilding(j);
	    		
	    		
	    		int xCoord = (int)(b.getArea().x * wScale);
	    		int yCoord = (int)(b.getArea().y * hScale);
	    		int bWidth = (int)(b.getArea().width * wScale);
	    		int bHeight = (int)(b.getArea().height * hScale);
	    	
	    	
	    		g2.fillRect(xCoord, yCoord, bWidth, bHeight);
	    	}
	    

	    
	    	
	    	//For all units
	    }
	}
}
