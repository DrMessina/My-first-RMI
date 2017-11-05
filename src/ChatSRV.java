import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

public class ChatSRV extends UnicastRemoteObject implements InterfaceChatSRV{

	private static final long serialVersionUID = 7699384301633005058L;
	
	private Hashtable<Integer, Room> rooms;
	private Hashtable<String, User> allUsers;
	
	
	public Hashtable<Integer, Room> getRooms() throws RemoteException {
		return rooms;
	}

	public ChatSRV() throws RemoteException{
		rooms = new Hashtable<>();
		allUsers = new Hashtable<>();
	}

	@Override
	public void addRoom(User u,int id, String name) throws RemoteException {
		Room r = new Room(u,id,name);
		rooms.put(id, r);
		System.out.println(name);
	}

	@Override
	public void addGlobalUser() throws RemoteException {
		// TODO Auto-generated method stub
	}

	@Override
	public void getIntoRoom(int roomId, int oldRoomId, User u, int positionMsg) throws RemoteException {
		System.out.println("On server");
		System.out.println(roomId);
		System.out.println(oldRoomId);
		if (oldRoomId != roomId) {
			quitRoom(oldRoomId, u.getNom(), positionMsg);
			System.out.println(u.getNom());
		}
		if(this.rooms.containsKey(roomId)) {
			rooms.get(roomId).addUser(u);
		}
	}

	
	@Override
	public void sendMsg(Msg m, int roomId) throws RemoteException {
		rooms.get(roomId).addMsg(m);
	}
	

	@Override
	public void inviteUser(User userAllow,int roomId) throws RemoteException {
		if(this.allUsers.contains(userAllow)) {
			rooms.get(roomId).addUser(userAllow);
		}
	}
	

	@Override
	public Msg getMsg() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(User u) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitRoom(int roomId, String nom, int positionMsg) throws RemoteException {
		rooms.get(roomId).setLastCheck(nom, positionMsg);
	}



}
