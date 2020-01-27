package projDemo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ObjectFunctions {

	public static void systemCreateAppointment(Person p) {
		LocalDate startDate = null, endDate = null;
		boolean isFlyable = true;
		String description = null;
		Appointment a = new Appointment(startDate, endDate, isFlyable, description);
		p.calendar.add(a);
	}

	public static void systemCreateSortie(String start, String end, String squadron, String type) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

		LocalDate dateStart = LocalDate.parse(start, formatter);
		LocalDate dateEnd = LocalDate.parse(end, formatter);

		switch (squadron) {
		case "960 AACS":
			squadron = "0";
			break;
		case "961 AACS":
			squadron = "1";
			break;
		case "962 AACS":
			squadron = "2";
			break;
		case "963 AACS":
			squadron = "3";
			break;
		case "964 AACS":
			squadron = "4";
			break;
		case "965 AACS":
			squadron = "5";
			break;
		case "966 AACS":
			squadron = "6";
			break;
		default:
			squadron = "?";
			break;
		}

		switch (type) {
		case "J-Sortie":
			type = "J";
			break;
		case "T-Sortie":
			type = "T";
			break;
		case "P-Sortie":
			type = "P";
			break;
		case "X-Sortie":
			type = "X";
			break;
		case "S-Sortie":
			type = "S";
			break;
		case "W-Sortie":
			type = "W";
			break;
		default:
			type = "?";
			break;
		}

		String sortieNumber = DataConvert.toSortieNumber(dateStart, squadron, type);

		@SuppressWarnings("unused")
		Sortie s = new Sortie(sortieNumber, dateStart, dateEnd);
	}

	public static Sortie systemEditSortie(Sortie s, ArrayList<Person> loadList, String start, String end,
			String squadron, String type) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

		LocalDate dateStart = LocalDate.parse(start, formatter);
		LocalDate dateEnd = LocalDate.parse(end, formatter);

		switch (squadron) {
		case "960 AACS":
			squadron = "0";
			break;
		case "961 AACS":
			squadron = "1";
			break;
		case "962 AACS":
			squadron = "2";
			break;
		case "963 AACS":
			squadron = "3";
			break;
		case "964 AACS":
			squadron = "4";
			break;
		case "965 AACS":
			squadron = "5";
			break;
		case "966 AACS":
			squadron = "6";
			break;
		default:
			squadron = "?";
			break;
		}

		switch (type) {
		case "J-Sortie":
			type = "J";
			break;
		case "T-Sortie":
			type = "T";
			break;
		case "P-Sortie":
			type = "P";
			break;
		case "X-Sortie":
			type = "X";
			break;
		case "S-Sortie":
			type = "S";
			break;
		case "W-Sortie":
			type = "W";
			break;
		default:
			type = "?";
			break;
		}

		String sortieNumber = DataConvert.toSortieNumber(dateStart, squadron, type);

		s.startDate = dateStart;
		s.endDate = dateEnd;
		s.sortieNumber = sortieNumber;
		s.loadList = loadList;

		return s;
	}

	public static void sortAndFilter() {

	}

	public static void refreshLookbackValues() {
		System.out.println("Refreshing lookback...");
		for (Sortie s : Main.sortieIndex) {
			for (Person p : s.loadList) {
				p.sortiesAllTime.add(s.startDate);
			}
		}

		LocalDate oneMonthLookbackRegion[] = new LocalDate[2];
		oneMonthLookbackRegion[0] = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 01).minusMonths(1);
		oneMonthLookbackRegion[1] = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 01).minusDays(1);
		System.out.println("\n1mo] "+oneMonthLookbackRegion[0] + " - " + oneMonthLookbackRegion[1]);
		
		LocalDate threeMonthLookbackRegion[] = new LocalDate[2];
		threeMonthLookbackRegion[0] = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 01).minusMonths(3);
		threeMonthLookbackRegion[1] = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 01).minusDays(1);
		System.out.println("3mo] "+threeMonthLookbackRegion[0] + " - " + threeMonthLookbackRegion[1]+"\n");

		for (Person p : Main.personIndex) {
			for (LocalDate ld : p.sortiesAllTime) {
				if (ld.isAfter(oneMonthLookbackRegion[0].minusDays(1)) && ld.isBefore(oneMonthLookbackRegion[1].plusDays(1)))
					p.lookbackOne++;
				if (ld.isAfter(threeMonthLookbackRegion[0].minusDays(1)) && ld.isBefore(threeMonthLookbackRegion[1].plusDays(1)))
					p.lookbackThree++;
			}
		}
		for (Person p : Main.personIndex) {
			System.out.println(p + " - lb1: " + p.lookbackOne + " lb3: " + p.lookbackThree);
		}

	}
}