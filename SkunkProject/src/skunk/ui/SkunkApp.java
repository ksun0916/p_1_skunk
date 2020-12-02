package skunk.ui;
import edu.princeton.cs.introcs.*;
import skunk.domain.Controller;

public class SkunkApp {

	public static void main(String[] args) {
		
		Controller controller = new Controller();
		
		StdOut.println("Welcome to play skunk!");		
		StdOut.print("Please enter player numbers: ");
		controller.setPlayerNumber(StdIn.readLine());
		for(int i=0;i<controller.getPlayerNumber();i++) 
		{
			StdOut.println("Please enter Player" + (i+1) + "'s Name: ");
			controller.setPlayerName(i, StdIn.readLine());
		}
		
		while(true)
		{
			StdOut.println("\nDo you need to add one more computer player?  y/n ");
			if(!controller.addComputerPlayer(StdIn.readLine()))
			{
				break;
			}
			StdOut.println("Do you want to set this computer player with smart mode or random mode? s/r (s for smart mode/r for random mode)");
			controller.setComputerPlayer(StdIn.readLine());
		}
		
		StdOut.println("Do you need to view the complete rules?  y/n ");
		StdOut.println(controller.displayRules(StdIn.readLine()));
		StdOut.println("Game Start!");
		
		outerloop:
		while(true)
		{
			for(int i=0;i<controller.getPlayerNumber();i++) 
			{
				// If someone reach a hundred at last round, then game is over
				if(controller.reachAHundred(i)) break outerloop;
							
				controller.startNewTurn();
				
				StdOut.println();
				StdOut.println(controller.getPlayerName(i) + "'s turn has started.");
				
				while(!controller.turnIsOver())
				{
					if(controller.isComputerPlayer(i))
					{
						controller.getComputerPlayerAction(i);
					}
					else
					{
						StdOut.println("\nDo you want to roll? y/n ");
						controller.getPlayerAction(StdIn.readLine());
					}
					
					if(!controller.turnIsOver())
					{
						controller.playRoll();
						StdOut.println("\nRoll Outcome Report: ");
						StdOut.println(controller.getPlayerName(i) + " got " + controller.printRoll());
						StdOut.println("Current turn score is: " + controller.getTurnPoint());
					}
				}
				
				controller.updatePlayer(i);
				
				printDivider();
				StdOut.println("End Of Turn Summary: ");
				StdOut.println("Player Name: " + controller.getPlayerName(i));
				StdOut.println("Roll Sequence" + controller.printTurn());
				StdOut.println("Final Turn Scores: " + controller.getTurnPoint());
				StdOut.println("Total Game Scores: " + controller.getPlayerScore(i));
				StdOut.println("Lost Chips: " + controller.getTurnLostChips());	
				printDivider();
			}
		}
		
		printDivider();
		StdOut.println("Game is Over!");
		StdOut.println(controller.printGameResult());
		printDivider();
		return;
	}
	
	public static void printDivider()
	{
		StdOut.println("-------------------------");
	}
}
