import java.rmi.Remote;
import java.rmi.RemoteException;
<<<<<<< HEAD
import java.util.ArrayList;

public interface InterfaceChatSRV extends Remote{
	
	public void addRoom(User u, int id) throws RemoteException;
	public void addGlobalUser(User u) throws RemoteException;
	public void changeRoom(int roomId, int oldRoomId, User u, int positionMsg) throws RemoteException;
	public void getIntoRoom(int roomId, User u, int positionMsg) throws RemoteException;
=======
import java.util.Hashtable;

public interface InterfaceChatSRV extends Remote{
	
	public void addRoom(User u, int id, String name) throws RemoteException;
	public void addGlobalUser() throws RemoteException;
	public void getIntoRoom(int roomId, int oldRoomId, User u, int positionMsg) throws RemoteException;
>>>>>>> 212dc4d03779d0d696d677299ec517997f267742
	public void sendMsg(Msg m, int roomId) throws RemoteException;
	public void inviteUser(User userAllow,int roomId) throws RemoteException;
	public ArrayList<String> getMsg(int position, int roomId) throws RemoteException;
	public void removeUser(User u) throws RemoteException;
	public void quitRoom(int idRoom, String nom, int positionMsg)throws RemoteException;
	public Hashtable<Integer, Room> getRooms() throws RemoteException;
}
