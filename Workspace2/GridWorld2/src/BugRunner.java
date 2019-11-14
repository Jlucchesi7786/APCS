import info.gridworld.actor.*;
import info.gridworld.grid.*;

public class BugRunner {
    public static void main(String[] args) {
    	//BoxBug buggy = new BoxBug(4);
    	//SpiralBug buggy = new SpiralBug();
    	//ZBug buggy = new ZBug();
    	//DanceBug buggy = new DanceBug();
    	//PongBug buggy = new PongBug();
    	ZigZagBug buggy = new ZigZagBug(1);
    	//Grid<Actor> grid = new BoundedGrid<Actor>(20, 10);
    	Grid<Actor> grid = new UnboundedGrid<Actor>();
        ActorWorld world = new ActorWorld(grid);
        //ActorWorld world = new ActorWorld();
        world.add(buggy);
        world.show();
        buggy.setDirection(360);
        buggy.moveTo(new Location(5, 2));
    }
}