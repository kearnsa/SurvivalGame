package clients;

import game.GameManager;

public class Client {

	public Client() {
		GameManager gm = new GameManager();
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		new Client();
	}
}
