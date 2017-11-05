import java.io.Serializable;
import java.util.Hashtable;

public class Room implements Serializable {
	private static final long serialVersionUID = 2833701869083276152L;
	
	private Hashtable<String, User> users = new Hashtable<>();
	private Hashtable<Integer, Msg> messages = new Hashtable<>();
	private Hashtable<String, Integer> lastCheck = new Hashtable<>();
	private int IDSalon;
	private String name;
	private boolean isPrivate;
	
	//constructor for room creation
	public Room(User u,int id, String name) {
		this.users.put(u.getNom(), u);
		this.IDSalon=id;
		this.name = name;
		lastCheck.put(u.getNom(), 0);
	}

	public Hashtable<String, User> getUsers() {
		return users;
	}

	//second constructeur
	public Room(User u, Msg m, int id) {
		this.users.put(u.getNom(), u);
		this.messages.put(m.getPosition(), m);
		this.IDSalon=id;
		lastCheck.put(u.getNom(), 0);
	}
	//on obtiens le nom de la room
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//on obtiens la derniere interaction
	public int getLastUserCheck(String nom) {
		return lastCheck.get(nom);
	}
	//definir la derniere interaction
	public void setLastUserCheck(String nom,int positionMsg) {
		this.lastCheck.put(nom, positionMsg);
	}
<<<<<<< HEAD
	
	public Hashtable<Integer, Msg> getMessages() {
		return messages;
	}
	public Hashtable<String, Integer> getLastCheck() {
		return lastCheck;
	}
	
	public void setLastCheck(Hashtable<String, Integer> lastCheck) {
		this.lastCheck = lastCheck;
	}
	//retourne  si oui ou non la room est privée
=======
	//retourne  si oui ou non la room est privï¿½e
>>>>>>> 212dc4d03779d0d696d677299ec517997f267742
	public boolean getIsPrivate() {
		return isPrivate;
	}
	//defini si une room est privï¿½
	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}
	//redefini l'id du salon
	public void setIDSalon(int id) {
		this.IDSalon=id;}
	//renvoie l'id du salon
	public int gtIDsalon() {
		return this.IDSalon;}
	//ajoute un msg dans la room
	public void addMsg(Msg m) { 
		this.messages.put(m.getPosition(), m);
	}
	//ajoute un user dans la room
	public void addUser(User u) {
		System.out.println(u.getNom() + " added to room");
		this.users.put(u.getNom(), u);
	}
	
	
}
