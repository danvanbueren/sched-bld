package projDemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

	public GUISortie() {
		initialize();
	}

	private void initialize() {

		/*
		 * Frame Settings
		 */
		setFrame(new JFrame());
		getFrame().setTitle("Telescope - Sortie - (Add/Edit)");
		getFrame().setBounds(100, 100, 500, 500);
		getFrame().getContentPane().setLayout(null);
		getFrame().setResizable(false);

		/*
		 * Roster List
		 */
		DefaultListModel<String> modelRoster = new DefaultListModel<String>();
		JList<String> listRoster = new JList<String>();
		listRoster.setModel(modelRoster);
		listRoster.setBounds(260, 40, 234, 392);
		getFrame().getContentPane().add(listRoster);

		/*
		 * Load List
		 */
		JLabel lblLoadlist = new JLabel("Loadlist");
		lblLoadlist.setBounds(6, 198, 151, 25);
		getFrame().getContentPane().add(lblLoadlist);

		DefaultListModel<String> modelLoadlist = new DefaultListModel<String>();
		JList<String> listLoadlist = new JList<String>();
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

		JLabel lblFilter = new JLabel("Filter");
		lblFilter.setBounds(260, 12, 40, 25);
		frame.getContentPane().add(lblFilter);
		JLabel lblSortieType = new JLabel("Sortie Type");
		lblSortieType.setBounds(5, 147, 151, 25);
		getFrame().getContentPane().add(lblSortieType);

		JComboBox<String> comboSortieType = new JComboBox<String>();
		comboSortieType.setModel(new DefaultComboBoxModel<String>(
				new String[] { "J-Sortie", "T-Sortie", "P-Sortie", "X-Sortie", "S-Sortie", "W-Sortie" }));
		comboSortieType.setBounds(5, 171, 243, 27);
		getFrame().getContentPane().add(comboSortieType);

		/*
		 * Squadron
		 */
		JLabel lblSquadron = new JLabel("Squadron");
		lblSquadron.setBounds(6, 97, 151, 25);
		getFrame().getContentPane().add(lblSquadron);

		JComboBox<String> comboSquadron = new JComboBox<String>();
		comboSquadron.setModel(new DefaultComboBoxModel<String>(new String[] { "960 AACS", "961 AACS", "962 AACS",
				"963 AACS", "964 AACS", "965 AACS", "966 AACS", "970 AACS" }));
		comboSquadron.setSelectedItem("963 AACS");
		comboSquadron.setEnabled(false);
		comboSquadron.setBounds(6, 121, 243, 27);
		getFrame().getContentPane().add(comboSquadron);

		/*
		 * START / END DATES
		 */
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(6, 49, 100, 25);
		getFrame().getContentPane().add(lblEndDate);

		JFormattedTextField txtEndDate = new JFormattedTextField(df);
		txtEndDate.setColumns(10);
		txtEndDate.setBounds(6, 71, 234, 26);
		getFrame().getContentPane().add(txtEndDate);

		JLabel lblStartDate = new JLabel("Start Date (dd-MMM-yyyy)");
		lblStartDate.setBounds(6, 6, 170, 25);
		getFrame().getContentPane().add(lblStartDate);

		JFormattedTextField txtStartDate = new JFormattedTextField(df);

		txtStartDate.setColumns(10);
		txtStartDate.setBounds(6, 28, 234, 26);
		getFrame().getContentPane().add(txtStartDate);

		/*
		 * Same Date for end date option
		 */
		JLabel lblSame = new JLabel("Same?");
		lblSame.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSame.setBounds(106, 50, 100, 25);
		frame.getContentPane().add(lblSame);

		JCheckBox chckSameDate = new JCheckBox("");
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
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(260, 437, 234, 35);
		getFrame().getContentPane().add(btnSubmit);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (true) {
					ObjectFunctions.systemCreateSortie(txtStartDate.getText(), txtEndDate.getText(),
							comboSquadron.getSelectedItem().toString(), comboSortieType.getSelectedItem().toString());
					GUITelescope.refreshSortieList();
					frame.setVisible(false);
					frame.dispose();
				}

			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
