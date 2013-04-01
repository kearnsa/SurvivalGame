package clients;

import java.awt.Point;

import document.*;
import document.building.Baracks;
import document.building.Farm;
import document.building.House;
import document.map.Map;
import document.map.PowerStation;

public class ClientChris {

	public static void main(String[] args)
	{
		Team team = new Team("Chris's Team");
		Map map = new Map();
		Point p = new Point();
		p.x = 8;
		p.y = 8;
		House h = new House(team, p, map);
		
		p.x = 2;
		p.y = 2;
		Farm h2 = new Farm(team, p, map);
		
		p.x = 5;
		p.y = 5;
		Baracks h3 = new Baracks(team, p, map);
		
		p.x = 0;
		p.y = 5;
		PowerStation h4 = new PowerStation(p, map);
		
		
		System.out.println(map.displayTest());
	}
}
