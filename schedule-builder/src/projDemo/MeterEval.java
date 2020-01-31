/*
 * Copyright (c) 2019, 2020, Daniel Van Bueren and/or affiliates. All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package projDemo;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import projDemo.Constants.MeterState;

/**
 * The {@code MeterEval} class is used to instantiate an object containing a
 * {@link JPanel} that reflects the necessary objects to visualize the
 * information to which it represents.
 *
 * @version 30 Jan 2020
 * @author Daniel Van Bueren
 * @see JPanel
 */
public class MeterEval {

	private JPanel backboard, pnlQual, pnlMsn;
	private JLabel lblQual, lblMsn;

	private int x, y, width, height, numQual, numMsn;

	public MeterEval() {

		x = 6;
		y = 6;
		width = 100;
		height = 25;

		initialize(x, y, width, height);
	}

	public MeterEval(int x, int y) {

		this.x = x;
		this.y = y;
		width = 100;
		height = 25;

		initialize(x, y, width, height);
	}

	public MeterEval(int x, int y, int width, int height) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		initialize(x, y, width, height);
	}

	public void initialize(int x, int y, int width, int height) {

		numQual = 0;
		numMsn = 0;

		backboard = new JPanel();
		backboard.setLayout(null);

		pnlQual = new JPanel();
		pnlQual.setBorder(new LineBorder(Constants.white, 2));
		pnlQual.setBackground(Constants.white);

		backboard.add(pnlQual);
		pnlQual.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		lblQual = new JLabel();
		lblQual.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblQual.setForeground(Constants.white);
		pnlQual.add(lblQual);

		pnlMsn = new JPanel();
		pnlMsn.setBorder(new LineBorder(Constants.white, 2));
		pnlMsn.setBackground(Constants.white);

		backboard.add(pnlMsn);
		pnlMsn.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		lblMsn = new JLabel();
		lblMsn.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblMsn.setForeground(Constants.white);
		pnlMsn.add(lblMsn);

		refreshAlignment();
	}

	public void setDimensions(int width, int height) {
		this.width = width;
		this.height = height;
		refreshAlignment();
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		refreshAlignment();
	}

	public void setDimPos(int x, int y, int width, int height) {
		setDimensions(width, height);
		setPosition(x, y);
	}

	public void setLabelNumber(int qual, int msn) {
		numQual = qual;
		numMsn = msn;

		refreshAlignment();
	}

	public void setPanelTooltip(String qual, String msn) {
		pnlQual.setToolTipText(qual);
		pnlMsn.setToolTipText(msn);
	}

	private void refreshAlignment() {
		backboard.setBounds(x, y, width, height);

		if (width >= height) {
			pnlQual.setBounds(0, 0, width / 2, height);
			pnlMsn.setBounds(width / 2, 0, width / 2, height);
		} else {
			pnlQual.setBounds(0, 0, width, height / 2);
			pnlMsn.setBounds(0, height / 2, width, height / 2);
		}

		if (width < 40) {
			lblQual.setText("q (" + numQual + ")");
			lblMsn.setText("m (" + numMsn + ")");
		} else {
			lblQual.setText("qual (" + numQual + ")");
			lblMsn.setText("msn (" + numMsn + ")");
		}
	}

	public JPanel getPanel() {
		return backboard;
	}

	public void setState(MeterState qual, MeterState msn) {

		switch (qual) {
		case GREEN:
			pnlQual.setBorder(new LineBorder(Constants.darkGreen, 2));
			pnlQual.setBackground(Constants.green);
			break;
		case YELLOW:
			pnlQual.setBorder(new LineBorder(Constants.darkYellow, 2));
			pnlQual.setBackground(Constants.yellow);
			break;
		case RED:
			pnlQual.setBorder(new LineBorder(Constants.darkRed, 2));
			pnlQual.setBackground(Constants.red);
			break;
		case UNK:
			pnlQual.setBorder(new LineBorder(Constants.darkGray, 2));
			pnlQual.setBackground(Constants.gray);
			break;
		default:
			break;
		}

		switch (msn) {
		case GREEN:
			pnlMsn.setBorder(new LineBorder(Constants.darkGreen, 2));
			pnlMsn.setBackground(Constants.green);
			break;
		case YELLOW:
			pnlMsn.setBorder(new LineBorder(Constants.darkYellow, 2));
			pnlMsn.setBackground(Constants.yellow);
			break;
		case RED:
			pnlMsn.setBorder(new LineBorder(Constants.darkRed, 2));
			pnlMsn.setBackground(Constants.red);
			break;
		case UNK:
			pnlMsn.setBorder(new LineBorder(Constants.darkGray, 2));
			pnlMsn.setBackground(Constants.gray);
			break;
		default:
			break;
		}
	}
}