import java.util.Hashtable;

public interface ClientInterface {
	public void addRoom(User user, int id, String name);
	public User login(String userName);
	public User getUser();
	public void setUser(User user);
	public Hashtable<Integer, Room> getRooms();
	public void getIntoRoom(int roomId, int oldRoomId, User u, int positionMsg);
}
