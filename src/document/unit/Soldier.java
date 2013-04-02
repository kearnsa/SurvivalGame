package document.unit;
import java.awt.Point;

import document.Team;
import document.map.Map;


public class Soldier extends Unit{

	public Soldier() {
		throw new RuntimeException("The default Soldier() constructor should not be called.");
	}

	public Soldier(Team team, Point origin, Map map)
	{
		this.team = team;
		resourceCost = 20;
		powerCost = 20;
		foodCost = 200;
		
		hp = 150;
		strength = 10;
		speed = 3;
		
		type = "Soldier";
		
		location = origin;
		
		
		
		map.updateMapArea(location, this);
	}

}
