import info.gridworld.grid.*;
import info.gridworld.actor.*;

public class Runner {
	public static Grid<Actor> grid = new BoundedGrid<Actor>(25, 40);
	public static FlockWorld world = new FlockWorld(grid);
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			world.add(new Bug());
			world.add(new Critter());
		}
		
		for (int i = 0; i < 20; i++) {
			world.add(new Rock());
		}
		
		world.show();
	}

}
