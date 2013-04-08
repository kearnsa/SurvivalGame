package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class GameLobby {

	public GameLobby() {
		JFrame f = new JFrame("Game Lobby");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);
		f.setLocation(500, 500);
		Container content = f.getContentPane();
		content.setBackground(Color.white);
		content.setLayout(new FlowLayout());
		
		f.setVisible(true);
	}

}
