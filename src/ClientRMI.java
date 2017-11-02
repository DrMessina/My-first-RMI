import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class ClientRMI {
	
	GUIInterface chatGUI;
	InterfaceChatSRV serverInterface;

public ClientRMI() {
	chatGUI = new Chat_GUI();
	
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
        	chatGUI.createInputInterface("login");
        	try {
				 serverInterface = (InterfaceChatSRV) Naming.lookup("rmi://" + InetAddress.getLocalHost().getHostAddress() + "/TestRMI");
			} catch (MalformedURLException | RemoteException | UnknownHostException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    });
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

public void addRoom(String userName, int id) {
	User user = new User(userName);
	
	try {
		serverInterface.addRoom(user, id);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	/*public Chat_client() {
		
		chatGUI = new Chat_GUI();
		
		
		// connect server
	}*/

}
