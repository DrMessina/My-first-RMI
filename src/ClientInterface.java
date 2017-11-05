import java.util.ArrayList;
import java.util.Hashtable;

public interface ClientInterface {
	public void addRoom(User user, int id, String roomName);
	public User login(String userName);
	public User getUser();
	public void setUser(User user);
	public Hashtable<Integer, Room> getRooms();
	public void getIntoRoom(int roomId, int oldRoomId, User u, int positionMsg);
	public ArrayList<String> getMsg(int position, int roomId);
	public void sendMsg(Msg m, int roomId);
	public void update ();
	public boolean addGlobalUser(String user);
}
