package projDemo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Appointment implements Serializable {

	private static final long serialVersionUID = -4460058923598831692L;
	
	UUID uuid;
	
	LocalDate startDate, endDate;
	boolean isFlyable;
	String description;

	public Appointment(LocalDate startDate, LocalDate endDate, boolean isFlyable, String description) {

		uuid = UUID.randomUUID();
		
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