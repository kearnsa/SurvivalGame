package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import document.Map;
import document.Selectable;
import document.Team;
import document.World;
import document.building.Building;
import document.building.PowerStation;
import document.unit.Unit;

public class rtsGraph extends JPanel
						implements MouseListener{
	private World world;
	private Vector<Team> teams;
	private Map map;
	
	private double hPixWindow;
	private double wPixWindow;
	private double hScale;
	private double wScale;
	private Selectable mapSelected;
	
	
	public rtsGraph(World world){
		this.world = world;
		teams = world.getTeams();
		map = world.getMap();
		mapSelected = null;
		
		addMouseListener(this);
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

	    	if(ps.isSelected())
	    		{g2.setColor(Color.yellow);}
	    	else if (ps.getOwner() == null)
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
	    		Building b = t.getBuilding(j);
	    		
	    		if(b.isSelected())
	    			{g2.setColor(Color.yellow);}
	    		else
	    			{setTeamColor(g2, t);}
	    		
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
	    		Unit u = t.getUnit(j);
	    		
	    		if(u.isSelected())
    				{g2.setColor(Color.yellow);}
	    		else
    				{setTeamColor(g2, t);}
	    		
	    		
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
	
	/**
	 * Translates a mouse click in pixels to a map location
	 * 
	 * @param Point p: in pixels
	 * @return Point p: in map units
	 */
	private Point clickToLocation(Point p)
	{
		p.x = (int) (p.x / wScale);
		p.y = (int) (p.y / hScale);
		
		return p;
	}

	private void leftMousePressed(MouseEvent e)
	{
		Point mapLocation = clickToLocation(e.getPoint());
		Selectable locationInhabitant = map.checkLocation(mapLocation);

		if (locationInhabitant != null)
		{
			//unset previously selected Selectable
			if(mapSelected != null) {mapSelected.setSelected(false);}
			
			locationInhabitant.setSelected(true);
			mapSelected = locationInhabitant;
		}
		
		else
		{
			if (mapSelected != null)
			{
				mapSelected.setSelected(false);
				mapSelected = null;
			}
		}
		
		repaint();
	}
	
	private void rightMousePressed(MouseEvent e)
	{
		if (mapSelected == null)
		{}
		
		else if (mapSelected instanceof Unit)
		{
			System.out.println("Moving Unit to: " + clickToLocation(e.getPoint()));
		}
		
		else if (mapSelected instanceof Building)
		{
			System.out.println("Moving Building rally point to: " + clickToLocation(e.getPoint()));
		}
		

	}
	
	
	
	
	
	//     ------------------------------------ Mouse Listener ----------------------------------------------
	
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if(SwingUtilities.isLeftMouseButton(e))
			{leftMousePressed(e);}
		
		if(SwingUtilities.isRightMouseButton(e))
			{rightMousePressed(e);}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		
	}
}
