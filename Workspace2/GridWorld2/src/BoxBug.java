import info.gridworld.actor.*;

public class BoxBug extends Bug {
	private int sidelength;
	private int steps;
	
	public BoxBug(int sidelength) {
		this.sidelength = sidelength;
		this.steps = 0;
	}
	
	public BoxBug() {
		this(4);
	}
	
	public void act() {
		move();
		steps++;
		if (steps == sidelength-1) {
			turn();
			turn();
			steps = 0;
		}
	}
}
