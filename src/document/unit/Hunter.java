package document.unit;

import java.awt.Point;

import document.Map;
import document.Team;

public class Hunter extends Unit {

	public Hunter() {
		throw new RuntimeException("The default Hunter() constructor should not be called.");
	}
	
	public Hunter(Team team, Point origin, Map map)
	{
		this.team = team;
		resourceCost = 100;
		powerCost = 0;
		foodCost = 200;
		
		hp = 120;
		strength = 8;
		speed = 8;
		
		type = "Hnt";
		
		location = origin;
		
		
		team.addUnit(this);
		map.updateMapArea(location, this);
	}

}
