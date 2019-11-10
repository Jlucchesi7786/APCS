//import java.util.*;

/**
 * This class will hold the data of every room given to it, putting it all in one 
 * big frame.
 * @author Dr. Cheese
 */
public class Frame extends FrameCompiler {
	int width;
	int height;

	//Player player = new Player();

	String orientation;

	Frame(Room[] rooms) {
		super(rooms);
		System.out.println(super.getWidth());
		width = super.getWidth();
		height = super.getHeight();
	}
	
	public String toString() {
		String s = "";

		for (int y = 0; y < 32; y++) {
			for (int x = 0; x < width; x++) {
				s += map[x][y].character + " ";

				if (x == width-1) {
					s += "\n";
				}
			}
		}

		return s;
	}

	/**
	 * This method takes in a Player object to update where the character is to display 
	 * it properly.
	 * @param player Player object
	 */
	public void updatePlayer(Player player) {
		super.update(player);
	}
}
