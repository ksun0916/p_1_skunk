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

	@Test
	public void test_set_player_name() {
		Controller controller = new Controller();
		controller.setPlayerName(0, "AAA");
		assertEquals(controller.getPlayerName(0), "AAA");
		assertNotEquals(controller.getPlayerName(1), "BBB");
		controller.setPlayerName(1, "BBB");
		assertEquals(controller.getPlayerName(0), "AAA");
		assertEquals(controller.getPlayerName(1), "BBB");
	}
	
	@Test
	public void test_start_new_turn() {
		Controller controller = new Controller();
		controller.getTurn().addPoints(10);
		Turn oldTurn = controller.getTurn();
		controller.startNewTurn();
		assertNotEquals(oldTurn, controller.getTurn());		
	}
}
