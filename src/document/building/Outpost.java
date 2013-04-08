package document.building;

import java.awt.Point;
import java.awt.Rectangle;

import document.Map;
import document.Selectable;
import document.Team;
import document.unit.Civilian;
import document.unit.Hunter;
import document.unit.Soldier;
import document.unit.Survivalist;

public class Outpost extends Building {
	private final int height = 2;
	private final int width = 2;
	
	public Outpost(){
		throw new RuntimeException("The default Baracks() constructor should not be called.");
	}
	
	public Outpost(Team team, Point origin, Map map)
	{
		super();
		
		this.team = team;
		this.map = map;
		resourceCost = 300;
		powerCost = 25;
		hp = 750;
		type = "Outpost";
		
		
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
	 * Creates a Survivalist
	 * 
	 * @return Survivalist
	 */
	public Survivalist makeSurvivalist()
	{
		//Spawn Location is empty and valid
		if (map.isValidAndUnoccupied(spawnLocation))
			{return new Survivalist(team, spawnLocation, map);}
		
		//Spawn Location is occupied or invalid
		else
		{
			if(map.findAvailableSpawnPoint(area) != null)
				{return new Survivalist(team, map.findAvailableSpawnPoint(area), map);}
			else
				{throw new RuntimeException("There is no available location to spawn a Unit.");}
		}
	}
	
	/**
	 * Creates a Hunter
	 * 
	 * @return Hunter
	 */
	public Hunter makeHunter()
	{
		//Spawn Location is empty and valid
		if (map.isValidAndUnoccupied(spawnLocation))
			{return new Hunter(team, spawnLocation, map);}
		
		//Spawn Location is occupied or invalid
		else
		{
			if(map.findAvailableSpawnPoint(area) != null)
				{return new Hunter(team, map.findAvailableSpawnPoint(area), map);}
			else
				{throw new RuntimeException("There is no available location to spawn a Unit.");}
			
			//TODO: Unit production should be made to hang until an available space opens up.
		}
	}
}