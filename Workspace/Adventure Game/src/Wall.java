import java.util.*;

public class Wall {
	public int length;
	public int xStart;
	public int yStart;
	public Position startPos;

	public boolean horizontal;
	public boolean vertical;

	public Tile space;
	public Position[] spaces = {};

	public Wall(String orientation, int length, int positionXstart, int positionYstart) {
		this(orientation, length, new Position(positionXstart, positionYstart));
	}
	
	public Wall(String orientation, int length, Position startPos) {
		this.length = length;
		this.xStart = startPos.x;
		this.yStart = startPos.y;
		this.startPos = startPos;
		space = new Tile("wall");

		if (orientation.equals("horizontal")) {
			horizontalSetup();

		} else if (orientation.equals("vertical")) {
			verticalSetup();
		}
	}

	private void horizontalSetup() {
		ArrayList<Position> spacesList = new ArrayList<Position>(); // makes an ArrayList
		spacesList.add(startPos);
		for (int i = 1; i < length; i++) {
			spacesList.add(new Position(startPos.x+i, startPos.y));
		}
		spaces = new Position[spacesList.size()];
		spacesList.toArray(spaces);
		
		horizontal = true;
		vertical = false;
	}

	private void verticalSetup() {
		ArrayList<Position> spacesList = new ArrayList<Position>(); // makes an ArrayList
		spacesList.add(startPos);
		for (int i = 1; i < length; i++) {
			spacesList.add(new Position(startPos.x, startPos.y+i));
		}
		spaces = new Position[spacesList.size()];
		spacesList.toArray(spaces);

		horizontal = false;
		vertical = true;
	}
	
	public boolean checkSpaces(int x, int y) {
		for (int i = 0; i < length; i++) {
			if (spaces[i].x == x && spaces[i].y == y) {
				return true;
			}
		}
		return false;
	}
	

	
	public boolean checkSpaces(Position other) {
		for (int i = 0; i < length; i++) {
			if (spaces[i].equals(other)) {
				return true;
			}
		}
		return false;
	}
}
