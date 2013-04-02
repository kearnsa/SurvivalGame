package document.unit;

import java.awt.Point;

import document.Map;
import document.Team;

public class Engineer extends Unit {

	public Engineer() {
		throw new RuntimeException("The default Engineer() constructor should not be called.");
	}
	
	public Engineer(Team team, Point origin, Map map)
	{
		this.team = team;
		resourceCost = 500;
		powerCost = 400;
		foodCost = 50;
		
		hp = 50;
		strength = 4;
		speed = 1;
		
		type = "Engineer";
		
		location = origin;
		
		
		
		map.updateMapArea(location, this);
	}

}
