
public class Enemy {
	int x;
	int y;
	int str;
	int def;
	String drop;
	String name;
	
	Enemy(String name, int level) {
		this.name = name;
		str = (int)(Math.ceil(Math.random()*level));
		def = (int)(Math.ceil(Math.random()*level));
	}
}
