import java.util.Hashtable;

public class Room {
	private Hashtable<String, User> users = new Hashtable<>();
	private Hashtable<Integer, Msg> messages = new Hashtable<>();
	private int IDSalon;
	@SuppressWarnings("unused")
	private boolean isPrivate;
	
	//constructor for room creation
	public Room(User u,int id) {
		this.users.put(u.getNom(), u);
		this.IDSalon=id;
	}
	public Room(User u, Msg m, int id) {
		this.users.put(u.getNom(), u);
		this.messages.put(m.getPosition(), m);
		this.IDSalon=id;
	}
	
	public void setIDSalon(int id) { this.IDSalon=id;}
	public int gtIDsalon() {return this.IDSalon;}
	
	public void addMsg(Msg m) { 
		this.messages.put(m.getPosition(), m);
	}
	public void addUser(User u) {
		this.users.put(u.getNom(), u);
	}
	
}
