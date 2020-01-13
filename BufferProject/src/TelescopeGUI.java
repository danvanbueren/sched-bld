import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;

public class TelescopeGUI {

	private JFrame frameMain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelescopeGUI window = new TelescopeGUI();
					window.frameMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelescopeGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMain = new JFrame();
		frameMain.setTitle("Telescope");
		frameMain.setBounds(100, 100, 720, 480);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().setLayout(null);

		JTabbedPane tabbedPaneMain = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneMain.setBounds(6, 6, 708, 446);
		frameMain.getContentPane().add(tabbedPaneMain);

		JPanel panelAdmin = new JPanel();
		tabbedPaneMain.addTab("Admin", null, panelAdmin, null);
		panelAdmin.setLayout(null);

		JPanel panelPeople = new JPanel();
		panelPeople.setBounds(0, 0, 343, 400);
		panelAdmin.add(panelPeople);
		panelPeople.setLayout(null);

		JLabel lblPeople = new JLabel("People");
		lblPeople.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeople.setBounds(0, 0, 343, 20);
		panelPeople.add(lblPeople);

		JList listPeople = new JList();
		listPeople.setModel(new AbstractListModel() {
			String[] values = new String[] {"Person 1", "Person 2", "Person 3", "Person 4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listPeople.setBounds(0, 20, 343, 360);
		panelPeople.add(listPeople);

		JButton btnPeople = new JButton("Add Person");
		btnPeople.setBounds(0, 380, 343, 20);
		panelPeople.add(btnPeople);

		JPanel panelSorties = new JPanel();
		panelSorties.setBounds(344, 0, 343, 400);
		panelAdmin.add(panelSorties);
		panelSorties.setLayout(null);

		JLabel lblSorties = new JLabel("Sorties");
		lblSorties.setHorizontalAlignment(SwingConstants.CENTER);
		lblSorties.setBounds(0, 0, 343, 20);
		panelSorties.add(lblSorties);

		JList listSorties = new JList();
		listSorties.setModel(new AbstractListModel() {
			String[] values = new String[] {"Sortie 1", "Sortie 2", "Sortie 3", "Sortie 4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listSorties.setBounds(0, 20, 343, 360);
		panelSorties.add(listSorties);

		JButton btnSorties = new JButton("Add Sortie");
		btnSorties.setBounds(0, 380, 343, 20);
		panelSorties.add(btnSorties);

		JPanel panelCalendar = new JPanel();
		tabbedPaneMain.addTab("Calendar", null, panelCalendar, null);

		JScrollPane scrollPaneSettings = new JScrollPane();
		tabbedPaneMain.addTab("Settings", null, scrollPaneSettings, null);

		JLabel lblNewLabel = new JLabel("Preferred Squadron");
		scrollPaneSettings.setRowHeaderView(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "960 AACS", "961 AACS", "962 AACS", "963 AACS",
				"964 AACS", "965 AACS", "966 AACS", "970 AACS" }));
		scrollPaneSettings.setViewportView(comboBox);
	}
}
