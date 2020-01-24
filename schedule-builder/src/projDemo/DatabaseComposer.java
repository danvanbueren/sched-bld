package projDemo;
import java.util.ArrayList;

public class DatabaseComposer {

	public static void save() {

		String outputBuffer = "";

		System.out.println("");

		for (Sortie s : Main.sortieIndex) {
			System.out.println("Saving " + s.sortieNumber + " (_" + s.loadList.size() + "_attached_obj)");

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
			System.out.println("Saving " + p.nameLast);

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

			outputBuffer += "@~" + uuid + "~" + rank + "~" + nameFirst + "~" + nameMiddle + "~" + nameLast + "~"
					+ crewPos + "~" + shop + "~" + flight + "~" + phoneNumber + "~" + address + "~" + social + "~"
					+ calendar + System.getProperty("line.separator");

		}

		ReadWriteIO.write(outputBuffer);
	}

	public static void load() {

		String inputBufferSingle = ReadWriteIO.read();

		if (inputBufferSingle.isBlank()) {
			try {
				ReadWriteIO.write("waiting to save...");
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

					Person loadP = new Person(DataConvert.fromStringToUUID(uuid), calendar, rank, nameFirst, nameMiddle,
							nameLast, crewPos, shop, flight, phoneNumber, address, social);

					System.out.println("Person loaded: " + loadP.nameLast);
				}

				if (s.contentEquals("%")) {
					String uuid = inputBuffer[currentLine + 1];
					String sortieNumber = inputBuffer[currentLine + 2];
					String startDate = inputBuffer[currentLine + 3];
					String endDate = inputBuffer[currentLine + 4];
					String sortieLoadList = inputBuffer[currentLine + 5];

					String[] loadListBuffer = sortieLoadList.split("\\#");

					Sortie loadS = new Sortie(DataConvert.fromStringToUUID(uuid), sortieNumber,
							DataConvert.fromStringToLocalDate(startDate), DataConvert.fromStringToLocalDate(endDate),
							loadListBuffer);

					System.out.println("Sortie loaded: " + loadS.sortieNumber);
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
	}
}