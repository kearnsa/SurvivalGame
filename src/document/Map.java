package document;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

import document.building.PowerStation;

public class Map {
	Vector<PowerStation> powerStations;
	Selectable[][] map;
	private final int printSpacing = 10; //Amount of spacing for displayText()
	
	/**
	 * Default Constructor - for testing only
	 */
	public Map() {
		throw new RuntimeException("The default Map() constructor should not be called.");
	}
	
	/**
	 * Non-Default Constructor
	 * 
	 * @param int x: x-dimension of map
	 * @param int y: y-dimension of map
	 * @param Vector<PowerStation> powerStations: A collection of the powerStations for the map
	 */
	public Map(int width, int height, Vector<PowerStation> powerStations) {
		map = new Selectable[width][height];
		this.powerStations = powerStations;
	}

	/**
	 * Getter Method
	 * 
	 * @param index
	 * @return PowerStation
	 */
	public PowerStation getPowerStation(int index)
		{return powerStations.get(index);}
	
	/**
	 * Check the given location for a Selectable Object
	 * 
	 * @param point
	 * @return Selectable or null
	 */
	public Selectable checkLocation(Point point)
		{return map[point.x][point.y];}

	
	/**
	 * Updates an area on the map to be inhabited by a Selectable
	 * 
	 * @param Rectangle r
	 * @param Selectable s
	 */
	public void updateMapArea(Rectangle r, Selectable s)
	{
		if(isValid(r) && isUnoccupied(r))
		{
			for (int xCoord = r.x; xCoord < r.x + r.width; xCoord++)
			{
				for (int yCoord = r.y; yCoord < r.y + r.height; yCoord++)
				{
					map[xCoord][yCoord] = s;
				}
			}
		}
		
		else
		{throw new RuntimeException("The area location is either occupied or not valid.");}
		
	}
	
	/**
	 * Updates a single point on the map to be inhabited by a Selectable
	 * 
	 * @param Point p
	 * @param Selectable s
	 */
	public void updateMapArea(Point p, Selectable s)
	{
		if(isValid(p) && isUnoccupied(p))
			{map[p.x][p.y] = s;}
		else
		{throw new RuntimeException("The map coordinate point: (" + p.x + "," + p.y + ") is either not valid or occupied.");}
	}
	
	/**
	 * Determines if a single Point on the map is valid and unoccupied
	 * 
	 * @param Point p
	 * @return boolean
	 */
	public boolean isValidAndUnoccupied(Point p)
	{
		return isValid(p) && isUnoccupied(p);
	}
	
	/**
	 * Converts int pair to Point
	 * 
	 * @param int x
	 * @param int y
	 * @return Point
	 */
	public Point coordsToPoint(int x, int y)
	{
		Point p = new Point();
		p.x = x;
		p.y = y;
		
		return p;
	}
	
	
	// 	    ------------------------------- Getter Methods -------------------------------------

	/**
	 * Getter Method
	 * @return int length
	 */
	public int getWidth()
		{return map.length;}
	

	/**
	 * Getter Method
	 * @return int Height
	 */
	public int getHeight()
		{return map[0].length;}
	
	/**
	 * Getter Method
	 * @return Vector<PowerStation>
	 */
	public Vector<PowerStation> getPowerStations()
		{return powerStations;}
	
	
	
	//      ------------------------------- Testing Methods -------------------------------------
	
	/**
	 * Returns a text representation of the map
	 * 
	 * @return String
	 */
	public String displayTest()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("-----------------------------------------------------------" +
				"------------------------------------");
		sb.append("\n");
		
		for (int j = 0; j < map.length; j++)
		{
			for (int i = 0; i < map[0].length; i++)
			{
				if (map[i][j] == null)
					{sb.append("empty" + addTextSpaces(printSpacing - "empty".length()));}
				else
				{String type = map[i][j].getType();
				sb.append(type + addTextSpaces(printSpacing - type.length()));
				}
			}
			sb.append("\n");
			
		}
		sb.append("----------------------------------------------------------" +
				"-------------------------------------");
		return sb.toString();
	}
	
	
	
	//      ------------------------------ Helper Methods -------------------------------------
	
	
	/**
	 * Determines if a single point on the map is unoccupied
	 * 
	 * @param Point p
	 * @return boolean
	 */
	public boolean isUnoccupied(Point p)
	{
		if(map[p.x][p.y] == null){return true;}
		else {return false;}
	}
	
	/**
	 * Determines if the given Point is a valid map coordinate
	 * 
	 * @param Point p
	 * @return boolean
	 */
	public boolean isValid(Point p)
	{
		if (p.x >= 0 && p.x < map.length && p.y >= 0 && p.y < map[0].length)
			{return true;}
		else
			{return false;}
	}
	
	/**
	 * Determines if an area on the map is unoccupied
	 * 
	 * @param Rectangle r: an area of space
	 * @return boolean
	 */
	public boolean isUnoccupied(Rectangle r)
	{
		for (int xCoord = r.x; xCoord < r.x + r.width; xCoord++)
		{
			for (int yCoord = r.y; yCoord < r.y + r.height; yCoord++)
			{
				if (map[xCoord][yCoord] != null)
					{return false;}
			}
		}
		
		return true;
	}
	
	/**
	 * Determines if the given Rectangle area consists of valid map coordinates
	 * 
	 * @param r
	 * @return
	 */
	public boolean isValid(Rectangle r)
	{
		Point bottomRight = new Point();
		bottomRight.x = r.x + r.width - 1;
		bottomRight.y = r.y + r.height - 1;
		
		Point topLeft = new Point();
		topLeft.x = r.x;
		topLeft.y = r.y;
		
		if(isValid(bottomRight) && isValid(topLeft))
			{return true;}
		else
			{return false;}
	}
	
	
	/**
	 * Formatting Helper Method - Adds the given number of spaces to a text string.
	 * @param int
	 * @return String
	 */
	private String addTextSpaces(int num)
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < num; i++)
			{sb.append(" ");}
		
		return sb.toString();
	}
	

	
		
	
	
}