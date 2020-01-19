package projDemo;

import java.time.LocalDate;

public class ObjectFunctions {

	public static void systemCreateAppointment(Person p) {
		LocalDate startDate = null, endDate = null;
		boolean isFlyable = true;
		String description = null;
		Appointment a = new Appointment(startDate, endDate, isFlyable, description);
		p.calendar.add(a);
	}

}