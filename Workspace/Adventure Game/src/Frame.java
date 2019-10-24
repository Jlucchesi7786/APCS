/**
 * This class is a placeholder class while I'm switching between the small Room and big Frame classes
 * @author Dr. Cheese
 */
public class Frame {
	int width;
	int height;

	Player player = new Player();

	boolean checked = false;
	boolean opened = false;
	Chest[] Chests = {new Chest(1, 30), new Chest(30, 19), new Chest(1, 1), new Chest(30, 2), new Chest(5, 5), new Chest(26, 15)};

	String orientation;

	/**
	 * This constructor makes a room with width and height. The playable area is a square/rectangle in the middle, with the walls taking up one space on each side
	 * @param width int
	 * @param height int
	 * @param orientation String
	 */
	Frame(int width, int height, String orientation) {
		this.width = width;
		this.height = height;
		this.orientation = orientation; // orientation tells it where the entrance is
	}

	/**
	 * This toString() method constructs a string with all of the symbols and the empty space in the frame
	 */
	public String toString() {
		String s = "";
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (y == player.y && x == player.x) {
					s += "@ ";
				} else if (y == 0 || y == height-1 || (y == 14 && x > 6)  || (y == 18 && x > 25) || (y == 18 && x < 6) || (y == 25 && x > 25) || (y == 29 && x < 6)) {
					if ((x == (width/2)-1 && y == height-1) || (x == 27 && y == 25) || (x == 5 && y == 29)) {
						s += "- ";
					} else {
						s += "# ";
					}
				} else if ((y == 4) && (x<6)) {
					s += "# ";
				} else {
					if (y == player.y && x == player.x) {
						s += "@ ";
					} else if ((x == 0) || (x == width-1) || (x == 6) || (x == 25)) {
						if ( ((y == 2 || y == 10 || y == 15 || y == 23) && x == 6) || ((y == 10 || y == 17 || y == 29) && x == 25) ) {
							s += "| ";
						} else {
							s += "# ";
						}
					} else  {
						if (chestCheck(x, y)) {
							if (opened) {
								s += "O ";
								opened = false;
							} else {
								s += "H ";
							}
						} else {
							s += "  ";
						}
					}
				}

			}
			s += "\n";
		}

		return s;
	}

	/**
	 * This method takes in a Player object to update where the character is to display it properly.
	 * @param player Player object
	 */
	public void update(Player player) {
		this.player = player;
	}

	/**
	 * This method checks if there is a chest on a given tile
	 * @param x int
	 * @param y int
	 * @return boolean (if chest is there)
	 */
	boolean chestCheck(int x, int y) {
		for (int i = 0; i < Chests.length; i++) {
			if (x == Chests[i].x && y == Chests[i].y) {
				if (Chests[i].open) {
					opened = true;
				}
				return true;
			}
		}
		return false;
	}
}
