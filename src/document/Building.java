package document;

import java.awt.Point;
import java.awt.Rectangle;

public class Building {
	Team team;
	int cost;
	int hp;
	Point location;
	Rectangle dimensions;
	
	public void createUnit(Unit unit)
	{
		
	}
	
	public void setHP(int newHP)
		{hp = newHP;}
	
	public int getHP()
		{return hp;}
	
	public void destroy()
		{this.team.removeBuilding(this);}
	
	
}
