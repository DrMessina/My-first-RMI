import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientRMI extends UnicastRemoteObject implements ClientInterface{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GUIInterface chatGUIInterface;
	InterfaceChatSRV serverInterface;
	User user;

	
public ClientRMI() throws RemoteException{
        	chatGUIInterface = new Chat_GUI(this);
        	try {
				 serverInterface = (InterfaceChatSRV) Naming.lookup("rmi://" + InetAddress.getLocalHost().getHostAddress() + "/TestRMI");
			} catch (MalformedURLException | RemoteException | UnknownHostException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}

public static void main(String[] argv) {
	try {
		new ClientRMI();
	} catch (Exception e) {
		System.err.println("Can't open program:");
        e.printStackTrace();
        System.exit(1);
	}
		
	}

public void login(String userName) {
        		user = new User(userName);
        		System.out.println(userName);
}

public void addRoom(String userName, int id) {
	user = new User(userName);
	
	try {
		serverInterface.addRoom(user, id);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		System.out.println(userName);
		e.printStackTrace();
	}
}


	/*public Chat_client() {
		
		chatGUI = new Chat_GUI();
		
		
		// connect server
	}*/

}
