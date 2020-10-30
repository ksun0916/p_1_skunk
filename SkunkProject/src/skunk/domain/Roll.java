package skunk.domain;

public class Roll {
	
	private Dice dice;
	int skunk;
	
	public Roll() {
		dice = new Dice();
		skunk = 0;
	}
	
	public void roll() {
		dice.roll();
		checkShunk();
	}
	
	public int getLastRoll() {
		return this.dice.getLastRoll();
	}
	
	public int getLastDie1() {
		return this.dice.getLastDie1();
	}
	
	public int getLastDie2() {
		return this.dice.getLastDie2();
	}
	
	public String toString() {
		return getLastDie1() + "+" + getLastDie2();
	}
	
	public int getSkunk() {
		return this.skunk;
	}
	
	public void checkShunk() {
		if(getLastDie1()==1 && getLastDie2()==1)
		{
			this.skunk = 4;
		}
		else if(getLastRoll()==3)
		{
			this.skunk = 2;
		}
		else if(getLastDie1()==1 || getLastDie2()==1)
		{
			this.skunk = 1;
		}
		else
		{
			this.skunk = 0;
		}
	}
}
