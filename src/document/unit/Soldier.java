package document.unit;
import java.awt.Point;

import document.Map;
import document.Team;


public class Soldier extends Unit{

	public Soldier() {
		throw new RuntimeException("The default Soldier() constructor should not be called.");
	}

	public Soldier(Team team, Point origin, Map map)
	{
		super();
		
		this.team = team;
		resourceCost = 350;
		powerCost = 20;
		foodCost = 250;
		
		hp = 300;
		strength = 10;
		speed = 6;
		
		type = "Sol";
		
		location = origin;
		
		
		team.addUnit(this);
		map.updateMapArea(location, this);
	}

}
