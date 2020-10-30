package skunk.ui;
import edu.princeton.cs.introcs.*;
import skunk.domain.Controller;

public class SkunkApp {

	public static void main(String[] args) {
		
		StdOut.println("Welcome to play skunk!");
		
		Controller controller = new Controller();
		//StdOut.println("Please enter player numbers: ");
		controller.setPlayerNumber(1);
		for(int i=0;i<controller.getPlayerNumber();i++) 
		{
			StdOut.println("Please enter Player" + (i+1) + "'s Name: ");
			controller.setPlayerName(i, StdIn.readLine());
		}
		
		// Game game = new Game();
		// while(!game.isLastTurn())
		
		for(int i=0;i<controller.getPlayerNumber();i++) 
		{
			controller.startNewTurn();
			StdOut.println(controller.getPlayerName(i) + "'s turn has started.");
			
			while(!controller.turnIsOver())
			{
				StdOut.println("\nDo you want to roll? y/n ");
				controller.getPlayerAction(StdIn.readLine());
				
				if(!controller.turnIsOver())
				{
					controller.playRoll();
					StdOut.println("\nRoll Outcome Report: ");
					StdOut.println(controller.getPlayerName(i) + " got " + controller.printRoll());
					StdOut.println("Current turn score is: " + controller.getTurnPoint());
				}
			}
			
			StdOut.println("\nEnd Of Turn Summary: ");
			StdOut.println("Player Name: " + controller.getPlayerName(i));
			StdOut.println("Roll Sequence" + controller.printTurn());
			StdOut.println("Final Turn Scores: " + controller.getTurnPoint());
			StdOut.println("Lost Chips: " + controller.getTurnLostChips());
			//controller.updatePlayer(i);
			
		}
		
		return;
	}

}
