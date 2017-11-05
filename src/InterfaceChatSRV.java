import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Hashtable;
<<<<<<< HEAD
/*public interface InterfaceChatSRV extends Remote{
	
	public void addRoom(User u, int id) throws RemoteException;
	public void addGlobalUser(User u) throws RemoteException;
	public void changeRoom(int roomId, int oldRoomId, User u, int positionMsg) throws RemoteException;
	public void getIntoRoom(int roomId, User u, int positionMsg) throws RemoteException;
*/
=======
>>>>>>> ff5f60718a041c3a0351f161e02226332821aa9f

public interface InterfaceChatSRV extends Remote{
	
	public void addRoom(User u, int id, String name) throws RemoteException;
	public void addGlobalUser(User u) throws RemoteException;
<<<<<<< HEAD
	public void getIntoRoom(int roomId, int oldRoomId, User u, int positionMsg) throws RemoteException;
=======
	public void getIntoRoom(int roomId, User u, int positionMsg) throws RemoteException;
>>>>>>> ff5f60718a041c3a0351f161e02226332821aa9f
	public void sendMsg(Msg m, int roomId) throws RemoteException;
	public void inviteUser(User userAllow,int roomId) throws RemoteException;
	public ArrayList<String> getMsg(int position, int roomId) throws RemoteException;
	public void removeUser(User u) throws RemoteException;
	public void quitRoom(int idRoom, String nom, int positionMsg)throws RemoteException;
	public Hashtable<Integer, Room> getRooms() throws RemoteException;
	void changeRoom(int roomId, int oldRoomId, User u, int positionMsg) throws RemoteException;
}
