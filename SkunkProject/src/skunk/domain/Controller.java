package skunk.domain;

import java.util.ArrayList;

public class Controller {

	private int playerNumber;
	private ArrayList<Player> playerList;
	private Turn turn;
	private Roll roll;
	
	public Controller() {
		playerNumber = 2;
		playerList = setPlayerList();
		turn = new Turn();
		roll = new Roll();
	}
	
	public void setPlayerNumber(int number) {
		playerNumber = number;
		playerList = setPlayerList();
	}
	
	public int getPlayerNumber() {
		return this.playerNumber;
	}
	
	public ArrayList<Player> setPlayerList() {
		ArrayList<Player> players = new ArrayList<>();
		for(int i=0;i<playerNumber;i++)
		{
			players.add(new Player());
		}
		return players;
	}
	
	public Player getPlayer(int number) {
		return playerList.get(number);
	}
	
	public String getPlayerName(int number) {
		return getPlayer(number).getName();
	}
	
	public void setPlayerName(int number, String name) {
		getPlayer(number).setName(name);
	}
	
	public void startNewTurn() {
		turn = new Turn();
	}
	
	public boolean turnIsOver() {
		return turn.isOver();
	}
	
	public void getPlayerAction(String s) {
		if(s.length()==0 || s.charAt(0) != 'y')
		{
			turn.stopPlay();
		}
	}
	
	public int getTurnPoint() {
		return turn.getPoints();
	}
	
	public void playRoll() {
		roll.roll();
	}
	
	public String printRoll() {
		String s = roll.toString();
		int status = roll.getSkunk();
		if(status==0)
		{
			turn.addPoints(roll.getLastRoll());
		}
		else
		{
			if(status == 4)
			{
				s = s + "\nTwo Skunks! You lose 4 chip to the Kitty.";
			}
			else if(status == 2)
			{
				s = s + "\nSkunk and Deuce! You lose 2 chip to the Kitty.";
			}
			else if(status == 1)
			{
				s = s + "\nOne Skunk! You lose 1 chip to the Kitty.";
			}
			turn.stopPlay();
			turn.resetPoints();
		}		
		turn.addRolls(s);  
		return s;
	}
	
	public String printTurn() {
		return turn.getRolls();
	}
	
	public int getTurnLostChips() {
		return roll.getSkunk();		
	}
}
