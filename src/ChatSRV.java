import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
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
		rooms.clear();
		allUsers.clear();
	}

	
	public void addRoom(User u,int id, String roomName, boolean isPrivate) throws RemoteException {
		Room r = new Room(u,id,roomName, isPrivate);
		
		rooms.put(id, r);
		System.out.println(roomName);
		System.out.println(allUsers.toString());
	}

	@Override
	public boolean addGlobalUser(User user, String u) throws RemoteException {
		if (allUsers.isEmpty()) {
			allUsers.put(u, user);
			return true;
		} else if (!allUsers.containsKey(u)) {
			allUsers.put(u, user);
			System.out.println("Added");
			return true;
		} 
		System.out.println("Not added");
		System.out.println(allUsers.toString());
		return false;
	}

	/*@Override
	public void getIntoRoom(int roomId, int oldRoomId, User u, int positionMsg) throws RemoteException {
		quitRoom(oldRoomId, u.getNom(), positionMsg);
	}*/

	public ArrayList<String> changeRoom(int roomId, int oldRoomId, User u) throws RemoteException {
		if (oldRoomId != roomId) {
			if(this.rooms.containsKey(roomId)) {
				Room actualRoom = rooms.get(roomId);
				if (!actualRoom.getUsers().containsKey(u.getNom())) {
					actualRoom.addUser(u);
					actualRoom.setLastUserCheck(u.getNom(),0);
					return getMsg(actualRoom.getLastUserCheck(u.getNom()),roomId);
				} else {
					return getMsg(actualRoom.getLastUserCheck(u.getNom()),roomId);
				}
				/*Hashtable<String, Integer>lastCheck =actualRoom.getLastCheck();
				if(lastCheck.contains(u.getNom())) {
					return getMsg(actualRoom.getLastUserCheck(u.getNom()),roomId);
				}else{			
					actualRoom.setLastUserCheck(u.getNom(), (lastCheck.size()-1));
					return getMsg(actualRoom.getLastUserCheck(u.getNom()),roomId);
				}*/
			}
			System.out.println(u.getNom());
		}else{
			return null;
		}
		return null;
	}
			
	public void getIntoRoom(int roomId, int oldRoomId, User u, int positionMsg) throws RemoteException {
		System.out.println("On server");
		System.out.println(roomId);
		System.out.println(oldRoomId);
		if (oldRoomId != roomId) {
			//quitRoom(oldRoomId, u.getNom(), positionMsg);
			System.out.println(u.getNom());
		}
		if(this.rooms.containsKey(roomId)) {
			Room actualRoom = rooms.get(roomId);
			if (!actualRoom.getIsPrivate()) {
				rooms.get(roomId).addUser(u);
				System.out.println("Added user server side");
			}
		}
	}

	@Override
	public void sendMsg(Msg m, int roomId) throws RemoteException {
		rooms.get(roomId).setLastUserCheck(m.getUser().getNom(), m.getPosition());
		rooms.get(roomId).addMsg(m);
	}
	

	@Override
	public boolean inviteUser(User userAllow,int roomId) throws RemoteException {
		if(this.allUsers.containsKey(userAllow.getNom())) {
			rooms.get(roomId).addUser(userAllow);
			System.out.println("invite user");
			return true;
		}
		System.out.println("invite user rejected");
		return false;
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
	public void disconnect(User u) throws RemoteException {
		allUsers.remove(u.getNom());
		for (int i=0;i<rooms.size();i++) {
			Hashtable<String, User> users=rooms.get(i).getUsers();
			System.out.println(users.get(u.getNom()));
			if (users.isEmpty()) {
				System.out.println("empty users");
			}
			if(users.containsKey(u.getNom())) {
				rooms.get(i).removeUser(u);
				if(rooms.get(i).getIsPrivate()) {
					if(rooms.get(i).getUsers().size()<1) {
						rooms.remove(i);
					}
				}
			} else {
				System.out.println("pas de nom");
			}
		}
	}

	/*@Override
	public void quitRoom(int roomId, String nom, int positionMsg) throws RemoteException {
		
		rooms.get(roomId).setLastUserCheck(nom, positionMsg);
		
	}*/

}
