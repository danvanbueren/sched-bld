package projDemo;

import java.time.LocalDate;

public class Appointment {

	LocalDate startDate, endDate;
	boolean isFlyable;
	String description;

	public Appointment(LocalDate startDate, LocalDate endDate, boolean isFlyable, String description) {

		this.startDate = startDate;
		this.endDate = endDate;
		this.isFlyable = isFlyable;
		this.description = description;

	}

	@Override
	public String toString() {
		if (isFlyable) {
			return "[" + startDate + " - " + endDate + "] FLY: " + description;
		} else {
			return "[" + startDate + " - " + endDate + "] NOFLY: " + description;
		}
	}
}