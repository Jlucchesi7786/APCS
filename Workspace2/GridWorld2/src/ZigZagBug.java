import info.gridworld.actor.Bug;

public class ZigZagBug extends Bug {
	int steps;
	int step;
	
	boolean left;
	
	public ZigZagBug(int steps) {
		this.steps = steps;
		step = 0;
		left = true;
	}
	
	public void act() {
		if (step < steps) {
			move();
			step++;
		} else {
			if (left) {
				turn();
				turn();
				turn();
				turn();
				turn();
				turn();
				left = false;
			}  else {
				turn();
				turn();
				left = true;
			}
			step = 0;
		}
	}
}
