import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class AppointmentGUI {

	private JFrame frmTelescopeAppointment;
	private JTextField txtDdmmmyyyy;
	private JTextField txtDdmmmyyyy_1;
	private JTextField txtBriefDescriptionOf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentGUI window = new AppointmentGUI();
					window.frmTelescopeAppointment.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppointmentGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelescopeAppointment = new JFrame();
		frmTelescopeAppointment.setTitle("Telescope - Appointment - (Add/Edit)");
		frmTelescopeAppointment.setBounds(100, 100, 450, 300);
		frmTelescopeAppointment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelescopeAppointment.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 278);
		frmTelescopeAppointment.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Start Date");
		lblNewLabel.setBounds(6, 6, 100, 20);
		panel.add(lblNewLabel);
		
		txtDdmmmyyyy = new JTextField();
		txtDdmmmyyyy.setText("dd-MMM-yyyy");
		txtDdmmmyyyy.setBounds(6, 26, 200, 20);
		panel.add(txtDdmmmyyyy);
		txtDdmmmyyyy.setColumns(10);
		
		txtDdmmmyyyy_1 = new JTextField();
		txtDdmmmyyyy_1.setText("dd-MMM-yyyy");
		txtDdmmmyyyy_1.setColumns(10);
		txtDdmmmyyyy_1.setBounds(6, 66, 200, 20);
		panel.add(txtDdmmmyyyy_1);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(6, 46, 100, 20);
		panel.add(lblEndDate);
		
		txtBriefDescriptionOf = new JTextField();
		txtBriefDescriptionOf.setText("Appointment information");
		txtBriefDescriptionOf.setColumns(10);
		txtBriefDescriptionOf.setBounds(6, 146, 200, 20);
		panel.add(txtBriefDescriptionOf);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(6, 126, 100, 20);
		panel.add(lblDescription);
		
		JLabel lblFlyable = new JLabel("Flyable");
		lblFlyable.setBounds(6, 86, 100, 20);
		panel.add(lblFlyable);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		comboBox.setBounds(6, 106, 200, 20);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(6, 186, 200, 40);
		panel.add(btnNewButton);
	}
}
