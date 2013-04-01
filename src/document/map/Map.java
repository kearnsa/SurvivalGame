package document.map;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

import document.Selectable;

public class Map {
	Vector<PowerStation> powerStations;
	Selectable[][] map;
	
	/**
	 * Default Constructor - for testing only
	 */
	public Map() {
		map = new Selectable[10][10];
		powerStations = new Vector<PowerStation>();
	}
	
	/**
	 * Non-Default Constructor
	 * 
	 * @param int x: x-dimension of map
	 * @param int y: y-dimension of map
	 * @param Vector<PowerStation> powerStations: A collection of the powerStations for the map
	 */
	public Map(int x, int y, Vector<PowerStation> powerStations) {
		map = new Selectable[x][y];
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
	
	public String displayTest()
	{
		StringBuilder sb = new StringBuilder();
		
		for (int j = 0; j < map.length; j++)
		{
			for (int i = 0; i < map[0].length; i++)
			{
				if (map[i][j] == null)
					{sb.append("null   ");}
				else
					{sb.append(map[i][j].getType() + " ");}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * Updates an area on the map to be inhabited by a Selectable
	 * 
	 * @param Rectangle r
	 * @param Selectable s
	 */
	public void updateMapArea(Rectangle r, Selectable s)
	{
		for (int xCoord = r.x; xCoord < r.x + r.width; xCoord++)
		{
			for (int yCoord = r.y; yCoord < r.y + r.height; yCoord++)
			{
				map[xCoord][yCoord] = s;
			}
		}
	}
	
	/**
	 * Updates a single point on the map to be inhabited by a Selectable
	 * 
	 * @param Point p
	 * @param Selectable s
	 */
	public void updateMapArea(Point p, Selectable s)
		{map[p.x][p.y] = s;}
	
	
}
