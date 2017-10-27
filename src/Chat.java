import java.rmi.Remote;
import java.rmi.RemoteException;

public class Chat implements ChatInterface, Remote {
	
	private String name;
	public ChatInterface client=null;
	
	
	public Chat(String name) {
		this.name=name;
	}
	public String getName() throws RemoteException {
		return this.name;
	}
 
	public void setClient(ChatInterface c){
		client=c;
	}
 
	public ChatInterface getClient(){
		return client;
	}
 
	public void send(String s) throws RemoteException{
		System.out.println(s);
	}	
	

}
