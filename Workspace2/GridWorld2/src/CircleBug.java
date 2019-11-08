import info.gridworld.actor.*;

public class CircleBug extends Bug {
	private int sidelength;
	private int steps;
	
	public CircleBug(int sidelength) {
		this.sidelength = sidelength;
		this.steps = 0;
	}
	
	public CircleBug() {
		this(4);
	}
	
	public void act() {
		move();
		steps++;
		if (steps == sidelength-1) {
			turn();
			steps = 0;
		}
	}
}
