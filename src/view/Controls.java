package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Controls {

	
	public Controls()
	{		
		
	
		JFrame f = new JFrame("Controls");
		f.setSize(400, 150);
		f.setLocation(600, 0);
		Container content = f.getContentPane();
		content.setBackground(Color.white);
		content.setLayout(new FlowLayout()); 
		
	
		JButton unitMenuButton = new JButton("Unit Production");
		unitMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnitMenu unitMenu = new UnitMenu();
				
			}
		});
		
		JButton buildingMenuButton = new JButton("Building Production");
		buildingMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Building Production"); //TODO: remove
				
			}
		});
		
	
		
		content.add(unitMenuButton);
		content.add(buildingMenuButton);
		
 
		f.setVisible(true);
	}
}
