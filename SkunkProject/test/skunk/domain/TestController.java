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
	public void test_set_player() {
		fail();
	}

}
