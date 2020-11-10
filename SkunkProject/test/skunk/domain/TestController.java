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
		controller.setPlayerNumber("3");
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
	
	@Test
	public void test_turn_is_over() {
		Controller controller = new Controller();
		assertEquals(controller.turnIsOver(), false);
		controller.getTurn().stopPlay();
		assertEquals(controller.turnIsOver(), true);
	}
	
	@Test
	public void test_get_player_action() {
		Controller controller = new Controller();
		controller.getPlayerAction("y");
		assertEquals(controller.turnIsOver(), false);
		controller.getPlayerAction("n");
		assertEquals(controller.turnIsOver(), true);
		controller.startNewTurn();
		controller.getPlayerAction("");
		assertEquals(controller.turnIsOver(), true);
	}
	
	@Test
	public void test_get_turn_point() {
		Controller controller = new Controller();
		assertEquals(controller.getTurnPoint(), 0);
		controller.getTurn().addPoints(8);
		assertEquals(controller.getTurnPoint(), 8);
	}
	
	@Test
	public void test_play_roll() {
		Controller controller = new Controller();
		int lastRoll = controller.getRoll().getLastRoll();
		for(int i=0;i<20;i++)
		{
			controller.playRoll();
			if(controller.getRoll().getLastRoll()!=lastRoll) return;
		}
		fail();
	}
	
	@Test
	public void test_get_turn_lost_chip() {
		Controller controller = new Controller();
		assertEquals(controller.getTurnLostChips(), 0);
		for(int i=0;i<20;i++)
		{
			controller.playRoll();
			if(controller.getTurnLostChips()!=0) return;
		}
		fail();
	}
	
	@Test
	public void test_print_roll() {
		Controller controller = new Controller();
		String s = controller.printRoll();
		int skunk = controller.getRoll().getSkunk();
		while(controller.getRoll().getSkunk()==skunk)
		{
			controller.playRoll();
		}
		assertNotEquals(s, controller.printRoll());
	}
	
	@Test 
	public void test_print_turn() {
		Controller controller = new Controller();
		String s = controller.printTurn();
		controller.playRoll();
		controller.printRoll();
		assertNotEquals(s, controller.printTurn());
	}
	
	@Test
	public void test_display_rules() {
		Controller controller = new Controller();
		assertEquals(controller.displayRules("n"), "");
		assertEquals(controller.displayRules(" "), "");
		assertNotEquals(controller.displayRules("y"), "");
	}
	
	@Test
	public void test_reach_a_hundred() {
		Controller controller = new Controller();
		assertEquals(controller.reachAHundred(0), false);
		assertEquals(controller.reachAHundred(1), false);
		controller.getPlayer(0).addPoint(99);
		controller.getPlayer(1).addPoint(101);
		controller.getPlayer(0).checkPlayerReachAHundred();
		controller.getPlayer(1).checkPlayerReachAHundred();
		assertEquals(controller.reachAHundred(0), false);
		assertEquals(controller.reachAHundred(1), true);
	}
	
	@Test
	public void test_get_player_score() {
		Controller controller = new Controller();
		assertEquals(controller.getPlayerScore(0), 0);
		controller.getPlayer(0).addPoint(30);
		assertEquals(controller.getPlayerScore(0), 30);
		controller.getPlayer(0).addPoint(13);
		assertEquals(controller.getPlayerScore(0), 43);
		controller.getPlayer(0).resetPoint();
		assertEquals(controller.getPlayerScore(0), 0);
	}
	
	@Test
	public void test_update_player() {
		Controller controller = new Controller();
		assertEquals(controller.getPlayer(0).getPoint(), 0);
		controller.getTurn().addPoints(30);
		assertEquals(controller.getPlayer(0).getPoint(), 0);
		controller.updatePlayer(0);
		assertEquals(controller.getPlayer(0).getPoint(), 30);
	}
	
	@Test
	public void test_print_game_result() {
		Controller controller = new Controller();
		controller.setPlayerName(0, "AAA");
		controller.setPlayerName(1, "BBB");
		controller.getPlayer(1).addPoint(101);
		assertEquals(controller.printGameResult(), "Winner is BBB!\n\nFinal Scoreboard: \n"
				+"Player Name: AAA	Final Scores: 0	Total Chips: 40\n"
				+"Player Name: BBB	Final Scores: 101	Total Chips: 60\n");
		
		controller.getPlayer(0).addPoint(50);
		assertEquals(controller.printGameResult(), "Winner is BBB!\n\nFinal Scoreboard: \n"
				+"Player Name: AAA	Final Scores: 50	Total Chips: 35\n"
				+"Player Name: BBB	Final Scores: 101	Total Chips: 65\n");
	}
}
