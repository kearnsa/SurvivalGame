package document.building;

import java.awt.Point;
import java.awt.Rectangle;

import document.Map;
import document.Player;
import document.Selectable;
import document.Team;

public class PowerStation extends Building{
	private final int powerRate = 5;
	private final int height = 2;
	private final int width = 2;
	
	/**
	 * Default Constructor
	 */
	public PowerStation()
	{
		throw new RuntimeException("The default PowerStation() constructor should not be called.");
	}
	
	/**
	 * Non-Default Constructor
	 */
	public PowerStation(Point origin, Map map)
	{
		this.team = null;
		type = "Pwr Stn";

		area = new Rectangle();
		area.x = origin.x;
		area.y = origin.y;
		area.height = height;
		area.width = width;
		
		map.getPowerStations().add(this);
		map.updateMapArea(area, this);
	}
	
	/**
	 * Setter Method
	 * 
	 * @param Team owner
	 */
	public void setOwner(Team owner)
		{this.team = owner;}
	
	/**
	 * Getter Method
	 * 
	 * @return Team
	 */
	public Team getOwner()
		{return this.team;}

	/**
	 * Getter Method
	 * 
	 * @return int
	 */
	public int getRate()
		{return powerRate;}
		
	/**
	 * Updates the controlling Team's power
	 */
	public void updateResource()
		{this.team.setResources(this.team.getResources() + powerRate);}


	/**
	 * Getter Method
	 * 
	 * @return String
	 */
	public String getType() 
		{return type;}
}
