import info.gridworld.actor.*;
import info.gridworld.grid.*;

public class FlockWorld extends ActorWorld {

	public FlockWorld (Grid<Actor> grid) {
		super (grid);
	}
	
	public boolean keyPressed(String description, Location loc)	 {
		if (Bird.getFlock() == true) {
			Bird.setFlock (false);
		}
		else {
			Bird.setFlock (true);
		}
		return true;
	}
}
