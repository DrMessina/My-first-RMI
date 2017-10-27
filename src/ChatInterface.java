import java.rmi.RemoteException;

public interface ChatInterface {
	
	public String getName()throws RemoteException;
	public void send(String msg)throws RemoteException;
	public void setClient(ChatInterface c)throws RemoteException;
	public ChatInterface getClient() throws RemoteException;

}
