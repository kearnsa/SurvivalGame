package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GameLobby {

	private final int height = 500;
	private final int width = 1000;
	private final int PAD = 30;
	
	public GameLobby() {
		JFrame f = new JFrame("Game Lobby");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(width, height);
		f.setLocation(500, 0);

		
		Container content = f.getContentPane();
		content.setBackground(Color.white);
		content.setLayout(null);
		
		
		JButton startButton = new JButton("Start Game");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		JButton sendButton = new JButton("Send Message");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		JTextField messageField = new JTextField(20);
		JTextArea textArea = new JTextArea();
		JScrollPane scrollTextArea = new JScrollPane(textArea);
		
		content.add(startButton);
		content.add(sendButton);
		content.add(messageField);
		content.add(scrollTextArea);
		
		Dimension size = startButton.getPreferredSize();
		startButton.setBounds(PAD, PAD, size.width, size.height);
		
		size = sendButton.getPreferredSize();
		sendButton.setBounds(width - size.width - PAD, height - size.height - 20 - PAD, size.width, size.height);
		
		
		size = messageField.getPreferredSize();
		messageField.setBounds(width - sendButton.getPreferredSize().width - size.width - PAD, height - size.height - PAD - 20, size.width, size.height);
		
		size = scrollTextArea.getPreferredSize();
		scrollTextArea.setBounds(PAD, (PAD * 2) + startButton.getPreferredSize().height, 500, height - 300);
		
		f.setVisible(true);
	}

}
