package projDemo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import projDemo.Constants.IndefiniteGrounded;
import projDemo.Constants.MeterState;
import projDemo.Constants.MeterType;

public class HelperFunction {

	public static void systemCreateAppointment(Person p) {
		LocalDate startDate = null, endDate = null;
		boolean isFlyable = true;
		String description = null;
		Appointment a = new Appointment(startDate, endDate, isFlyable, description);
		p.calendar.add(a);
	}

	public static void systemCreateSortie(String start, String end, String squadron, String type) {

		LocalDate dateStart = LocalDate.parse(start, Constants.dateTimeFormat);
		LocalDate dateEnd = LocalDate.parse(end, Constants.dateTimeFormat);

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

		String sortieNumber = HelperDataConversion.toSortieNumber(dateStart, squadron, type);

		@SuppressWarnings("unused")
		Sortie s = new Sortie(sortieNumber, dateStart, dateEnd);
	}

	public static Sortie systemEditSortie(Sortie s, ArrayList<Person> loadList, String start, String end,
			String squadron, String type) {

		LocalDate dateStart = LocalDate.parse(start, Constants.dateTimeFormat);
		LocalDate dateEnd = LocalDate.parse(end, Constants.dateTimeFormat);

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

		String sortieNumber = HelperDataConversion.toSortieNumber(dateStart, squadron, type);

		s.startDate = dateStart;
		s.endDate = dateEnd;
		s.sortieNumber = sortieNumber;
		s.loadList = loadList;

		return s;
	}

	public static void sortAndFilter() {

	}

	public static boolean getLookbackStatus(Person p, MeterType type) {
		p.sortiesAllTime.clear();
		p.lookbackOne = 0;
		p.lookbackThree = 0;

		for (Sortie s : Main.sortieIndex) {
			for (Person p1 : s.loadList) {
				if (p.equals(p1))
					p.sortiesAllTime.add(s);
			}
		}

		if (type.equals(MeterType.ONE)) {

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

		} else if (type.equals(MeterType.THREE)) {

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

	public static String getTooltipForLookbackMeter(Person p, MeterType type) {
		String sorties = "<html>";

		if (type.equals(MeterType.ONE)) {
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

		if (type.equals(MeterType.THREE)) {
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

	public static void groundingMeterManager(Person p, MeterGrounding meter) {

		meter.setState(MeterState.GREEN);

		boolean markYellow = false, markRed = false;
		String tooltipText = "<html>", labelText = "";

		for (IndefiniteGrounded ig : p.groundingTags) {
			switch (ig) {
			case GENERIC_RED:
				markRed = true;
				labelText += "GENERIC_RED ";
				tooltipText += "[GENERIC_RED] Generic grounding, non-waivable<br>";
				break;
			case GENERIC_YELLOW:
				markYellow = true;
				labelText += "GENERIC_YELLOW ";
				tooltipText += "[GENERIC_YELLOW] Generic grounding, waivable<br>";
				break;
			case TRAINING_PLAN:
				markYellow = true;
				labelText += "TRAINING_PLAN ";
				tooltipText += "[TRAINING_PLAN] Requires instructor<br>";
				break;
			case NON_CMR:
				markYellow = true;
				labelText += "NON_CMR ";
				tooltipText += "[NON_CMR] Requires instructor, waivable<br>";
				break;
			case BMC_BAQ:
				markYellow = true;
				labelText += "BMC_BAQ ";
				tooltipText += "[BMC_BAQ] Requires instructor, waivable<br>";
				break;
			case DNIF:
				markRed = true;
				labelText += "DNIF ";
				tooltipText += "[DNIF] Non-waivable<br>";
				break;
			}

		}

		tooltipText += "</html>";

		if (tooltipText.contentEquals("<html></html>")) {
			tooltipText = "No tags found";
		}

		if (labelText == "")
			labelText = "Cleared for flight";

		meter.setLabel(labelText);
		meter.setPanelTooltip(tooltipText);

		if (markRed) {
			meter.setState(MeterState.RED);
		} else if (markYellow) {
			meter.setState(MeterState.YELLOW);
		}
	}

	public static void evalMeterManager(Person p, MeterEval meter) {
		meter.setState(MeterState.UNK, MeterState.UNK);
		meter.setPanelTooltip("", "");
		meter.setLabelNumber(0, 0);

		int daysUntilMsnEvalWindowOpens = (int) ChronoUnit.DAYS.between(LocalDate.now(), p.lastEvalMsn.plusMonths(12));

		/*
		 * THIS NEEDS TO BE FACT CHECKED!! IS IT REALLY 16 MONTHS?? OR 18??
		 */
		int daysUntilMsnEvalWindowCloses = (int) ChronoUnit.DAYS.between(LocalDate.now(), p.lastEvalMsn.plusMonths(16));

		int daysUntilQualEvalWindowOpens = (int) ChronoUnit.DAYS.between(LocalDate.now(), p.lastEvalQual.plusMonths(12));

		/*
		 * THIS NEEDS TO BE FACT CHECKED!! IS IT REALLY 16 MONTHS?? OR 18??
		 */
		int daysUntilQualEvalWindowCloses = (int) ChronoUnit.DAYS.between(LocalDate.now(),
				p.lastEvalQual.plusMonths(16));

		MeterState tempStateMsn, tempStateQual;
		String tempTooltipMsn, tempTooltipQual;
		int tempNumMsn, tempNumQual;

		if (daysUntilMsnEvalWindowOpens > 0) {
			// set msn state green, return int & tooltip
			tempStateMsn = MeterState.GREEN;
			tempTooltipMsn = "Mission eval window will open in " + daysUntilMsnEvalWindowOpens + " days";
			tempNumMsn = daysUntilMsnEvalWindowOpens;
		} else if (daysUntilMsnEvalWindowCloses > 0) {
			// set msn state yellow, return int & tooltip
			tempStateMsn = MeterState.YELLOW;
			tempTooltipMsn = "Mission eval window is open for " + daysUntilMsnEvalWindowCloses + " days";
			tempNumMsn = daysUntilMsnEvalWindowCloses;
		} else {
			// set msn state red, return int & tooltip
			tempStateMsn = MeterState.RED;
			tempTooltipMsn = "Mission eval window missed by " + daysUntilMsnEvalWindowCloses + " days";
			tempNumMsn = daysUntilMsnEvalWindowCloses;
		}

		if (daysUntilQualEvalWindowOpens > 0) {
			// set qual state green, return int & tooltip
			tempStateQual = MeterState.GREEN;
			tempTooltipQual = "Qual eval window will open in " + daysUntilQualEvalWindowOpens + " days";
			tempNumQual = daysUntilQualEvalWindowOpens;
		} else if (daysUntilQualEvalWindowCloses > 0) {
			// set qual state yellow, return int & tooltip
			tempStateQual = MeterState.YELLOW;
			tempTooltipQual = "Qual eval window is open for " + daysUntilQualEvalWindowCloses + " days";
			tempNumQual = daysUntilQualEvalWindowCloses;
		} else {
			// set qual state red, return int & tooltip
			tempStateQual = MeterState.RED;
			tempTooltipQual = "Qual eval window missed by " + daysUntilQualEvalWindowCloses + " days";
			tempNumQual = daysUntilQualEvalWindowCloses;
		}

		meter.setState(tempStateQual, tempStateMsn);
		meter.setPanelTooltip(tempTooltipQual, tempTooltipMsn);
		meter.setLabelNumber(tempNumQual, tempNumMsn);

	}
}