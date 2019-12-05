
public class Square {
	private int score;
	private boolean occupied;
	
	public Square() {
		score = 0;
		occupied = false;
	}
	
	public Square(int score) {
		this.score = score;
		occupied = false;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int newScore) {
		this.score = newScore;
	}
	
	public boolean getState() {
		return occupied;
	}
	
	public void setState(boolean newState) {
		occupied = newState;
	}
}
