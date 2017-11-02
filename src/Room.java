import java.util.HashMap;
import java.util.Hashtable;

public class Room {
	
	private int idRoom;
	private boolean isPrivate;
	private Hashtable<Integer, Client> tabUsers;
	private Hashtable<Integer, Msg> tabMsg;
	
	public Room(int idRoom, boolean isPrivate, Hashtable<Integer, Client> tabUsers, Hashtable<Integer, Msg> tabMsg) {
		super();
		this.tabUsers = tabUsers;
		this.tabMsg = tabMsg;
		this.idRoom = idRoom;
		this.isPrivate = isPrivate;
	}

	public Hashtable<Integer, Client> getTabUsers() {
		return tabUsers;
	}

	public void setTabUsers(Hashtable<Integer, Client> tabUsers) {
		this.tabUsers = tabUsers;
	}

	public Hashtable<Integer, Msg> getTabMsg() {
		return tabMsg;
	}

	public void setTabMsg(Hashtable<Integer, Msg> tabMsg) {
		this.tabMsg = tabMsg;
	}

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	

}
