import java.util.HashMap;

public class Room {
	
	private int idRoom;
	private boolean isPrivate;
	private HashMap<Integer, Client> tabUsers;
	private HashMap<Integer, Msg> tabMsg;
	
	public Room(int idRoom, boolean isPrivate, HashMap<Integer, Client> tabUsers, HashMap<Integer, Msg> tabMsg) {
		super();
		this.tabUsers = tabUsers;
		this.tabMsg = tabMsg;
		this.idRoom = idRoom;
		this.isPrivate = isPrivate;
	}

	public HashMap<Integer, Client> getTabUsers() {
		return tabUsers;
	}

	public void setTabUsers(HashMap<Integer, Client> tabUsers) {
		this.tabUsers = tabUsers;
	}

	public HashMap<Integer, Msg> getTabMsg() {
		return tabMsg;
	}

	public void setTabMsg(HashMap<Integer, Msg> tabMsg) {
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
