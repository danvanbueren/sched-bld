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
 * The {@code LookbackMeter} class is used to instantiate an object
 * containing a {@link JPanel} that reflects the necessary objects 
 * to visualize the information to which it represents.
 *
 * @version 29 Jan 2020
 * @author Daniel Van Bueren
 * @see JPanel
 */
public class LookbackMeter {

	private Color red = new Color(183, 28, 28);
	private Color darkRed = new Color(127, 0, 0);
	private Color green = new Color(27, 94, 32);
	private Color darkGreen = new Color(0, 51, 0);
	private Color gray = new Color(33, 33, 33);
	private Color darkGray = new Color(0, 0, 0);
	private Color white = new Color(255, 255, 255, 127);

	private JPanel backboard, pnlOneMonth, pnlThreeMonth;
	private JLabel lblOneMonth, lblThreeMonth;

	private int x, y, width, height, oneMonthNumber, threeMonthNumber;

	enum Month {
		ONE_MONTH, THREE_MONTH;
	}

	enum State {
		PASS, FAIL, UNK;
	}

	public LookbackMeter() {

		oneMonthNumber = 0;
		threeMonthNumber = 0;
		
		x = 6;
		y = 6;
		width = 100;
		height = 25;

		backboard = new JPanel();
		backboard.setLayout(null);

		pnlOneMonth = new JPanel();
		pnlOneMonth.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlOneMonth.setBackground(Color.DARK_GRAY);

		backboard.add(pnlOneMonth);
		pnlOneMonth.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		lblOneMonth = new JLabel();
		lblOneMonth.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblOneMonth.setForeground(white);
		pnlOneMonth.add(lblOneMonth);

		pnlThreeMonth = new JPanel();
		pnlThreeMonth.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlThreeMonth.setBackground(Color.DARK_GRAY);

		backboard.add(pnlThreeMonth);
		pnlThreeMonth.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		lblThreeMonth = new JLabel();
		lblThreeMonth.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblThreeMonth.setForeground(white);
		pnlThreeMonth.add(lblThreeMonth);

		refreshAlignment();
	}
	
	public LookbackMeter(int x, int y) {

		oneMonthNumber = 0;
		threeMonthNumber = 0;
		
		this.x = x;
		this.y = y;
		width = 100;
		height = 25;

		backboard = new JPanel();
		backboard.setLayout(null);

		pnlOneMonth = new JPanel();
		pnlOneMonth.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlOneMonth.setBackground(Color.DARK_GRAY);

		backboard.add(pnlOneMonth);
		pnlOneMonth.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		lblOneMonth = new JLabel();
		lblOneMonth.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblOneMonth.setForeground(white);
		pnlOneMonth.add(lblOneMonth);

		pnlThreeMonth = new JPanel();
		pnlThreeMonth.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlThreeMonth.setBackground(Color.DARK_GRAY);

		backboard.add(pnlThreeMonth);
		pnlThreeMonth.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		lblThreeMonth = new JLabel();
		lblThreeMonth.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblThreeMonth.setForeground(white);
		pnlThreeMonth.add(lblThreeMonth);

		refreshAlignment();
	}
	
	public LookbackMeter(int x, int y, int width, int height) {

		oneMonthNumber = 0;
		threeMonthNumber = 0;
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		backboard = new JPanel();
		backboard.setLayout(null);

		pnlOneMonth = new JPanel();
		pnlOneMonth.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlOneMonth.setBackground(Color.DARK_GRAY);

		backboard.add(pnlOneMonth);
		pnlOneMonth.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		lblOneMonth = new JLabel();
		lblOneMonth.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblOneMonth.setForeground(white);
		pnlOneMonth.add(lblOneMonth);

		pnlThreeMonth = new JPanel();
		pnlThreeMonth.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		pnlThreeMonth.setBackground(Color.DARK_GRAY);

		backboard.add(pnlThreeMonth);
		pnlThreeMonth.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		lblThreeMonth = new JLabel();
		lblThreeMonth.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblThreeMonth.setForeground(white);
		pnlThreeMonth.add(lblThreeMonth);

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

	public void setLabelNumber(int i, Month m) {
		
		if(m.equals(Month.ONE_MONTH)) {
			oneMonthNumber = i;
		}
		if(m.equals(Month.THREE_MONTH)) {
			threeMonthNumber = i;
		}
		
		refreshAlignment();
		
	}
	
	public void setPanelTooltip(String s, Month m) {
		if(m.equals(Month.ONE_MONTH)) {
			pnlOneMonth.setToolTipText(s);
		}
		if(m.equals(Month.THREE_MONTH)) {
			pnlThreeMonth.setToolTipText(s);
		}
	}
	
	private void refreshAlignment() {
		backboard.setBounds(x, y, width, height);

		if (width >= height) {
			pnlOneMonth.setBounds(0, 0, width / 2, height);
			pnlThreeMonth.setBounds(width / 2, 0, width / 2, height);
		} else {
			pnlOneMonth.setBounds(0, 0, width, height / 2);
			pnlThreeMonth.setBounds(0, height / 2, width, height / 2);
		}

		if (width < 40) {
			lblOneMonth.setText("1 (" + oneMonthNumber + ")");
			lblThreeMonth.setText("3 (" + threeMonthNumber + ")");
		} else {
			lblOneMonth.setText("1mo (" + oneMonthNumber + ")");
			lblThreeMonth.setText("3mo (" + threeMonthNumber + ")");
		}
	}

	public JPanel getPanel() {
		return backboard;
	}

	public void setState(State s, Month m) {
		switch (m) {
		case ONE_MONTH:
			switch (s) {
			case PASS:
				pnlOneMonth.setBorder(new LineBorder(darkGreen, 2));
				pnlOneMonth.setBackground(green);
				break;
			case FAIL:
				pnlOneMonth.setBorder(new LineBorder(darkRed, 2));
				pnlOneMonth.setBackground(red);
				break;
			case UNK:
				pnlOneMonth.setBorder(new LineBorder(darkGray, 2));
				pnlOneMonth.setBackground(gray);
				break;
			}
			break;
		case THREE_MONTH:
			switch (s) {
			case PASS:
				pnlThreeMonth.setBorder(new LineBorder(darkGreen, 2));
				pnlThreeMonth.setBackground(green);
				break;
			case FAIL:
				pnlThreeMonth.setBorder(new LineBorder(darkRed, 2));
				pnlThreeMonth.setBackground(red);
				break;
			case UNK:
				pnlThreeMonth.setBorder(new LineBorder(darkGray, 2));
				pnlThreeMonth.setBackground(gray);
				break;
			}
			break;
		}
	}
}