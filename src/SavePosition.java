
public class SavePosition {
	private int idroom;
	private int positionMsg;
	private String nomUser;

	SavePosition(int id, int pos, String nm){
		this.idroom = id;
		this.positionMsg = pos;
		this.nomUser = nm;
	}
	
	public int getIdroom() {
		return idroom;
	}

	public void setIdroom(int idroom) {
		this.idroom = idroom;
	}

	public int getPositionMsg() {
		return positionMsg;
	}

	public void setPositionMsg(int positionMsg) {
		this.positionMsg = positionMsg;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
}
