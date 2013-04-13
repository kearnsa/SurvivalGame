package document.building;

import java.awt.Point;
import java.awt.Rectangle;

import document.Map;
import document.Selectable;
import document.Team;
import document.unit.Unit;

public class Building implements Selectable{
	protected Team team;
	protected Map map;
	protected int resourceCost;
	protected int powerCost;
	protected int hp;
	protected Point spawnLocation;
	protected Rectangle area;
	protected String type;
	protected boolean selected;
	
	public Building()
	{
		selected = false;
	}
	
	/**
	 * Places a Unit at the spawn point of this building. If the spawn point
	 * is occupied, the Unit will spawn at the nearest open location.
	 * 
	 * @param Unit unit
	 */
	public void placeUnit(Unit unit)
	{
		map.updateMapArea(spawnLocation, unit);
	}
	
	/**
	 * Finds location to spawn a Unit adjacent to given area.
	 * 
	 * @param Rectangle r
	 * @return Point
	 */
	public Point findAvailableSpawnPoint(Rectangle r)
	{
		int leftX = r.x;
		int rightX = r.x + r.width - 1;
		int topY = r.y;
		int bottomY = r.y + r.height - 1;
		
		int tempx;
		int tempy;
		
		//Checks bottom row
		for (tempx = leftX - 1; tempx < rightX + 1; tempx++)
		{
			Point p = map.coordsToPoint(tempx, bottomY + 1);
			
			if(map.isValidAndUnoccupied(p))
				{return p;}
		}
				
		//Checks top row
		for (tempx = leftX - 1; tempx < rightX + 1; tempx++)
		{
			Point p = map.coordsToPoint(tempx, topY - 1);
			
			if(map.isValidAndUnoccupied(p))
				{return p;}
		}
		
		//Checks columns
		for (tempy = topY - 1; tempy < bottomY + 1; tempy++)
		{
			Point p = map.coordsToPoint(leftX - 1, tempy);
			
			if(map.isValidAndUnoccupied(p))
				{return p;}
			
			p = map.coordsToPoint(rightX + 1, tempy);
			
			if(map.isValidAndUnoccupied(p))
				{return p;}
		}
		

		
		//There are no available spawn points.
		return null;
	}

	
	/**
	 * Determines if this Building is currently Selected
	 * 
	 * @return boolean
	 */
	public boolean isSelected()
		{return selected;}
	
	/**
	 * Setter Method
	 * 
	 * @param boolean b
	 */
	public void setSelected(boolean b)
		{selected = b;}
	
	/**
	 * Setter Method
	 * 
	 * @param int newHP
	 */
	public void setHP(int newHP)
		{hp = newHP;}
	
	/**
	 * Getter Method
	 * 
	 * @return int
	 */
	public int getHP()
		{return hp;}
	
	/**
	 * Determines if this Building contains the given Point location
	 * 
	 * @param Point point
	 * @return boolean
	 */
	public boolean isLocation(Point point) {
		return area.contains(point);
	}
	
	/**
	 * Getter Method
	 * 
	 * @return String
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Destroys this Building
	 */
	public void destroy()
		{this.team.removeBuilding(this);}
	
	public Rectangle getArea()
		{return area;}


	
	
}
