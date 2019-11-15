import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JComboBox;

public class Scheduler {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scheduler window = new Scheduler();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Scheduler() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 960, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Integrated Sortie Scheduler");

		JButton btnAlibiG = new JButton("Alibi Generator");
		btnAlibiG.setEnabled(false);
		btnAlibiG.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlibiG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, null);
			}
		});
		btnAlibiG.setBounds(0, 70, 200, 30);
		frame.getContentPane().add(btnAlibiG);
		
		JButton btnReviewP = new JButton("Review Pendings");
		btnReviewP.setEnabled(false);
		btnReviewP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, null);
			}
		});
		btnReviewP.setHorizontalAlignment(SwingConstants.LEFT);
		btnReviewP.setBounds(0, 100, 200, 30);
		frame.getContentPane().add(btnReviewP);
		
		JButton btnAuditP = new JButton("Audit Personnel");
		btnAuditP.setEnabled(false);
		btnAuditP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, null);
			}
		});
		btnAuditP.setHorizontalAlignment(SwingConstants.LEFT);
		btnAuditP.setBounds(0, 130, 200, 30);
		frame.getContentPane().add(btnAuditP);
		
		JButton btnEditFR = new JButton("Edit Formula Rules");
		btnEditFR.setEnabled(false);
		btnEditFR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, null);
			}
		});
		btnEditFR.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditFR.setBounds(0, 160, 200, 30);
		frame.getContentPane().add(btnEditFR);
		
		JButton btnReviewM = new JButton("Review Mergers");
		btnReviewM.setEnabled(false);
		btnReviewM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, null);
			}
		});
		btnReviewM.setHorizontalAlignment(SwingConstants.LEFT);
		btnReviewM.setBounds(0, 190, 200, 30);
		frame.getContentPane().add(btnReviewM);
		
		JButton btnSync = new JButton("Sync");
		btnSync.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnSync.setEnabled(false);
		btnSync.setBounds(10, 630, 180, 60);
		frame.getContentPane().add(btnSync);
		
		JLabel lblQuickL = new JLabel("Quick Links");
		lblQuickL.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuickL.setBounds(16, 0, 185, 65);
		frame.getContentPane().add(lblQuickL);
		lblQuickL.setFont(new Font("Myriad Pro", Font.BOLD, 30));
		lblQuickL.setForeground(Color.WHITE);
		
		JPanel pnlBgDarkGray = new JPanel();
		pnlBgDarkGray.setBounds(0, 0, 201, 55);
		frame.getContentPane().add(pnlBgDarkGray);
		pnlBgDarkGray.setBackground(Color.DARK_GRAY);
		
		JPanel pnlBgGray = new JPanel();
		pnlBgGray.setBackground(Color.GRAY);
		pnlBgGray.setBounds(0, 0, 200, 698);
		frame.getContentPane().add(pnlBgGray);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.setBounds(213, 19, 117, 29);
		frame.getContentPane().add(btnNewButton);
	}
}
