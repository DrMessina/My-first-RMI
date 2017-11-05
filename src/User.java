import java.io.Serializable;
/**
 * Classe permettant de cr�e un utilisateur.
 * 
 * @author Landry & Hendrik
 *
 */
public class User implements Serializable{
	/**
	 * Version de serialisation de la classe.</br>
	 * Il est autogener� et unique. 
	 */
	private static final long serialVersionUID = 133828474699154622L;
	/**
	 * Nom de l'utilisateur.</br>
	 * 
	 * @see User#setNom(String)
	 * @see User#getNom()
	 */
	private String nom;
	/**
	 * Constructeur permettant de cr�e un utilisateur.
	 * 
	 * @param nom
	 * 		Le nom de l'utilisateur.
	 * 
	 * @see User#nom
	 */
	public User(String nom) {	this.nom=nom;}
	/**
	 * met � jour le nom de l'utilisateur.</br>
	 * 
	 * @param nom
	 * 		Le nom de l'utilisateur.
	 * 
	 * @see User#nom
	 */
	public void setNom(String nom) {	this.nom=nom;}
	/**
	 * getter pour recuperer le nom de l'utilisateur.<br>
	 * 
	 * @return
	 * 		retourne le String corresponndant au nom de l'utilisateur
	 */
	public String getNom() {	return nom;}
	
}
