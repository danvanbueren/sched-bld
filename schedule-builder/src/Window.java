import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class Window {

	static Dimension s = Toolkit.getDefaultToolkit().getScreenSize();

	private static double windowWidthPercent = 70, windowHeightPercent = 60;

	private static double width = s.width * (windowWidthPercent / 100), height = s.height * (windowHeightPercent / 100),
			x = (s.width - width) / 2, y = (s.height - height) / 2;

	public static void createGUI() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				System.setProperty("apple.laf.useScreenMenuBar", "true");
				System.setProperty("com.apple.mrj.application.apple.menu.about.name", "AppName");

				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}

				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {

		System.out.println("\nscreen width: " + s.width + "\nscreen height: " + s.height + "\nwidth: " + width
				+ "\nheight: " + height + "\nwindowWidthPercent: " + windowWidthPercent + "\nwindowHeightPercent: "
				+ windowHeightPercent + "\nx: " + x + "\ny: " + y);

		JFrame.setDefaultLookAndFeelDecorated(true);

		JFrame frame = new JFrame("Gemsort - Control Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setBounds((int) x, (int) y, (int) width, (int) height);
		frame.setSize((int) width, (int) height);

		JLabel label = new JLabel("Create sortie\nCreate person");
		frame.getContentPane().add(label);

		// frame.pack();
		frame.setVisible(true);
	}
}