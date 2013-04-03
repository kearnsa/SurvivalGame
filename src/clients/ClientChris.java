package clients;

import java.awt.Point;

import document.*;
import document.building.Baracks;
import document.building.Farm;
import document.building.House;
import document.building.Outpost;
import document.building.PowerStation;

public class ClientChris {

	
	
	public static void main(String[] args)
	{
		Team team = new Team("Chris's Team");
		Map map = new Map();
		Point p = new Point();
		p.x = 7;
		p.y = 0;
		House h = new House(team, p, map);
		
		p.x = 2;
		p.y = 2;
		Farm f = new Farm(team, p, map);
		
		p.x = 6;
		p.y = 4;
		Outpost op = new Outpost(team, p, map);
		
		op.makeHunter();
		op.makeHunter();
		op.makeHunter();
		op.makeHunter();
		op.makeHunter();
		op.makeHunter();
		op.makeHunter();
		op.makeHunter();
		op.makeHunter();
		op.makeHunter();
		op.makeHunter();
		op.makeHunter();
	
	

	
		
		
		
		System.out.println(map.displayTest());
		
		
	}
}
