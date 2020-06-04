import java.awt.Color;

import info.gridworld.grid.*;
import info.gridworld.actor.*;

public class ChameleonRunner {
	public static Grid<Actor> grid = new BoundedGrid<Actor>(20, 20);
	public static ActorWorld world = new ActorWorld(grid);
	
	public static Rock r1 = new Rock();
	public static Rock r2 = new Rock();
	public static Rock r3 = new Rock();
	public static Rock r4 = new Rock();
	public static Rock r5 = new Rock();
	public static Rock r6 = new Rock();
	public static Rock r7 = new Rock();
	public static Rock r8 = new Rock();
	public static Rock r9 = new Rock();
	
	public static ChameleonCritter crit1 = new ChameleonCritter();
	
	public static ChameleonKidCritter cham1 = new ChameleonKidCritter();
	
	public static void main(String[] args) {
		r1.setColor(Color.RED);
		r2.setColor(Color.GREEN);
		r3.setColor(Color.RED);
		r4.setColor(Color.GREEN);
		r5.setColor(Color.RED);
		r6.setColor(Color.GREEN);
		r7.setColor(Color.RED);
		r8.setColor(Color.GREEN);
		r9.setColor(Color.RED);
		world.add(r1);
		world.add(r2);
		world.add(r3);
		world.add(r4);
		world.add(r5);
		world.add(r6);
		world.add(r7);
		world.add(r8);
		world.add(r9);
		world.add(cham1);
		
		world.show();
	}

}
