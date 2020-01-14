import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class GUITelescope {

	
	private JFrame frame;

	static JList<String> listSorties;

	static JList<String> listPeople;
	static DefaultListModel<String> listModelSorties;

	static DefaultListModel<String> listModelPeople;
	
	
	/**
	 * Create the application.
	 */
	public GUITelescope() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setTitle("Telescope");
		getFrame().setBounds(100, 100, 720, 480);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);

		JTabbedPane tabbedPaneMain = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneMain.setBounds(6, 6, 708, 446);
		getFrame().getContentPane().add(tabbedPaneMain);

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

		listPeople = new JList<String>();
		listModelPeople = new DefaultListModel<String>();
		
		for(Person p : Main.personIndex) {
			listModelPeople.addElement(p.rank + " " + p.nameLast + ", " + p.nameFirst + " " + p.nameMiddle + " - " + p.crewPos + " [" + p.shop + "] [" + p.flight + "]");
		}
		
		listPeople.setModel(listModelPeople);
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

		listSorties = new JList<String>();
		listModelSorties = new DefaultListModel<String>();
		
		for(Sortie s : Main.sortieIndex) {
			listModelSorties.addElement(s.sortieNumber);
		}
		
		listSorties.setModel(listModelSorties);
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

		// Open SortieGUI in create state
		btnSorties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GUISortie window = new GUISortie(0);
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		// Open SortieGUI in edit state
		listSorties.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() >= 2) {
					// int index = list.locationToIndex(evt.getPoint());
					// viewSortie(index);
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								GUISortie window = new GUISortie(0);
								window.getFrame().setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});

		// Open PersonGUI in create state
		btnPeople.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GUIPerson window = new GUIPerson();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		// Open PersonGUI in edit state
		listPeople.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() >= 2) {
					int index = list.locationToIndex(evt.getPoint());
					Person p = Main.personIndex.get(index);
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								GUIPerson window = new GUIPerson(p);
								window.getFrame().setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
	}
	
	public static void refreshSortieList() {
		listModelSorties.clear();
		
		for(Sortie s : Main.sortieIndex) {
			listModelSorties.addElement(s.sortieNumber);
		}
		
		listSorties.setModel(listModelSorties);
	}
	
	public static void refreshPersonList() {
		listModelPeople.clear();
		
		for(Person p : Main.personIndex) {
			listModelPeople.addElement(p.rank + " " + p.nameLast + ", " + p.nameFirst + " " + p.nameMiddle + " - " + p.crewPos + " [" + p.shop + "] [" + p.flight + "]");
		}
		
		listPeople.setModel(listModelPeople);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
