package clients;

import manager.GameManager;

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
