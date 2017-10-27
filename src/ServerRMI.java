import java.rmi.*;
import java.util.*;

public class ServerRMI {
	
	public static void main(String[] argv) {
		try {
			//System.setSecurityManager(new RMISecurityManager());
			Scanner s = new Scanner(System.in);
			System.out.println("enter your name");
			String name = s.nextLine().trim();
			Chat server = new Chat(name);
			Naming.bind("rmi://localhost/abc",  server);
			System.out.println("system : Chat Remote Object is ready:");
			while(true) {
				String msg=s.nextLine().trim();
				if(server.getClient()!=null) {
					ChatInterface client = server.getClient();
					msg = "["+server.getName()+"]"+msg;
					client.send(msg);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("server failed!");
			e.printStackTrace();
		}
	}

}
