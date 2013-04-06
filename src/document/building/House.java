package document.building;

import java.awt.Point;
import java.awt.Rectangle;

import document.Map;
import document.Selectable;
import document.Team;
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
		hp = 600;
		type = "House";
		
		
		area = new Rectangle();
		area.x = origin.x;
		area.y = origin.y;
		area.height = height;
		area.width = width;
		
		this.spawnLocation = new Point();
		this.spawnLocation.x = origin.x + width;
		this.spawnLocation.y = origin.y + height;
		
		team.addBuilding(this);
		this.map.updateMapArea(area, this);
	}
	
	/**
	 * Creates a Civilian
	 * 
	 * @return Civilian
	 */
	public Civilian makeCivilian()
	{
		//Spawn Location is empty and valid
		if (map.isValidAndUnoccupied(spawnLocation))
			{return new Civilian(team, spawnLocation, map);}
		
		//Spawn Location is occupied or invalid
		else
		{
			if(map.findAvailableSpawnPoint(area) != null)
				{return new Civilian(team, map.findAvailableSpawnPoint(area), map);}
			else
				{throw new RuntimeException("There is no available location to spawn a Unit.");}
		}
	}
	

}
