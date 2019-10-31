import java.util.*;

public class FrameCompiler extends Compiler {
	private Chest[] chests;
	private Wall[] walls;
	private Door[] doors;
	private Player player;
	private Room[] rooms;
	
	private int width;
	private int height;

	public Tile[][] map;
	
	public FrameCompiler(Room[] rooms) {
		this.rooms = rooms;
		ArrayList<Chest> ChestsList = new ArrayList<Chest>();
		ArrayList<Wall> WallsList = new ArrayList<Wall>();
		ArrayList<Door> DoorsList = new ArrayList<Door>();
		
		width = 0;
		height = 0;
		
		for (int i = 0; i < rooms.length; i++) {
			for (int q = 0; q <rooms[i].getChests().length; q++) {
				ChestsList.add(rooms[i].getChests()[q]);
			}
			for (int q = 0; q < rooms[i].getWalls().length; q++) {
				WallsList.add(rooms[i].getWalls()[q]);
			}
			for (int q = 0; q < rooms[i].getDoors().length; q++) {
				DoorsList.add(rooms[i].getDoors()[q]);
			}
			width += rooms[i].width;
			height += rooms[i].height;
			//System.out.println(rooms[i].compress());
		}
		chests = new Chest[ChestsList.size()];
		ChestsList.toArray(chests);
		
		walls = new Wall[WallsList.size()];
		WallsList.toArray(walls);
		
		doors = new Door[DoorsList.size()];
		DoorsList.toArray(doors);
		player = new Player();
		compileTiles();
	}

	public void compileTiles() {
		ArrayList<Tile[]> mapList = new ArrayList<Tile[]>();
		for (int x = 0; x < width; x++) {
			ArrayList<Tile> rowList = new ArrayList<Tile>();
			for (int y = 0; y < height; y++) {
				if (y == 0 || y == height-1) {
					rowList.add(new Tile("wall"));
				} else {
					Position gridPos = new Position(x, y);
					//System.out.println(gridPos);
					if (x == 0 || x == width-1) {
						rowList.add(new Tile("wall"));
					} else {
						boolean added = false;

						for (int c = 0; c < chests.length; c++) {
							if (chests[c].pos.equals(gridPos)) {
								rowList.add(chests[c].space);
								added = true;
							}
						}

						if (player.pos.equals(gridPos)) {
							rowList.add(player.space);
							added = true;
						}

						for (int c = 0; c < doors.length; c++) {
							if (doors[c].pos.equals(gridPos) && !added) {
								rowList.add(doors[c].space);
								added = true;
							}
						}

						for (int c = 0; c < walls.length; c++) {
							if (walls[c].checkSpaces(gridPos) && !added) {
								rowList.add(walls[c].space);
								added = true;
							}
						}

						if (!added) {
							rowList.add(new Tile("empty"));
						}
					}
				}
			}
			
			Tile[] rowArray = new Tile[rowList.size()];
			rowList.toArray(rowArray);
			mapList.add(rowArray);
		}
		map = new Tile[mapList.size()][];
		mapList.toArray(map);
	}
	
	public void updatePlayer(Player player) {
		this.player = player;
	}
	
	public Chest[] getChests() {
		return chests;
	}
	
	public Wall[] getWalls() {
		return walls;
	}
	
	public Door[] getDoors() {
		return doors;
	}
}
