package document.unit;

import java.awt.Point;

import document.Map;
import document.Team;

public class Survivalist extends Unit {

	public Survivalist() {
		throw new RuntimeException("The default Survivalist() constructor should not be called.");
	}
	
	public Survivalist(Team team, Point origin, Map map)
	{
		super();
		
		this.team = team;
		resourceCost = 20;
		powerCost = 0;
		foodCost = 150;
		
		hp = 100;
		strength = 8;
		speed = 7;
		
		type = "Srv";
		
		location = origin;
		
		
		team.addUnit(this);
		map.updateMapArea(location, this);
	}

}
