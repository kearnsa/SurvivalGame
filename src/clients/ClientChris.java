package clients;

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
		
		rtsGraph graph = new rtsGraph(world);
		
        JFrame f = new JFrame("2D RTS View");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(graph);
        f.setSize(500,500);
        f.setVisible(true);
        
        Point p = new Point();
        p.x = 3;
        p.y = 3;
        
        PowerStation ps = new PowerStation(p, world.getMap());
        
        System.out.println(world.getMap().displayTest());
        
        
        
        graph.repaint();
		
		
	}
}
