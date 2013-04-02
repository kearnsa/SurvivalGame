package document.building;

import java.awt.Point;
import java.awt.Rectangle;

import document.Selectable;
import document.Team;
import document.map.Map;
import document.unit.Civilian;

public class House extends Building{
	private final int height = 2;
	private final int width = 2;
	
	public House(){
		throw new RuntimeException("The default House() constructor should not be called.");
	}
	
	public House(Team team, Point origin, Map map)
	{
		this.team = team;
		this.map = map;
		resourceCost = 100;
		powerCost = 5;
		hp = 200;
		type = "House";
		
		
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
	
	/**
	 * Creates a Civilian
	 * 
	 * @return Civilian
	 */
	public Civilian makeCivilian()
		{return new Civilian(team, spawnLocation, map);}
	

}
