package skunk.domain;

public class Player {

	private int point;
	private int chip;
	private String name;
	
	public Player()
	{
		this.chip = 50;
		this.point = 0;
		this.name = "Player";
	}
	
	public void setChip(int chip)
	{
		this.chip = chip;
	}
	
	public void adjustChip(int chip)
	{
		this.chip = this.chip + chip;
	}
	
	public int getChip()
	{
		return this.chip;
	}
	
	public void resetPoint()
	{
		this.point = 0;
	}
	
	public void addPoint(int point)
	{
		this.point = this.point + point;
	}
	
	public int getPoint()
	{
		return this.point;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String toString() 
	{
		return "Player: " + getName() + "\nCurrent Points: " + getPoint() + "\nTotal Chips: "  + getChip();
	}
}
