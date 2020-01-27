package projDemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class GUISortie {

	private JFrame frame;
	private JTextField txtFilter;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

	DefaultListModel<Person> modelRoster, modelLoadlist;
	JList<Person> listRoster, listLoadlist;

	JLabel lblLoadlist, lblFilter, lblSortieType, lblSquadron, lblEndDate, lblStartDate, lblSame;
	JComboBox<String> comboSortieType, comboSquadron;
	JFormattedTextField txtEndDate, txtStartDate;
	JCheckBox chckSameDate;
	JButton btnSubmit, btnDelete;

	boolean createNew;

	Sortie s;

	public GUISortie() {
		initialize();
	}

	public GUISortie(Sortie s) {
		initialize();
		initializeExisting(s);
	}

	private void initializeExisting(Sortie s) {
		this.s = s;
		createNew = false;

		getFrame().setTitle("Telescope - Sortie (Edit: " + s.sortieNumber + ")");

		txtStartDate.setText(s.startDate.format(formatter));
		txtEndDate.setText(s.endDate.format(formatter));

		comboSquadron.setSelectedItem("96" + s.sortieNumber.charAt(1) + " AACS");
		/*
		 * THE ABOVE ITEM IS BROKEN AND NEEDS TO BE DONE PROPERLY (DOES NOT INCLUDE
		 * 70th)
		 */

		comboSortieType.setSelectedItem(s.sortieNumber.charAt(2) + "-Sortie");

		listRoster.setEnabled(true);
		listLoadlist.setEnabled(true);
		refreshLists();

		btnSubmit.setBounds(260, 437, 117, 35);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(377, 437, 117, 35);
		getFrame().getContentPane().add(btnDelete);

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Main.sortieIndex.remove(s);

				GUITelescope.refreshSortieList();
				frame.setVisible(false);
				frame.dispose();

			}
		});

	}

	private void initialize() {

		createNew = true;

		/*
		 * Frame Settings
		 */
		setFrame(new JFrame());
		getFrame().setTitle("Telescope - Sortie (Add)");
		getFrame().setBounds(100, 100, 500, 500);
		getFrame().getContentPane().setLayout(null);
		getFrame().setResizable(false);

		/*
		 * Roster List
		 */
		modelRoster = new DefaultListModel<Person>();
		listRoster = new JList<Person>();
		listRoster.setModel(modelRoster);
		listRoster.setBounds(260, 40, 234, 392);
		getFrame().getContentPane().add(listRoster);

		/*
		 * Load List
		 */
		lblLoadlist = new JLabel("Loadlist");
		lblLoadlist.setBounds(6, 198, 151, 25);
		getFrame().getContentPane().add(lblLoadlist);

		modelLoadlist = new DefaultListModel<Person>();
		listLoadlist = new JList<Person>();
		listLoadlist.setModel(modelLoadlist);
		listLoadlist.setBounds(6, 223, 244, 249);
		getFrame().getContentPane().add(listLoadlist);

		/*
		 * Filter box
		 */
		txtFilter = new JTextField();
		txtFilter.setEnabled(false);
		txtFilter.setBounds(300, 11, 194, 26);
		getFrame().getContentPane().add(txtFilter);
		txtFilter.setColumns(10);

		/*
		 * Sortie type
		 */

		lblFilter = new JLabel("Filter");
		lblFilter.setBounds(260, 12, 40, 25);
		frame.getContentPane().add(lblFilter);
		lblSortieType = new JLabel("Sortie Type");
		lblSortieType.setBounds(5, 147, 151, 25);
		getFrame().getContentPane().add(lblSortieType);

		comboSortieType = new JComboBox<String>();
		comboSortieType.setModel(new DefaultComboBoxModel<String>(
				new String[] { "J-Sortie", "T-Sortie", "P-Sortie", "X-Sortie", "S-Sortie", "W-Sortie" }));
		comboSortieType.setBounds(5, 171, 243, 27);
		getFrame().getContentPane().add(comboSortieType);

		/*
		 * Squadron
		 */
		lblSquadron = new JLabel("Squadron");
		lblSquadron.setBounds(6, 97, 151, 25);
		getFrame().getContentPane().add(lblSquadron);

		comboSquadron = new JComboBox<String>();
		comboSquadron.setModel(new DefaultComboBoxModel<String>(new String[] { "960 AACS", "961 AACS", "962 AACS",
				"963 AACS", "964 AACS", "965 AACS", "966 AACS", "970 AACS" }));
		comboSquadron.setSelectedItem("963 AACS");
		comboSquadron.setEnabled(false);
		comboSquadron.setBounds(6, 121, 243, 27);
		getFrame().getContentPane().add(comboSquadron);

		/*
		 * START / END DATES
		 */
		lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(6, 49, 100, 25);
		getFrame().getContentPane().add(lblEndDate);

		txtEndDate = new JFormattedTextField(df);
		txtEndDate.setColumns(10);
		txtEndDate.setBounds(6, 71, 234, 26);
		getFrame().getContentPane().add(txtEndDate);

		lblStartDate = new JLabel("Start Date (dd-MMM-yyyy)");
		lblStartDate.setBounds(6, 6, 170, 25);
		getFrame().getContentPane().add(lblStartDate);

		txtStartDate = new JFormattedTextField(df);

		txtStartDate.setColumns(10);
		txtStartDate.setBounds(6, 28, 234, 26);
		getFrame().getContentPane().add(txtStartDate);

		/*
		 * Same Date for end date option
		 */
		lblSame = new JLabel("Same?");
		lblSame.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSame.setBounds(106, 50, 100, 25);
		frame.getContentPane().add(lblSame);

		chckSameDate = new JCheckBox("");
		chckSameDate.setSelected(true);
		txtEndDate.setEnabled(false);

		chckSameDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckSameDate.isSelected()) {
					txtEndDate.setEnabled(false);
					txtEndDate.setText(txtStartDate.getText());
				} else {
					txtEndDate.setEnabled(true);
				}
			}
		});

		/*
		 * Update End Date box with listener
		 */
		txtStartDate.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent de) {
				if (chckSameDate.isSelected())
					txtEndDate.setText(txtStartDate.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent de) {
				if (chckSameDate.isSelected())
					txtEndDate.setText(txtStartDate.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent de) {
				if (chckSameDate.isSelected())
					txtEndDate.setText(txtStartDate.getText());
			}
		});

		chckSameDate.setBounds(210, 50, 28, 23);
		frame.getContentPane().add(chckSameDate);

		/*
		 * SUBMIT
		 */
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(260, 437, 234, 35);
		getFrame().getContentPane().add(btnSubmit);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (createNew) {
					ObjectFunctions.systemCreateSortie(txtStartDate.getText(), txtEndDate.getText(),
							comboSquadron.getSelectedItem().toString(), comboSortieType.getSelectedItem().toString());
				} else {
					ArrayList<Person> tempLoadList = new ArrayList<>();
					
					for(int i = 0; i < modelLoadlist.getSize(); i++) {
						tempLoadList.add(modelLoadlist.elementAt(i));
						System.out.println("i: " + i + ". " + modelLoadlist.elementAt(i));
					}
					
					s = ObjectFunctions.systemEditSortie(s, tempLoadList, txtStartDate.getText(),
							txtEndDate.getText(), comboSquadron.getSelectedItem().toString(),
							comboSortieType.getSelectedItem().toString());
					/*
					 * NEED TO ADD LOADLIST!!!
					 */
				}
				GUITelescope.refreshSortieList();
				frame.setVisible(false);
				frame.dispose();
			}
		});

		listRoster.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				@SuppressWarnings("rawtypes")
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() >= 2) {
					int index = list.locationToIndex(evt.getPoint());
					if (index != -1) {
						Person p = modelRoster.elementAt(index);

						// CHANGE STATE TO LOADLIST
						modelRoster.removeElement(p);
						modelLoadlist.addElement(p);
					}
				}
			}
		});

		listLoadlist.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				@SuppressWarnings("rawtypes")
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() >= 2) {
					int index = list.locationToIndex(evt.getPoint());
					if (index != -1) {
						Person p = modelLoadlist.elementAt(index);

						// CHANGE STATE TO LOADLIST
						modelLoadlist.removeElement(p);
						modelRoster.addElement(p);
					}

				}
			}
		});
	}

	public void refreshLists() {
		modelLoadlist.clear();
		modelRoster.clear();

		for (Person p : Main.personIndex) {
			modelRoster.addElement(p);
			System.out.println(p.nameFirst);
		}

		for (Person p : s.loadList) {
			modelLoadlist.addElement(p);
			System.out.println(p.nameFirst);
		}

		listLoadlist.setModel(modelLoadlist);
		listRoster.setModel(modelRoster);
		System.out.println("refresh list");
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
