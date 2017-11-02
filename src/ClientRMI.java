
public class ClientRMI {
	
	GUIInterface chatGUI;
	
public ClientRMI() {
	chatGUI = new Chat_GUI();
	
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
        	chatGUI.createInputInterface("login");
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

	/*public Chat_client() {
		
		chatGUI = new Chat_GUI();
		
		
		// connect server
	}*/

}
