//import java.util.*;

/**
 * This class will hold the data of every room given to it, putting it all in one 
 * big frame.
 * @author Dr. Cheese
 */
public class Frame extends FrameCompiler {
	int width;
	int height;

	RoomStorage storerooms = new RoomStorage();
	
	//Player player = new Player();

	String orientation;

	Frame(Room[] rooms) {
		//rooms = storerooms.getRooms();
		super(rooms);
		width = super.getWidth();
		height = super.getHeight();
	}
	
	public String toString() {
		String s = "";

		for (int y = 0; y < width; y++) {
			for (int x = 0; x < height; x++) {
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
