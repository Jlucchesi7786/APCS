/**
 * This class is holds a bunch of information about the enemies around the dungeon.
 * @author Dr. Cheese
 */
public class Enemy {
	int x;
	int y;

	int level;
	int str;
	int def;
	Item drop;
	String name;

	int playerX;
	int playerY;
	boolean pursuing = false;

	/**
	 * This constructor initializes an enemy with a name and some level to base the stats on.
	 * @param name String
	 * @param level int
	 */
	Enemy(String name, int level) {
		this.name = name;
		this.level = level;
		str = (int)(Math.ceil(Math.random()*level));
		def = (int)(Math.ceil(Math.random()*level));
		x = (int)(Math.ceil(Math.random()*30));
		y = (int)(Math.ceil(Math.random()*30));
		drop = new Item();
	}

	/**
	 * This constructor initializes an enemy at some given x and y position and a level to base the stats on. The String name is not initialized.
	 * @param x int
	 * @param y int
	 * @param level int
	 */
	Enemy(int x, int y, int level) {
		this.x = x;
		this.y = y;
		this.level = level;
		str = (int)(Math.ceil(Math.random()*level));
		def = (int)(Math.ceil(Math.random()*level));
		drop = new Item();
	}
}
