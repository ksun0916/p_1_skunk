package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTurn {

	@Test
	public void test_create_turn() {
		Turn turn = new Turn();
		assertEquals(turn.getClass(), Turn.class);
	}
	
	@Test
	public void test_stop_play_and_is_over() {
		Turn turn = new Turn();
		assertEquals(turn.isOver(), false);
		turn.stopPlay();
		assertEquals(turn.isOver(), true);
	}

	@Test
	public void test_add_points() {
		Turn turn = new Turn();
		assertEquals(turn.getPoints(), 0);
		turn.addPoints(7);
		assertEquals(turn.getPoints(), 7);
		turn.addPoints(15);
		assertEquals(turn.getPoints(), 22);
	}
	
	@Test
	public void test_reset_points() {
		Turn turn = new Turn();
		turn.addPoints(7);
		assertNotEquals(turn.getPoints(), 0);
		turn.resetPoints();
		assertEquals(turn.getPoints(), 0);
	}
	
	@Test
	public void test_add_rolls() {
		fail();
	}
}
