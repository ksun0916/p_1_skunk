package skunk.domain;

public class Turn {
	
	private int points;
	private boolean keepPlay;
	private String rolls;
	
	public Turn() {
		keepPlay = true;
		points = 0;
		rolls = "";
	}
	
	public boolean isOver() {
		return !keepPlay;
	}
	
	public void stopPlay() {
		keepPlay = false;		
	}
	
	public void addPoints(int pt) {
		this.points = this.points + pt;
	}
	
	public void resetPoints() {
		this.points = 0;
	}
	
	public int getPoints() {
		return points;
	}

	public void addRolls(String s) {
		this.rolls = this.rolls + " => " + s;
	}
	
	public String getRolls() {
		return rolls;
	}
}
