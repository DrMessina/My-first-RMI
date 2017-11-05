import java.io.Serializable;
import java.net.InetAddress;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
/**
 * Classe de demarrage du server RMI
 * @author Landry & Hendrik
 */
public class ServerRMI implements Serializable {
	private static final long serialVersionUID = 6479220762872517522L;
	
	/**
	 * Main de lancement du serveur: </br>
	 * on instancie la classe distante</br>
	 * on lance le registre RMI
	 * 
	 * @param argv
	 */
	public static void main(String[] argv) {
		try {			
			//lancement du registre de nom RMI(ne se fait qu'une seule fois
			LocateRegistry.createRegistry(1099);
			//instanciation de la classe distante
			ChatSRV chatSRV = new ChatSRV();
			//enregistrement dans le registre de noms RMI
			Naming.rebind("rmi://" + InetAddress.getLocalHost().getHostAddress() + "/TestRMI", chatSRV);
			System.out.println("server started");
		
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("server failed!");
			e.printStackTrace();
		}
	}

}
