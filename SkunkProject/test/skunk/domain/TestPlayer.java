package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlayer {

	@Test
	public void test_create_new_player() {
		Player player = new Player();
		assertEquals(player.getClass(), Player.class);
	}
	
	@Test
	public void test_set_chip() {
		Player player = new Player();
		assertEquals(player.getChip(), 50);
		player.setChip(100);
		assertEquals(player.getChip(), 100);
	}
	
	@Test
	public void test_adjust_chip() {
		Player player = new Player();
		assertEquals(player.getChip(), 50);
		player.adjustChip(10);
		assertEquals(player.getChip(), 60);
		player.adjustChip(-5);
		assertEquals(player.getChip(), 55);
	}
	
	@Test
	public void test_add_point() {
		Player player = new Player();
		player.addPoint(30);
		assertEquals(player.getPoint(), 30);
		player.addPoint(5);
		assertEquals(player.getPoint(), 35);
		player.addPoint(11);
		assertEquals(player.getPoint(), 46);
	}
	
	@Test
	public void test_reset_point() {
		Player player = new Player();
		player.addPoint(13);
		assertEquals(player.getPoint(), 13);
		player.resetPoint();
		assertEquals(player.getPoint(), 0);
	}
	
	@Test
	public void test_reset_name() {
		Player player = new Player();
		assertEquals(player.getName(), "Player");
		player.setName("ABC");
		assertEquals(player.getName(), "ABC");
	}
	
	@Test
	public void test_player_to_string() {
		Player player = new Player();
		assertEquals(player.toString(), "Player: Player"+"\nCurrent Points: 0"+"\nTotal Chips: 50");
		player.setName("ABCD");
		player.setChip(100);
		player.addPoint(25);
		assertEquals(player.toString(), "Player: ABCD"+"\nCurrent Points: 25"+"\nTotal Chips: 100");
	}
}
