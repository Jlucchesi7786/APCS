/**
 * This class will hold the data of every room given to it, putting it all in one big frame.
 * @author Dr. Cheese
 */
public class Frame {
	int width;
	int height;

	Player player = new Player();

	String orientation;

	Frame(Room[] rooms) {
		width = 0;
		height = 0;
		for (int i = 0; i < rooms.length; i++) {
			width += rooms[i].width;
			height += rooms[i].height;
		}
	}

	/**
	 * This method takes in a Player object to update where the character is to display it properly.
	 * @param player Player object
	 */
	public void updatePlayer(Player player) {
		this.player = player;
	}
}
