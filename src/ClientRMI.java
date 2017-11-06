import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.Timer;
/**
 * Classe lien avec le serveur.
 * @author Landry & Hendrik
 *
 */
public class ClientRMI extends UnicastRemoteObject implements ClientInterface{
	
	/**
	 * Version de serialisation de la classe.<br>
	 * Il est autogeneré et unique.
	 */
	private static final long serialVersionUID = 7699384301633005058L;
	/**
	 * Instance de l'interface GUI
	 */
	GUIInterface chatGUIInterface;
	/**
	 * instance de l'objet du registre rmi
	 */
	InterfaceChatSRV serverInterface;
	/**
	 * utilisateur
	 */
	User user;
	/**
	 * temps pour la mise à jour de l'affichage
	 */
	Timer timer;

	/**
	 * constructeur du Client RMI
	 * @throws RemoteException
	 * 		gere les erreurs RMI
	 */
public ClientRMI() throws RemoteException{
        	chatGUIInterface = new Chat_GUI(this);   
        	
        	try {
				serverInterface = (InterfaceChatSRV) Naming.lookup("rmi://" + InetAddress.getLocalHost().getHostAddress() + "/TestRMI");
			} catch (MalformedURLException | RemoteException | UnknownHostException | NotBoundException e) {
				chatGUIInterface.setServerError();
				e.printStackTrace();
			}
}
/**
 * main du client RMI
 * @param argv
 */
public static void main(String[] argv) {
	try {
		new ClientRMI();
	} catch (Exception e) {
		System.err.println("Can't open program:");
        e.printStackTrace();
        System.exit(1);
	}
		
}

/**
 * crée un user a partir de l'input du client
 * @param username
 * 		nom de l'utilisateur
 */
public User login(String userName) {
        		user = new User(userName);
        		System.out.println(userName + " logged in");
        		return user;
}

/**
 * ajoute une room à l'interface et crée une room sur l'objet remote.
 * 
 * @param user
 * 		utilisteur.
 * @param id 
 * 		id du salon de discussion.
 * @param roomName
 * 		nom du salon de discussion.
 * @param isprivate
 * 		defini si le salon est privée ou non.
 */
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
/**
 * retourn l'utilisateur.
 * @return
 * 		retourne un objet user.
 */
public User getUser() {
	return user;
}
/**
 * met à jour l'objet user.
 */
public void setUser(User user) {
	this.user = user;
}
/**
 * retourne tout les salon disponible.
 * @return
 * 		retoune une hashtable contenant touts les users.
 * 
 */
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

/**
 * permet d'entrer dans un salon de discussion
 */
public void getIntoRoom(int roomId, int oldRoomId, User u, int positionMsg) {
	try {
		serverInterface.getIntoRoom(roomId, oldRoomId, u, positionMsg);
		System.out.println("Got into room " + roomId);
	} catch (RemoteException e) {
		System.out.println("Didn't got into room");
		e.printStackTrace();
	}
}
/**
 * retourne l'array qui contient les messages.
 * @return 
 * 		arrayList comprenant la lister des messagges.
 */
public ArrayList<String> getMsg(int position, int roomId) {
	try {
		return serverInterface.getMsg(position, roomId);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
/**
 * envoye d'un msg ddans la banque de données.
 * @param m
 * 		messag à envoyer.
 */
public void sendMsg(Msg m, int roomId) {
	try {
		serverInterface.sendMsg(m, roomId);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/**
 * met a jour l'interface  utilisateur.
 * 
 */
public void update () {
	timer =	new Timer (delay,update);
	timer.start();
}

int delay = 3000;
/**
 * event listener pour declencher l'update periodiquement.
 */
ActionListener update = new ActionListener() {
	public void actionPerformed(ActionEvent evt) {
		chatGUIInterface.update();
	}
};
/**
 * ajout d'un utilisateur.
 * 
 * @param u
 * 		nom de l'utilisateur.
 */
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
/**
 *  ajout d'un utilisateur das une room privée.
 *  @param userAllow
 *  	utilisateur autorisé dans le salon privé
 *  @param roomId
 *  	identifiant de la room
 */
public boolean inviteUser(User userAllow,int roomId) {
	try {
		return serverInterface.inviteUser(userAllow, roomId);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}
/**
 * deconnecte l'user lors de la fermeture de la fenetre
 * @param u
 * 		utilisateur àdeconnecter.
 */
public void disconnect(User u) {
	try {
		//System.out.println("lolilol");
		serverInterface.disconnect(u);
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
