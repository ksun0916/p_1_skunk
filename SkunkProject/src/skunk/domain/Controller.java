package skunk.domain;

import java.util.ArrayList;

import edu.princeton.cs.introcs.StdOut;

public class Controller {

	private static final int RANDOM_KEEP_PLAY_RATE = 50;
	private static final int FIVE = 5;
	private static final int ONE_SKUNK = 1;
	private static final int SKUNK_DEUCE = 2;
	private static final int TWO_SKUNKS = 4;
	
	private int playerNumber;
	private ArrayList<Player> playerList;
	private Turn turn;
	private Roll roll;
	private int kitty;
	
	public Controller() {
		playerNumber = 2;
		playerList = setPlayerList();
		turn = new Turn();
		roll = new Roll();
		kitty = 0;
	}
	
	public void setPlayerNumber(String number) {
		playerNumber = Integer.parseInt(number);
		playerList = setPlayerList();
	}
	
	public int getPlayerNumber() {
		return this.playerNumber;
	}
	
	private ArrayList<Player> setPlayerList() {
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
	
	public Turn getTurn() {
		return turn;
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
	
	public Roll getRoll() {
		return roll;
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
			if(status == TWO_SKUNKS) s += "\nTwo Skunks! You lose 4 chip to the Kitty.";
			else if(status == SKUNK_DEUCE) s += "\nSkunk and Deuce! You lose 2 chip to the Kitty.";
			else if(status == ONE_SKUNK) s += "\nOne Skunk! You lose 1 chip to the Kitty.";
			
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
	
	public String displayRules(String s)
	{
		String result = "";
		if(s.length()!=0 && s.charAt(0) == 'y')
		{
			result = "DIRECTIONS FOR PLAYING\n" + 
					 "The object of the game is to accumulate a score of 100 points or more. A s" +
					 "core is made by rolling the dice and combining the points on the two dice." +
					 " For example: A 4 and 5 would be 9 points - if the player decides to take " +
					 "another roll of the dice and turns up a 3 and 5 (8 points), he would then " +
					 "have an accumulated total of 17 points for the two rolls. The player has t" +
					 "he privilege of continuing to shake to increase his score or of passing th" +
					 "e dice to wait for the next series, thus preventing the possibility of rol" +
					 "ling a Skunk and losing his score.\n" +
					 "PENALTIES\n" + 
					 "A skunk in any series voids the score for that series only and draws a pen" +
					 "alty of 1 chip placed in the \"kitty\", and loss of dice. A skunk and a de" +
					 "uce voids the score for that series only and draws a penalty of 2 chips pl" +
					 "aced in the \"kitty\", and loss of dice. TWO skunks void the ENTIRE accumu" +
					 "lated score and draws a penalty of 4 chips placed in the \"kitty\", and lo" +
					 "ss of dice. Player must again start to score from scratch. \n" +
					 "Any number can play. [Assume at least two players!] The suggested number o" +
					 "f chips to start is 50. The first player to accumulate a total of 100 or m" +
					 "ore points can continue to score as many points over 100 as he believes is" +
					 " needed to win. When he decides to stop, his total score is the goal. Each" +
					 " succeeding player receives one more chance to better the goal and end the" +
					 "game. \n" + 
					 "The winner of each game collects all chips in \"kitty\" and in addition 5 " +
					 "chips from each losing player or 10 chips from any player without a score.";
		}
		return result;
	}
	
	public boolean reachAHundred(int number)
	{
		return getPlayer(number).getReachAHundred();
	}
	
	public void updatePlayer(int number)
	{
		Player player = getPlayer(number);
		int status = roll.getSkunk();
		
		if(status == TWO_SKUNKS) player.resetPoint();
		else player.addPoint(getTurnPoint());
		
		player.adjustChip(-status);
		this.kitty += status;
		
		player.checkPlayerReachAHundred();
		return;
	}
	
	public int getPlayerScore(int number)
	{
		return getPlayer(number).getPoint();
	}

	private void deductFiveChips(int number)
	{
		getPlayer(number).adjustChip(-FIVE);
		this.kitty += FIVE;
	}
	
	public String printGameResult()
	{
		int winner = 0;
		int winnerScore = 0;
		for(int i=0;i<getPlayerNumber();i++) 
		{
			if(getPlayer(i).getPoint() > winnerScore || (getPlayer(i).getPoint() == winnerScore && getPlayer(i).getReachAHundred()))
			{
				winnerScore = this.getPlayer(i).getPoint();
				winner = i;
			}
		}
		
		for(int i=0;i<getPlayerNumber();i++) 
		{
			if(i!=winner)
			{
				deductFiveChips(i);
				if(getPlayerScore(i)==0)
				{
					deductFiveChips(i);
				}
			}
		}		
		getPlayer(winner).adjustChip(kitty);
		
		String result = "Winner is " + getPlayerName(winner) +"!\n";
		result += "\nFinal Scoreboard: \n";
		
		for(int i=0;i<getPlayerNumber();i++) 
		{
			result += ("Player Name: " + getPlayerName(i) + "	Final Scores: " + getPlayer(i).getPoint() + "	Total Chips: " + getPlayer(i).getChip() + "\n");
		}
		
		return result;
	}
	
	public boolean addComputerPlayer(String s)
	{
		if(s.length()==0 || s.charAt(0) != 'y')
		{
			return false;
		}		
		this.playerNumber++;
		this.playerList.add(new Player());
		return true;
	}
	
	public void setComputerPlayer(String s)
	{
		if(s.length()==0 || s.charAt(0) != 's')
		{
			// Random computer player (mode 1)
			getPlayer(playerNumber-1).setName("Player "+ playerNumber +" (Random AI)");
			getPlayer(playerNumber-1).setMode(1);
		}
		else
		{
			// Smart computer player (mode 2)
			getPlayer(playerNumber-1).setName("Player "+ playerNumber +" (Smart AI)");
			getPlayer(playerNumber-1).setMode(2);
		}
	}
	
	public boolean isComputerPlayer(int number)
	{
		if(getPlayer(number).getMode()==0) return false;
		return true;
	}
	
	public void getComputerPlayerAction(int number)
	{
		if(getPlayer(number).getMode()==1)
		{
			if(getTurnPoint() != 0 && (Math.random() * 100 + 1) > RANDOM_KEEP_PLAY_RATE) 
				turn.stopPlay();
		}
		else
		{
			int turnPoint = getTurnPoint();
			int gamePoint = getPlayerScore(number);
			double expectPoint = 0
					+ 1.0 / 36 * 0
		            + 2.0 / 36 * gamePoint
		            + 8.0 / 36 * gamePoint
		            + 1.0 / 36 * (gamePoint + turnPoint + 4)
		            + 2.0 / 36 * (gamePoint + turnPoint + 5)
		            + 3.0 / 36 * (gamePoint + turnPoint + 6)
		            + 4.0 / 36 * (gamePoint + turnPoint + 7)
		            + 5.0 / 36 * (gamePoint + turnPoint + 8)
		            + 4.0 / 36 * (gamePoint + turnPoint + 9)
		            + 3.0 / 36 * (gamePoint + turnPoint + 10)
		            + 2.0 / 36 * (gamePoint + turnPoint + 11)
		            + 1.0 / 36 * (gamePoint + turnPoint + 12);
			//StdOut.println("Turn: "+turnPoint+" Game: "+ gamePoint + " EP: "+ expectPoint);
			if(expectPoint <= turnPoint + gamePoint) turn.stopPlay();
		}
	}
	
	// This is for AutoPlayApp
	public int getWinner()
	{
		int winner = 0;
		int winnerScore = 0;
		for(int i=0;i<getPlayerNumber();i++) 
		{
			if(getPlayer(i).getPoint() > winnerScore || (getPlayer(i).getPoint() == winnerScore && getPlayer(i).getReachAHundred()))
			{
				winnerScore = this.getPlayer(i).getPoint();
				winner = i;
			}
		}
		return winner;
	}
}
