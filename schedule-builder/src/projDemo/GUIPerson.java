package projDemo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.UUID;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import projDemo.LookbackMeter.Month;

public class GUIPerson {

	public UUID windowSignature;

	private JFrame frame;
	private JTextField txtNmF, txtNmM, txtNmL, txtPhone, txtAddr, txtId, txtCrewPos, txtFlight, txtRank, txtShop;
	boolean createNew;

	private LookbackMeter meterLookback;
	private CurrencyMeter meterCurrency;
	private GroundingMeter meterGrounding;

	JButton btnAddAppointment;

	JList<Appointment> list;
	DefaultListModel<Appointment> listModel;
	JScrollPane scroll;

	JButton btnDelete;

	Person p;

	public GUIPerson() {
		initialize();
	}

	public GUIPerson(Person p) {
		initialize();
		initializeExisting(p);
	}

	private void initialize() {

		windowSignature = UUID.randomUUID();

		GUITelescope.personWindowSignatures.add(this);

		createNew = true;

		JLabel lblSortieType = new JLabel("Crew Position");
		JLabel lblSquadron = new JLabel("Rank");
		JLabel lblEndDate = new JLabel("Middle Name");
		JLabel lblFirstName = new JLabel("First Name");
		JButton btnSubmit = new JButton("Submit");
		JLabel lblLastName = new JLabel("Last Name");
		JLabel lblShop = new JLabel("Shop");
		JLabel lblFlight = new JLabel("Flight");
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		JLabel lblAddress = new JLabel("Address");
		JLabel lblSocial = new JLabel("Individual Identifier");

		setFrmTelescopeAdd(new JFrame());
		getFrame().setTitle("Telescope - Person (Add)");
		getFrame().setBounds(100, 100, 500, 500);
		getFrame().getContentPane().setLayout(null);
		getFrame().setResizable(false);

		list = new JList<Appointment>();
		listModel = new DefaultListModel<Appointment>();
		list.setModel(listModel);
		list.setBounds(260, 26, 234, 406);

		scroll = new JScrollPane(list);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(260, 26, 234, 406);

		getFrame().getContentPane().add(scroll);
		list.setEnabled(false);

		txtNmM = new JTextField();
		txtNmM.setColumns(10);
		txtNmM.setBounds(6, 66, 234, 20);
		getFrame().getContentPane().add(txtNmM);

		txtCrewPos = new JTextField();
		txtCrewPos.setBounds(6, 186, 234, 20);
		getFrame().getContentPane().add(txtCrewPos);

		lblSortieType.setBounds(6, 166, 151, 20);
		getFrame().getContentPane().add(lblSortieType);

		txtRank = new JTextField();
		txtRank.setBounds(6, 146, 234, 20);
		getFrame().getContentPane().add(txtRank);

		lblSquadron.setBounds(6, 126, 151, 20);
		getFrame().getContentPane().add(lblSquadron);

		lblEndDate.setBounds(6, 46, 151, 20);
		getFrame().getContentPane().add(lblEndDate);

		txtNmF = new JTextField();
		txtNmF.setColumns(10);
		txtNmF.setBounds(6, 26, 234, 20);
		getFrame().getContentPane().add(txtNmF);

		lblFirstName.setBounds(6, 6, 151, 20);
		getFrame().getContentPane().add(lblFirstName);

		btnSubmit.setBounds(260, 437, 234, 35);
		getFrame().getContentPane().add(btnSubmit);

		txtNmL = new JTextField();
		txtNmL.setColumns(10);
		txtNmL.setBounds(6, 106, 234, 20);
		getFrame().getContentPane().add(txtNmL);

		lblLastName.setBounds(6, 86, 151, 20);
		getFrame().getContentPane().add(lblLastName);

		txtShop = new JTextField();
		txtShop.setBounds(6, 266, 234, 20);
		getFrame().getContentPane().add(txtShop);

		lblShop.setBounds(6, 246, 151, 20);
		getFrame().getContentPane().add(lblShop);

		txtFlight = new JTextField();
		txtFlight.setBounds(6, 226, 234, 20);
		getFrame().getContentPane().add(txtFlight);

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

		lblPhoneNumber.setBounds(6, 286, 151, 20);
		getFrame().getContentPane().add(lblPhoneNumber);

		txtAddr = new JTextField();
		txtAddr.setColumns(10);
		txtAddr.setBounds(6, 346, 234, 20);
		getFrame().getContentPane().add(txtAddr);

		lblAddress.setBounds(6, 326, 151, 20);
		getFrame().getContentPane().add(lblAddress);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setColumns(10);
		txtId.setBounds(6, 386, 234, 20);
		getFrame().getContentPane().add(txtId);

		lblSocial.setBounds(6, 366, 151, 20);
		getFrame().getContentPane().add(lblSocial);

		// Open new window to get appointments
		btnAddAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GUIAppointment window = new GUIAppointment(p, windowSignature);
							window.getFrame().setVisible(true);
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

		// Open SortieGUI in edit state
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				@SuppressWarnings("rawtypes")
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() >= 2) {
					int index = list.locationToIndex(evt.getPoint());
					Appointment a = p.calendar.get(index);
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								GUIAppointment window = new GUIAppointment(p, windowSignature, a);
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

	private void initializeExisting(Person p) {
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

		getFrame().setBounds(100, 100, 650, 500);

		/*
		 * PERSON STATUS
		 */
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(500, 5, 140, 25);
		lblStatus.setFont(new Font(null, 1, 20));
		getFrame().getContentPane().add(lblStatus);

		/*
		 * LOOKBACK METER
		 */
		JLabel lblLookback = new JLabel("Lookback");
		lblLookback.setBounds(500, 30, 140, 25);
		getFrame().getContentPane().add(lblLookback);

		meterLookback = new LookbackMeter(500, 50, 140, 25);
		getFrame().getContentPane().add(meterLookback.getPanel());

		if (ObjectFunctions.getLookbackStatus(p, Month.ONE_MONTH)) {
			meterLookback.setState(LookbackMeter.State.PASS, Month.ONE_MONTH);
		} else {
			meterLookback.setState(LookbackMeter.State.FAIL, Month.ONE_MONTH);
		}

		meterLookback.setLabelNumber(p.lookbackOne, Month.ONE_MONTH);
		meterLookback.setPanelTooltip(ObjectFunctions.getTooltipForLookbackMeter(p, Month.ONE_MONTH), Month.ONE_MONTH);

		if (ObjectFunctions.getLookbackStatus(p, Month.THREE_MONTH)) {
			meterLookback.setState(LookbackMeter.State.PASS, Month.THREE_MONTH);
		} else {
			meterLookback.setState(LookbackMeter.State.FAIL, Month.THREE_MONTH);
		}

		meterLookback.setLabelNumber(p.lookbackThree, Month.THREE_MONTH);
		meterLookback.setPanelTooltip(ObjectFunctions.getTooltipForLookbackMeter(p, Month.THREE_MONTH), Month.THREE_MONTH);

		/*
		 * CURRENCY METER
		 */
		JLabel lblCurrency = new JLabel("Currency");
		lblCurrency.setBounds(500, 80, 140, 25);
		getFrame().getContentPane().add(lblCurrency);

		meterCurrency = new CurrencyMeter(500, 100, 140, 25);
		getFrame().getContentPane().add(meterCurrency.getPanel());
		
		if (ObjectFunctions.getCurrencyStatus(p)) {
			meterCurrency.setState(CurrencyMeter.State.PASS);
		} else {
			meterCurrency.setState(CurrencyMeter.State.FAIL);
		}

		meterCurrency.setLabelNumber(ObjectFunctions.getCurrencyDaysLeft(p));
		meterCurrency.setPanelTooltip(ObjectFunctions.getTooltipForCurrencyMeter(p));
		
		/*
		 * GROUNDING TAGS
		 */
		JLabel lblGrounding = new JLabel("Grounding Tags");
		lblGrounding.setBounds(500, 130, 140, 25);
		getFrame().getContentPane().add(lblGrounding);
		
		meterGrounding = new GroundingMeter(500, 150, 140, 25);
		getFrame().getContentPane().add(meterGrounding.getPanel());
		
		ObjectFunctions.groundingMeterManager(p, meterGrounding);
	}

	public void refreshList() {
		listModel.clear();
		for (Appointment a : p.calendar) {
			listModel.addElement(a);
		}

		list.setModel(listModel);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrmTelescopeAdd(JFrame frmTelescopeAdd) {
		this.frame = frmTelescopeAdd;
	}
}
