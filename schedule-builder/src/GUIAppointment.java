package projDemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIAppointment {

	private JFrame frame;
	private JFormattedTextField ftfDateStart;
	private JFormattedTextField ftfDateEnd;
	private JFormattedTextField ftfDescription;

	public GUIAppointment(Person p) {
		initialize(p);
	}

	private void initialize(Person p) {
		setFrmTelescopeAppointment(new JFrame());
		getFrmTelescopeAppointment().setTitle("Telescope - Appointment - (Add/Edit)");
		getFrmTelescopeAppointment().setBounds(100, 100, 450, 300);
		getFrmTelescopeAppointment().getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 278);
		getFrmTelescopeAppointment().getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Start Date");
		lblNewLabel.setBounds(6, 6, 100, 20);
		panel.add(lblNewLabel);

		ftfDateStart = new JFormattedTextField();
		ftfDateStart.setText("dd-MMM-yyyy");
		ftfDateStart.setBounds(6, 26, 200, 20);
		panel.add(ftfDateStart);
		ftfDateStart.setColumns(10);

		ftfDateEnd = new JFormattedTextField();
		ftfDateEnd.setText("dd-MMM-yyyy");
		ftfDateEnd.setColumns(10);
		ftfDateEnd.setBounds(6, 66, 200, 20);
		panel.add(ftfDateEnd);

		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(6, 46, 100, 20);
		panel.add(lblEndDate);

		ftfDescription = new JFormattedTextField();
		ftfDescription.setText("Appointment information");
		ftfDescription.setColumns(10);
		ftfDescription.setBounds(6, 146, 200, 20);
		panel.add(ftfDescription);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(6, 126, 100, 20);
		panel.add(lblDescription);

		JLabel lblFlyable = new JLabel("Flyable");
		lblFlyable.setBounds(6, 86, 100, 20);
		panel.add(lblFlyable);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Yes", "No" }));
		comboBox.setBounds(6, 106, 200, 20);
		panel.add(comboBox);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(6, 186, 200, 40);
		panel.add(btnSubmit);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (true) {

					LocalDate startDate, endDate;
					boolean isFlyable = false;
					String description;

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

					startDate = LocalDate.parse(ftfDateStart.getText(), formatter);
					endDate = LocalDate.parse(ftfDateStart.getText(), formatter);

					switch (comboBox.getSelectedItem().toString()) {
					case "Yes":
						isFlyable = true;
						break;
					case "No":
						isFlyable = false;
						break;
					default:
						System.err.println("Error.");
					}

					description = ftfDescription.getText();

					Appointment a = new Appointment(startDate, endDate, isFlyable, description);
					p.calendar.add(a);

					frame.setVisible(false);
					frame.dispose();
				}

			}
		});
	}

	public JFrame getFrmTelescopeAppointment() {
		return frame;
	}

	public void setFrmTelescopeAppointment(JFrame frmTelescopeAppointment) {
		this.frame = frmTelescopeAppointment;
	}
}
