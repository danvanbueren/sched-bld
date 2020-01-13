import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Window {

	private JFrame frameMain;

	DefaultListModel<String> personnelList, sortieList;

	public static void build() {

		System.out.println("Building window");
		
		// CALL PUBLIC METHOD TO CREATE NEW WINDOW
		EventQueue.invokeLater(new Runnable() {			
			public void run() {
				try {
					Window windowMain = new Window();
					windowMain.frameMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// CALL PRIVATE METHOD (SAFETY)
	public Window() {
		initialize();
	}

	// DICTATE ALL WINDOW SETTINGS
	private void initialize() {

		/**********************************************************
		 * FRAME SETTINGS *****************************************
		 **********************************************************/
		frameMain = new JFrame();
		frameMain.setResizable(false);
		frameMain.setTitle("Telescope");
		frameMain.setBounds(100, 100, 721, 481);
		frameMain.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameMain.getContentPane().setLayout(new BorderLayout(0, 0));

		// TELL WINDOW WHAT TO DO WHEN CLOSING
		frameMain.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				JFrame saveFrame = new JFrame("Telescope");
				JPanel savePanel = new JPanel();
				JProgressBar saveBar = new JProgressBar();

				saveBar.setValue(0);
				saveBar.setStringPainted(true);
				saveBar.setString("Saving");

				savePanel.add(saveBar);
				saveFrame.add(savePanel);

				saveFrame.setResizable(false);
				saveFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				saveFrame.setBounds(0, 0, 200, 50);
				saveFrame.setVisible(true);

				DatabaseComposer.save();

				saveFrame.setVisible(false);
				saveFrame.dispose();

				frameMain.setVisible(false);
				frameMain.dispose();

				System.out.println("Calling System to exit with code 0.");
				System.exit(0);

			}
		});

		/**********************************************************
		 * PANE SETTINGS ******************************************
		 **********************************************************/
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.BLACK);
		frameMain.getContentPane().add(desktopPane);

		/**********************************************************
		 * BREADCRUMB PANEL ***************************************
		 **********************************************************/
		JPanel breadcrumbPanel = new JPanel();
		breadcrumbPanel.setBackground(Color.DARK_GRAY);
		breadcrumbPanel.setForeground(Color.WHITE);
		breadcrumbPanel.setBounds(0, 0, 721, 25);
		desktopPane.add(breadcrumbPanel);
		breadcrumbPanel.setLayout(null);

		/**********************************************************
		 * BREADCRUMB PANEL * LABEL *******************************
		 **********************************************************/
		JLabel breadcrumbLbl1 = new JLabel("HOME");
		breadcrumbLbl1.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		breadcrumbLbl1.setForeground(Color.LIGHT_GRAY);
		breadcrumbLbl1.setBounds(5, 0, 50, 25);
		breadcrumbPanel.add(breadcrumbLbl1);

		/**********************************************************
		 * NAV PANEL **********************************************
		 **********************************************************/
		JPanel navPanel = new JPanel();
		navPanel.setBackground(Color.GRAY);
		navPanel.setBounds(0, 25, 150, 434);
		desktopPane.add(navPanel);
		navPanel.setLayout(null);

		/**********************************************************
		 * NAV PANEL * ADMIN BUTTON *******************************
		 **********************************************************/
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setBounds(0, 10, 150, 30);
		navPanel.add(btnAdmin);

		/**********************************************************
		 * NAV PANEL * CALENDAR BUTTON ****************************
		 **********************************************************/
		JButton btnCalendar = new JButton("Calendar");
		btnCalendar.setBounds(0, 40, 150, 30);
		navPanel.add(btnCalendar);

		/**********************************************************
		 * NAV PANEL * SETTINGS BUTTON ****************************
		 **********************************************************/
		JButton btnSettings = new JButton("Settings");
		btnSettings.setBounds(0, 70, 150, 30);
		navPanel.add(btnSettings);

		/**********************************************************
		 * NAV PANEL * CONSOLE BUTTON *****************************
		 **********************************************************/
		JButton btnConsole = new JButton("Console");
		btnConsole.setBounds(0, 100, 150, 30);
		navPanel.add(btnConsole);

		//
		/**********************************************************
		 * PORTHOLE PANEL *****************************************
		 **********************************************************/
		JPanel portholePanel = new JPanel();
		portholePanel.setBackground(Color.LIGHT_GRAY);
		portholePanel.setBounds(150, 25, 571, 434);
		desktopPane.add(portholePanel);
		portholePanel.setLayout(null);

		//
		/**********************************************************
		 * PORTHOLE PANEL * CONSOLE SUB PANEL *********************
		 **********************************************************/
		JPanel consoleSubPanel = new JPanel();
		consoleSubPanel.setLayout(null);
		consoleSubPanel.setBounds(0, 0, 571, 434);
		portholePanel.add(consoleSubPanel);

		//
		/**********************************************************
		 * PORTHOLE PANEL * CONSOLE SUB PANEL * LABEL *************
		 **********************************************************/
		JLabel lblConsole = new JLabel("Console");
		lblConsole.setBounds(6, 6, 61, 16);
		consoleSubPanel.add(lblConsole);

		/**********************************************************
		 * PORTHOLE PANEL * CONSOLE SUB PANEL * CONSOLE TEXT AREA *
		 **********************************************************/
		JTextArea textAreaConsole = new JTextArea("This console is currently disabled.");

		textAreaConsole.setForeground(Color.GREEN);
		textAreaConsole.setBackground(Color.BLACK);
		textAreaConsole.setEditable(false);
		textAreaConsole.setBounds(0, 30, 571, 382);
		consoleSubPanel.add(textAreaConsole);

		JTextField textFieldConsole = new JTextField();
		textFieldConsole.setBounds(0, 412, 571, 22);
		textFieldConsole.setColumns(10);
		consoleSubPanel.add(textFieldConsole);

		// PrintStream ps = new PrintStream(new TextAreaOutputStream(textAreaConsole,
		// 60));
		// System.setOut(ps);
		// System.setErr(ps);

		// Respond to enter key when text field is used
		textFieldConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Disregarding \"" + textFieldConsole.getText() + "\" - input method is disabled");

				// InputStream is = null;
				// System.setIn(is);
				// is = new ByteArrayInputStream(textFieldConsole.getText().getBytes());

				textFieldConsole.setText("");
			}
		});

		// Automatically select the text field for easy input / less confusion
		textAreaConsole.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldConsole.grabFocus();
			}
		});

		/**********************************************************
		 * PORTHOLE PANEL * SETTINGS SUB PANEL ********************
		 **********************************************************/
		JPanel settingsSubPanel = new JPanel();
		settingsSubPanel.setLayout(null);
		settingsSubPanel.setBounds(0, 0, 571, 434);
		portholePanel.add(settingsSubPanel);

		/**********************************************************
		 * PORTHOLE PANEL * SETTINGS SUB PANEL * LABEL ************
		 **********************************************************/
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setBounds(6, 6, 61, 16);
		settingsSubPanel.add(lblSettings);

		/**********************************************************
		 * PORTHOLE PANEL * ADMIN SUB PANEL ***********************
		 **********************************************************/
		JPanel adminSubPanel = new JPanel();
		adminSubPanel.setBounds(0, 0, 571, 434);
		portholePanel.add(adminSubPanel);
		adminSubPanel.setLayout(null);

		/**********************************************************
		 * PORTHOLE PANEL * ADMIN SUB PANEL * LABEL ***************
		 **********************************************************/
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setBounds(6, 6, 61, 16);
		adminSubPanel.add(lblAdmin);

		/**********************************************************
		 * PORTHOLE PANEL * ADMIN SUB PANEL * PERSON LIST LABEL ***
		 **********************************************************/
		JLabel lblPersonnel = new JLabel("Personnel");
		lblPersonnel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonnel.setBounds(0, 30, 200, 25);
		adminSubPanel.add(lblPersonnel);

		/**********************************************************
		 * PORTHOLE PANEL * ADMIN SUB PANEL * PERSON LIST MODEL ***
		 **********************************************************/
		personnelList = new DefaultListModel();

		JList lstPersonnel = new JList(personnelList);
		lstPersonnel.setBounds(0, 55, 200, 300);
		lstPersonnel.setSelectedIndex(0);
		adminSubPanel.add(lstPersonnel);

		/**********************************************************
		 * PORTHOLE PANEL * ADMIN SUB PANEL * ADD PERSON BUTTON ***
		 **********************************************************/
		JButton btnAddPerson = new JButton("Add Person");
		btnAddPerson.setBounds(0, 355, 200, 20);
		adminSubPanel.add(btnAddPerson);

		btnAddPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// personnelList.addElement("element");
				addPerson();
			}
		});

		/**********************************************************
		 * PORTHOLE PANEL * ADMIN SUB PANEL * SORTIE LIST MODEL ***
		 **********************************************************/
		sortieList = new DefaultListModel();

		JList lstSorties = new JList(sortieList);
		lstSorties.setBounds(212, 55, 200, 300);
		adminSubPanel.add(lstSorties);

		/**********************************************************
		 * PORTHOLE PANEL * ADMIN SUB PANEL * ADD SORTIE BUTTON ***
		 **********************************************************/
		JButton btnAddSortie = new JButton("Add Sortie");
		btnAddSortie.setBounds(212, 355, 200, 20);
		adminSubPanel.add(btnAddSortie);

		btnAddSortie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// sortieList.addElement("element");
				addSortie();
			}
		});

		/**********************************************************
		 * PORTHOLE PANEL * ADMIN SUB PANEL * SORTIE LIST LABEL ***
		 **********************************************************/
		JLabel lblSorties = new JLabel("Sorties");
		lblSorties.setHorizontalAlignment(SwingConstants.CENTER);
		lblSorties.setBounds(212, 30, 200, 25);
		adminSubPanel.add(lblSorties);

		/**********************************************************
		 * PORTHOLE PANEL * CALENDAR SUB PANEL ********************
		 **********************************************************/
		JPanel calendarSubPanel = new JPanel();
		calendarSubPanel.setLayout(null);
		calendarSubPanel.setBounds(0, 0, 571, 434);
		portholePanel.add(calendarSubPanel);

		/**********************************************************
		 * PORTHOLE PANEL * CALENDAR SUB PANEL * LABEL ************
		 **********************************************************/
		JLabel lblCalendar = new JLabel("Calendar");
		lblCalendar.setBounds(6, 6, 61, 16);
		calendarSubPanel.add(lblCalendar);

		/**********************************************************
		 * FINALIZATION *******************************************
		 **********************************************************/

		// HIDE ALL SUBPANELS TO AVOID UI GLITCHES
		calendarSubPanel.setVisible(false);
		settingsSubPanel.setVisible(false);
		consoleSubPanel.setVisible(false);
		adminSubPanel.setVisible(true);

		// NAV BUTTON LISTENERS

		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendarSubPanel.setVisible(false);
				settingsSubPanel.setVisible(false);
				consoleSubPanel.setVisible(false);

				adminSubPanel.setVisible(true);
			}
		});

		btnCalendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settingsSubPanel.setVisible(false);
				consoleSubPanel.setVisible(false);
				adminSubPanel.setVisible(false);

				calendarSubPanel.setVisible(true);
			}
		});

		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendarSubPanel.setVisible(false);
				consoleSubPanel.setVisible(false);
				adminSubPanel.setVisible(false);

				settingsSubPanel.setVisible(true);
			}
		});

		btnConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendarSubPanel.setVisible(false);
				settingsSubPanel.setVisible(false);
				adminSubPanel.setVisible(false);

				consoleSubPanel.setVisible(true);
			}
		});

		lstSorties.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() >= 2) {
					int index = list.locationToIndex(evt.getPoint());
					viewSortie(index);
				}
			}
		});

		lstPersonnel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() >= 2) {
					int index = list.locationToIndex(evt.getPoint());
					viewPerson(index);
				}
			}
		});

		buildLists();

	}

	private void buildLists() {
		personnelList.clear();
		sortieList.clear();

		for (Person p : Main.personIndex) {
			personnelList.addElement(p.nameLast);
		}
		for (Sortie s : Main.sortieIndex) {
			sortieList.addElement(s.sortieNumber);
		}
	}

	private void addSortie() {
		JFrame frameAddSortie = new JFrame("Add Sortie");
		JPanel panelAddSortie = new JPanel();
		JTextField textField1 = new JTextField("1");
		JButton btnAddSortie = new JButton();
		

		frameAddSortie.setBounds(0, 0, 400, 500);
		frameAddSortie.setResizable(false);
		
		frameAddSortie.add(textField1);
		frameAddSortie.add(btnAddSortie);

		frameAddSortie.setVisible(true);

		btnAddSortie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

	}

	private void addPerson() {
		JFrame frameAddPerson = new JFrame("Add Person");
		frameAddPerson.setBounds(0, 0, 400, 500);
		frameAddPerson.setResizable(false);
		frameAddPerson.setVisible(true);
	}

	private void viewSortie(int index) {
		Sortie s = Main.sortieIndex.get(index);
		System.out.println("Sortie clicked: "+s.sortieNumber);

		JFrame frameViewSortie = new JFrame("View Sortie: " + s.sortieNumber);
		frameViewSortie.setBounds(0, 0, 400, 500);
		frameViewSortie.setResizable(false);
		frameViewSortie.setVisible(true);
	}

	private void viewPerson(int index) {
		Person p = Main.personIndex.get(index);
		System.out.println("Person clicked: "+p.nameLast);

		JFrame frameViewPerson = new JFrame("View Person: " + p.nameLast);
		frameViewPerson.setBounds(0, 0, 400, 500);
		frameViewPerson.setResizable(false);
		frameViewPerson.setVisible(true);
	}
}
