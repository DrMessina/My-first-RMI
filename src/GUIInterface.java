import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionEvent;

public interface GUIInterface {

	public void createChatInterface(String nickname);
	public void createInputInterface(String inputInterfaceType);
	public void chatChange (int roomID);
	
}
