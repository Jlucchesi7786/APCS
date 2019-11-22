import java.util.*;

public class FrameCompiler {
	private Chest[] chests;
	private Wall[] walls;
	private Door[] doors;
	private Player player;
	public Room[] rooms;
	
	private RoomStorage storerooms = new RoomStorage();

	private int width;
	private int height;

	public Tile[][] map;
	public Tile[][][] maps;

	public FrameCompiler(Room[] rooms) {
		rooms = storerooms.getRooms();
		this.rooms = rooms;
		ArrayList<Chest> ChestsList = new ArrayList<Chest>();
		ArrayList<Wall> WallsList = new ArrayList<Wall>();
		ArrayList<Door> DoorsList = new ArrayList<Door>();
		ArrayList<Tile[][]> mapsList = new ArrayList<Tile[][]>();
		
		for (int i = 0; i < rooms.length; i++) {
			mapsList.add(rooms[i].getMap());
			
			for (int q = 0; q <rooms[i].getChests().length; q++) {
				ChestsList.add(rooms[i].getChests()[q]);
				rooms[i].getChests()[q].pos.init(rooms, i);
			}
			for (int q = 0; q < rooms[i].getWalls().length; q++) {
				WallsList.add(rooms[i].getWalls()[q]);
				for (int z = 0; z < rooms[i].getWalls()[q].getSpaces().length; z++) {
					rooms[i].getWalls()[q].getSpaces()[z].init(rooms, i);
				}
			}
			for (int q = 0; q < rooms[i].getDoors().length; q++) {
				DoorsList.add(rooms[i].getDoors()[q]);
				rooms[i].getDoors()[q].pos.init(rooms, i);
			}
			
			width += rooms[i].width;
			height += rooms[i].height;
		}
		
		maps = new Tile[mapsList.size()][][];
		mapsList.toArray(maps);
		
		chests = new Chest[ChestsList.size()];
		ChestsList.toArray(chests);

		walls = new Wall[WallsList.size()];
		WallsList.toArray(walls);

		doors = new Door[DoorsList.size()];
		DoorsList.toArray(doors);
		
		player = new Player();

		makeMap();
	}

	public void makeMap() {
		ArrayList<Tile[]> mapList = new ArrayList<Tile[]>();
		for (int q = 0; q < maps.length; q++) {
			for (int x = 0; x < rooms[q].width; x++) {
				ArrayList<Tile> rowList = new ArrayList<Tile>();
				
				for (int y = 0; y < rooms[q].height; y++) {
					rowList.add(maps[q][x][y]);
				}
				
				Tile[] rowArray = new Tile[rowList.size()];
				rowList.toArray(rowArray);
				mapList.add(rowArray);
			}
		}
		/*for (int q = 0; q < allrooms.length; q++) {
			int b = 0;
			int c = 0;
			if (q > 0) {
				b += allrooms[q].width;
				c += 0;
			}

			for (int x = b; x < allrooms[q].width+b; x++) {
				ArrayList<Tile> rowList = new ArrayList<Tile>();
				for (int y = c; y < allrooms[q].height+c; y++) {
					if (y == c || y == allrooms[q].height-1+c) {
						rowList.add(new Tile("wall"));
					} else {
						Position gridPos = new Position(x+b, y+c);
						//System.out.println(gridPos);
						if (x == 0 || x == allrooms[q].width-1) {
							rowList.add(new Tile("wall"));
						} else {
							boolean added = false;

							for (int w = 0; w < chests.length; w++) {
								if (chests[w].pos.equals(gridPos)) {
									rowList.add(chests[w].space);
									added = true;
								}
							}

							if (player.pos.equals(gridPos)) {
								rowList.add(player.space);
								added = true;
							}

							for (int w = 0; w < doors.length; w++) {
								if (doors[w].pos.equals(gridPos) && !added) {
									rowList.add(doors[w].space);
									added = true;
								}
							}

							for (int w = 0; w < walls.length; w++) {
								if (walls[w].checkSpaces(gridPos) && !added) {
									rowList.add(walls[w].space);
									added = true;
								}
							}

							if (!added) {
								rowList.add(new Tile("empty"));
							}
						}
					}
				}

				//System.out.println(x);
				Tile[] rowArray = new Tile[rowList.size()];
				rowList.toArray(rowArray);
				mapList.add(rowArray);
			}
		}*/
		map = new Tile[mapList.size()][];
		mapList.toArray(map);
	}

	public void update(Player player) {
		System.out.println("updating frame");
		this.player = player;
		makeMap();
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

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
