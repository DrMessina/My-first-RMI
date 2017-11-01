import javax.swing.JFrame; 
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.JTextArea;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

public class Chat_GUI implements GUIInterface, ActionListener {
	
	private JTextField messageInput;
	private JTextField separateInput;


	/**
	 * @wbp.parser.entryPoint
	 */
	public void createChatInterface(String nickname) {
		
		JFrame frame = new JFrame();
		frame.setTitle("RMI Chat for " + nickname);
		frame.getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {70, 200};
		gridBagLayout.rowHeights = new int[] {0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		
		JTabbedPane user_rooms_tabbed = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_user_rooms_tabbed = new GridBagConstraints();
		gbc_user_rooms_tabbed.insets = new Insets(0, 0, 0, 5);
		gbc_user_rooms_tabbed.fill = GridBagConstraints.BOTH;
		gbc_user_rooms_tabbed.gridx = 0;
		gbc_user_rooms_tabbed.gridy = 0;
		frame.getContentPane().add(user_rooms_tabbed, gbc_user_rooms_tabbed);
		
		JPanel users_panel = new JPanel();
		user_rooms_tabbed.addTab("Users", null, users_panel, null);
		GridBagLayout gbl_users_panel = new GridBagLayout();
		gbl_users_panel.columnWidths = new int[] {0, 0};
		gbl_users_panel.rowHeights = new int[] {0, 0, 0};
		gbl_users_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_users_panel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		users_panel.setLayout(gbl_users_panel);
		
		JList listUsers = new JList();
		GridBagConstraints gbc_listUsers = new GridBagConstraints();
		gbc_listUsers.insets = new Insets(0, 0, 5, 0);
		gbc_listUsers.fill = GridBagConstraints.BOTH;
		gbc_listUsers.gridx = 0;
		gbc_listUsers.gridy = 0;
		users_panel.add(listUsers, gbc_listUsers);
		
		JButton btnAddUser = new JButton("Add");
		GridBagConstraints gbc_btnAddUser = new GridBagConstraints();
		gbc_btnAddUser.gridx = 0;
		gbc_btnAddUser.gridy = 1;
		users_panel.add(btnAddUser, gbc_btnAddUser);
		
		JPanel rooms_panel = new JPanel();
		user_rooms_tabbed.addTab("Rooms", null, rooms_panel, null);
		GridBagLayout gbl_rooms_panel = new GridBagLayout();
		gbl_rooms_panel.columnWidths = new int[]{0, 0};
		gbl_rooms_panel.rowHeights = new int[]{0, 0, 0};
		gbl_rooms_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_rooms_panel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		rooms_panel.setLayout(gbl_rooms_panel);
		
		JList listRooms = new JList();
		GridBagConstraints gbc_listRooms = new GridBagConstraints();
		gbc_listRooms.insets = new Insets(0, 0, 5, 0);
		gbc_listRooms.fill = GridBagConstraints.BOTH;
		gbc_listRooms.gridx = 0;
		gbc_listRooms.gridy = 0;
		rooms_panel.add(listRooms, gbc_listRooms);
		
		JButton btnAddRoom = new JButton("Add");
		GridBagConstraints gbc_btnAddRoom = new GridBagConstraints();
		gbc_btnAddRoom.gridx = 0;
		gbc_btnAddRoom.gridy = 1;
		rooms_panel.add(btnAddRoom, gbc_btnAddRoom);
		
		JPanel chat_panel = new JPanel();
		GridBagConstraints gbc_chat_panel = new GridBagConstraints();
		gbc_chat_panel.insets = new Insets(5, 0, 13, 5);
		gbc_chat_panel.fill = GridBagConstraints.BOTH;
		gbc_chat_panel.gridx = 1;
		gbc_chat_panel.gridy = 0;
		frame.getContentPane().add(chat_panel, gbc_chat_panel);
		GridBagLayout gbl_chat_panel = new GridBagLayout();
		gbl_chat_panel.columnWidths = new int[]{0, 0};
		gbl_chat_panel.rowHeights = new int[]{0, 0, 0};
		gbl_chat_panel.columnWeights = new double[]{1.0, 0.0};
		gbl_chat_panel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		chat_panel.setLayout(gbl_chat_panel);
		
		JList messagesDisplay = new JList();
		GridBagConstraints gbc_messagesDisplay = new GridBagConstraints();
		gbc_messagesDisplay.gridwidth = 2;
		gbc_messagesDisplay.insets = new Insets(0, 0, 5, 0);
		gbc_messagesDisplay.fill = GridBagConstraints.BOTH;
		gbc_messagesDisplay.gridx = 0;
		gbc_messagesDisplay.gridy = 0;
		chat_panel.add(messagesDisplay, gbc_messagesDisplay);
		
		messageInput = new JTextField();
		GridBagConstraints gbc_messageInput = new GridBagConstraints();
		gbc_messageInput.insets = new Insets(0, 5, 0, 5);
		gbc_messageInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_messageInput.gridx = 0;
		gbc_messageInput.gridy = 1;
		chat_panel.add(messageInput, gbc_messageInput);
		messageInput.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.gridx = 1;
		gbc_btnSend.gridy = 1;
		chat_panel.add(btnSend, gbc_btnSend);
	}
	
	public void createInputInterface(String inputInterfaceType) {
		
		//règles pour editer l'affichage selon les 3 cas login, ajouter un utilisateur et créer un salon.
		String inputTitle = "Login";
		String welcomeMessage = "Choose your nickname :";
		String buttonText = "Log in";
		
		if (inputInterfaceType == "login") {
			inputTitle = "Login";
			welcomeMessage = "Choose your nickname :";
			buttonText = "Log in";
		} else if (inputInterfaceType == "add_user"){
			inputTitle = "Add a user";
			welcomeMessage = "Enter the nickname of the autorised user :";
			buttonText = "Add";
		} else if (inputInterfaceType == "add_room"){
			inputTitle = "Create a new room";
			welcomeMessage = "Enter the name of the desired room :";
			buttonText = "Create";
		}
		
		//éléments d'interface
		JFrame inputframe = new JFrame();
		inputframe.setPreferredSize(new Dimension(80, 40));
		inputframe.setTitle(inputTitle);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		inputframe.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel(welcomeMessage);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		inputframe.getContentPane().add(lblTitle, gbc_lblTitle);
		
		separateInput = new JTextField();
		GridBagConstraints gbc_textInput = new GridBagConstraints();
		gbc_textInput.insets = new Insets(0, 20, 5, 20);
		gbc_textInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_textInput.gridx = 0;
		gbc_textInput.gridy = 1;
		inputframe.getContentPane().add(separateInput, gbc_textInput);
		separateInput.setColumns(10);
		
		
		JButton btnSubmit = new JButton(buttonText);
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridx = 0;
		gbc_btnSubmit.gridy = 2;
		inputframe.getContentPane().add(btnSubmit, gbc_btnSubmit);
		btnSubmit.addActionListener(this);
		
		inputframe.setSize(300,200);
		inputframe.setLocationRelativeTo(null);
		inputframe.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		JButton btn = (JButton)evt.getSource();
		String name = btn.getName();
		if (name.equals("Log In")) {
			String inputText = separateInput.getText();
			
			//envoyer le login au serveur
			//recevoir l'erreur si login déjà existant
			
			createChatInterface(inputText);
			
	
		}
	
	}
	
}
