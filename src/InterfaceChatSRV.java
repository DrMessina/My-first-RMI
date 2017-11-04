import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Hashtable;

public interface InterfaceChatSRV extends Remote{
	
	public void addRoom(User u, int id, String name) throws RemoteException;
	public void addGlobalUser() throws RemoteException;
	public void getIntoRoom(int roomId, int oldRoomId, User u, int positionMsg) throws RemoteException;
	public void sendMsg(Msg m, int roomId) throws RemoteException;
	public void inviteUser(User userAllow,int roomId) throws RemoteException;
	public Msg getMsg() throws RemoteException;
	public void removeUser(User u) throws RemoteException;
	public void quitRoom(int idRoom, String nom, int positionMsg)throws RemoteException;
	public Hashtable<Integer, Room> getRooms() throws RemoteException;
	public void setRooms(Hashtable<Integer, Room> rooms) throws RemoteException;
}
