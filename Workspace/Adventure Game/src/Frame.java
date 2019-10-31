import java.util.*;

/**
 * This class will hold the data of every room given to it, putting it all in one big frame.
 * @author Dr. Cheese
 */
public class Frame extends FrameCompiler {
	int width;
	int height;

	//Player player = new Player();

	String orientation;

	Frame(Room[] rooms) {
		super(rooms);
		width = 0;
		height = 0;
		for (int i = 0; i < rooms.length; i++) {
			width += rooms[i].width;
			height += rooms[i].height;
			//decompress(rooms[i].compress());
		}
	}
	
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

	/**
	 * This method takes in a Player object to update where the character is to display 
	 * it properly.
	 * @param player Player object
	 */
	public void updatePlayer(Player player) {
		super.updatePlayer(player);
	}

	private void decompress(String compressed) {
		String[] splits = compressed.split("\\*");
		decompressChests(splits);
	}

	private void decompressChests(String[] splits) {
		String[] chests = splits[1].split("\\(");
		ArrayList<String[]> chestList = new ArrayList<String[]>();
		for (int i = 0; i < chests.length; i++) {
			chestList.add(chests[i].split(";"));

			System.out.println(chests[i]);
		}
		String[][] placeholder = new String[chestList.size()][];
		chestList.toArray(placeholder);

		ArrayList<String> statesList = new ArrayList<String>();
		//ArrayList<String> positionList = new ArrayList<String>();
		for (int i = 0; i < placeholder.length; i++) {
			statesList.add(placeholder[i][0]);
			for (int q = 0; q < placeholder[i].length; q++) {
				System.out.println(placeholder[i][q]);
			}
		}
		String[] states = new String[chests.length];
		statesList.toArray(states);
		/*for (int i = 0; i < states.length; i++) {
			System.out.println(states[i]);
		}*/
	}
}
