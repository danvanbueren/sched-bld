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

import projDemo.Constants.MeterType;
import projDemo.Constants.MeterState;

/**
 * The {@code MeterLookback} class is used to instantiate an object containing a
 * {@link JPanel} that reflects the necessary objects to visualize the
 * information to which it represents.
 *
 * @version 30 Jan 2020
 * @author Daniel Van Bueren
 * @see JPanel
 */
public class MeterLookback {

	private JPanel backboard, pnlOneMonth, pnlThreeMonth;
	private JLabel lblOneMonth, lblThreeMonth;

	private int x, y, width, height, oneMonthNumber, threeMonthNumber;

	public MeterLookback() {

		x = 6;
		y = 6;
		width = 100;
		height = 25;

		initialize(x, y, width, height);
	}

	public MeterLookback(int x, int y) {

		this.x = x;
		this.y = y;
		width = 100;
		height = 25;

		initialize(x, y, width, height);
	}

	public MeterLookback(int x, int y, int width, int height) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		initialize(x, y, width, height);
	}

	public void initialize(int x, int y, int width, int height) {

		oneMonthNumber = 0;
		threeMonthNumber = 0;

		backboard = new JPanel();
		backboard.setLayout(null);

		pnlOneMonth = new JPanel();
		pnlOneMonth.setBorder(new LineBorder(Constants.white, 2));
		pnlOneMonth.setBackground(Constants.white);

		backboard.add(pnlOneMonth);
		pnlOneMonth.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		lblOneMonth = new JLabel();
		lblOneMonth.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblOneMonth.setForeground(Constants.white);
		pnlOneMonth.add(lblOneMonth);

		pnlThreeMonth = new JPanel();
		pnlThreeMonth.setBorder(new LineBorder(Constants.white, 2));
		pnlThreeMonth.setBackground(Constants.white);

		backboard.add(pnlThreeMonth);
		pnlThreeMonth.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		lblThreeMonth = new JLabel();
		lblThreeMonth.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblThreeMonth.setForeground(Constants.white);
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

	public void setLabelNumber(int i, MeterType m) {
		switch (m) {
		case ONE:
			oneMonthNumber = i;
			break;
		case THREE:
			threeMonthNumber = i;
			break;
		default:
			break;
		}

		refreshAlignment();

	}

	public void setPanelTooltip(String s, MeterType m) {
		switch (m) {
		case ONE:
			pnlOneMonth.setToolTipText(s);
			break;
		case THREE:
			pnlThreeMonth.setToolTipText(s);
			break;
		default:
			break;
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

	public void setState(MeterState s, MeterType m) {
		switch (m) {
		case ONE:
			switch (s) {
			case GREEN:
				pnlOneMonth.setBorder(new LineBorder(Constants.darkGreen, 2));
				pnlOneMonth.setBackground(Constants.green);
				break;
			case YELLOW:
				break;
			case RED:
				pnlOneMonth.setBorder(new LineBorder(Constants.darkRed, 2));
				pnlOneMonth.setBackground(Constants.red);
				break;
			case UNK:
				pnlOneMonth.setBorder(new LineBorder(Constants.darkGray, 2));
				pnlOneMonth.setBackground(Constants.gray);
				break;
			}
			break;
		case THREE:
			switch (s) {
			case GREEN:
				pnlThreeMonth.setBorder(new LineBorder(Constants.darkGreen, 2));
				pnlThreeMonth.setBackground(Constants.green);
				break;
			case YELLOW:
				break;
			case RED:
				pnlThreeMonth.setBorder(new LineBorder(Constants.darkRed, 2));
				pnlThreeMonth.setBackground(Constants.red);
				break;
			case UNK:
				pnlThreeMonth.setBorder(new LineBorder(Constants.darkGray, 2));
				pnlThreeMonth.setBackground(Constants.gray);
				break;
			}
			break;
		default:
			break;
		}
	}
}