package document.unit;

import java.awt.Point;

import document.Map;
import document.Team;

public class Farmer extends Unit {

	public Farmer() {
		throw new RuntimeException("The default Farmer() constructor should not be called.");
	}
	
	public Farmer(Team team, Point origin, Map map)
	{
		this.team = team;
		resourceCost = 200;
		powerCost = 0;
		foodCost = 100;
		
		hp = 50;
		strength = 4;
		speed = 4;
		
		type = "Fa";
		
		location = origin;
		
		
		team.addUnit(this);
		map.updateMapArea(location, this);
	}
}
