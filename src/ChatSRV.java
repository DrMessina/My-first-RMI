import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
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
	public void addGlobalUser(User u) throws RemoteException {
		allUsers.put(u.getNom(), u);
	}

	@Override
	public void changeRoom(int roomId, int oldRoomId, User u, int positionMsg) throws RemoteException {
		quitRoom(oldRoomId, u.getNom(), positionMsg);
		if(this.rooms.containsKey(roomId)) {
			rooms.get(roomId).addUser(u);
			Hashtable<String, Integer>lastCheck =rooms.get(roomId).getLastCheck();
			if(lastCheck.contains(u.getNom())) {
				getMsg(positionMsg,roomId);
			}else{			
				rooms.get(roomId).setLastUserCheck(u.getNom(), (lastCheck.size()-1));
				getMsg(rooms.get(roomId).getLastUserCheck(u.getNom()),roomId);
			}
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
	public ArrayList<String> getMsg(int position, int roomId) throws RemoteException {
		ArrayList<String> msg = new ArrayList<>();
		Room r =rooms.get(roomId);
		Hashtable<Integer, Msg> msgTable= r.getMessages(); 
		int i=position;
		while(i<msgTable.size()) {
			msg.add(msgTable.get(i).getMessage());
			i++;
		}
		return msg;
	}

	@Override
	public void removeUser(User u) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitRoom(int roomId, String nom, int positionMsg) throws RemoteException {
		rooms.get(roomId).setLastUserCheck(nom, positionMsg);
	}

	@Override
	public void getIntoRoom(int roomId, User u, int positionMsg) throws RemoteException {
		
	}

}
