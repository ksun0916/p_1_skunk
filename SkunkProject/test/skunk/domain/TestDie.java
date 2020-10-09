package skunk.domain;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestDie
{
	@Test
	public void test_die_with_seed()
	{
		fail();
	}
	
	@Test
	public void test_die_range()
	{
		Die die = new Die();
		for(int i=0;i<50;i++)
		{
			die.roll();
			if(die.getLastRoll()<1||die.getLastRoll()>6)
			{
				fail("Die should be in 1 to 6.");
			}
		}
	}
}
