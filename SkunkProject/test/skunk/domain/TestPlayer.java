package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlayer {

	@Test
	public void test_create_new_player() {
		Player player = new Player();
		assertEquals(player.getClass(), Player.class);
	}

}
