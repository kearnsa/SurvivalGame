package document.building;

import java.awt.Point;
import java.awt.Rectangle;

import document.Map;
import document.Selectable;
import document.Team;
import document.unit.Civilian;
import document.unit.Farmer;

public class Farm extends Building{
	private final int height = 3;
	private final int width = 3;
	private final int foodRate = 5;
	
	public Farm(){
		throw new RuntimeException("The default House() constructor should not be called.");
	}
	
	public Farm(Team team, Point origin, Map map)
	{
		super();
		
		this.team = team;
		this.map = map;
		resourceCost = 100;
		powerCost = 5;
		hp = 600;
		type = "Farm";
		
		
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
	 * Getter Method
	 * 
	 * @return int
	 */
	public int getRate()
		{return foodRate;}
		
	/**
	 * Updates the controling Team's power
	 */
	public void updateResource()
		{this.team.setResources(this.team.getResources() + foodRate);}
	
	/**
	 * Creates a Farmer
	 * 
	 * @return Civilian
	 */
	public Farmer makeFarmer()
	{
		//Spawn Location is empty and valid
		if (map.isValidAndUnoccupied(spawnLocation))
			{return new Farmer(team, spawnLocation, map);}
		
		//Spawn Location is occupied or invalid
		else
		{
			if(map.findAvailableSpawnPoint(area) != null)
				{return new Farmer(team, map.findAvailableSpawnPoint(area), map);}
			else
				{throw new RuntimeException("There is no available location to spawn a Unit.");}
		}
	}
	
}
