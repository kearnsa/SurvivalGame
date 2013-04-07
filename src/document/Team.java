package document;

import java.awt.Color;
import java.awt.Point;
import java.util.Hashtable;
import java.util.Vector;

import document.building.Building;
import document.building.PowerStation;
import document.unit.Unit;

public class Team {
	private Vector<Player> players;
	private String teamName;
	private Color color;
	private int teamResources;
	private int teamFood;
	private int teamPower;
	private Vector<Unit> units;
	private Vector<Building> buildings;
	
	/**
	 * Default Constructor
	 */
	public Team() 
	{
		players = new Vector<Player>();
		color = Color.red;
		teamName = "Team Name";
		teamResources = 200;
		teamFood = 200;
		teamPower = 200;
		units = new Vector<Unit>();
		buildings = new Vector<Building>();
	}
	
	/**
	 * Non-default Constructor
	 * 
	 * @param String teamName
	 */
	public Team(String teamName, Color color)
	{
		this.teamName = teamName;
		this.color = color;
		players = new Vector<Player>();
		teamResources = 200;
		teamFood = 200;
		teamPower = 200;
		units = new Vector<Unit>();
		buildings = new Vector<Building>();
	}
	
	/**
	 * Adds a new Player to this Team
	 * 
	 * @param Player player
	 */
	public void addPlayer(Player player)
		{players.add(player);}
	
	/**
	 * Removes a player from this Team
	 * 
	 * @param Player player
	 */
	public void removePlayer(Player player)
		{players.remove(player);}
	
	/**
	 * Adds a new Building to this Team at the given Point location
	 * 
	 * @param Building building
	 */
	public void addBuilding(Building building)
	{
		buildings.add(building);
	}
	
	/**
	 * Removes a Building from this Team
	 * 
	 * @param Building building
	 */
	public void removeBuilding(Building building)
	{
		buildings.remove(building);
	}
	
	/**
	 * Adds a new Unit to this Team's roster
	 * 
	 * @param Unit unit
	 */
	public void addUnit(Unit unit)
	{
		units.add(unit);
	}
	
	/**
	 * Remove a Unit from this Team's roster
	 * 
	 * @param Unit unit
	 */
	public void removeUnit(Unit unit)
	{
		units.remove(unit);
	}
	
	/**
	 * Gives control of a PowerStation to this Team
	 * 
	 * @param PowerStation station
	 */
	public void takePowerStation(PowerStation station)
		{station.setOwner(this);}
	
	/**
	 * Removes control of a PowerStation from this Team
	 * @param PowerStation station
	 */
	public void losePowerStation(PowerStation station)
		{station.setOwner(null);}
	
	//		--------------------------Getter Methods----------------------------------
	
	/**
	 * Getter Method
	 * 
	 * @param String playerName
	 * @return Player: The player with the given input name
	 */
	public Player getPlayer(String playerName)
	{
		for (int i = 0; i < players.size(); i++)
		{
			if (players.get(i).getName().equals(playerName))
				{return players.get(i);}
		}
		return null;
	}
	
	/**
	 * Getter Method
	 * 
	 * @param int index
	 * @return Player: The player at the given index
	 */
	public Player getPlayer(int index)
		{return players.get(index);}
	
	/**
	 * Getter Method
	 * 
	 * @return int
	 */
	public int getResources()
		{return teamResources;}
	
	/**
	 * Getter Method
	 * 
	 * @return int
	 */
	public int getFood()
		{return teamFood;}
	
	/**
	 * Getter Method
	 * 
	 * @return int
	 */
	public int getPower()
		{return teamPower;}
	
	/**
	 * Getter Method
	 * 
	 * @return Color
	 */
	public Color getColor()
		{return color;}
	
	/**
	 * Getter Method
	 * 
	 * @return Vector<Building>
	 */
	public Vector<Building> getBuildings()
		{return buildings;}
	
	/**
	 * Getter Method
	 * 
	 * @return Vector<Building>
	 */
	public Building getBuilding(int i)
		{return buildings.get(i);}
	
	/**
	 * Getter Method
	 * 
	 * @return Vector<Building>
	 */
	public Vector<Unit> getUnits()
		{return units;}
	
	/**
	 * Getter Method
	 * 
	 * @return Vector<Building>
	 */
	public Unit getUnit(int i)
		{return units.get(i);}

	//		--------------------------Setter Methods----------------------------------

	/**
	 * Setter Method
	 * 
	 * @param Color color
	 */
	public void setColor(Color color)
		{this.color = color;}
	
	/**
	 * Setter Method
	 * 
	 * @param int amount
	 */
	public void setResources(int amount)
		{this.teamResources = amount;}
	

	
	/**
	 * Setter Method
	 * 
	 * @param int amount
	 */
	public void setFood(int amount)
		{this.teamFood = amount;}
	

	
	/**
	 * Setter Method
	 * 
	 * @param int amount
	 */
	public void setPower(int amount)
		{this.teamPower = amount;}
	
	
}
