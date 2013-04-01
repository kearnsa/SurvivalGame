package document.building;

import java.awt.Point;
import java.awt.Rectangle;

import document.Selectable;
import document.Team;
import document.map.Map;

public class Baracks extends Building implements Selectable {
	private final int height = 3;
	private final int width = 3;
	
	public Baracks(){
		throw new RuntimeException("The default Baracks() constructor should not be called.");
	}
	
	public Baracks(Team team, Point origin, Map map)
	{
		this.team = team;
		resourceCost = 300;
		powerCost = 25;
		hp = 500;
		type = "Baracks";
		
		
		area = new Rectangle();
		area.x = origin.x;
		area.y = origin.y;
		area.height = height;
		area.width = width;
		
		this.spawnLocation = new Point();
		this.spawnLocation.x = origin.x + width;
		this.spawnLocation.y = origin.y + height;
		
		map.updateMapArea(area, this);
	}


}
