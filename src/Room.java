import java.util.Hashtable;

public class Room {
	private Hashtable<String, User> users = new Hashtable<>();
	private Hashtable<Integer, Msg> messages = new Hashtable<>();
	private Hashtable<String, Integer> lastCheck = new Hashtable<>();
	private int IDSalon;
	private boolean isPrivate;
	
	//constructor for room creation
	public Room(User u,int id) {
		this.users.put(u.getNom(), u);
		this.IDSalon=id;
		lastCheck.put(u.getNom(), 0);
	}
	//second constructeur
	public Room(User u, Msg m, int id) {
		this.users.put(u.getNom(), u);
		this.messages.put(m.getPosition(), m);
		this.IDSalon=id;
		lastCheck.put(u.getNom(), 0);
	}
	//on obtiens la derniere interaction
	public int getLastUserCheck(String nom) {
		return lastCheck.get(nom);
	}
	//definir la derniere interaction
	public void setLastUserCheck(String nom,int positionMsg) {
		this.lastCheck.put(nom, positionMsg);
	}
	
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
	public boolean getIsPrivate() {
		return isPrivate;
	}
	//defini si une room est privé
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
