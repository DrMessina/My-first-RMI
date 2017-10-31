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
import java.awt.Component;
import javax.swing.JTextArea;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JToggleButton;


public class Chat_GUI {
	
	private JTextField text;
	private JTextField textField;

	/**
	 * @wbp.parser.entryPoint
	 */
	public Chat_GUI() {
		
		JFrame frame = new JFrame();
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
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		users_panel.add(list, gbc_list);
		
		JButton btnAdd = new JButton("Add");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 1;
		users_panel.add(btnAdd, gbc_btnAdd);
		
		JPanel rooms_panel = new JPanel();
		user_rooms_tabbed.addTab("Rooms", null, rooms_panel, null);
		GridBagLayout gbl_rooms_panel = new GridBagLayout();
		gbl_rooms_panel.columnWidths = new int[]{0, 0};
		gbl_rooms_panel.rowHeights = new int[]{0, 0, 0};
		gbl_rooms_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_rooms_panel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		rooms_panel.setLayout(gbl_rooms_panel);
		
		JList list_2 = new JList();
		GridBagConstraints gbc_list_2 = new GridBagConstraints();
		gbc_list_2.insets = new Insets(0, 0, 5, 0);
		gbc_list_2.fill = GridBagConstraints.BOTH;
		gbc_list_2.gridx = 0;
		gbc_list_2.gridy = 0;
		rooms_panel.add(list_2, gbc_list_2);
		
		JButton btnAdd_1 = new JButton("Add");
		GridBagConstraints gbc_btnAdd_1 = new GridBagConstraints();
		gbc_btnAdd_1.gridx = 0;
		gbc_btnAdd_1.gridy = 1;
		rooms_panel.add(btnAdd_1, gbc_btnAdd_1);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JList list_1 = new JList();
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.gridwidth = 2;
		gbc_list_1.insets = new Insets(0, 0, 5, 0);
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 0;
		gbc_list_1.gridy = 0;
		panel.add(list_1, gbc_list_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.gridx = 1;
		gbc_btnSend.gridy = 1;
		panel.add(btnSend, gbc_btnSend);
		
		
		//BUGGED TRIAL
		
		/*JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.anchor = GridBagConstraints.NORTHWEST;
		gbc_tabbedPane.insets = new Insets(0, 0, 0, 5);
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		frame.getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		
		JPanel users_panel = new JPanel();
		tabbedPane.addTab("Users", null, users_panel, null);
		GridBagLayout users_gbl_panel = new GridBagLayout();
		users_gbl_panel.columnWidths = new int[] {50};
		users_gbl_panel.rowHeights = new int[] {200, 20};
		users_gbl_panel.columnWeights = new double[]{0.0};
		users_gbl_panel.rowWeights = new double[]{0.0, 0.0};
		users_panel.setLayout(users_gbl_panel);
		
		JList list = new JList();
		GridBagConstraints gbc_user_list = new GridBagConstraints();
		gbc_user_list.fill = GridBagConstraints.BOTH;
		gbc_user_list.insets = new Insets(0, 0, 5, 5);
		gbc_user_list.gridx = 0;
		gbc_user_list.gridy = 0;
		users_panel.add(list, gbc_user_list);
		
		JButton btnAdd = new JButton("Add");
		GridBagConstraints gbc_btnAdd_user = new GridBagConstraints();
		gbc_btnAdd_user.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd_user.fill = GridBagConstraints.BOTH;
		gbc_btnAdd_user.gridx = 0;
		gbc_btnAdd_user.gridy = 1;
		users_panel.add(btnAdd, gbc_btnAdd_user);
		
		
		
		JPanel rooms_panel = new JPanel();
		rooms_panel.setPreferredSize(new Dimension(10, 100));
		tabbedPane.addTab("Rooms", null, rooms_panel, null);
		tabbedPane.setEnabledAt(1, true);
		GridBagLayout rooms_gbl_panel = new GridBagLayout();
		rooms_gbl_panel.columnWidths = new int[] {50};
		rooms_gbl_panel.rowHeights = new int[] {200, 20};
		rooms_gbl_panel.columnWeights = new double[]{1.0};
		rooms_gbl_panel.rowWeights = new double[]{1.0, 0.0};
		rooms_panel.setLayout(rooms_gbl_panel);
		
		JList list_1 = new JList();
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.insets = new Insets(0, 0, 5, 0);
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 0;
		gbc_list_1.gridy = 0;
		rooms_panel.add(list_1, gbc_list_1);
		
		JButton btnAdd_1 = new JButton("Add");
		GridBagConstraints gbc_btnAdd_1 = new GridBagConstraints();
		gbc_btnAdd_1.gridx = 0;
		gbc_btnAdd_1.gridy = 1;
		rooms_panel.add(btnAdd_1, gbc_btnAdd_1);
		
		
		
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JList chat_messages = new JList();
		GridBagConstraints gbc_message_list = new GridBagConstraints();
		gbc_message_list.gridwidth = 2;
		gbc_message_list.insets = new Insets(0, 0, 5, 0);
		gbc_message_list.fill = GridBagConstraints.BOTH;
		gbc_message_list.gridx = 0;
		gbc_message_list.gridy = 0;
		panel.add(chat_messages, gbc_message_list);
		
		JTextArea txtrChatInput = new JTextArea();
		txtrChatInput.setText("Chat input");
		GridBagConstraints gbc_txtrChatInput = new GridBagConstraints();
		gbc_txtrChatInput.insets = new Insets(0, 0, 0, 5);
		gbc_txtrChatInput.fill = GridBagConstraints.BOTH;
		gbc_txtrChatInput.gridx = 0;
		gbc_txtrChatInput.gridy = 1;
		panel.add(txtrChatInput, gbc_txtrChatInput);
		
		JButton btnSend = new JButton("Send");
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.gridx = 1;
		gbc_btnSend.gridy = 1;
		panel.add(btnSend, gbc_btnSend);*/
		
		
		
		
	}
}
