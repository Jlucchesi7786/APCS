import info.gridworld.grid.*;
import info.gridworld.actor.*;

public class RockHoundRunner {
	public static Grid<Actor> grid = new BoundedGrid<Actor>(20, 20);
	public static ActorWorld world = new ActorWorld(grid);
	public static RockHound hound = new RockHound();
	
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			world.add(new Rock());
		}
		world.add(hound);
		
		world.show();
	}

}
