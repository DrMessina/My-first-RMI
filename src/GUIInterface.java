/**
 * interface client GUI
 * 
 * @author Landry & Hendrik
 *
 */

public interface GUIInterface {

	public void createChatInterface(String nickname);
	public void createInputInterface(String inputInterfaceType);
	public void chatChange (int roomID);
	public void showAllRooms ();
	public void setServerError();
	public void update();
}
