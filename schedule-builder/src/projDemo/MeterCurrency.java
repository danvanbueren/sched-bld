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
 * The {@code MeterCurrency} class is used to instantiate an object containing a
 * {@link JPanel} that reflects the necessary objects to visualize the
 * information to which it represents.
 *
 * @version 30 Jan 2020
 * @author Daniel Van Bueren
 * @see JPanel
 */
public class MeterCurrency {

	private JPanel backboard, pnlMain;
	private JLabel lblMain;

	private int x, y, width, height, mainNumber;

	public MeterCurrency() {

		x = 6;
		y = 6;
		width = 100;
		height = 25;

		initialize(x, y, width, height);
	}

	public MeterCurrency(int x, int y) {

		this.x = x;
		this.y = y;
		width = 100;
		height = 25;

		initialize(x, y, width, height);
	}

	public MeterCurrency(int x, int y, int width, int height) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		initialize(x, y, width, height);
	}

	private void initialize(int x, int y, int width, int height) {
		mainNumber = 0;

		backboard = new JPanel();
		backboard.setLayout(null);

		pnlMain = new JPanel();
		pnlMain.setBorder(new LineBorder(Constants.white, 2));
		pnlMain.setBackground(Constants.white);

		backboard.add(pnlMain);
		pnlMain.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		lblMain = new JLabel();
		lblMain.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblMain.setForeground(Constants.white);
		pnlMain.add(lblMain);

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

	public void setLabelNumber(int i) {
		mainNumber = i;
		refreshAlignment();
	}

	public void setPanelTooltip(String s) {
		pnlMain.setToolTipText(s);
	}

	private void refreshAlignment() {
		backboard.setBounds(x, y, width, height);
		pnlMain.setBounds(0, 0, width, height);

		lblMain.setText("(" + mainNumber + ")");
	}

	public JPanel getPanel() {
		return backboard;
	}

	public void setState(MeterState s) {
		switch (s) {
		case GREEN:
			pnlMain.setBorder(new LineBorder(Constants.darkGreen, 2));
			pnlMain.setBackground(Constants.green);
			break;
		case YELLOW:
			break;
		case RED:
			pnlMain.setBorder(new LineBorder(Constants.darkRed, 2));
			pnlMain.setBackground(Constants.red);
			break;
		case UNK:
			pnlMain.setBorder(new LineBorder(Constants.darkGray, 2));
			pnlMain.setBackground(Constants.gray);
			break;
		}
	}
}