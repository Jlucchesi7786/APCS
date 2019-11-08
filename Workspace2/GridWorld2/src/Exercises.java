import info.gridworld.actor.*;
import info.gridworld.grid.*;

/**
 * This uses extension 4, and adds it to the mix.
 * @author Dr. Cheese
 */
public class Exercises {
	static 	CircleBug 	bug1 = new CircleBug(4);
	static 	SpiralBug 	bug2 = new SpiralBug();
	static 	ZBug 		bug3 = new ZBug(4);
	static	DanceBug	bug4 = new DanceBug();
	static PongBug		bug5 = new PongBug();
	
	static Grid<Actor> biggrid = new BoundedGrid<Actor>(45, 50);
	static ActorWorld world = new ActorWorld(biggrid);
	
	public static void main(String[] args) {
		world.add(bug1);
        bug1.moveTo(new Location(5, 2));
		world.add(bug2);
        bug1.moveTo(new Location(2, 5));
		world.add(bug3);
        bug1.moveTo(new Location(6, 4));
		world.add(bug4);
        bug1.moveTo(new Location(3, 7));
		world.add(bug5);
        bug1.moveTo(new Location(4, 3));
		world.show();
	}

}
