import java.util.*;

public class Compiler {
	public Chest[] Chests = {new Chest(new Position(1, 30)), new Chest(30, 19), new Chest(1, 1), new Chest(30, 2), new Chest(5, 5), new Chest(26, 15)};
	public Tile[][] map = {};
	public Wall[] walls = {new Wall("vertical", 30, 6, 1), new Wall("horizontal", 5, 1, 4), new Wall("horizontal", 25, 6, 14), new Wall("vertical", 30, 25, 1)};
	public Door[] doors = {new Door(new Position(6, 2), "unlocked", "vertical")};
	public Player player;

	private int width;
	private int height;

	public Compiler(int width, int height, Player player) {
		this.width = width;
		this.height = height;
		this.player = player;
		compileTiles();
	}

	public Compiler() {
		compileTiles();
	}

	public void compileTiles() {
		ArrayList<Tile[]> mapList = new ArrayList<Tile[]>();
		int i = 0;
		int a = 0;
		for (int y = 0; y < height; y++) {
			ArrayList<Tile> rowList = new ArrayList<Tile>();
			for (int x = 0; x < width; x++) {
				if (x == 0 || x == width-1) {
					rowList.add(new Tile("wall"));
					a++;
				} else {
					Position gridPos = new Position(x, y);
					//System.out.println(gridPos);
					if (y == 0 || y == height-1) {
						rowList.add(new Tile("wall"));
						//System.out.println("yes");
						a++;
					} else {
						boolean added = false;

						for (int c = 0; c < Chests.length; c++) {
							if (Chests[c].pos.equals(gridPos)) {
								rowList.add(Chests[c].space);
								added = true;
								a++;
							}
						}

						if (player.pos.equals(gridPos)) {
							rowList.add(player.space);
							added = true;
							a++;
						}

						for (int c = 0; c < doors.length; c++) {
							if (doors[c].pos.equals(gridPos) && !added) {
								rowList.add(doors[c].space);
								added = true;
								a++;
							}
						}

						for (int c = 0; c < walls.length; c++) {
							if (walls[c].checkSpaces(gridPos) && !added) {
								rowList.add(walls[c].space);
								added = true;
								a++;
							}
						}

						if (!added) {
							rowList.add(new Tile("empty"));
							a++;
						}
					}
				}
				i++;
			}
			
			Tile[] rowArray = new Tile[rowList.size()];
			rowList.toArray(rowArray);
			mapList.add(rowArray);
			System.out.println(rowArray.length);
		}
		map = new Tile[mapList.size()][];
		mapList.toArray(map);
		System.out.println("big; " + map.length);
		
		System.out.println(i + " = " + a);
	}

	public void update(Player player) {
		this.player = player;
		compileTiles();
	}
}
