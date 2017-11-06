import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;
/**
 * 
 * @author Landry &  Hendrik
 *
 */
public class ChatSRV extends UnicastRemoteObject implements InterfaceChatSRV{
	/**
	 * Version de serialisation de la classe.<br>
	 * Il est autogeneré et unique. 
	 */
	private static final long serialVersionUID = 7699384301633005058L;
	/**
	 * liste de toutes les rooms.<br>
	 * 
	 * @see ChatSRV#addRoom(User, int, String, boolean)
	 * @see ChatSRV#changeRoom(int, int, User, int)
	 * @see ChatSRV#getIntoRoom(int, int, User, int)
	 * @see ChatSRV#getRooms()
	 * @see ChatSRV#quitRoom(int, String, int)
	 * @see	ChatSRV#disconnect(User)
	 */
	private Hashtable<Integer, Room> rooms;
	/**
	 * liste de tout les ustilisateurs du system.<br>
	 * 
	 * @see ChatSRV#addGlobalUser(User, String)
	 * @see ChatSRV#inviteUser(User, int)
	 */
	private Hashtable<String, User> allUsers;
	
	/**
	 * retourne la table de rooms
	 * @return
	 * 		retourne une hashTable contenant tout les utilisateurs.
	 */
	public Hashtable<Integer, Room> getRooms() throws RemoteException {
		return rooms;
	}
	/**
	 * constructeur  ChatSRV
	 * 
	 * @throws RemoteException
	 * 		gere les exception RMI
	 */
	public ChatSRV() throws RemoteException{
		rooms = new Hashtable<>();
		allUsers = new Hashtable<>();
		rooms.clear();
		allUsers.clear();
	}

	/**
	 * ajout d'un salon.
	 * 
	 * @param u
	 * 		utilisateur.
	 * @param id
	 * 		id du salon.
	 * @param roomName
	 * 		nom du salon.
	 * @param isPrivate
	 * 		defini si le salon est privée ou non.
	 */
	public void addRoom(User u,int id, String roomName, boolean isPrivate) throws RemoteException {
		Room r = new Room(u,id,roomName, isPrivate);
		
		rooms.put(id, r);
		System.out.println(roomName);
		System.out.println(allUsers.toString());
	}
	/**
	 * ajout  d'un utilisateur a la liste globale d'utilisateur
	 * 
	 * @param user
	 * 		utilisateur.
	 * @param u
	 * 		nom d'utilisateur.
	 */
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
	/**
	 * permet de quitter d'une room à une autre.
	 * @param roomId
	 * 		identifiant de la room à rejoindre
	 * @param oldRoomId
	 * 		identifiant de l'ancien salon
	 * @param u 
	 * 		utilisateur qui crée la room
	 * @param positionMsg
	 * 		position du msg dans le chat.
	 */
	public void changeRoom(int roomId, int oldRoomId, User u, int positionMsg) throws RemoteException {
		if (oldRoomId != roomId) {
			quitRoom(oldRoomId, u.getNom(), positionMsg);
			System.out.println(u.getNom());
		}else{
			return;
		}
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
	/**
	 * permet d'entre dans un salon apres la connexion
	 * 
	 * @param roomId
	 * 		identifiant du salon
	 * @param u
	 * 			utilisateur
	 * @param positionMsg
	 * 		position du msg	
	 */
	public void getIntoRoom(int roomId, int oldRoomId, User u, int positionMsg) throws RemoteException {
		System.out.println("On server");
		System.out.println(roomId);
		System.out.println(oldRoomId);
		if (oldRoomId != roomId) {
			quitRoom(oldRoomId, u.getNom(), positionMsg);
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
	/**
	 * permet d'envoyer le message.
	 * @param m
	 * 		message.
	 * @param roomId
	 * 		id du salon.
	 */
	@Override
	public void sendMsg(Msg m, int roomId) throws RemoteException {
		rooms.get(roomId).addMsg(m);
	}
	
	/**
	 * ajout d'un utilisateur  dans un salon privée.
	 * @param userAllow
	 * 		utilisateur autorisé.
	 * @param roomId
	 * 		identifiant du salon privé.
	 */
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
	
	/**
	 * recevoir les messages d'un salon
	 * @param position
	 * 		position du message dans le chat
	 * @param roomId
	 * 		identifiant du salon
	 */
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
	/**
	 * deconnexion de l'utilisateur et supression des salons.
	 * 
	 * @param u
	 * 		utilisateur.
	 */
	@Override
	public void disconnect(User u) throws RemoteException {
		allUsers.remove(u.getNom());
		for (int i=0;i<rooms.size();i++) {
			Hashtable<String, User> users=rooms.get(i).getUsers();
			System.out.println(users.get(u.getNom()));
			if(users.containsKey(u.getNom())) {
				rooms.get(i).removeUser(u);
				if(rooms.get(i).getIsPrivate()) {
					if(rooms.get(i).getUsers().size()<1) {
						rooms.remove(i);
					}
				}
			}
		}
	}
	/**
	 * definit le dernier point d'interaction lorsqu'on quitte un salon.
	 * @param roomId
	 * 		identifiant du salon
	 * @param nom
	 * 		nom de l'utilisateur.
	 * @param positionMsg
	 * 		position du message dans le chat à quitter.
	 */
	@Override
	public void quitRoom(int roomId, String nom, int positionMsg) throws RemoteException {
		rooms.get(roomId).setLastUserCheck(nom, positionMsg);
	}

}
