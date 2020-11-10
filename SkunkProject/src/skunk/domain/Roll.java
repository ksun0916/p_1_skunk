package skunk.domain;

public class Roll {
	
	private static final int SKUNK_DIE = 1;
	private static final int ONE_SKUNK = 1;
	private static final int SKUNK_DEUCE = 2;
	private static final int TWO_SKUNKS = 4;
	
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
		if(getLastDie1()==SKUNK_DIE && getLastDie2()==SKUNK_DIE)
		{
			this.skunk = TWO_SKUNKS;
		}
		else if(getLastRoll()==3)
		{
			this.skunk = SKUNK_DEUCE;
		}
		else if(getLastDie1()==SKUNK_DIE || getLastDie2()==SKUNK_DIE)
		{
			this.skunk = ONE_SKUNK;
		}
		else
		{
			this.skunk = 0;
		}
	}
}
