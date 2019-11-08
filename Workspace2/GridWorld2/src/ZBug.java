import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class ZBug extends Bug {
	private int sidelength;
	private int stage;
	private int steps;
	
	public ZBug() {
		this(4);
	}
	
	public ZBug(int length) {
		this.sidelength = length;
		stage = -1;
		steps = 0;
	}
	
	public void act() {
		if (stage == -1) {
			turn();
			turn();
			stage++;
		}
		if (stage < 3) {
			move();
		}
		steps++;
		
		if (steps == sidelength-1) {
			if (stage == 0) {
				turn();
				turn();
				turn();
				steps = 0;
				sidelength++;
				stage++;
			}
		} else if (stage == 1 && (steps == sidelength-2)) {
			turn("left");
			turn("left");
			turn("left");
			steps = 0;
			sidelength++;
			stage++;
		} else if (stage == 2 && ((steps == sidelength-2))) {
			stage++;
		}
	}
	
	public void turn(String direction) {
		if (direction.equals("left")) {
	        setDirection(getDirection() + Location.HALF_LEFT);
		} else if (direction.equals("right")) {
	        setDirection(getDirection() + Location.HALF_RIGHT);
		}
	}
}
