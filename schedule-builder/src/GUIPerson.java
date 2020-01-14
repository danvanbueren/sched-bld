import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class GUIPerson {

	private JFrame frame;
	private PTextField txtFirstName;
	private PTextField txtMiddleName;
	private PTextField txtLastName;
	private PTextField txtPhoneNum;
	private PTextField txtAddress;
	private PTextField txtIdentifier;
	JComboBox<String> comboCrewPos, comboFlight, comboRank, comboShop;

	/**
	 * Launch the application.
	 *
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { PersonGUI window = new PersonGUI(1);
	 * window.getFrmTelescopeAdd().setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 **
	 * 
	 * Create the application.
	 */
	public GUIPerson() {
		initialize();
	}

	public GUIPerson(Person p) {
		initialize();
		initLoad(p);
	}
	/*
	 * public PersonGUI(Person p) { initialize(1); }
	 */

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		setFrmTelescopeAdd(new JFrame());
		getFrame().setTitle("Telescope - Person (Add)");
		getFrame().setBounds(100, 100, 500, 500);
		getFrame().getContentPane().setLayout(null);

		JList<String> list = new JList<String>();
		list.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -322245715788744180L;
			String[] values = new String[] { "Appointment 1", "Appointment 2", "Appointment 3", "Appointment 4" };

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(260, 26, 234, 406);
		getFrame().getContentPane().add(list);

		txtMiddleName = new PTextField("e.x. Jack", true);
		txtMiddleName.setColumns(10);
		txtMiddleName.setBounds(6, 66, 234, 20);
		getFrame().getContentPane().add(txtMiddleName);

		comboCrewPos = new JComboBox<String>();
		comboCrewPos.setModel(
				new DefaultComboBoxModel<String>(new String[] { "MCC", "ECO", "SD", "AWO", "ASO", "SST", "AST" }));
		comboCrewPos.setBounds(6, 186, 243, 20);
		getFrame().getContentPane().add(comboCrewPos);

		JLabel lblSortieType = new JLabel("Crew Position");
		lblSortieType.setBounds(6, 166, 151, 20);
		getFrame().getContentPane().add(lblSortieType);

		comboRank = new JComboBox<String>();
		comboRank.setModel(new DefaultComboBoxModel<String>(new String[] { "E-1 AB", "E-2 Amn", "E-3 A1C", "E-4 SrA",
				"E-5 SSgt", "E-6 TSgt", "E-7 MSgt", "E-8 SMSgt", "E-9 CMSgt", "O-1 2Lt", "O-2 1Lt", "O-3 Capt",
				"O-4 Maj", "O-5 LtC", "O-6 Col", "O-7 BrigGen", "O-8 MajGen", "O-9 LtGen", "O-10 Gen" }));
		comboRank.setBounds(6, 146, 243, 20);
		getFrame().getContentPane().add(comboRank);

		JLabel lblSquadron = new JLabel("Rank");
		lblSquadron.setBounds(6, 126, 151, 20);
		getFrame().getContentPane().add(lblSquadron);

		JLabel lblEndDate = new JLabel("Middle Name");
		lblEndDate.setBounds(6, 46, 151, 20);
		getFrame().getContentPane().add(lblEndDate);

		txtFirstName = new PTextField("e.x. John", true);
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(6, 26, 234, 20);
		getFrame().getContentPane().add(txtFirstName);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(6, 6, 151, 20);
		getFrame().getContentPane().add(lblFirstName);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(260, 437, 234, 35);
		getFrame().getContentPane().add(btnSubmit);

		txtLastName = new PTextField("e.x. Doe", true);
		txtLastName.setColumns(10);
		txtLastName.setBounds(6, 106, 234, 20);
		getFrame().getContentPane().add(txtLastName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(6, 86, 151, 20);
		getFrame().getContentPane().add(lblLastName);

		comboShop = new JComboBox<String>();
		comboShop.setModel(new DefaultComboBoxModel<String>(
				new String[] { "DOMA", "DOMC", "DOMD", "DOMJ", "DOMK", "CSS", "RA", "DORM" }));
		comboShop.setBounds(6, 266, 243, 20);
		getFrame().getContentPane().add(comboShop);

		JLabel lblShop = new JLabel("Shop");
		lblShop.setBounds(6, 246, 151, 20);
		getFrame().getContentPane().add(lblShop);

		comboFlight = new JComboBox<String>();
		comboFlight.setModel(new DefaultComboBoxModel<String>(
				new String[] { "A-Flight", "B-Flight", "C-Flight", "D-Flight", "E-Flight", "F-Flight", "G-Flight",
						"H-Flight", "I-Flight", "J-Flight", "K-Flight", "L-Flight" }));
		comboFlight.setBounds(6, 226, 243, 20);
		getFrame().getContentPane().add(comboFlight);

		JLabel lblFlight = new JLabel("Flight");
		lblFlight.setBounds(6, 206, 151, 20);
		getFrame().getContentPane().add(lblFlight);

		JButton btnAddAppointment = new JButton("Add Appointment");
		btnAddAppointment.setBounds(260, 6, 234, 20);
		getFrame().getContentPane().add(btnAddAppointment);

		txtPhoneNum = new PTextField("e.x. (000) 000-0000", true);
		txtPhoneNum.setColumns(10);
		txtPhoneNum.setBounds(6, 306, 234, 20);
		getFrame().getContentPane().add(txtPhoneNum);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(6, 286, 151, 20);
		getFrame().getContentPane().add(lblPhoneNumber);

		txtAddress = new PTextField("e.x. 0000 Name St., City, ST 00000", true);
		txtAddress.setColumns(10);
		txtAddress.setBounds(6, 346, 234, 20);
		getFrame().getContentPane().add(txtAddress);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(6, 326, 151, 20);
		getFrame().getContentPane().add(lblAddress);

		txtIdentifier = new PTextField("e.x. 000-00-0000", true);
		txtIdentifier.setEnabled(false);
		txtIdentifier.setColumns(10);
		txtIdentifier.setBounds(6, 386, 234, 20);
		getFrame().getContentPane().add(txtIdentifier);

		JLabel lblSocial = new JLabel("Individual Identifier");
		lblSocial.setBounds(6, 366, 151, 20);
		getFrame().getContentPane().add(lblSocial);

		// Open new window to get appointments
		btnAddAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GUIAppointment window = new GUIAppointment(0);
							window.getFrmTelescopeAppointment().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		// Submit info & close window
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (true) {
					Person p = new Person(comboRank.getItemAt(comboRank.getSelectedIndex()), txtFirstName.getText(),
							txtMiddleName.getText(), txtLastName.getText(),
							comboCrewPos.getItemAt(comboCrewPos.getSelectedIndex()),
							comboShop.getItemAt(comboShop.getSelectedIndex()),
							comboFlight.getItemAt(comboFlight.getSelectedIndex()), txtPhoneNum.getText(),
							txtAddress.getText(), txtIdentifier.getText());
					GUITelescope.refreshPersonList();
					frame.setVisible(false);
					frame.dispose();
				}

			}
		});
	}

	private void initLoad(Person p) {
		getFrame().setTitle("Telescope - Person (Edit: " + p.nameLast + ")");
		txtFirstName.setTextFill(p.nameFirst);
		txtMiddleName.setTextFill(p.nameMiddle);
		txtLastName.setTextFill(p.nameLast);
		txtAddress.setTextFill(p.address);
		txtIdentifier.setTextFill(p.social);
		txtPhoneNum.setTextFill(p.phoneNumber);
		comboCrewPos.setSelectedIndex(2);
		comboFlight.setSelectedIndex(2);
		comboRank.setSelectedIndex(2);
		comboShop.setSelectedIndex(2);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrmTelescopeAdd(JFrame frmTelescopeAdd) {
		this.frame = frmTelescopeAdd;
	}
}
