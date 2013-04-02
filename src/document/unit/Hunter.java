package document.unit;

import java.awt.Point;

import document.Team;
import document.map.Map;

public class Hunter extends Unit {

	public Hunter() {
		throw new RuntimeException("The default Hunter() constructor should not be called.");
	}
	
	public Hunter(Team team, Point origin, Map map)
	{
		this.team = team;
		resourceCost = 5;
		powerCost = 0;
		foodCost = 5;
		
		hp = 50;
		strength = 5;
		speed = 3;
		
		type = "Hunter";
		
		location = origin;
		
		
		
		map.updateMapArea(location, this);
	}

}
