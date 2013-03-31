package document;

public class Player {
	private String name;
	private Team team;
	private int resources;
	private int food;
	private int power;
	private Selectable currentSelected;
	
	/**
	 * Default Constructor
	 */
	public Player()
	{
		
	}
	
	/**
	 * Non-Default Constructor
	 * 
	 * @param String playerName
	 */
	public Player(String playerName, Team team) {
		name = playerName;
		this.team = team;
		resources = 0;
		food = 0;
		power = 0;
		currentSelected = null;
	}
	
	/**
	 * Getter Method
	 * 
	 * @return String name
	 */
	public String getName()
		{return name;}
	
	/**
	 * Getter Method
	 * 
	 * @return int resources
	 */
	public int getResources()
		{return resources;}
	
	/**
	 * Getter Method
	 * 
	 * @return int power
	 */
	public int getPower()
		{return power;}
	
	/**
	 * Setter Method
	 * 
	 * @param Selectable s: An object which implements Selectable.
	 */
	public void setSelected(Selectable s)
		{currentSelected = s;}
}
