package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTurn {

	@Test
	public void test_create_turn() {
		Turn turn = new Turn();
		assertEquals(turn.getClass(), Turn.class);
	}

}
