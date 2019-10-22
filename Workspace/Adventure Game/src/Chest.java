
public class Chest {
	public int x;
	public int y;
	boolean open;
	Item contents;

	Chest(int x, int y) {
		this.x = x;
		this.y = y;
		open = false;
		contents = new Item();
	}
	
	public void open() {
		open = true;
	}
}
