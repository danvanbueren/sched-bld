package projDemo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class GUIPerson {

	private JFrame frame;
	private JTextField txtNmF, txtNmM, txtNmL, txtPhone, txtAddr, txtId, txtCrewPos, txtFlight, txtRank, txtShop;
	boolean createNew;
	JList<String> list;
	JButton btnAddAppointment;
	DefaultListModel<String> listModel;

	JButton btnDelete;

	Person p;

	public GUIPerson() {
		initialize();
	}

	public GUIPerson(Person p) {
		initialize();
		initLoad(p);
	}

	private void initialize() {

		createNew = true;

		setFrmTelescopeAdd(new JFrame());
		getFrame().setTitle("Telescope - Person (Add)");
		getFrame().setBounds(100, 100, 500, 500);
		getFrame().getContentPane().setLayout(null);

		list = new JList<String>();

		listModel = new DefaultListModel<String>();
		list.setModel(listModel);

		list.setBounds(260, 26, 234, 406);
		getFrame().getContentPane().add(list);
		list.setEnabled(false);

		txtNmM = new JTextField();
		txtNmM.setColumns(10);
		txtNmM.setBounds(6, 66, 234, 20);
		getFrame().getContentPane().add(txtNmM);

		txtCrewPos = new JTextField();
		txtCrewPos.setBounds(6, 186, 234, 20);
		getFrame().getContentPane().add(txtCrewPos);

		JLabel lblSortieType = new JLabel("Crew Position");
		lblSortieType.setBounds(6, 166, 151, 20);
		getFrame().getContentPane().add(lblSortieType);

		txtRank = new JTextField();
		txtRank.setBounds(6, 146, 234, 20);
		getFrame().getContentPane().add(txtRank);

		JLabel lblSquadron = new JLabel("Rank");
		lblSquadron.setBounds(6, 126, 151, 20);
		getFrame().getContentPane().add(lblSquadron);

		JLabel lblEndDate = new JLabel("Middle Name");
		lblEndDate.setBounds(6, 46, 151, 20);
		getFrame().getContentPane().add(lblEndDate);

		txtNmF = new JTextField();
		txtNmF.setColumns(10);
		txtNmF.setBounds(6, 26, 234, 20);
		getFrame().getContentPane().add(txtNmF);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(6, 6, 151, 20);
		getFrame().getContentPane().add(lblFirstName);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(260, 437, 234, 35);
		getFrame().getContentPane().add(btnSubmit);

		txtNmL = new JTextField();
		txtNmL.setColumns(10);
		txtNmL.setBounds(6, 106, 234, 20);
		getFrame().getContentPane().add(txtNmL);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(6, 86, 151, 20);
		getFrame().getContentPane().add(lblLastName);

		txtShop = new JTextField();
		txtShop.setBounds(6, 266, 234, 20);
		getFrame().getContentPane().add(txtShop);

		JLabel lblShop = new JLabel("Shop");
		lblShop.setBounds(6, 246, 151, 20);
		getFrame().getContentPane().add(lblShop);

		txtFlight = new JTextField();
		txtFlight.setBounds(6, 226, 234, 20);
		getFrame().getContentPane().add(txtFlight);

		JLabel lblFlight = new JLabel("Flight");
		lblFlight.setBounds(6, 206, 151, 20);
		getFrame().getContentPane().add(lblFlight);

		btnAddAppointment = new JButton("Add Appointment");
		btnAddAppointment.setBounds(260, 6, 234, 20);
		getFrame().getContentPane().add(btnAddAppointment);
		btnAddAppointment.setEnabled(false);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(6, 306, 234, 20);
		getFrame().getContentPane().add(txtPhone);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(6, 286, 151, 20);
		getFrame().getContentPane().add(lblPhoneNumber);

		txtAddr = new JTextField();
		txtAddr.setColumns(10);
		txtAddr.setBounds(6, 346, 234, 20);
		getFrame().getContentPane().add(txtAddr);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(6, 326, 151, 20);
		getFrame().getContentPane().add(lblAddress);

		txtId = new JTextField();
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
							GUIAppointment window = new GUIAppointment(p);
							window.getFrmTelescopeAppointment().setVisible(true);
							refreshList();
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
					@SuppressWarnings("unused")
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
		txtNmF.setText(p.nameFirst);
		txtNmM.setText(p.nameMiddle);
		txtNmL.setText(p.nameLast);
		txtAddr.setText(p.address);
		txtId.setText(p.social);
		txtPhone.setText(p.phoneNumber);
		txtCrewPos.setText(p.crewPos);
		txtFlight.setText(p.flight);
		txtRank.setText(p.rank);
		txtShop.setText(p.shop);

		list.setEnabled(true);
		refreshList();

		btnAddAppointment.setEnabled(true);

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

	public void refreshList() {
		listModel.clear();
		for (Appointment a : p.calendar) {
			listModel.addElement(a.startDate + " - " + a.description);
			System.out.println(a.description);
		}

		list.setModel(listModel);
		System.out.println("refresh list");
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrmTelescopeAdd(JFrame frmTelescopeAdd) {
		this.frame = frmTelescopeAdd;
	}
}
