import info.gridworld.grid.*;
import info.gridworld.actor.*;

public class Runner {
	public static Grid<Actor> grid = new BoundedGrid<Actor>(25, 40);
	public static FlockWorld world = new FlockWorld(grid);
	
	public static void main(String[] args) {
		for (int i = 0; i < 40; i++) {
			world.add(new Rock());
			if (i < 15) {
				world.add(new Bird());
			}
		}
		
		world.show();
	}

}
