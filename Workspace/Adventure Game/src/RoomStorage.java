import java.util.*;

public class RoomStorage {
	Room[] rooms;
	
	public RoomStorage() {
		ArrayList<Room> roomlist = new ArrayList<Room>();
		roomlist.add(new Room(2, 2));
		//roomlist.add(new Room(2, 2));
		rooms = new Room[roomlist.size()];
		roomlist.toArray(rooms);
	}

	public Room[] getRooms() {
		return rooms;
	}
	
	public Room getRoom(int roomnum) {
		return rooms[roomnum];
	}
}
