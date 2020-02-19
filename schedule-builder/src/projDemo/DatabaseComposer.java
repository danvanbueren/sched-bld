package projDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import projDemo.Constants.IndefiniteGrounded;

public class DatabaseComposer {

	public static void save() {

		String outputBuffer = "";

		for (Sortie s : Main.sortieIndex) {
			String uuid = s.uuid.toString();
			String sortieNumber = s.sortieNumber;
			String startDate = s.startDate.toString();
			String endDate = s.endDate.toString();
			String loadList = "";

			int i = 1;
			for (Person p : s.loadList) {
				loadList += p.uuid;
				if (i < s.loadList.size())
					loadList += "#";
				i++;
			}

			outputBuffer += "%~" + uuid + "~" + sortieNumber + "~" + startDate + "~" + endDate + "~" + loadList
					+ System.getProperty("line.separator");
		}

		for (Person p : Main.personIndex) {
			String uuid = p.uuid.toString();
			String rank = p.rank;
			String nameFirst = p.nameFirst;
			String nameMiddle = p.nameMiddle;
			String nameLast = p.nameLast;
			String crewPos = p.crewPos;
			String shop = p.shop;
			String flight = p.flight;
			String phoneNumber = p.phoneNumber;
			String address = p.address;
			String social = p.social;
			String calendar = p.calendar.toString();
			String groundingTags = "";
			
			for(IndefiniteGrounded ig : p.groundingTags) {
				groundingTags += ig + ",";
			}
			
			// groundingTags -= groundingTags;

			outputBuffer += "@~" + uuid + "~" + rank + "~" + nameFirst + "~" + nameMiddle + "~" + nameLast + "~"
					+ crewPos + "~" + shop + "~" + flight + "~" + phoneNumber + "~" + address + "~" + social + "~"
					+ calendar + "~" + groundingTags + System.getProperty("line.separator");

		}

		writeBytes("db.txt", outputBuffer);

		outputBuffer = "";

		for (Person p : Main.personIndex) {
			for (Appointment a : p.calendar) {
				outputBuffer += p.uuid + "~" + a.startDate + "~" + a.endDate + "~" + a.isFlyable + "~" + a.description
						+ System.getProperty("line.separator");
			}
		}

		writeBytes("db_.txt", outputBuffer);

	}

	public static void load() {

		String inputBufferSingle = readBytes("db.txt");

		if (inputBufferSingle.isBlank()) {
			try {
				writeBytes("db.txt", "");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			String[] inputBuffer = inputBufferSingle.replace(System.getProperty("line.separator"), "~").split("\\~");

			int currentLine = 0;

			for (String s : inputBuffer) {
				if (s.contentEquals("@")) {
					String uuid = inputBuffer[currentLine + 1];
					String rank = inputBuffer[currentLine + 2];
					String nameFirst = inputBuffer[currentLine + 3];
					String nameMiddle = inputBuffer[currentLine + 4];
					String nameLast = inputBuffer[currentLine + 5];
					String crewPos = inputBuffer[currentLine + 6];
					String shop = inputBuffer[currentLine + 7];
					String flight = inputBuffer[currentLine + 8];
					String phoneNumber = inputBuffer[currentLine + 9];
					String address = inputBuffer[currentLine + 10];
					String social = inputBuffer[currentLine + 11];

					@SuppressWarnings("unused")
					String calendarString = inputBuffer[currentLine + 12];
					ArrayList<Appointment> calendar = new ArrayList<>();

					new Person(HelperDataConversion.fromStringToUUID(uuid), calendar, rank, nameFirst, nameMiddle, nameLast,
							crewPos, shop, flight, phoneNumber, address, social);
				}

				if (s.contentEquals("%")) {
					String uuid = inputBuffer[currentLine + 1];
					String sortieNumber = inputBuffer[currentLine + 2];
					String startDate = inputBuffer[currentLine + 3];
					String endDate = inputBuffer[currentLine + 4];
					String sortieLoadList = inputBuffer[currentLine + 5];

					String[] loadListBuffer = sortieLoadList.split("\\#");

					new Sortie(HelperDataConversion.fromStringToUUID(uuid), sortieNumber,
							HelperDataConversion.fromStringToLocalDate(startDate), HelperDataConversion.fromStringToLocalDate(endDate),
							loadListBuffer);
				}

				currentLine++;
			}

			for (Sortie s : Main.sortieIndex) {
				for (String st : s.loadListTemp) {
					for (Person p : Main.personIndex) {
						if (st.contentEquals(p.uuid.toString())) {
							s.loadList.add(p);
						}
					}
				}
			}
		}

		inputBufferSingle = readBytes("db_.txt");

		if (inputBufferSingle.isBlank()) {
			try {
				writeBytes("db_.txt", "");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			String[] inputBuffer = inputBufferSingle.split(System.getProperty("line.separator"));

			for (String s : inputBuffer) {
				String[] aptBuffer = s.split("\\~");

				boolean tempFlyable = false;

				if (aptBuffer[3].contentEquals("true"))
					tempFlyable = true;

				String tempDesc;

				try {
					tempDesc = aptBuffer[4];
				} catch (Exception e) {
					tempDesc = "Generic";
				}

				for (Person p : Main.personIndex) {
					if (p.uuid.equals(HelperDataConversion.fromStringToUUID(aptBuffer[0]))) {
						Appointment a = new Appointment(LocalDate.parse(aptBuffer[1]), LocalDate.parse(aptBuffer[2]),
								tempFlyable, tempDesc);
						p.calendar.add(a);
					}
				}
			}
		}
	}
	
	
	
	public static void writeBytes(String fileName, String fileContent) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
			fileOutputStream.write(fileContent.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String readBytes(String fileName) {
		String output = "";
		try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
			int ch = fileInputStream.read();
			while (ch != -1) {
				output += (char) ch;
				ch = fileInputStream.read();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Creating db file.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}
}