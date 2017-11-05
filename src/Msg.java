import java.io.Serializable;
/**
 * Classe permettant de crée un message.<br>
 * 
 * @author Landry & Hendrik
 *
 */
public class Msg implements Serializable{
	/**
	 * version de la classe permettant de rendre la classe seriablisé unique.
	 */
	private static final long serialVersionUID = 2833701869083276152L;
	/**
	 * utilisateur ayant envoyé le message.<br>
	 * 
	 * @see Msg#getUser()
	 * @see Msg#setUser(User)
	 */
	private User user;
	/**
	 * objet representant le message envoyé.<br>
	 * 
	 * @see Msg#getMessage()
	 * @see Msg#setMessage(String)
	 */
	private String msg;
	/**
	 * instance representant la position du message  dans la conversation.
	 * 
	 * @see Msg#getPosition()
	 * @see Msg#setPosition(int)
	 */
	private int position;
	/**
	 * Constructeur permettant de crée une instance de message.<br>
	 * 
	 * @param u
	 * 		valeur de l'utilisateur ayant envoye le message.<br>
	 * @param m
	 * 		valeur du message envoyé par l'utilisateur.<br>
	 * @param p
	 * 		valeur de la position du message.<br>
	 */
	public Msg(User u, String m,int p) {
		this.user = u;
		this.msg=m;
		this.position=p;
	}
	/**
	 * methode retournant l'objet utilisateur.<br>
	 * 
	 * @return
	 * 		retourne l'utilisateur ayant envoyé le msg.<br>
	 */
	public User getUser() {	return this.user;}
	/**
	 * methode permettant de mettre à jour l'utilisateur qui envoye le msg.<br>
	 * 
	 * @param u
	 * 		Utilisateur ayant envoyé le message.
	 */
	public void setUser(User u) {	this.user=u;}
	/**
	 * methode permettant de recuperer un message envoyé par l'utilisateur.<br>
	 * 
	 * @return
	 * 		retourne un string correspondant au message envoyé par l'utilisateur.<br>
	 */
	public String getMessage() {	return this.msg;}
	/**
	 * methode permettant de mettre à jour un message.<br>
	 * 
	 * @param m
	 * 		Message mis à jour.
	 */
	public void setMessage(String m) {	this.msg=m;}
	/**
	 * methode permettant de mettre à jour le message.<br>
	 * @param p
	 *		position du message
	 */
	public void setPosition(int p) {	this.position=p;}
	/**
	 * methode permettant de  recuperer un position d'un message.<br>
	 * @return
	 * 		retourn un entier correspond à la position du message.<br>
	 */
	public int getPosition() {	return position;}
}
