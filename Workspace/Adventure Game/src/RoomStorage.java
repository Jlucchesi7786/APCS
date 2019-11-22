import java.util.*;

public class RoomStorage {
	Room[] rooms;
	int currentRoom;
	final Room[] defaultRoom = {new Room()};
	
	public RoomStorage() {
		rooms = defaultRoom;
	}
	
	public RoomStorage(Room[] rooms) {
		ArrayList<Room> roomlist = new ArrayList<Room>();
		for (Room item: rooms) {
			roomlist.add(item);
		}
		this.rooms = new Room[roomlist.size()];
		roomlist.toArray(this.rooms);
	}

	public int index() {
		return currentRoom;
	}
	
	public Room[] getRooms() {
		return rooms;
	}
	
	public Room getRoom(int index) {
		this.currentRoom = index;
		return rooms[index];
	}
}
