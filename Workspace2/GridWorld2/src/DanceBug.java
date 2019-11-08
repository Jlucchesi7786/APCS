import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;


public class DanceBug extends Bug {

	public DanceBug() {}
	
	public void act() {
		int dir = rand();
		
		if (dir == -2) {
			turn("left", 2);
		} else if (dir == -1) {
			turn("left");
		} else if (dir == 1) {
			turn("right");
		} else if (dir == 2) {
			turn("right", 2);
		}
		
		super.act();
	}
	
	private int rand() {
		return ((int) ((Math.random()*5)-2));
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
