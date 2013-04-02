package document.unit;

import java.awt.Point;
import java.awt.Rectangle;

import document.Selectable;
import document.Team;
import document.map.Map;

public class Civilian extends Unit {

	public Civilian() {
		throw new RuntimeException("The default Civilian() constructor should not be called.");
	}
	
	public Civilian(Team team, Point origin, Map map)
	{
		this.team = team;
		resourceCost = 0;
		powerCost = 0;
		foodCost = 25;
		
		hp = 15;
		strength = 0;
		speed = 1;
		
		type = "Civilian";
		
		location = origin;
		
		
		
		map.updateMapArea(location, this);
	}

}
