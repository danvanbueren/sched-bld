package projDemo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class GUISortie {

	private JFrame frame;
	private JTextField txtFilter;
	private JTextField txtDdmmmyyyy;
	private JTextField txtDdmmmyyyy_1;

	/*
	 * public void editSortie() { EventQueue.invokeLater(new Runnable() { public
	 * void run() { try { SortieGUI window = new SortieGUI(1);
	 * window.getFrame().setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 **
	 * 
	 * Create the application.
	 */
	public GUISortie(int mode) {
		initialize(mode);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	private void initialize(int mode) {
		setFrame(new JFrame());
		getFrame().setTitle("Telescope - Sortie - (Add/Edit)");
		getFrame().setBounds(100, 100, 500, 500);
		getFrame().getContentPane().setLayout(null);

		JList<String> list = new JList<String>();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Person 1", "Person 2", "Person 3", "Person 4" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(260, 49, 234, 383);
		getFrame().getContentPane().add(list);

		JList<String> list_1 = new JList<String>();
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] { "Person 5", "Person 6", "Person 7" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setBounds(6, 223, 244, 249);
		getFrame().getContentPane().add(list_1);

		txtFilter = new JTextField();
		txtFilter.setText("Filter");
		txtFilter.setBounds(260, 11, 234, 26);
		getFrame().getContentPane().add(txtFilter);
		txtFilter.setColumns(10);

		txtDdmmmyyyy = new JTextField();
		txtDdmmmyyyy.setText("dd-MMM-yyyy");
		txtDdmmmyyyy.setColumns(10);
		txtDdmmmyyyy.setBounds(6, 71, 234, 26);
		getFrame().getContentPane().add(txtDdmmmyyyy);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "J-Sortie", "T-Sortie", "P-Sortie", "X-Sortie", "S-Sortie", "W-Sortie" }));
		comboBox.setBounds(5, 171, 243, 27);
		getFrame().getContentPane().add(comboBox);

		JLabel lblLoadlist = new JLabel("Loadlist");
		lblLoadlist.setBounds(6, 198, 151, 25);
		getFrame().getContentPane().add(lblLoadlist);

		JLabel lblSortieType = new JLabel("Sortie Type");
		lblSortieType.setBounds(5, 147, 151, 25);
		getFrame().getContentPane().add(lblSortieType);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] { "960 AACS", "961 AACS", "962 AACS",
				"963 AACS", "964 AACS", "965 AACS", "966 AACS", "970 AACS" }));
		comboBox_1.setBounds(6, 121, 243, 27);
		getFrame().getContentPane().add(comboBox_1);

		JLabel lblSquadron = new JLabel("Squadron");
		lblSquadron.setBounds(6, 97, 151, 25);
		getFrame().getContentPane().add(lblSquadron);

		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(6, 49, 151, 25);
		getFrame().getContentPane().add(lblEndDate);

		txtDdmmmyyyy_1 = new JTextField();
		txtDdmmmyyyy_1.setText("dd-MMM-yyyy");
		txtDdmmmyyyy_1.setColumns(10);
		txtDdmmmyyyy_1.setBounds(6, 28, 234, 26);
		getFrame().getContentPane().add(txtDdmmmyyyy_1);

		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(6, 6, 151, 25);
		getFrame().getContentPane().add(lblStartDate);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(260, 437, 234, 35);
		getFrame().getContentPane().add(btnSubmit);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (true) {
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
