import java.util.Date;

public class Msg {
	
	private String userName;
	private Date time;
	private String msg;
	
	public Msg(String userName, Date time, String msg) {
		super();
		this.msg = msg;
		this.userName = userName;
		this.time = time;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserID(String userName) {
		this.userName = userName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	

}
