package document.map;

import java.awt.Point;

import document.Player;
import document.Selectable;
import document.Team;

public class PowerStation implements Selectable{
	private Team owner;
	private String ID;
	private Point location;
	private final int powerRate = 5;
	
	/**
	 * Default Constructor
	 */
	public PowerStation()
	{
		
	}
	
	/**
	 * Non-Default Constructor
	 */
	public PowerStation(Point location)
	{
		this.location = location;
		owner = null;
		//ID = 
	}
	
	/**
	 * Setter Method
	 * 
	 * @param Team owner
	 */
	public void setOwner(Team owner)
		{this.owner = owner;}
	
	/**
	 * Getter Method
	 * 
	 * @return Team
	 */
	public Team getOwner()
		{return owner;}

	/**
	 * Getter Method
	 * 
	 * @return int
	 */
	public int getRate()
		{return powerRate;}
		
	public void updateTeamPower()
		{owner.setResources(owner.getResources() + powerRate);}

	/**
	 * Checks to see if the location of this PowerStation is
	 * equal to the given Point location
	 * 
	 * @param Point point
	 */
	public boolean isLocation(Point point) {
		if(location.equals(point))
			{return true;}
		else 
			{return false;}
	}
}
