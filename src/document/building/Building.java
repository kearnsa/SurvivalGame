package document.building;

import java.awt.Point;
import java.awt.Rectangle;

import document.Selectable;
import document.Team;
import document.map.Map;
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
	
	
}
