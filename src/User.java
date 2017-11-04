import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 133828474699154622L;
	private String nom;
	
	public User(String nm) {	this.nom=nm;}
	
	public void setNom(String nm) {	this.nom=nm;}
	public String getNom() {	return nom;}
	
}
