

public class Msg {
	private User user;
	private String msg;
	private int position;
	
	public Msg(User u, String m,int p) {
		this.user = u;
		this.msg=m;
		this.position=p;
	}
	public User getUser() {	return this.user;}
	public void setUser(User u) {	this.user=u;}
	
	public String getMessage() {	return this.msg;}
	public void setMessage(String m) {	this.msg=m;}
	
	public void setPosition(int p) {	this.position=p;}
	public int getPosition() {	return position;}
}
