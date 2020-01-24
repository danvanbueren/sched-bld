package projDemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class GUIAppointment {

	private JFrame frame;
	private JFormattedTextField ftfDescription;

	public GUIAppointment(Person p, UUID windowSignature) {
		initialize(p, windowSignature);
	}

	private void initialize(Person p, UUID windowSignature) {
		setFrame(new JFrame());
		getFrame().setTitle("Telescope - Appointment - (Add/Edit)");
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().getContentPane().setLayout(null);
		getFrame().setResizable(false);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 278);
		getFrame().getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Start Date (dd-MMM-yyyy)");
		lblNewLabel.setBounds(6, 6, 200, 20);
		panel.add(lblNewLabel);

		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(6, 46, 100, 20);
		panel.add(lblEndDate);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(6, 126, 100, 20);
		panel.add(lblDescription);

		JLabel lblFlyable = new JLabel("Flyable");
		lblFlyable.setBounds(6, 86, 100, 20);
		panel.add(lblFlyable);

		ftfDescription = new JFormattedTextField();
		ftfDescription.setColumns(10);
		ftfDescription.setBounds(6, 146, 200, 20);
		panel.add(ftfDescription);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Yes", "No" }));
		comboBox.setBounds(6, 106, 200, 20);
		comboBox.setSelectedItem("No");
		panel.add(comboBox);

		/*
		 * START / END DATES
		 */
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

		JFormattedTextField txtEndDate = new JFormattedTextField(df);
		txtEndDate.setColumns(10);
		txtEndDate.setBounds(6, 66, 200, 20);
		panel.add(txtEndDate);

		JFormattedTextField txtStartDate = new JFormattedTextField(df);

		txtStartDate.setColumns(10);
		txtStartDate.setBounds(6, 26, 200, 20);
		panel.add(txtStartDate);

		/*
		 * Same Date for end date option
		 */
		JLabel lblSame = new JLabel("Same?");
		lblSame.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSame.setBounds(76, 45, 100, 25);
		panel.add(lblSame);

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

		chckSameDate.setBounds(180, 45, 28, 23);
		panel.add(chckSameDate);

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

					startDate = LocalDate.parse(txtStartDate.getText(), formatter);
					endDate = LocalDate.parse(txtEndDate.getText(), formatter);

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

					p.calendar.add(new Appointment(startDate, endDate, isFlyable, description));

					for (GUIPerson window : GUITelescope.personWindowSignatures) {

						if (window.windowSignature.equals(windowSignature)) {
							window.refreshList();
						}

					}

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
