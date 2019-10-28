/**
 * This class controls the frame that the player is in.
 * @author Dr. Cheese
 */
public class Room extends Compiler {
	// MAKE THE CLASS TAKE IN SMALLER ONES TO UPDATE THE FRAME
	int width;
	int height;

	Player player = new Player();

	boolean checked = false;
	boolean opened = false;
	//Chest[] Chests = {new Chest(1, 30), new Chest(30, 19), new Chest(1, 1), new Chest(30, 2), new Chest(5, 5), new Chest(26, 15)};
	//Wall[] Walls = {new Wall("horizontal", 32, 0, 0), new Wall("vertical", 30, 0, 1), new Wall("vertical", 30, 0, 1), new Wall("horizontal", 32, 0, 32)};

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

	/**
	 * This toString() method constructs a string with all of the symbols and the empty space in the frame
	 */
	public String toString() {
		String s = "";
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				s += map[x][y].character + " ";
				if (y == width-1) {
					s += "\n";
				}
			}
		}
		
		return s;
	}

	/**
	 * This method takes in a Player object to update where the character is to display it properly.
	 * @param player Player object
	 */
	public void updatePlayer(Player player) {
		super.update(player);
		this.player = player;
	}
}
