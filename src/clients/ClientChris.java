package clients;

import java.awt.Point;

import document.*;
import document.building.Baracks;
import document.building.Farm;
import document.building.House;
import document.building.PowerStation;

public class ClientChris {

	//TODO: modify code so that units will automatically spawn where there is room for them.
	//TODO: Add more buildings and units.
	
	
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
		
		p.x = 5;
		p.y = 5;
		Baracks b = new Baracks(team, p, map);
		
		p.x = 0;
		p.y = 5;
		PowerStation ps = new PowerStation(p, map);
		
		p.x = 2;
		p.y = 5;
		PowerStation ps2 = new PowerStation(p, map);
		
		p.x = 0;
		p.y = 7;
		Baracks b2 = new Baracks(team, p, map);
		
		
		System.out.println(map.displayTest());
		
		h.makeCivilian();
		
		
		System.out.println(map.displayTest());
		System.out.println(map.findAvailableSpawnPoint(ps.getArea()));
		
	}
}
