import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.Component;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout; 


public class Chat_Interface {
	
	private JTextField text;
	private JTextField textField;

	/**
	 * @wbp.parser.entryPoint
	 */
	public Chat_Interface() {
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JSplitPane splitPane = new JSplitPane();
		tabbedPane.addTab("New tab", null, splitPane, null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		splitPane.setLeftComponent(layeredPane);
		layeredPane.setLayout(new BoxLayout(layeredPane, BoxLayout.Y_AXIS));
		
		JLabel lblUsers = new JLabel("Users");
		lblUsers.setAlignmentY(Component.TOP_ALIGNMENT);
		layeredPane.add(lblUsers);
		
		JList list = new JList();
		layeredPane.add(list);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		splitPane.setRightComponent(layeredPane_1);
		layeredPane_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextPane textPane = new JTextPane();
		layeredPane_1.add(textPane);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		layeredPane_1.setLayer(textField, 0);
		layeredPane_1.add(textField);
		textField.setColumns(10);
		
		
	}
}
