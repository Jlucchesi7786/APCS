import java.awt.Color;
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.*;

public class Bird extends Actor {
	public static boolean flock = false;
	
	@Override
	public void act() {
		Location loc = this.getLocation();
		Grid<Actor> grid = this.getGrid();
		ArrayList<Location> surroundings = grid.getEmptyAdjacentLocations(this.getLocation());
		
		if (Bird.flock) {
			this.setColor(Color.BLUE);
			if (surroundings.size() > 0) {
				Location goalLoc = loc.getAdjacentLocation(Location.NORTH);
				if (grid.isValid(goalLoc)) {
					this.setDirection(Location.NORTH);
					if (grid.get(goalLoc) == null) {
					} else {
						int rand = (int) (Math.random()*surroundings.size());
						int dir = loc.getDirectionToward(surroundings.get(rand));
						this.setDirection(dir);
						goalLoc = loc.getAdjacentLocation(dir);
					}
					this.moveTo(goalLoc);
				}
			}
		} else {
			this.setColor(Color.RED);
			this.setDirection(Location.SOUTH);
			Location goalLoc = loc.getAdjacentLocation(Location.SOUTH);
			if (grid.isValid(goalLoc)) {
				if (grid.get(goalLoc) == null) {
					this.moveTo(goalLoc);
				} else {
					int rand = (int) (Math.random()*2);
					if (rand == 0) {
						goalLoc = loc.getAdjacentLocation(Location.EAST);
					} else {
						goalLoc = loc.getAdjacentLocation(Location.WEST);
					}
					
					if (grid.isValid(goalLoc)) {
						this.moveTo(goalLoc);
					} else if (rand == 0) {
						this.moveTo(loc.getAdjacentLocation(Location.WEST));
					} else {
						this.moveTo(loc.getAdjacentLocation(Location.EAST));
					}
				}
			}
		}
		
		
	}
	
	public static boolean getFlock() {
		return flock;
	}
	
	public static void setFlock(boolean flock) {
		Bird.flock = flock;
	}
}
