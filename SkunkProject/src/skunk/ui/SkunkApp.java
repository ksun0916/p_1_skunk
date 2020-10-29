package skunk.ui;
import edu.princeton.cs.introcs.*;
import skunk.domain.Dice;

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
