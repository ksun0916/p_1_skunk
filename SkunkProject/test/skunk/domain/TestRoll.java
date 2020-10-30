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
		fail();
	}
}
