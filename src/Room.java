import java.io.Serializable;
import java.util.Hashtable;
/** 
 * Classe qui permet de crée un salon de discussion.
 * 
 * @author Landry & Hendrik
 */
public class Room implements Serializable {
	/**
	 * Version de serialisation de la classe.<br>
	 * Il est autogeneré et unique.<br>
	 */
	private static final long serialVersionUID = 2833701869083276152L;
	/**
	 * liste contenant les utilisateurs liés au salon d discussion.<br>
	 * 
	 * @see Room#addUser(User)
	 * @see Room#removeUser(User)
	 */
	private Hashtable<String, User> users = new Hashtable<>();
	private Hashtable<Integer, Msg> messages = new Hashtable<>();
	private Hashtable<String, Integer> lastCheck = new Hashtable<>();
	private int IDSalon;
	private String name;
	private boolean isPrivate;
	/**
	 * consteur permettant la cration d'une room.<br>
	 * 
	 * @param u
	 * 		variable represetant un utilisateur du salon.<br>
	 * @param id
	 * 		variable representant l'id du salon.<br>
	 * @param name
	 * 		variable representant le nom du salon.<br>
	 * @param isPrivate
	 * 		variable determinant si oui ou non le salon est privé.<br>
	 */
	public Room(User u,int id, String name, boolean isPrivate) {
		this.users.put(u.getNom(), u);
		this.IDSalon=id;
		this.name = name;
		this.messages.put(0, new Msg(null, "--- Welcome in room " + name + " ---",0));
		this.isPrivate = isPrivate;
		lastCheck.put(u.getNom(), 0);
	}
	/**
	 * permet de recuperer la liste des utilisateur de la room.<br>
	 * @return
	 * 		retourn un tabl contenant la liste de utilisateur avec comme clé leur nom d'utilisateur.<br>
	 */
	public Hashtable<String, User> getUsers() {
		return users;
	}

	/**
	 * second constructeur.
	 * 
	 * @param u
	 * 		utilisateur de la room.
	 * @param m
	 * 		Message envoyé par l'utilisateur.
	 * @param id
	 * 		id representant le salon.
	 */
	public Room(User u, Msg m, int id) {
		this.users.put(u.getNom(), u);
		this.messages.put(m.getPosition(), m);
		this.IDSalon=id;
		lastCheck.put(u.getNom(), 0);
	}
	/**
	 * on obtiens le nom de la room.<br>
	 * @return
	 * 		retourne un String represeantant le nom de la room.<br>
	 */
	public String getName() {
		return name;
	}
	/**
	 * met à jour le nom d'un utilisateur de la room.
	 * @param name
	 * 		nouveau nom de l'utilisateur.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * on obtiens la derniere interaction.
	 * @param nom
	 * 		nom de lutilisateur dont on doti renvoyer la position.
	 * @return
	 * 		un entier determinant la derniere fois où l'utilisateur à lu un mesage.
	 */
	public int getLastUserCheck(String nom) {
		return lastCheck.get(nom);
	}
	/**
	 * defini la derniere interaction d'un utilisateur dans le salon.
	 * @param nom
	 * 		nom de l'utilisateur.
	 * @param positionMsg
	 * 		position du message de la derniere intercation.
	 */
	public void setLastUserCheck(String nom,int positionMsg) {
		this.lastCheck.put(nom, positionMsg);
	}
	/**
	 * retourne toute la table des messages.
	 * 
	 * @return
	 * 		retourne une hastable dont la clé est la possition du messages.
	 */
	public Hashtable<Integer, Msg> getMessages() {
		return messages;
	}
	/**
	 * retourne la table des interaction des utilisateur.
	 * @return
	 * 		retourne une hastable des derniere iteraction des utilisateur du salon depuis leur derniere interaction.<br>
	 * 		
	 */
	public Hashtable<String, Integer> getLastCheck() {
		return lastCheck;
	}
	/**
	 * defini la tableu des dernieres interactions des utilisateurs.
	 * @param lastCheck
	 * 		tableau des dernieres interactions de l'utilisateur. 
	 */
	public void setLastCheck(Hashtable<String, Integer> lastCheck) {
		this.lastCheck = lastCheck;
	}
	/**
	 * retourne  si oui ou non la room est privé.
	 * @return
	 * 		retourne un boolean.<br>
	 *		si true: la room est privée.<br>
	 *		si false: la room est publique.<br>
	 */
	public boolean getIsPrivate() {
		return isPrivate;
	}
	/**
	 * met à jour si s-une room est privée ou non.
	 * @param isPrivate
	 * 		boolean determinant si la romm est privée ou non.<br>
	 */
	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}
	/**
	 * redefini l'id du salon.
	 * @param id
	 * 		nouvel id du salon
	 */
	public void setIDSalon(int id) {
		this.IDSalon=id;}
	/**
	 * renvoie l'id du salon.
	 * @return
	 * 		un entier  qui represente l'identifiant du salon.
	 */
	public int gtIDsalon() {
		return this.IDSalon;}
	/**
	 * ajoute un message dans la banque de messages de la room
	 * @param m
	 * 		message à ajouter dans la banque de messages.
	 */
	public void addMsg(Msg m) { 
		this.messages.put(m.getPosition(), m);
	}
	/**
	 * ajoute un ustilisateur dans la liste des utilisateurs du salon.
	 * @param u
	 * 		utilisateur à ajouter dans le salon.
	 */
	public void addUser(User u) {
		System.out.println(u.getNom() + " added to room");
		this.users.put(u.getNom(), u);
	}
	/**
	 * retire un utilisateur du salon.
	 * @param u
	 * 		utilisateur à retirer.
	 */
	public void removeUser(User u) {
		users.remove(u.getNom());
		lastCheck.remove(u.getNom());
	}
	
	
}
