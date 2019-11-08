import info.gridworld.actor.Bug;

public class SpiralBug extends Bug {
	private int sidelength;
	private int steps;
	
	public SpiralBug(int startingSidelength) {
		this.sidelength = startingSidelength;
		this.steps = 0;
	}
	
	public SpiralBug() {
		this(3);
	}
	
	public void act() {
		move();
		steps++;
		if (steps == sidelength-1) {
			turn();
			turn();
			steps = 0;
			sidelength++;
		}
	}
}
