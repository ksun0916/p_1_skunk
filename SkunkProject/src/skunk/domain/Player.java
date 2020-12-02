package skunk.domain;

public class Player {

	private int point;
	private int chip;
	private String name;
	private boolean reachAHundred;
	private int mode;
	
	public Player()
	{
		this.chip = 50;
		this.point = 0;
		this.name = "Player";
		this.reachAHundred = false;
		this.mode = 0;
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
	
	public boolean getReachAHundred()
	{
		return this.reachAHundred;
	}
	
	public void checkPlayerReachAHundred()
	{
		if(this.getPoint() >= 100) this.reachAHundred = true;
	}
	
	public void setMode(int m)
	{
		this.mode = m;
	}
	
	public int getMode()
	{
		return this.mode;
	}
}
