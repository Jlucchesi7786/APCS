package info.gridworld.actor;

public class CircleBug extends Bug {
	private int sidelength = 5;
	private int steps = 0;
	
	public CircleBug(int sidelength) {
		this.sidelength = sidelength-1;
	}
	
	public void act() {
		move();
		steps++;
		if (steps == sidelength) {
			turn();
			turn();
			steps = 0;
		}
	}
}
