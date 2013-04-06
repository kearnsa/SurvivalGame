package document.building;

import java.awt.Point;
import java.awt.Rectangle;

import document.Map;
import document.Selectable;
import document.Team;
import document.unit.Civilian;
import document.unit.Soldier;

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
		
		team.addBuilding(this);
		this.map.updateMapArea(area, this);
	}


	/**
	 * Creates a Soldier
	 * 
	 * @return Soldier
	 */
	public Soldier makeSoldier()
	{
		//Spawn Location is empty and valid
		if (map.isValidAndUnoccupied(spawnLocation))
			{return new Soldier(team, spawnLocation, map);}
		
		//Spawn Location is occupied or invalid
		else
		{
			if(map.findAvailableSpawnPoint(area) != null)
				{return new Soldier(team, map.findAvailableSpawnPoint(area), map);}
			else
				{throw new RuntimeException("There is no available location to spawn a Unit.");}
		}
	}
}
