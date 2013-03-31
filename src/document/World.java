package document;

import java.awt.Point;
import java.util.Vector;

import document.map.Map;

public class World {
	Vector<Team> teams;
	Map map;
	
	/**
	 * Default Constructor
	 */
	public World()
	{
		teams = new Vector<Team>();
	}

	public World(Map map)
	{
		teams = new Vector<Team>();
		this.map = map;
	}
	
	public void addTeam(Team team)
		{teams.add(team);}
	
	public void removeTeam(Team team)
		{teams.remove(team);}
	
	public Team getTeam(int index)
		{return teams.get(index);}
	
	public void setMap(Map map)
		{this.map = map;}
	
	public Map getMap()
		{return map;}
	
	public Selectable getSelectable(Point point)
		{return map.checkLocation(point);}
}
