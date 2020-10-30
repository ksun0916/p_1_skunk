package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestController {

	@Test
	public void test_create_controller() {
		Controller controller = new Controller();
		assertEquals(controller.getClass(), Controller.class);
	}
	
	@Test
	public void test_set_player_number() {
		Controller controller = new Controller();
		assertEquals(controller.getPlayerNumber(), 2);
		controller.setPlayerNumber(3);
		assertEquals(controller.getPlayerNumber(), 3);
	}

}
