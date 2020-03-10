package projDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DatabaseComposer {

	private static String currentUUID;

	private static void serialWrite(Object o, String directory) {

		try {
			FileOutputStream fos = new FileOutputStream(directory);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void serialWriteController() {

		ArrayList<String> dbIndexWrite = new ArrayList<String>();

		for (Sortie s : Main.sortieIndex) {
			currentUUID = "s_" + s.uuid;
			dbIndexWrite.add(currentUUID);
			serialWrite(s, currentUUID);
		}

		for (Person p : Main.personIndex) {
			currentUUID = "p_" + p.uuid;
			dbIndexWrite.add(currentUUID);
			serialWrite(p, currentUUID);

			for (Appointment a : p.calendar) {
				currentUUID = "a_" + a.uuid;
				dbIndexWrite.add(currentUUID);
				serialWrite(a, currentUUID);
			}
		}

		serialWrite(dbIndexWrite, "index");
		System.out.println("INDEX ON WRITE: " + dbIndexWrite.toString());

	}

	public static void serialReadController() {
		if (new File("index").exists()) {
			ArrayList<String> dbIndexRead = serialReadIndex();
			System.out.println("INDEX ON READ: " + dbIndexRead.toString());

			String currentLine = null;
			for (int i = 0; i < dbIndexRead.size(); i++) {
				currentLine = dbIndexRead.get(i);
				System.out.println("Reading " + currentLine);
				switch (currentLine.charAt(0)) {
				case 's':
					serialReadSortie(currentLine);
					break;
				case 'p':
					serialReadPerson(currentLine);
					break;
				case 'a':
					serialReadAppointment(currentLine);
					break;
				default:
					System.err.println("index element type is unknown: " + currentLine);
				}

			}
		} else {
			System.err.println("Index file not found, no objects loaded");
		}

	}

	@SuppressWarnings("unchecked")
	private static ArrayList<String> serialReadIndex() {

		ArrayList<String> result = null;

		try {
			FileInputStream fis = new FileInputStream("index");
			ObjectInputStream ois = new ObjectInputStream(fis);
			result = (ArrayList<String>) ois.readObject();
			ois.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	private static Person serialReadPerson(String directory) {

		Person result = null;

		try {
			FileInputStream fis = new FileInputStream(directory);
			ObjectInputStream ois = new ObjectInputStream(fis);
			result = (Person) ois.readObject();
			ois.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Main.personIndex.add(result);
		System.out.println("Created person object: " + result.nameLast);
		return result;
	}

	private static Sortie serialReadSortie(String directory) {

		Sortie result = null;

		try {
			FileInputStream fis = new FileInputStream(directory);
			ObjectInputStream ois = new ObjectInputStream(fis);
			result = (Sortie) ois.readObject();
			ois.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Main.sortieIndex.add(result);
		System.out.println("Created sortie object: " + result.sortieNumber);
		return result;
	}

	private static Appointment serialReadAppointment(String directory) {

		Appointment result = null;

		try {
			FileInputStream fis = new FileInputStream(directory);
			ObjectInputStream ois = new ObjectInputStream(fis);
			result = (Appointment) ois.readObject();
			ois.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Created appointment object: " + result.description);
		return result;
	}

}