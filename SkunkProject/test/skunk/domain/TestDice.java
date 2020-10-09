package skunk.domain;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestDice
{
	@Test
	public void test_dice_is_dice()
	{
		Dice dice = new Dice();
		assertEquals(dice.getClass(), Dice.class);
	}
	
	@Test
	public void test_dice_range()
	{
		Dice dice = new Dice();
		for(int i=0;i<100;i++)
		{
			dice.roll();
			if(dice.getLastRoll()<2||dice.getLastRoll()>12)
			{
				fail("Dice should be in 2 to 12.");
			}
		}
	}
}
