package skunk.domain;
import edu.princeton.cs.introcs.*;

public class SkunkApp {

	public static void main(String[] args) {
		
		StdOut.println("Welcome to play skunk!");
		
		Dice dice = new Dice();
		dice.roll();
		StdOut.println("First roll: " + dice.getLastRoll());
		dice.roll();
		StdOut.println("Second roll: " + dice.getLastRoll());
		
		return;
	}

}
