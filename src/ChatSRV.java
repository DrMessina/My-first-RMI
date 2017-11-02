import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

public class ChatSRV extends UnicastRemoteObject implements InterfaceChatSRV {

	private static final long serialVersionUID = 3716834582298139732L;
	
	Hashtable<Integer, Room> rooms = new Hashtable<>();
	Hashtable<String, User> allUsers = new Hashtable<>();
	
	public ChatSRV() throws RemoteException{}

	@Override
	public void addRoom(User u,int id) throws RemoteException {
		Room r = new Room(u,id);
		rooms.put(id, r);
	}

	@Override
	public void addGlobalUser() throws RemoteException {
		// TODO Auto-generated method stub
	}

	@Override
	public void getIntoRoom(int roomId, int oldRoomId, User u, int positionMsg) throws RemoteException {
		quitRoom(oldRoomId, u.toString(), positionMsg);
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
