import info.gridworld.actor.*;
import info.gridworld.grid.*;

public class BugRunner
{
    public static void main(String[] args)
    {
    	CircleBug buggy = new CircleBug(5);
        ActorWorld world = new ActorWorld();
        world.add(buggy);
        world.show();
        buggy.setDirection(360);
        buggy.moveTo(new Location(5, 2));
        ;
    }
}