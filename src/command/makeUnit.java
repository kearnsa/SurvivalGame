package command;

import java.awt.Point;

import document.unit.Unit;

public class MakeUnit implements Command{

	Unit unit;
	int unitID;
	Point goalLoc;
	
	public MakeUnit() {
		// TODO Auto-generated constructor stub
	}

	public void execute() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString()
	{
		return "Command:MakeUnit Unit:" + unit +" unitID:" + unitID + "goalLoc:" +goalLoc;
	}
	
}
