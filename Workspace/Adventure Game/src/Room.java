/**
 * This class controls the frame that the player is in.
 * @author Dr. Cheese
 */
public class Room extends Compiler {
	int width;
	int height;

	String orientation;

	/**
	 * This constructor makes a room with width and height. The playable area is a square/rectangle in the middle, with the walls taking up one space on each side
	 * @param width int
	 * @param height int
	 * @param orientation String
	 */
	Room(int width, int height, String orientation, Player player) {
		super(width+2, height+2, player);
		this.width = width+2;
		this.height = height+2;
		this.orientation = orientation; // orientation tells it where the entrance is
	}
	
	Room(int width, int height, String orientation, Player player, Chest[] chests, Wall[] walls, Door[] doors) {
		super(width+2, height+2, player, chests, walls, doors);
		this.width = width+2;
		this.height = height+2;
		this.orientation = orientation;
	}

	/**
	 * This toString() method constructs a string with all of the symbols and the empty space in the frame
	 */
	public String toString() {
		String s = "";
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				s += map[x][y].character + " ";
				
				if (x == width-1) {
					s += "\n";
				}
			}
		}

		return s;
	}
}
