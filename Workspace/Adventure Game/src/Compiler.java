import java.util.*;

public class Compiler {
	public Chest[] Chests = {new Chest(1, 30), new Chest(30, 19), new Chest(1, 1), new Chest(30, 2), new Chest(5, 5), new Chest(26, 15)};
	public Tile[][] map = {};
	public Wall[] walls = {new Wall("vertical", 30, 6, 1), new Wall("horizontal", 5, 1, 4), new Wall("horizontal", 25, 6, 14)};
	public Player player;

	private int width;
	private int height;

	public Compiler(int width, int height) {
		this.width = width;
		this.height = height;
		compileTiles();
	}

	public Compiler() {
		compileTiles();
	}

	public void compileTiles() {
		ArrayList<Tile[]> mapList = new ArrayList<Tile[]>();
		for (int column = 0; column < width; column++) {
			ArrayList<Tile> columnList = new ArrayList<Tile>();
			if (column == 0 || column == width-1) {
				for (int h = 0; h < height; h++) {
					columnList.add(new Tile("wall"));
				}
			} else {
				for (int h = 0; h < height; h++) {
					Position gridPos = new Position(column, h);
					if (h == 0 || h == height-1) {
						columnList.add(new Tile("wall"));
					} else {
						boolean added = false;
						for (int i = 0; i < Chests.length; i++) {
							if (Chests[i].pos.equals(gridPos)) {
								columnList.add(Chests[i].space);
								added = true;
							}
						}

						for (int i = 0; i < walls.length; i++) {
							if (walls[i].checkSpaces(gridPos) && !added) {
								columnList.add(walls[i].space);
								added = true;
							}
						}

						if (!added) {
							columnList.add(new Tile("empty"));
						}
					}
				}
			}
			Tile[] columnArray = new Tile[columnList.size()];
			columnList.toArray(columnArray);
			mapList.add(columnArray);
		}
		map = new Tile[mapList.size()][];
		mapList.toArray(map);
	}
}
