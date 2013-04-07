package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;

import javax.swing.JPanel;

import document.Map;
import document.Team;
import document.World;
import document.building.Building;
import document.building.PowerStation;
import document.unit.Unit;

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

	    	if (ps.getOwner() == null)
	    		{g2.setColor(Color.black);}
	    	else
	    		{setTeamColor(g2, ps.getOwner());}
	    	
	    	int xCoord = (int)(ps.getArea().x * wScale);
	    	int yCoord = (int)(ps.getArea().y * hScale);
	    	int bWidth = (int)(ps.getArea().width * wScale);
	    	int bHeight = (int)(ps.getArea().height * hScale);
	    	
	    	//Draw
	    	g2.fillRect(xCoord, yCoord, bWidth, bHeight);
	    	
	    	//Make Label
    		g2.setColor(Color.black);
    		g2.setFont(new Font("Serif", Font.BOLD, 25));
    		g2.drawString(ps.getType(), xCoord, yCoord + 20);
	    }
	    
	    //For all Teams
	    for (int i = 0; i < teams.size(); i++)
	    {
	    	Team t = teams.get(i);
	    	
	    	//Display Buildings
	    	for(int j = 0; j < t.getBuildings().size(); j++)
	    	{
	    		setTeamColor(g2, t);
	    		Building b = t.getBuilding(j);
	    		
	    		
	    		int xCoord = (int)(b.getArea().x * wScale);
	    		int yCoord = (int)(b.getArea().y * hScale);
	    		int bWidth = (int)(b.getArea().width * wScale);
	    		int bHeight = (int)(b.getArea().height * hScale);
	    	
	    		//Draw
	    		g2.fillRect(xCoord, yCoord, bWidth, bHeight);
	    		
	    		//Make Label
	    		g2.setColor(Color.black);
	    		g2.setFont(new Font("Serif", Font.BOLD, 25));
	    		g2.drawString(b.getType(), xCoord, yCoord + 20);
	    	}
	    

	    
	    	
	    	//For all units
	    	for(int j = 0; j < t.getUnits().size(); j++)
	    	{
	    		setTeamColor(g2, t);
	    		Unit u = t.getUnit(j);
	    		
	    		int xCoord = (int)(u.getLocation().x * wScale);
	    		int yCoord = (int)(u.getLocation().y * hScale);
	    		
	    		//Draw
	    		g2.fillRect(xCoord, yCoord, (int)wScale, (int)hScale);
	    		
	    		//Make Label
	    		g2.setColor(Color.black);
	    		g2.setFont(new Font("Serif", Font.BOLD, 25));
	    		g2.drawString(u.getType(), xCoord, yCoord + 20);
	    	}
	    }
	}
	
	
	
	
	//     ------------------------------------ Helper Methods ----------------------------------------------
	
	/**
	 * Sets the color of the Graphics2D to be the color of the given team.
	 * @param Graphics2D drawer
	 * @param Team team
	 */
	private void setTeamColor(Graphics2D drawer, Team team)
		{drawer.setColor(team.getColor());}
}
