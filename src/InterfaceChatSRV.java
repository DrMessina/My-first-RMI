import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceChatSRV extends Remote{
	
	public void addRoom(User u, int id) throws RemoteException;
	public void addGlobalUser() throws RemoteException;
	public void getIntoRoom(int roomId,User u) throws RemoteException;
	public void sendMsg(Msg m, int roomId) throws RemoteException;
	public void inviteUser(User userAllow) throws RemoteException;
	public Msg getMsg() throws RemoteException;
	public void removeUser(User u) throws RemoteException;

}
