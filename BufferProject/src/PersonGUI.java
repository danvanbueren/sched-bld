import java.awt.EventQueue;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class PersonGUI {

	private JFrame frmTelescopeAdd;
	private JTextField txtJack;
	private JTextField txtJohn;
	private JTextField txtDoe;
	private JTextField textField_3;
	private JTextField txtNameSt;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonGUI window = new PersonGUI();
					window.frmTelescopeAdd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PersonGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelescopeAdd = new JFrame();
		frmTelescopeAdd.setTitle("Telescope - Person - (Add/Edit)");
		frmTelescopeAdd.setBounds(100, 100, 500, 500);
		frmTelescopeAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelescopeAdd.getContentPane().setLayout(null);

		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Appointment 1", "Appointment 2", "Appointment 3", "Appointment 4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(260, 26, 234, 406);
		frmTelescopeAdd.getContentPane().add(list);

		txtJack = new JTextField();
		txtJack.setText("Jack");
		txtJack.setColumns(10);
		txtJack.setBounds(6, 66, 234, 20);
		frmTelescopeAdd.getContentPane().add(txtJack);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MCC", "ECO", "SD", "AWO", "ASO", "SST", "AST"}));
		comboBox.setBounds(6, 186, 243, 20);
		frmTelescopeAdd.getContentPane().add(comboBox);

		JLabel lblSortieType = new JLabel("Crew Position");
		lblSortieType.setBounds(6, 166, 151, 20);
		frmTelescopeAdd.getContentPane().add(lblSortieType);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"E-1 AB", "E-2 Amn", "E-3 A1C", "E-4 SrA", "E-5 SSgt", "E-6 TSgt", "E-7 MSgt", "E-8 SMSgt", "E-9 CMSgt", "O-1 2Lt", "O-2 1Lt", "O-3 Capt", "O-4 Maj", "O-5 LtC", "O-6 Col", "O-7 BrigGen", "O-8 MajGen", "O-9 LtGen", "O-10 Gen"}));
		comboBox_1.setBounds(6, 146, 243, 20);
		frmTelescopeAdd.getContentPane().add(comboBox_1);

		JLabel lblSquadron = new JLabel("Rank");
		lblSquadron.setBounds(6, 126, 151, 20);
		frmTelescopeAdd.getContentPane().add(lblSquadron);

		JLabel lblEndDate = new JLabel("Middle Name");
		lblEndDate.setBounds(6, 46, 151, 20);
		frmTelescopeAdd.getContentPane().add(lblEndDate);

		txtJohn = new JTextField();
		txtJohn.setText("John");
		txtJohn.setToolTipText("");
		txtJohn.setColumns(10);
		txtJohn.setBounds(6, 26, 234, 20);
		frmTelescopeAdd.getContentPane().add(txtJohn);

		JLabel lblStartDate = new JLabel("First Name");
		lblStartDate.setBounds(6, 6, 151, 20);
		frmTelescopeAdd.getContentPane().add(lblStartDate);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(260, 437, 234, 35);
		frmTelescopeAdd.getContentPane().add(btnNewButton);
		
		txtDoe = new JTextField();
		txtDoe.setText("Doe");
		txtDoe.setColumns(10);
		txtDoe.setBounds(6, 106, 234, 20);
		frmTelescopeAdd.getContentPane().add(txtDoe);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(6, 86, 151, 20);
		frmTelescopeAdd.getContentPane().add(lblLastName);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"DOMA", "DOMC", "DOMD", "DOMJ", "DOMK", "CSS", "RA", "DORM"}));
		comboBox_2.setBounds(6, 266, 243, 20);
		frmTelescopeAdd.getContentPane().add(comboBox_2);
		
		JLabel lblShop = new JLabel("Shop");
		lblShop.setBounds(6, 246, 151, 20);
		frmTelescopeAdd.getContentPane().add(lblShop);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"A-Flight", "B-Flight", "C-Flight", "D-Flight", "E-Flight", "F-Flight", "G-Flight", "H-Flight", "I-Flight", "J-Flight", "K-Flight", "L-Flight"}));
		comboBox_3.setBounds(6, 226, 243, 20);
		frmTelescopeAdd.getContentPane().add(comboBox_3);
		
		JLabel lblFlight = new JLabel("Flight");
		lblFlight.setBounds(6, 206, 151, 20);
		frmTelescopeAdd.getContentPane().add(lblFlight);
		
		JButton btnAddAppointment = new JButton("Add Appointment");
		btnAddAppointment.setBounds(260, 6, 234, 20);
		frmTelescopeAdd.getContentPane().add(btnAddAppointment);
		
		textField_3 = new JTextField();
		textField_3.setText("(000) 000-0000");
		textField_3.setColumns(10);
		textField_3.setBounds(6, 306, 234, 20);
		frmTelescopeAdd.getContentPane().add(textField_3);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(6, 286, 151, 20);
		frmTelescopeAdd.getContentPane().add(lblPhoneNumber);
		
		txtNameSt = new JTextField();
		txtNameSt.setText("0000 Name St., City, ST 00000");
		txtNameSt.setColumns(10);
		txtNameSt.setBounds(6, 346, 234, 20);
		frmTelescopeAdd.getContentPane().add(txtNameSt);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(6, 326, 151, 20);
		frmTelescopeAdd.getContentPane().add(lblAddress);
		
		textField_5 = new JTextField();
		textField_5.setText("000-00-0000");
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(6, 386, 234, 20);
		frmTelescopeAdd.getContentPane().add(textField_5);
		
		JLabel lblSocial = new JLabel("Individual Identifier");
		lblSocial.setBounds(6, 366, 151, 20);
		frmTelescopeAdd.getContentPane().add(lblSocial);
	}
}
