package document;

import java.awt.Point;
import java.util.Hashtable;
import java.util.Vector;

import document.building.Building;
import document.map.PowerStation;

public class Team {
	private Vector<Player> players;
	private String teamName;
	private int teamResources;
	private int teamFood;
	private int teamPower;
	private Hashtable<String, Unit> units;
	private Hashtable<String, Building> buildings;
	
	/**
	 * Default Constructor
	 */
	public Team() 
	{
		players = new Vector<Player>();
		teamName = "Team Name";
		teamResources = 200;
		teamFood = 200;
		teamPower = 200;
		units = new Hashtable<String, Unit>();
		buildings = new Hashtable<String, Building>();
	}
	
	/**
	 * Non-default Constructor
	 * 
	 * @param String teamName
	 */
	public Team(String teamName)
	{
		this.teamName = teamName;
		players = new Vector<Player>();
		teamResources = 200;
		teamFood = 200;
		teamPower = 200;
		units = new Hashtable<String, Unit>();
		buildings = new Hashtable<String, Building>();
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
	 * Adds a new Building to this Team at the given Point location
	 * 
	 * @param Building building
	 * @param Point origin: location of the Building
	 */
	public void addBuilding(Building building, Point origin)
	{
		
	}
	
	/**
	 * Removes a Building from this Team
	 * 
	 * @param Building building
	 */
	public void removeBuilding(Building building)
	{
		
	}
	
	/**
	 * Adds a new Unit to this Team at a given Point location
	 * 
	 * @param Unit unit
	 * @param Point origin: location of the new Unit
	 */
	public void addUnit(Unit unit, Point origin)
	{
		
	}
	
	/**
	 * Remove a Unit from this Team
	 * 
	 * @param Unit unit
	 */
	public void removeUnit(Unit unit)
	{
		
	}
	
	/**
	 * Gives control of a PowerStation to this Team
	 * 
	 * @param PowerStation station
	 */
	public void takePowerStation(PowerStation station)
	{
		
	}
	
	/**
	 * Removes control of a PowerStation from this Team
	 * @param PowerStation station
	 */
	public void losePowerStation(PowerStation station)
	{
		
	}
	
	/**
	 * Getter Method
	 * 
	 * @return int
	 */
	public int getResources()
		{return teamResources;}
	
	/**
	 * Setter Method
	 * 
	 * @param int amount
	 */
	public void setResources(int amount)
		{this.teamResources = amount;}
	
	/**
	 * Getter Method
	 * 
	 * @return int
	 */
	public int getFood()
		{return teamFood;}
	
	/**
	 * Setter Method
	 * 
	 * @param int amount
	 */
	public void setFood(int amount)
		{this.teamFood = amount;}
	
	/**
	 * Getter Method
	 * 
	 * @return int
	 */
	public int getPower()
		{return teamPower;}
	
	/**
	 * Setter Method
	 * 
	 * @param int amount
	 */
	public void setPower(int amount)
		{this.teamPower = amount;}
	
	
}
