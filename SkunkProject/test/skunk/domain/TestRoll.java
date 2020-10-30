package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRoll {

	@Test
	public void test_create_roll() {
		Roll roll = new Roll();
		assertEquals(roll.getClass(), Roll.class);
	}

	@Test
	public void test_roll() {
		Roll roll = new Roll();
		int lastRoll = roll.getLastRoll();
		for(int i=0;i<20;i++)
		{
			roll.roll();
			if(roll.getLastRoll()!=lastRoll) return;
		}
		fail();
	}
	
	@Test
	public void test_to_string() {
		Roll roll = new Roll();
		assertEquals(roll.toString(), roll.getLastDie1()+"+"+roll.getLastDie2());
	}
	
	@Test
	public void test_get_skunk() {
		fail();
	}
}
