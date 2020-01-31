package projDemo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import projDemo.Constants.IndefiniteGrounded;

public class Person {

	UUID uuid = UUID.randomUUID();

	String rank, nameFirst, nameMiddle, nameLast, crewPos, shop, flight, phoneNumber, address, social;
	ArrayList<Appointment> calendar = new ArrayList<>();
	ArrayList<Sortie> sortiesAllTime = new ArrayList<>();
	int lookbackOne, lookbackThree;

	// these need to be saved and editable!!
	ArrayList<IndefiniteGrounded> groundingTags = new ArrayList<>();
	
	LocalDate lastEvalMsn = LocalDate.of(1990, 01, 01);
	LocalDate lastEvalQual = LocalDate.of(1990, 01, 01);

	public Person(String rank, String nameFirst, String nameMiddle, String nameLast, String crewPos, String shop,
			String flight, String phoneNumber, String address, String social) {
		Main.personIndex.add(this);

		this.rank = rank;
		this.nameFirst = nameFirst;
		this.nameMiddle = nameMiddle;
		this.nameLast = nameLast;
		this.crewPos = crewPos;
		this.shop = shop;
		this.flight = flight;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.social = social;
	}

	public Person(UUID uuid, ArrayList<Appointment> calendar, String rank, String nameFirst, String nameMiddle,
			String nameLast, String crewPos, String shop, String flight, String phoneNumber, String address,
			String social) {
		
		boolean good = true;

		for (Person per : Main.personIndex) {
			if (uuid.equals(per.uuid)) {
				System.err.println("Tried creating an object with the same UUID as another object!");
				good = false;
			}
		}

		if (good) {
			Main.personIndex.add(this);

			this.uuid = uuid;
			this.calendar = calendar;

			this.rank = rank;
			this.nameFirst = nameFirst;
			this.nameMiddle = nameMiddle;
			this.nameLast = nameLast;
			this.crewPos = crewPos;
			this.shop = shop;
			this.flight = flight;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.social = social;
		}
	}

	@Override
	public String toString() {
		return rank + " " + nameLast + ", " + nameFirst + " " + nameMiddle + " [" + crewPos + "] [" + shop + "] ["
				+ flight + "]";
	}
}