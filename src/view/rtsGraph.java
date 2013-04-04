package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;

import javax.swing.JPanel;

import document.Map;
import document.Team;
import document.World;
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
	    
	    hScale = map.getHeight() / hPixWindow;
	    wScale = map.getWidth() / wPixWindow;
	    
	    
	    g2.fillRect(3,3, 7, 7);
	    
	    //For all Power Stations
	    for (int i = 0; i < map.getPowerStations().size(); i++)
	    {
	    	PowerStation ps = map.getPowerStation(i);

	    	int xCoord = ps.getArea().x;
	    	int yCoord = ps.getArea().y;
	    	
	    	g2.fillRect(xCoord,yCoord, ps.getArea().height, ps.getArea().width);
	    }
	    
	    //For all Teams
	    for (int i = 0; i < teams.size(); i++)
	    {
	    	
	    }
	}
}
