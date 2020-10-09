package skunk.domain;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class TestDie
{
	@Test
	public void test_die_is_die()
	{
		fail();
	}
	
	@Test
	public void test_die_with_predictable_die_123()
	{
		PredictableDie die = new PredictableDie(new int[] {1,2,3});
		die.roll();
		assertEquals(1, die.getLastRoll());
		die.roll();
		assertEquals(2, die.getLastRoll());
		die.roll();
		assertEquals(3, die.getLastRoll());
	}
	
	@Test 
	public void test_die_with_predictable_die_more_than_once() 
	{
		PredictableDie die = new PredictableDie(new int[] {1});
		die.roll();
		assertEquals(1, die.getLastRoll());
		die.roll();
		assertEquals(1, die.getLastRoll());
	}
	
	@Test(expected=RuntimeException.class)
	public void test_die_with_predictable_die_empty_array()
	{
		PredictableDie die = new PredictableDie(new int[] {});
		die.roll();
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
