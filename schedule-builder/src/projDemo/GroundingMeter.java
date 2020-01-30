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

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * The {@code GroundingMeter} class is used to instantiate an object containing
 * a {@link JPanel} that reflects the necessary objects to visualize the
 * information to which it represents.
 *
 * @version 30 Jan 2020
 * @author Daniel Van Bueren
 * @see JPanel
 */
public class GroundingMeter {

	private Color red = new Color(183, 28, 28);
	private Color darkRed = new Color(127, 0, 0);
	private Color yellow = new Color(245, 127, 23);
	private Color darkYellow = new Color(188, 81, 0);
	private Color green = new Color(27, 94, 32);
	private Color darkGreen = new Color(0, 51, 0);
	private Color gray = new Color(33, 33, 33);
	private Color darkGray = new Color(0, 0, 0);
	private Color white = new Color(255, 255, 255, 127);

	private JPanel backboard, pnlMain;
	private JLabel lblMain;

	private int x, y, width, height;
	
	private String mainText;

	enum State {
		GREEN, YELLOW, RED, UNK;
	}

	public GroundingMeter() {

		mainText = "";

		x = 6;
		y = 6;
		width = 100;
		height = 25;

		backboard = new JPanel();
		backboard.setLayout(null);

		pnlMain = new JPanel();
		pnlMain.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlMain.setBackground(Color.DARK_GRAY);

		backboard.add(pnlMain);
		pnlMain.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		lblMain = new JLabel();
		lblMain.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblMain.setForeground(white);
		pnlMain.add(lblMain);

		refreshAlignment();
	}

	public GroundingMeter(int x, int y) {

		mainText = "";

		this.x = x;
		this.y = y;
		width = 100;
		height = 25;

		backboard = new JPanel();
		backboard.setLayout(null);

		pnlMain = new JPanel();
		pnlMain.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlMain.setBackground(Color.DARK_GRAY);

		backboard.add(pnlMain);
		pnlMain.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		lblMain = new JLabel();
		lblMain.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblMain.setForeground(white);
		pnlMain.add(lblMain);

		refreshAlignment();
	}

	public GroundingMeter(int x, int y, int width, int height) {

		mainText = "";

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		backboard = new JPanel();
		backboard.setLayout(null);

		pnlMain = new JPanel();
		pnlMain.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlMain.setBackground(Color.DARK_GRAY);

		backboard.add(pnlMain);
		pnlMain.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		lblMain = new JLabel();
		lblMain.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblMain.setForeground(white);
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

	public void setLabel(String s) {
		mainText = s;
		refreshAlignment();
	}

	public void setPanelTooltip(String s) {
		pnlMain.setToolTipText(s);
	}

	private void refreshAlignment() {
		backboard.setBounds(x, y, width, height);
		pnlMain.setBounds(0, 0, width, height);

		lblMain.setText(mainText);
	}

	public JPanel getPanel() {
		return backboard;
	}

	public void setState(State s) {
		switch (s) {
		case GREEN:
			pnlMain.setBorder(new LineBorder(darkGreen, 2));
			pnlMain.setBackground(green);
			break;
		case YELLOW:
			pnlMain.setBorder(new LineBorder(darkYellow, 2));
			pnlMain.setBackground(yellow);
			break;
		case RED:
			pnlMain.setBorder(new LineBorder(darkRed, 2));
			pnlMain.setBackground(red);
			break;
		case UNK:
			pnlMain.setBorder(new LineBorder(darkGray, 2));
			pnlMain.setBackground(gray);
			break;
		}
	}
}