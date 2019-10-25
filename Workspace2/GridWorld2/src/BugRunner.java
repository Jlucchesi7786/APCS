import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class BugRunner
{
    public static void main(String[] args)
    {
    	Bug buggy = new Bug();
        ActorWorld world = new ActorWorld();
        world.add(buggy);
        world.add(new Rock());
        world.show();
        buggy.setDirection(360);
        buggy.moveTo(new Location(2, 5));
        ;
    }
}