package document.unit;

import java.awt.Point;
import java.awt.Rectangle;

import document.Selectable;
import document.Team;

public class Unit implements Selectable{
	protected Team team;
	protected int resourceCost;
	protected int powerCost;
	protected int foodCost;
	protected int hp;
	protected int strength;
	protected int speed;
	protected Point location;
	protected String type;
	
	
	/**
	 * Setter Method
	 * 
	 * @param int newHP
	 */
	public void setHP(int hp)
		{this.hp = hp;}
	

	
	/**
	 * Removes the Unit from the game
	 */
	public void die()
	{
		
	}
	
	/**
	 * Determines if this Building contains the given Point location
	 * 
	 * @param Point point
	 * @return boolean
	 */
	public boolean isLocation(Point p)
		{return location.equals(p);}
	
	
	// -------------------------------- Getter Methods -------------------------------------------
	
	/**
	 * Getter Method
	 * 
	 * @return Point
	 */
	public Point getLocation()
		{return location;}
	
	/**
	 * Getter Method
	 * 
	 * @return int
	 */
	public int getHP()
		{return hp;}
	
	/**
	 * Getter Method
	 * 
	 * @return String
	 */
	public String getType()
		{return type;}
	
	

}
