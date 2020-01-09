package testbench;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TestBench {

	private JFrame frmTitle;
	private JTextField txtEnterToSubmit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestBench window = new TestBench();
					window.frmTitle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestBench() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// FRAME
		frmTitle = new JFrame();
		frmTitle.setResizable(false);
		frmTitle.setTitle("Telescope");
		frmTitle.setBounds(100, 100, 721, 481);
		frmTitle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTitle.getContentPane().setLayout(new BorderLayout(0, 0));

		// PANE
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.BLACK);
		frmTitle.getContentPane().add(desktopPane);

		// PANEL
		JPanel breadcrumbPanel = new JPanel();
		breadcrumbPanel.setBackground(Color.DARK_GRAY);
		breadcrumbPanel.setForeground(Color.WHITE);
		breadcrumbPanel.setBounds(0, 0, 721, 25);
		desktopPane.add(breadcrumbPanel);
		breadcrumbPanel.setLayout(null);

		// PANEL LABEL
		JLabel breadcrumbLbl1 = new JLabel("HOME");
		breadcrumbLbl1.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		breadcrumbLbl1.setForeground(Color.LIGHT_GRAY);
		breadcrumbLbl1.setBounds(5, 0, 50, 25);
		breadcrumbPanel.add(breadcrumbLbl1);

		// PANEL
		JPanel navPanel = new JPanel();
		navPanel.setBackground(Color.GRAY);
		navPanel.setBounds(0, 25, 150, 434);
		desktopPane.add(navPanel);
		navPanel.setLayout(null);

		// NAV BUTTON - ADMIN
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setBounds(0, 10, 150, 30);
		navPanel.add(btnAdmin);

		// NAV BUTTON - CALENDAR
		JButton btnCalendar = new JButton("Calendar");
		btnCalendar.setBounds(0, 40, 150, 30);
		navPanel.add(btnCalendar);

		// NAV BUTTON - SETTINGS
		JButton btnSettings = new JButton("Settings");
		btnSettings.setBounds(0, 70, 150, 30);
		navPanel.add(btnSettings);

		// NAV BUTTON - CONSOLE
		JButton btnConsole = new JButton("Console");
		btnConsole.setBounds(0, 100, 150, 30);
		navPanel.add(btnConsole);

		// PANEL
		JPanel portholePanel = new JPanel();
		portholePanel.setBackground(Color.LIGHT_GRAY);
		portholePanel.setBounds(150, 25, 571, 434);
		desktopPane.add(portholePanel);
		portholePanel.setLayout(null);

		// CONSOLE - SUB PANEL
		JPanel consoleSubPanel = new JPanel();
		consoleSubPanel.setLayout(null);
		consoleSubPanel.setBounds(0, 0, 571, 434);
		portholePanel.add(consoleSubPanel);

		// CONSOLE - LABEL
		JLabel lblConsole = new JLabel("Console");
		lblConsole.setBounds(6, 6, 61, 16);
		consoleSubPanel.add(lblConsole);

		// CONSOLE - TEXT AREA
		JTextArea textAreaConsole = new JTextArea();

		textAreaConsole.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEnterToSubmit.grabFocus();
			}
		});

		textAreaConsole.setForeground(Color.GREEN);
		textAreaConsole.setBackground(Color.BLACK);
		textAreaConsole.setEditable(false);
		PrintStream ps = new PrintStream(new TextAreaOutputStream(textAreaConsole, 60));
		System.setOut(ps);
		System.setErr(ps);

		textAreaConsole.setBounds(0, 30, 571, 382);
		consoleSubPanel.add(textAreaConsole);

		txtEnterToSubmit = new JTextField();
		txtEnterToSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Sending this to System.in reader... " + txtEnterToSubmit.getText());

				InputStream is = null;

				// System.setIn(is);

				is = new ByteArrayInputStream(txtEnterToSubmit.getText().getBytes());

				txtEnterToSubmit.setText("");
			}
		});
		txtEnterToSubmit.setBounds(0, 412, 571, 22);
		consoleSubPanel.add(txtEnterToSubmit);
		txtEnterToSubmit.setColumns(10);

		// SETTINGS - SUB PANEL
		JPanel settingsSubPanel = new JPanel();
		settingsSubPanel.setLayout(null);
		settingsSubPanel.setBounds(0, 0, 571, 434);
		portholePanel.add(settingsSubPanel);

		// SETTINGS - LABEL
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setBounds(6, 6, 61, 16);
		settingsSubPanel.add(lblSettings);

		// ADMIN - SUB PANEL
		JPanel adminSubPanel = new JPanel();
		adminSubPanel.setBounds(0, 0, 571, 434);
		portholePanel.add(adminSubPanel);
		adminSubPanel.setLayout(null);

		// ADMIN - LABEL
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setBounds(6, 6, 61, 16);
		adminSubPanel.add(lblAdmin);

		// ADMIN - PERSON LIST LABEL
		JLabel lblPersonnel = new JLabel("Personnel");
		lblPersonnel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonnel.setBounds(0, 30, 200, 25);
		adminSubPanel.add(lblPersonnel);

		// ADMIN - PERSON LIST
		DefaultListModel personnelList = new DefaultListModel();
		
		
		JList lstPersonnel = new JList(personnelList);
		lstPersonnel.setBounds(0, 55, 200, 300);
		lstPersonnel.setSelectedIndex(0);
		adminSubPanel.add(lstPersonnel);

		// ADMIN - ADD PERSON BUTTON
		JButton btnAddPerson = new JButton("Add Person");
		btnAddPerson.setBounds(0, 355, 200, 20);
		adminSubPanel.add(btnAddPerson);

		btnAddPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personnelList.addElement("element");
			}
		});

		// ADMIN - SORTIE LIST
		DefaultListModel sortieList = new DefaultListModel();
		
		JList lstSorties = new JList(sortieList);
		lstSorties.setBounds(212, 55, 200, 300);
		adminSubPanel.add(lstSorties);

		// ADMIN - ADD SORTIE BUTTON
		JButton btnAddSortie = new JButton("Add Sortie");
		btnAddSortie.setBounds(212, 355, 200, 20);
		adminSubPanel.add(btnAddSortie);
		
		btnAddSortie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortieList.addElement("element");
			}
		});
		
		// ADMIN - SORTIE LIST LABEL
		JLabel lblSorties = new JLabel("Sorties");
		lblSorties.setHorizontalAlignment(SwingConstants.CENTER);
		lblSorties.setBounds(212, 30, 200, 25);
		adminSubPanel.add(lblSorties);

		// CALENDAR - SUB PANEL
		JPanel calendarSubPanel = new JPanel();
		calendarSubPanel.setLayout(null);
		calendarSubPanel.setBounds(0, 0, 571, 434);
		portholePanel.add(calendarSubPanel);

		// CALENDAR - LABEL
		JLabel lblCalendar = new JLabel("Calendar");
		lblCalendar.setBounds(6, 6, 61, 16);
		calendarSubPanel.add(lblCalendar);

		calendarSubPanel.hide();
		settingsSubPanel.hide();
		consoleSubPanel.hide();
		adminSubPanel.hide();

		// NAV BUTTON LISTENERS
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendarSubPanel.hide();
				settingsSubPanel.hide();
				consoleSubPanel.hide();

				adminSubPanel.show();
			}
		});

		btnCalendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminSubPanel.hide();
				settingsSubPanel.hide();
				consoleSubPanel.hide();

				calendarSubPanel.show();
			}
		});

		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminSubPanel.hide();
				calendarSubPanel.hide();
				consoleSubPanel.hide();

				settingsSubPanel.show();
			}
		});

		btnConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminSubPanel.hide();
				calendarSubPanel.hide();
				settingsSubPanel.hide();

				consoleSubPanel.show();
			}
		});

	}
}
