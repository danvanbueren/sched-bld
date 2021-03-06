package projDemo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Sortie implements Serializable {

	private static final long serialVersionUID = -8658931064359097206L;

	UUID uuid;

	String sortieNumber;

	LocalDate startDate, endDate;

	String[] loadListTemp;
	ArrayList<Person> loadList = new ArrayList<>();

	// LOAD FROM FILE
	public Sortie(UUID uuid, String sortieNumber, LocalDate startDate, LocalDate endDate, String[] loadListTemp) {

		boolean good = true;

		for (Sortie sor : Main.sortieIndex) {
			if (uuid.equals(sor.uuid)) {
				System.out.println("Tried creating an object with the same UUID as another object!");
				good = false;
			}
		}

		if (good) {

			Main.sortieIndex.add(this);

			this.uuid = uuid;
			this.sortieNumber = sortieNumber;
			this.startDate = startDate;
			this.endDate = endDate;
			this.loadListTemp = loadListTemp;

		}
	}

	// LOAD FROM USER
	public Sortie(String sortieNumber, LocalDate startDate, LocalDate endDate/* , ArrayList<Person> loadList */) {

		Main.sortieIndex.add(this);

		uuid = UUID.randomUUID();
		this.sortieNumber = sortieNumber;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return sortieNumber + " [" + startDate.format(Constants.dateTimeFormat) + "]";
	}

}
