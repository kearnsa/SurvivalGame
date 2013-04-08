package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BuildingMenu {

	public BuildingMenu() {
		JFrame f = new JFrame("Building Roster");
		f.setSize(200, 150);
		f.setLocation(800, 400);
		Container content = f.getContentPane();
		content.setBackground(Color.white);
		content.setLayout(new FlowLayout()); 
		
	
		JButton baracksButton = new JButton("Baracks");
		baracksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Baracks"); //TODO: remove
				
			}
		});
		
		JButton farmButton = new JButton("Farm");
		farmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Farm"); //TODO: remove
				
			}
		});
		
		JButton houseButton = new JButton("House");
		houseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("House"); //TODO: remove
				
			}
		});
		
		JButton outpostButton = new JButton("Outpost");
		outpostButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Outpost"); //TODO: remove
				
			}
		});
		
		JButton powerStationButton = new JButton("Power Station");
		powerStationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Power Station"); //TODO: remove
				
			}
		});
					
		
		content.add(baracksButton);
		content.add(farmButton);
		content.add(houseButton);
		content.add(outpostButton);
		content.add(powerStationButton);
		
 
		f.setVisible(true);
	}	
	

}
