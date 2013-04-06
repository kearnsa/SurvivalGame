package clients;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JFrame;

import view.rtsGraph;

import document.*;
import document.building.Baracks;
import document.building.Farm;
import document.building.House;
import document.building.Outpost;
import document.building.PowerStation;

public class ClientChris {

	public ClientChris(){}
	
	
	public static void main(String[] args)
	{
		World world = new World();
		Team team = new Team("Chris", Color.red);
		
		
		rtsGraph graph = new rtsGraph(world);
		
        JFrame f = new JFrame("2D RTS View");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(graph);
        f.setSize(500,500);
        f.setVisible(true);
        
        Point p = new Point();
        p.x = 0;
        p.y = 0;
        
        PowerStation ps1 = new PowerStation(p, world.getMap());
        
        p.x = 2;
        p.y = 2;
        PowerStation ps2 = new PowerStation(p, world.getMap());
        
        p.x = 0;
        p.y = 4;
        Baracks baracks = new Baracks(team, p, world.getMap());
        
        
        
        
        System.out.println(world.getMap().displayTest());
        
        
        
        graph.repaint();
		
	}
}
