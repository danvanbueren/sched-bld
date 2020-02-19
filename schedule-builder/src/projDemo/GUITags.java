package projDemo;

import java.awt.Font;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import projDemo.Constants.GeneralTags;
import projDemo.Constants.IndefiniteGrounded;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUITags {

	private JFrame frame;

	private JPanel panel;
	private JLabel lblGroundingTags, lblPerson;
	private JToggleButton tglbtnNoncmr, tglbtnBmc, tglbtnBaq, tglbtnDnif, tglbtnSupervised, tglbtnUq,
			tglbtnTrainingPlanUq, tglbtnGenericRed, tglbtnGenericYellow, tglbtnNoFlight, tglbtnNoSim;
	private JToggleButton tglbtnSubmit;

	public GUITags(Person p, UUID windowSignature) {
		initialize(p, windowSignature);
	}

	private void initialize(Person p, UUID windowSignature) {
		frame = new JFrame();
		frame.setBounds(100, 100, 135, 387);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 135, 365);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		lblGroundingTags = new JLabel("Grounding Tags");
		lblGroundingTags.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblGroundingTags.setBounds(6, 6, 149, 19);
		panel.add(lblGroundingTags);

		lblPerson = new JLabel();
		lblPerson.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblPerson.setText(p.toString());
		lblPerson.setBounds(6, 29, 120, 16);
		panel.add(lblPerson);

		tglbtnNoncmr = new JToggleButton("NON-CMR");
		tglbtnNoncmr.setBounds(6, 57, 120, 29);
		panel.add(tglbtnNoncmr);

		tglbtnBmc = new JToggleButton("BMC");
		tglbtnBmc.setBounds(6, 87, 60, 29);
		panel.add(tglbtnBmc);

		tglbtnBaq = new JToggleButton("BAQ");
		tglbtnBaq.setBounds(66, 87, 60, 29);
		panel.add(tglbtnBaq);

		tglbtnDnif = new JToggleButton("DNIF");
		tglbtnDnif.setBounds(6, 116, 60, 29);
		panel.add(tglbtnDnif);

		tglbtnSupervised = new JToggleButton("SUPERVISED");
		tglbtnSupervised.setBounds(6, 145, 120, 29);
		panel.add(tglbtnSupervised);

		tglbtnUq = new JToggleButton("UQ");
		tglbtnUq.setBounds(66, 116, 60, 29);
		panel.add(tglbtnUq);

		tglbtnTrainingPlanUq = new JToggleButton("TRAINING UQ");
		tglbtnTrainingPlanUq.setBounds(6, 174, 120, 29);
		panel.add(tglbtnTrainingPlanUq);

		tglbtnGenericRed = new JToggleButton("GEN RED");
		tglbtnGenericRed.setBounds(6, 203, 120, 29);
		panel.add(tglbtnGenericRed);

		tglbtnGenericYellow = new JToggleButton("GEN YELLOW");
		tglbtnGenericYellow.setBounds(6, 232, 120, 29);
		panel.add(tglbtnGenericYellow);

		tglbtnNoFlight = new JToggleButton("NO FLIGHT");
		tglbtnNoFlight.setBounds(6, 261, 120, 29);
		panel.add(tglbtnNoFlight);

		tglbtnNoSim = new JToggleButton("NO SIM");
		tglbtnNoSim.setBounds(6, 290, 120, 29);
		panel.add(tglbtnNoSim);

		tglbtnSubmit = new JToggleButton("SUBMIT");
		tglbtnSubmit.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		tglbtnSubmit.setBounds(6, 322, 120, 35);
		panel.add(tglbtnSubmit);
		
		for(IndefiniteGrounded ig : p.groundingTags) {
			switch(ig) {
			case NON_CMR:
				tglbtnNoncmr.setSelected(true);
				break;
			case BAQ:
				tglbtnBaq.setSelected(true);
				break;
			case BMC:
				tglbtnBmc.setSelected(true);
				break;
			case DNIF:
				tglbtnDnif.setSelected(true);
				break;
			case GENERIC_RED:
				tglbtnGenericRed.setSelected(true);
				break;
			case GENERIC_YELLOW:
				tglbtnGenericYellow.setSelected(true);
				break;
			case SUPERVISED:
				tglbtnSupervised.setSelected(true);
				break;
			case TRAINING_PLAN_UQ:
				tglbtnTrainingPlanUq.setSelected(true);
				break;
			case UQ:
				tglbtnUq.setSelected(true);
				break;
			default:
				break;
			}
		}
		
		for (GeneralTags gt : p.generalTags) {
			switch(gt) {
			case NO_FLIGHT:
				tglbtnNoFlight.setSelected(true);
				break;
			case NO_SIM:
				tglbtnNoSim.setSelected(true);
				break;
			default:
				break;
			}
		}
		
		/*
		 * LISTENERS
		 */
		tglbtnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.groundingTags.clear();
				p.generalTags.clear();
				
				if(tglbtnNoncmr.isSelected())
					p.groundingTags.add(IndefiniteGrounded.NON_CMR);
				if(tglbtnBmc.isSelected())
					p.groundingTags.add(IndefiniteGrounded.BMC);
				if(tglbtnBaq.isSelected())
					p.groundingTags.add(IndefiniteGrounded.BAQ);
				if(tglbtnDnif.isSelected())
					p.groundingTags.add(IndefiniteGrounded.DNIF);
				if(tglbtnSupervised.isSelected())
					p.groundingTags.add(IndefiniteGrounded.SUPERVISED);
				if(tglbtnUq.isSelected())
					p.groundingTags.add(IndefiniteGrounded.UQ);
				if(tglbtnTrainingPlanUq.isSelected())
					p.groundingTags.add(IndefiniteGrounded.TRAINING_PLAN_UQ);
				if(tglbtnGenericRed.isSelected())
					p.groundingTags.add(IndefiniteGrounded.GENERIC_RED);
				if(tglbtnGenericYellow.isSelected())
					p.groundingTags.add(IndefiniteGrounded.GENERIC_YELLOW);
				if(tglbtnNoFlight.isSelected())
					p.generalTags.add(GeneralTags.NO_FLIGHT);
				if(tglbtnNoSim.isSelected())
					p.generalTags.add(GeneralTags.NO_SIM);
				
				frame.setVisible(false);
				frame.dispose();
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}
}