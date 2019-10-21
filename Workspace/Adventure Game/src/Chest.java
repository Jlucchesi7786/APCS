
public class Chest {
	public int x;
	public int y;
	boolean open;

	Chest(int x, int y) {
		this.x = x;
		this.y = y;
		open = false;
	}
	
	public void open() {
		open = true;
	}
	
	public boolean status() {
		return open;
	}
}
