package document.building;

import java.awt.Point;
import java.awt.Rectangle;

import document.Selectable;
import document.Team;
import document.map.Map;

public class Farm extends Building implements Selectable {
	private final int height = 3;
	private final int width = 3;
	private final int foodRate = 5;
	
	public Farm(){
		throw new RuntimeException("The default House() constructor should not be called.");
	}
	
	public Farm(Team team, Point origin, Map map)
	{
		this.team = team;
		resourceCost = 100;
		powerCost = 5;
		hp = 200;
		type = "Farm";
		
		
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
	
}
