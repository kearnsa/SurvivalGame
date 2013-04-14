package document;

import java.awt.Point;
import java.util.Vector;


public class World {
	private Vector<Team> teams;
	private Map map;
	
	/**
	 * Default Constructor
	 */
	public World()
	{
		teams = new Vector<Team>();
		this.map = new Map();
	}

	public World(Map map, Vector<Team> teams)
	{
		this.teams = teams;
		this.map = map;
	}
	
	public void addTeam(Team team)
		{teams.add(team);}
	
	public void removeTeam(Team team)
		{teams.remove(team);}
	
	public Team getTeam(int index)
		{return teams.get(index);}
	
	public Vector<Team> getTeams()
		{return teams;}
	
	public void setMap(Map map)
		{this.map = map;}
	
	public Map getMap()
		{return map;}
	
	public Selectable getSelectable(Point point)
		{return map.checkLocation(point);}
}
