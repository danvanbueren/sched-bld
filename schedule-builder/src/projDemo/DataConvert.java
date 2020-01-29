package projDemo;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

public class DataConvert {

	public static LocalDate fromMultIntToLocalDate(int year, int month, int date) {

		LocalDate ld = LocalDate.of(year, month, date);
		return ld;

	}

	public static LocalDate fromStringToLocalDate(String dateString) {

		String[] dateStringArray = dateString.split("\\-");
		return LocalDate.of(Integer.parseInt(dateStringArray[0]), Integer.parseInt(dateStringArray[1]),
				Integer.parseInt(dateStringArray[2]));

	}

	public static String ldToString(LocalDate ld, boolean isVerbose) {

		if (isVerbose) {
			return ld.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
		} else {
			return ld.format(DateTimeFormatter.ofPattern("ddMMMyy")).toUpperCase();
		}

	}

	public static UUID fromStringToUUID(String uuidString) {

		return UUID.fromString(uuidString);

	}

	public static String toSortieNumber(LocalDate ld, String squadron, String type) {

		String tkMonth = "";

		switch (ld.getMonth().getValue()) {
		case 1:
			tkMonth = "A";
			break;
		case 2:
			tkMonth = "B";
			break;
		case 3:
			tkMonth = "C";
			break;
		case 4:
			tkMonth = "D";
			break;
		case 5:
			tkMonth = "E";
			break;
		case 6:
			tkMonth = "F";
			break;
		case 7:
			tkMonth = "G";
			break;
		case 8:
			tkMonth = "H";
			break;
		case 9:
			tkMonth = "I";
			break;
		case 10:
			tkMonth = "J";
			break;
		case 11:
			tkMonth = "K";
			break;
		case 12:
			tkMonth = "L";
			break;
		default:
			System.err.println("Something went wrong when setting month.");
			break;
		}

		return tkMonth + squadron + type + squadron + new DecimalFormat("00").format(ld.getDayOfMonth());
	}

	public static String fromLoadListToString(ArrayList<Person> loadList) {
		String tempLoadList = "";

		for (Person pL : loadList) {
			tempLoadList += pL.nameLast + ", ";
		}

		if (tempLoadList.endsWith(", "))
			tempLoadList = tempLoadList.substring(0, tempLoadList.length() - 2);

		return tempLoadList;
	}
}
