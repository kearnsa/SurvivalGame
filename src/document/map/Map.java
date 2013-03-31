package document.map;

import java.awt.Point;
import java.util.Vector;

import document.Selectable;

public class Map {
	Vector<PowerStation> powerStations;
	Selectable[][] map;
	
	/**
	 * Default Constructor
	 */
	public Map() {
		map = new Selectable[50][50];
		powerStations = new Vector<PowerStation>();
	}
	
	/**
	 * Default Constructor
	 * 
	 * @param int x: x-dimension of map
	 * @param int y: y-dimension of map
	 */
	public Map(int x, int y) {
		map = new Selectable[x][y];
		powerStations = new Vector<PowerStation>();
	}

	public PowerStation getPowerStation(int index)
		{return powerStations.get(index);}
	
	public Selectable checkLocation(Point point)
		{return map[point.x][point.y];}
}
