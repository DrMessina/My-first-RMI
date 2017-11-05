import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.Timer;

public class ClientRMI extends UnicastRemoteObject implements ClientInterface{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7699384301633005058L;
	GUIInterface chatGUIInterface;
	InterfaceChatSRV serverInterface;
	User user;
	Timer timer;

	
public ClientRMI() throws RemoteException{
        	chatGUIInterface = new Chat_GUI(this);   
        	
        	try {
				serverInterface = (InterfaceChatSRV) Naming.lookup("rmi://" + InetAddress.getLocalHost().getHostAddress() + "/TestRMI");
			} catch (MalformedURLException | RemoteException | UnknownHostException | NotBoundException e) {
				chatGUIInterface.setServerError();
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

public User login(String userName) {
        		user = new User(userName);
        		System.out.println(userName + " logged in");
        		return user;
}


public void addRoom(User user, int id, String roomName, boolean isPrivate) {
	
	try {
		serverInterface.addRoom(user, id, roomName, isPrivate);
		System.out.println("add room " + roomName);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		System.out.println("didn't add room" + roomName);
		e.printStackTrace();
	}
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Hashtable<Integer, Room> getRooms() {
	try {
		System.out.println("Rooms gotten");
		return serverInterface.getRooms();
	} catch (RemoteException e) {
		e.printStackTrace();
		System.out.println("Rooms not gotten");
		return null;
	}
	
}


public void getIntoRoom(int roomId, int oldRoomId, User u, int positionMsg) {
	try {
		serverInterface.getIntoRoom(roomId, oldRoomId, u, positionMsg);
		System.out.println("Got into room " + roomId);
	} catch (RemoteException e) {
		System.out.println("Didn't got into room");
		e.printStackTrace();
	}
}

public ArrayList<String> getMsg(int position, int roomId) {
	try {
		return serverInterface.getMsg(position, roomId);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

public void sendMsg(Msg m, int roomId) {
	try {
		serverInterface.sendMsg(m, roomId);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void update () {
	timer =	new Timer (delay,update);
	timer.start();
}

int delay = 3000;
ActionListener update = new ActionListener() {
	public void actionPerformed(ActionEvent evt) {
		chatGUIInterface.update();
	}
};

public boolean addGlobalUser(String u) {
	
	try {
		user = new User (u);
		if (serverInterface.addGlobalUser(user, u)) {
			return true;
		}
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}

	/*public Chat_client() {
		
		chatGUI = new Chat_GUI();
		
		
		// connect server
	}*/

}
