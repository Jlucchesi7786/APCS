import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.actor.*;


public class BlusterRunner {
	public static Grid<Actor> grid = new BoundedGrid<Actor>(20, 20);
	public static ActorWorld world = new ActorWorld(grid);
	public static BlusterCritter bluster = new BlusterCritter(1);
	
	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			world.add(new Critter());
			world.add(new Rock());
		}
		world.add(bluster);
		
		world.show();
	}

}
