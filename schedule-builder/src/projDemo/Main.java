package projDemo;

import java.awt.EventQueue;
import java.util.ArrayList;

public class Main {

	public static ArrayList<Person> personIndex = new ArrayList<>();
	public static ArrayList<Sortie> sortieIndex = new ArrayList<>();

	public static void main(String args[]) {

		DatabaseComposer.load();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITelescope window = new GUITelescope();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}