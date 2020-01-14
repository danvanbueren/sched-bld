import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class GUIPerson {

	private JFrame frame;
	private PTextField txtNmF, txtNmM, txtNmL, txtPhone, txtAddr, txtId, txtCrewPos, txtFlight, txtRank, txtShop;
	boolean createNew;
	
	JButton btnDelete;
	
	Person p;
	
	
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
		
		createNew = true;

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

		txtNmM = new PTextField("e.x. Jack", true);
		txtNmM.setColumns(10);
		txtNmM.setBounds(6, 66, 234, 20);
		getFrame().getContentPane().add(txtNmM);

		txtCrewPos = new PTextField("e.x. AST", true);
		txtCrewPos.setBounds(6, 186, 234, 20);
		getFrame().getContentPane().add(txtCrewPos);

		JLabel lblSortieType = new JLabel("Crew Position");
		lblSortieType.setBounds(6, 166, 151, 20);
		getFrame().getContentPane().add(lblSortieType);

		txtRank = new PTextField("e.x. E-7", true);
		txtRank.setBounds(6, 146, 234, 20);
		getFrame().getContentPane().add(txtRank);

		JLabel lblSquadron = new JLabel("Rank");
		lblSquadron.setBounds(6, 126, 151, 20);
		getFrame().getContentPane().add(lblSquadron);

		JLabel lblEndDate = new JLabel("Middle Name");
		lblEndDate.setBounds(6, 46, 151, 20);
		getFrame().getContentPane().add(lblEndDate);

		txtNmF = new PTextField("e.x. John", true);
		txtNmF.setColumns(10);
		txtNmF.setBounds(6, 26, 234, 20);
		getFrame().getContentPane().add(txtNmF);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(6, 6, 151, 20);
		getFrame().getContentPane().add(lblFirstName);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(260, 437, 234, 35);
		getFrame().getContentPane().add(btnSubmit);

		txtNmL = new PTextField("e.x. Doe", true);
		txtNmL.setColumns(10);
		txtNmL.setBounds(6, 106, 234, 20);
		getFrame().getContentPane().add(txtNmL);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(6, 86, 151, 20);
		getFrame().getContentPane().add(lblLastName);

		txtShop = new PTextField("e.x. CSS", true);
		txtShop.setBounds(6, 266, 234, 20);
		getFrame().getContentPane().add(txtShop);

		JLabel lblShop = new JLabel("Shop");
		lblShop.setBounds(6, 246, 151, 20);
		getFrame().getContentPane().add(lblShop);

		txtFlight = new PTextField("e.x. J-Flight", true);
		txtFlight.setBounds(6, 226, 234, 20);
		getFrame().getContentPane().add(txtFlight);

		JLabel lblFlight = new JLabel("Flight");
		lblFlight.setBounds(6, 206, 151, 20);
		getFrame().getContentPane().add(lblFlight);

		JButton btnAddAppointment = new JButton("Add Appointment");
		btnAddAppointment.setBounds(260, 6, 234, 20);
		getFrame().getContentPane().add(btnAddAppointment);

		txtPhone = new PTextField("e.x. (000) 000-0000", true);
		txtPhone.setColumns(10);
		txtPhone.setBounds(6, 306, 234, 20);
		getFrame().getContentPane().add(txtPhone);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(6, 286, 151, 20);
		getFrame().getContentPane().add(lblPhoneNumber);

		txtAddr = new PTextField("e.x. 0000 Name St., City, ST 00000", true);
		txtAddr.setColumns(10);
		txtAddr.setBounds(6, 346, 234, 20);
		getFrame().getContentPane().add(txtAddr);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(6, 326, 151, 20);
		getFrame().getContentPane().add(lblAddress);

		txtId = new PTextField("e.x. 000-00-0000", true);
		txtId.setEnabled(false);
		txtId.setColumns(10);
		txtId.setBounds(6, 386, 234, 20);
		getFrame().getContentPane().add(txtId);

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
				if (createNew) {
					Person person = new Person(txtRank.getText(), txtNmF.getText(), txtNmM.getText(), txtNmL.getText(),
							txtCrewPos.getText(), txtShop.getText(), txtFlight.getText(), txtPhone.getText(),
							txtAddr.getText(), txtId.getText());
				} else {
					p.rank = txtRank.getText();
					p.nameFirst = txtNmF.getText();
					p.nameMiddle = txtNmM.getText();
					p.nameLast = txtNmL.getText();
					p.crewPos = txtCrewPos.getText();
					p.shop = txtShop.getText();
					p.flight = txtFlight.getText();
					p.phoneNumber = txtPhone.getText();
					p.address = txtAddr.getText();
					p.social = txtId.getText();
					
				}
				GUITelescope.refreshPersonList();
				frame.setVisible(false);
				frame.dispose();
				
			}
		});
	}
	
	private void initLoad(Person p) {
		this.p = p;
		
		createNew = false;
		
		getFrame().setTitle("Telescope - Person (Edit: " + p.nameLast + ")");
		txtNmF.setTextFill(p.nameFirst);
		txtNmM.setTextFill(p.nameMiddle);
		txtNmL.setTextFill(p.nameLast);
		txtAddr.setTextFill(p.address);
		txtId.setTextFill(p.social);
		txtPhone.setTextFill(p.phoneNumber);
		txtCrewPos.setTextFill(p.crewPos);
		txtFlight.setTextFill(p.flight);
		txtRank.setTextFill(p.rank);
		txtShop.setTextFill(p.shop);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(6, 437, 234, 35);
		getFrame().getContentPane().add(btnDelete);
		
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Main.personIndex.remove(p);
				
				GUITelescope.refreshPersonList();
				frame.setVisible(false);
				frame.dispose();
				
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrmTelescopeAdd(JFrame frmTelescopeAdd) {
		this.frame = frmTelescopeAdd;
	}
}
