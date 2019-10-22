
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
	
	Enemy(String name, int level) {
		this.name = name;
		this.level = level;
		str = (int)(Math.ceil(Math.random()*level));
		def = (int)(Math.ceil(Math.random()*level));
		x = (int)(Math.ceil(Math.random()*30));
		y = (int)(Math.ceil(Math.random()*30));
		drop = new Item();
	}
	
	Enemy(int x, int y, int level) {
		this.x = x;
		this.y = y;
		this.level = level;
		str = (int)(Math.ceil(Math.random()*level));
		def = (int)(Math.ceil(Math.random()*level));
		drop = new Item();
	}
}
