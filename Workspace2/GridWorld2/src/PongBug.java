import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;


public class PongBug extends Bug {
	String turndirection;
	int dir;
	int notdir;
	int stage;
	final String[] directions = {"left", "right"};
	
	public PongBug() {
		this("right");
	}
	
	public PongBug(String turndirection) {
		for (int i = 0; i < directions.length; i++) {
			if (directions[i].equals(turndirection)) {
				dir = i;
				if (i == 1) {
					notdir = 0;
				} else {
					notdir = 1;
				}
			}
		}
		
		stage = -1;
	}
	
	public void act() {
		if (stage == -1) {
			turn();
			stage++;
		}
		
		if (canMove()) {
			move();
		} else if (stage == 0) {
			turn(directions[dir], 2);
			if (!canMove()) {
				turn(directions[notdir], 4);
			}
		}
	}
	
	public void turn(String direction) {
		if (direction.equals("left")) {
	        setDirection(getDirection() + Location.HALF_LEFT);
		} else if (direction.equals("right")) {
	        setDirection(getDirection() + Location.HALF_RIGHT);
		}
	}
	
	public void turn(String direction, int times) {
		for (int i = 0; i < times; i++) {
			turn(direction);
		}
	}
}
