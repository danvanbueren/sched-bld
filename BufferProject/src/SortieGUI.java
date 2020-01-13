import java.awt.EventQueue;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class SortieGUI {

	private JFrame frmTelescopeAdd;
	private JTextField txtFilter;
	private JTextField txtDdmmmyyyy;
	private JTextField txtDdmmmyyyy_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortieGUI window = new SortieGUI();
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
	public SortieGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelescopeAdd = new JFrame();
		frmTelescopeAdd.setTitle("Telescope - Sortie - (Add/Edit)");
		frmTelescopeAdd.setBounds(100, 100, 500, 500);
		frmTelescopeAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelescopeAdd.getContentPane().setLayout(null);

		JList list = new JList();
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
		frmTelescopeAdd.getContentPane().add(list);

		JList list_1 = new JList();
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
		frmTelescopeAdd.getContentPane().add(list_1);

		txtFilter = new JTextField();
		txtFilter.setText("Filter");
		txtFilter.setBounds(260, 11, 234, 26);
		frmTelescopeAdd.getContentPane().add(txtFilter);
		txtFilter.setColumns(10);

		txtDdmmmyyyy = new JTextField();
		txtDdmmmyyyy.setText("dd-MMM-yyyy");
		txtDdmmmyyyy.setColumns(10);
		txtDdmmmyyyy.setBounds(6, 71, 234, 26);
		frmTelescopeAdd.getContentPane().add(txtDdmmmyyyy);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"J-Sortie", "T-Sortie", "P-Sortie", "X-Sortie", "S-Sortie", "W-Sortie"}));
		comboBox.setBounds(5, 171, 243, 27);
		frmTelescopeAdd.getContentPane().add(comboBox);

		JLabel lblLoadlist = new JLabel("Loadlist");
		lblLoadlist.setBounds(6, 198, 151, 25);
		frmTelescopeAdd.getContentPane().add(lblLoadlist);

		JLabel lblSortieType = new JLabel("Sortie Type");
		lblSortieType.setBounds(5, 147, 151, 25);
		frmTelescopeAdd.getContentPane().add(lblSortieType);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"960 AACS", "961 AACS", "962 AACS", "963 AACS", "964 AACS", "965 AACS", "966 AACS", "970 AACS"}));
		comboBox_1.setBounds(6, 121, 243, 27);
		frmTelescopeAdd.getContentPane().add(comboBox_1);

		JLabel lblSquadron = new JLabel("Squadron");
		lblSquadron.setBounds(6, 97, 151, 25);
		frmTelescopeAdd.getContentPane().add(lblSquadron);

		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(6, 49, 151, 25);
		frmTelescopeAdd.getContentPane().add(lblEndDate);

		txtDdmmmyyyy_1 = new JTextField();
		txtDdmmmyyyy_1.setText("dd-MMM-yyyy");
		txtDdmmmyyyy_1.setColumns(10);
		txtDdmmmyyyy_1.setBounds(6, 28, 234, 26);
		frmTelescopeAdd.getContentPane().add(txtDdmmmyyyy_1);

		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(6, 6, 151, 25);
		frmTelescopeAdd.getContentPane().add(lblStartDate);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(260, 437, 234, 35);
		frmTelescopeAdd.getContentPane().add(btnNewButton);
	}
}
