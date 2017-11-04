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
	public int getLastCheck(String nom) {
		return lastCheck.get(nom);
	}
	//definir la derniere interaction
	public void setLastCheck(String nom,int positionMsg) {
		this.lastCheck.put(nom, positionMsg);
	}
	//retourne  si oui ou non la room est priv�e
	public boolean getIsPrivate() {
		return isPrivate;
	}
	//defini si une room est priv�
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
		this.users.put(u.getNom(), u);
	}
	
	
}
