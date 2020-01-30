package projDemo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import projDemo.LookbackMeter.Month;
import projDemo.GroundingMeter.State;;

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

	public static boolean getLookbackStatus(Person p, LookbackMeter.Month type) {
		p.sortiesAllTime.clear();
		p.lookbackOne = 0;
		p.lookbackThree = 0;

		for (Sortie s : Main.sortieIndex) {
			for (Person p1 : s.loadList) {
				if (p.equals(p1))
					p.sortiesAllTime.add(s);
			}
		}

		if (type.equals(LookbackMeter.Month.ONE_MONTH)) {

			LocalDate oneMonthLookbackRegion[] = new LocalDate[2];
			oneMonthLookbackRegion[0] = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 01)
					.minusMonths(1);
			oneMonthLookbackRegion[1] = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 01)
					.minusDays(1);

			for (Sortie s : p.sortiesAllTime) {
				if (s.startDate.isAfter(oneMonthLookbackRegion[0].minusDays(1))
						&& s.startDate.isBefore(oneMonthLookbackRegion[1].plusDays(1)))
					p.lookbackOne++;
			}

			if (p.lookbackOne >= 2) {
				return true;
			} else {
				return false;
			}

		} else if (type.equals(LookbackMeter.Month.THREE_MONTH)) {

			LocalDate threeMonthLookbackRegion[] = new LocalDate[2];
			threeMonthLookbackRegion[0] = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 01)
					.minusMonths(3);
			threeMonthLookbackRegion[1] = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 01)
					.minusDays(1);

			for (Sortie s : p.sortiesAllTime) {
				if (s.startDate.isAfter(threeMonthLookbackRegion[0].minusDays(1))
						&& s.startDate.isBefore(threeMonthLookbackRegion[1].plusDays(1)))
					p.lookbackThree++;
			}

			if (p.lookbackThree >= 6) {
				return true;
			} else {
				return false;
			}

		}

		return false;
	}

	public static String getTooltipForLookbackMeter(Person p, Month type) {
		String sorties = "<html>";

		if (type.equals(Month.ONE_MONTH)) {
			LocalDate oneMonthLookbackRegion[] = new LocalDate[2];
			oneMonthLookbackRegion[0] = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 01)
					.minusMonths(1);
			oneMonthLookbackRegion[1] = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 01)
					.minusDays(1);

			for (Sortie s : p.sortiesAllTime) {
				if (s.startDate.isAfter(oneMonthLookbackRegion[0].minusDays(1))
						&& s.startDate.isBefore(oneMonthLookbackRegion[1].plusDays(1)))
					sorties += s.sortieNumber + "<br>";
			}
		}

		if (type.equals(Month.THREE_MONTH)) {
			LocalDate threeMonthLookbackRegion[] = new LocalDate[2];
			threeMonthLookbackRegion[0] = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 01)
					.minusMonths(3);
			threeMonthLookbackRegion[1] = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 01)
					.minusDays(1);

			for (Sortie s : p.sortiesAllTime) {
				if (s.startDate.isAfter(threeMonthLookbackRegion[0].minusDays(1))
						&& s.startDate.isBefore(threeMonthLookbackRegion[1].plusDays(1)))
					sorties += s.sortieNumber + "<br>";
			}
		}

		sorties += "</html>";
		if (sorties.contentEquals("<html></html>"))
			return "No flights found";

		return sorties;
	}

	public static boolean getCurrencyStatus(Person p) {
		LocalDate lastDayForCurrency = LocalDate
				.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth())
				.minusDays(60);
		LocalDate mostRecentSortie = LocalDate.of(1990, 01, 01);

		for (Sortie s : p.sortiesAllTime) {
			if (s.startDate.isAfter(mostRecentSortie)) {
				mostRecentSortie = s.startDate;
			}
		}

		if (mostRecentSortie.isAfter(lastDayForCurrency)) {
			return true;
		} else {
			return false;
		}

	}

	public static String getTooltipForCurrencyMeter(Person p) {
		LocalDate mostRecentSortie = LocalDate.of(1990, 01, 01);

		String sortieNumber = "";

		for (Sortie s : p.sortiesAllTime) {
			if (s.startDate.isAfter(mostRecentSortie)) {
				mostRecentSortie = s.startDate;
				sortieNumber = s.sortieNumber;
			}
		}

		if (p.sortiesAllTime.size() < 1)
			return "No flights found";

		return sortieNumber;

	}

	public static int getCurrencyDaysLeft(Person p) {
		LocalDate lastDayForCurrency = LocalDate
				.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth())
				.minusDays(60);
		LocalDate mostRecentSortie = LocalDate.of(1990, 01, 01);

		for (Sortie s : p.sortiesAllTime) {
			if (s.startDate.isAfter(mostRecentSortie)) {
				mostRecentSortie = s.startDate;
			}
		}

		if (p.sortiesAllTime.size() < 1)
			return 0;

		return (int) ChronoUnit.DAYS.between(lastDayForCurrency, mostRecentSortie);

	}
	
	public static void groundingMeterManager(Person p, GroundingMeter meter) {
		if(p.groundingTags.size() <= 0) {
			meter.setState(State.GREEN);
			meter.setLabel("Cleared for flight");
			meter.setPanelTooltip("No tags loaded.");
		} else if(true) {
			// ADD ALL STIPULATIONS FOR GROUNDING TAGS
		}
	}
}