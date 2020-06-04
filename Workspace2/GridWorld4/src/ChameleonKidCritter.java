import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.*;

public class ChameleonKidCritter extends ChameleonCritter {
	
	public ArrayList<Actor> getActors() {
		ArrayList<Actor> actors = new ArrayList<Actor>();
		int[] dirs = {Location.AHEAD, Location.HALF_CIRCLE};
		for (Location loc: getLocationsInDirections(dirs)) {
			Actor a = getGrid().get(loc);
			if (a != null) {
				
			}
		}
		
		return actors;
	}
	
	public void processActors(ArrayList<Actor> actors) {
		int n = actors.size();
		if (n == 0) return;
		int rand = (int) (Math.random() * n);
		Actor other = actors.get(rand);
		setColor(other.getColor());
	}
	
	/**
     * Turns towards the new location as it moves.
     */
    public void makeMove(Location loc)
    {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }
    
    public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
    ArrayList<Location> locs = new ArrayList<Location>();
    Grid gr = getGrid();
    Location loc = getLocation();
    for (int d : directions)
    {
    Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
    if (gr.isValid(neighborLoc))
    locs.add(neighborLoc);
    }
    return locs;
    }
}
