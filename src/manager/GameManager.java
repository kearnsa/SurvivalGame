package manager;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import view.Controls;

public class GameManager {

	public GameManager() 
	{
		createLobby();
		Controls controls = new Controls();
	}

	//     ---------------------------   Helper Methods   --------------------------------------
	
	private void createLobby()
	{
		JFrame f = new JFrame("Game Lobby");
		f.setSize(500, 500);
		f.setLocation(500, 500);
		Container content = f.getContentPane();
		content.setBackground(Color.white);
		content.setLayout(new FlowLayout());
		
		f.setVisible(true);
	}
}
