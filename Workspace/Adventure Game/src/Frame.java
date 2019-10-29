/**
 * This class is a placeholder class while I'm switching between the small Room and big Frame classes
 * @author Dr. Cheese
 */
public class Frame {
	int width;
	int height;

	Player player = new Player();

	String orientation;

	Frame(Room[] rooms) {

	}

	/**
	 * This method takes in a Player object to update where the character is to display it properly.
	 * @param player Player object
	 */
	public void updatePlayer(Player player) {
		this.player = player;
	}
}
