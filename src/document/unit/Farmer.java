package document.unit;

import java.awt.Point;

import document.Team;
import document.map.Map;

public class Farmer extends Unit {

	public Farmer() {
		throw new RuntimeException("The default Farmer() constructor should not be called.");
	}
	
	public Farmer(Team team, Point origin, Map map)
	{
		this.team = team;
		resourceCost = 50;
		powerCost = 0;
		foodCost = 100;
		
		hp = 30;
		strength = 3;
		speed = 2;
		
		type = "Farmer";
		
		location = origin;
		
		
		
		map.updateMapArea(location, this);
	}
}
