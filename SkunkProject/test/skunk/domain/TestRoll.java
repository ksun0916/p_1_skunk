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
		fail(); // Roll 20 times will get some different number than beginning
	}
	
	@Test
	public void test_to_string() {
		Roll roll = new Roll();
		assertEquals(roll.toString(), roll.getLastDie1()+"+"+roll.getLastDie2());
	}
	
	@Test
	public void test_get_skunk() {
		Roll roll = new Roll();
		assertEquals(roll.getSkunk(), 0);
		for(int i=0;i<20;i++)
		{
			roll.roll();
			if(roll.getSkunk()!=0) return;
		}
		fail(); // Roll 20 times will get at least one skunk
	}
	
	@Test
	public void test_check_skunk() {
		Roll roll = new Roll();
		assertEquals(roll.getSkunk(), 0);
		for(int i=0;i<10;i++)
		{
			roll.roll();
			roll.checkShunk();
			if(roll.getLastDie1()==1 && roll.getLastDie2()==1)
			{
				assertEquals(roll.getSkunk(), 4);
			}
			else if(roll.getLastRoll()==3)
			{
				assertEquals(roll.getSkunk(), 2);
			}
			else if(roll.getLastDie1()==1 || roll.getLastDie2()==1)
			{
				assertEquals(roll.getSkunk(), 1);
			}
			else
			{
				assertEquals(roll.getSkunk(), 0);
			}
		}
	}
}
