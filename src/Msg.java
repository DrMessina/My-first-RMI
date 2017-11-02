import java.util.Date;

public class Msg {
	
	private int userID;
	private Date time;
	private String msg;
	
	public Msg(int userID, Date time, String msg) {
		super();
		this.msg = msg;
		this.userID = userID;
		this.time = time;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	

}
