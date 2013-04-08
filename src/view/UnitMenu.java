package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UnitMenu {

	public UnitMenu() {
		JFrame f = new JFrame("Controls");
		f.setSize(200, 150);
		f.setLocation(800, 400);
		Container content = f.getContentPane();
		content.setBackground(Color.white);
		content.setLayout(new FlowLayout()); 
		
	
		JButton civilianButton = new JButton("Civilian");
		civilianButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("civilian"); //TODO: remove
				
			}
		});
		
		JButton engineerButton = new JButton("Engineer");
		engineerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("engineer"); //TODO: remove
				
			}
		});
		
		JButton farmerButton = new JButton("Farmer");
		farmerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("farmer"); //TODO: remove
				
			}
		});
		
		JButton hunterButton = new JButton("Hunter");
		hunterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("hunter"); //TODO: remove
				
			}
		});
		
		JButton soldierButton = new JButton("Soldier");
		soldierButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("soldier"); //TODO: remove
				
			}
		});
		
		JButton survivalistButton = new JButton("Survivalist");
		survivalistButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("survivalist"); //TODO: remove
				
			}
		});		

		
		
		content.add(civilianButton);
		content.add(engineerButton);
		content.add(farmerButton);
		content.add(hunterButton);
		content.add(soldierButton);
		content.add(survivalistButton);
		
 
		f.setVisible(true);
	}

}
