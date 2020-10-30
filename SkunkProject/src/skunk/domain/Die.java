package skunk.domain;

public class Die
{
	private int lastRoll;

	public Die()
	{
		this.roll();
	}

	public int getLastRoll()
	{
		return this.lastRoll;
	}

	public void roll()
	{
		this.lastRoll = (int) (Math.random() * 6 + 1);
	}

	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}
}
