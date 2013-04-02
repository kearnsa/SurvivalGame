package document.building;

import java.awt.Point;
import java.awt.Rectangle;

import document.Map;
import document.Selectable;
import document.Team;

public class Baracks extends Building {
	private final int height = 3;
	private final int width = 3;
	
	public Baracks(){
		throw new RuntimeException("The default Baracks() constructor should not be called.");
	}
	
	public Baracks(Team team, Point origin, Map map)
	{
		this.team = team;
		this.map = map;
		resourceCost = 300;
		powerCost = 25;
		hp = 1000;
		type = "Baracks";
		
		
		area = new Rectangle();
		area.x = origin.x;
		area.y = origin.y;
		area.height = height;
		area.width = width;
		
		this.spawnLocation = new Point();
		this.spawnLocation.x = origin.x + width;
		this.spawnLocation.y = origin.y + height;
		
		this.map.updateMapArea(area, this);
	}


}
