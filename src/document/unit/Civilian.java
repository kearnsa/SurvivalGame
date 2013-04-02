package document.unit;

import java.awt.Point;
import java.awt.Rectangle;

import document.Map;
import document.Selectable;
import document.Team;

public class Civilian extends Unit {

	public Civilian() {
		throw new RuntimeException("The default Civilian() constructor should not be called.");
	}
	
	public Civilian(Team team, Point origin, Map map)
	{
		this.team = team;
		resourceCost = 0;
		powerCost = 0;
		foodCost = 50;
		
		hp = 15;
		strength = 1;
		speed = 2;
		
		type = "Civilian";
		
		location = origin;
		
		
		
		map.updateMapArea(location, this);
	}

}
