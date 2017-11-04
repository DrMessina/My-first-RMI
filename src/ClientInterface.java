import java.util.Hashtable;

public interface ClientInterface {
	public void addRoom(User user, int id, String name);
	public void login(String userName);
	public User getUser();
	public void setUser(User user);
	public Hashtable<Integer, Room> getRooms();
}
