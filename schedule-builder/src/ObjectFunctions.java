import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class ObjectFunctions {

	public static void userCreateSortie() {

		System.out.print("Enter squadron (ex: 3)... ");
		String squadron = Main.sc.nextLine();
		System.out.print("Enter sortie type (ex: J)... ");
		String type = Main.sc.nextLine().toUpperCase();
		System.out.print("Enter takeoff year (ex: 2020)... ");
		int year = Main.sc.nextInt();
		System.out.print("Enter takeoff month (ex: 11)... ");
		int month = Main.sc.nextInt();
		System.out.print("Enter takeoff date (ex: 13)... ");
		int date = Main.sc.nextInt();

		LocalDate start = DataConvert.fromMultIntToLocalDate(year, month, date);
		LocalDate end = start;

		String snum = DataConvert.toSortieNumber(start, squadron, type);

		System.out.println("Is landing date same as takeoff date?");

		boolean endSwitch = false;
		while (!endSwitch) {
			switch (Main.sc.nextLine().toUpperCase()) {
			case "Y":
				endSwitch = true;
				break;
			case "N":
				System.out.print("Enter landing year (ex: 2020)... ");
				int yearE = Main.sc.nextInt();
				System.out.print("Enter landing month (ex: 11)... ");
				int monthE = Main.sc.nextInt();
				System.out.print("Enter landing date (ex: 13)... ");
				int dateE = Main.sc.nextInt();

				end = DataConvert.fromMultIntToLocalDate(yearE, monthE, dateE);
				endSwitch = true;
				break;
			default:
				System.out.println(" -> Use \"Y\" or \"N\"");
				break;
			}
		}

		Sortie s = new Sortie(snum, start, end);

		System.out.println("\nNEW OBJECT CREATED\n" + s.toString() + " (" + s.uuid + ")\n" + s.sortieNumber + " ("
				+ s.startDate + " - " + s.endDate + ")\n" + s.loadList);

	}

	public static void userCreatePerson() {

		System.out.print("Enter rank... ");
		String rank = Main.sc.nextLine();
		System.out.print("Enter first name... ");
		String nameFirst = Main.sc.nextLine();
		System.out.print("Enter middle name... ");
		String nameMiddle = Main.sc.nextLine();
		System.out.print("Enter last name... ");
		String nameLast = Main.sc.nextLine();
		System.out.print("Enter crew position... ");
		String crewPos = Main.sc.nextLine();
		System.out.print("Enter shop... ");
		String shop = Main.sc.nextLine();
		System.out.print("Enter flight... ");
		String flight = Main.sc.nextLine();
		System.out.print("Enter phone number... ");
		String phoneNumber = Main.sc.nextLine();
		System.out.print("Enter address... ");
		String address = Main.sc.nextLine();
		System.out.print("Enter social... ");
		String social = Main.sc.nextLine();

		Person p = new Person(rank, nameFirst, nameMiddle, nameLast, crewPos, shop, flight, phoneNumber, address,
				social);

		System.out.println("\nNEW OBJECT CREATED\n" + p.toString() + " (" + p.uuid + ")\n" + p.rank + " " + p.nameLast
				+ ", " + p.nameFirst + " " + p.nameMiddle + "\n" + p.crewPos + ", " + p.shop + " // " + p.flight + "\n"
				+ p.phoneNumber + "\n" + p.address + "\n" + p.social);

	}

	public static void printAllSorties() {

		System.out.println("\nSRTNUM - STARTDT - ENDDATE - #P\n======   =======   =======   ==");
		for (Sortie s : Main.sortieIndex) {

			String start = DataConvert.ldToString(s.startDate, false);
			String end = DataConvert.ldToString(s.endDate, false);
			if (start.contentEquals(end))
				end = ".      ";

			System.out.println(s.sortieNumber + " - " + start + " - " + end + " - "
					+ new DecimalFormat("00").format(s.loadList.size()));
		}

		boolean loopIsRunning = true;

		while (loopIsRunning) {
			System.out.print("\nEnter sortie number for detail, or Return to skip... ");

			String localSN = Main.sc.nextLine();

			switch (localSN.toUpperCase()) {
			case "":
				loopIsRunning = false;
				break;
			default:
				boolean foundMatch = false;
				for (Sortie s : Main.sortieIndex) {
					if (localSN.toUpperCase().contentEquals(s.sortieNumber)) {
						foundMatch = true;

						System.out.println("Sortie Number:  " + s.sortieNumber);
						System.out.println("Start Date:     " + s.startDate);
						System.out.println("End Date:       " + s.endDate);
						System.out.println("Crew Loaded:    " + DataConvert.fromLoadListToString(s.loadList));
						System.out.println("((" + s.toString() + "//" + s.uuid + "))");

						System.out.print("Edit? (Y/N) ");

						boolean switchLoopRunning = true;

						while (switchLoopRunning) {
							switch (Main.sc.nextLine().toUpperCase()) {
							case "Y":

								boolean nestedSwitchLoopRunning = true;

								while (nestedSwitchLoopRunning) {
									System.out.println("Choose: (1) Start Date (2) End Date "
											+ "\n        (3) Squadron   (4) Sortie Type "
											+ "\n        (5) Add Crew   (6) Remove Crew "
											+ "\n        (Return) to close");

									switch (Main.sc.nextLine()) {
									case "1":
										System.out.print("Enter takeoff year (ex: 2020)... ");
										int year = Main.sc.nextInt();
										System.out.print("Enter takeoff month (ex: 11)... ");
										int month = Main.sc.nextInt();
										System.out.print("Enter takeoff date (ex: 13)... ");
										int date = Main.sc.nextInt();

										s.startDate = DataConvert.fromMultIntToLocalDate(year, month, date);

										String squadron1 = "";
										squadron1 += s.sortieNumber.toCharArray()[1];

										String type1 = "";
										type1 += s.sortieNumber.toCharArray()[2];

										s.sortieNumber = DataConvert.toSortieNumber(s.startDate, squadron1, type1);
										System.out.println("Sortie number updated: " + s.sortieNumber);

										if (s.endDate.isBefore(s.startDate)) {
											s.endDate = s.startDate;
											System.out.println(
													"End date was detected to be before start date. Automatically set end to to equal start date.");
										}
										break;
									case "2":
										System.out.print("Enter landing year (ex: 2020)... ");
										int yearE = Main.sc.nextInt();
										System.out.print("Enter landing month (ex: 11)... ");
										int monthE = Main.sc.nextInt();
										System.out.print("Enter landing date (ex: 13)... ");
										int dateE = Main.sc.nextInt();

										s.endDate = DataConvert.fromMultIntToLocalDate(yearE, monthE, dateE);

										if (s.endDate.isBefore(s.startDate)) {
											s.endDate = s.startDate;
											System.out.println(
													"End date was detected to be before start date. Automatically set end to to equal start date.");
										}

										break;
									case "3":
										System.out.print("Enter squadron (ex: 3)... ");
										String squadronTemp = Main.sc.nextLine();
										String type = "";
										type += s.sortieNumber.toCharArray()[2];
										s.sortieNumber = DataConvert.toSortieNumber(s.startDate, squadronTemp, type);
										System.out.println("Sortie number updated: " + s.sortieNumber);
										break;
									case "4":
										System.out.print("Enter sortie type (ex: J)... ");
										String typeTemp = Main.sc.nextLine().toUpperCase();

										String squadron2 = "";
										squadron2 += s.sortieNumber.toCharArray()[1];

										s.sortieNumber = DataConvert.toSortieNumber(s.startDate, squadron2, typeTemp);

										System.out.println("Sortie number updated: " + s.sortieNumber);
										break;
									case "5":
										s.loadList = crewAdd(s.loadList);
										break;
									case "6":
										s.loadList = crewRemove(s.loadList);
										break;
									case "":
										System.out.println("Exiting editor");
										nestedSwitchLoopRunning = false;
										break;
									default:
										System.out.println("Did not recognise input.");
										break;
									}
								}
								switchLoopRunning = false;
								break;
							case "N":
								switchLoopRunning = false;
								break;
							default:
								System.out.print("Enter 'Y' or 'N'... ");
								break;
							}
						}
					}
				}
				if (!foundMatch)
					System.out.println("Failed to recognise input '" + localSN + "'.");
				break;
			}
		}

	}

	public static void printAllPersons() {

		System.out.println("\nPERSONNEL\n=========");

		for (Person p : Main.personIndex) {

			System.out.println(p.rank + " " + p.nameLast + ", " + p.nameFirst + " " + p.nameMiddle + " - " + p.crewPos
					+ " / " + p.shop + " / " + p.flight + " - " + p.phoneNumber);
		}

		boolean loopIsRunning = true;

		while (loopIsRunning) {

			System.out.print("\nEnter last name for detail, or Return to skip... ");
			String localLN = Main.sc.nextLine();

			switch (localLN.toUpperCase()) {
			case "":
				loopIsRunning = false;
				break;
			default:
				boolean foundMatch = false;
				for (Person p : Main.personIndex) {
					if (localLN.toUpperCase().contentEquals(p.nameLast.toUpperCase())) {
						foundMatch = true;
						System.out.println("\n" + p.rank + " " + p.nameLast + ", " + p.nameFirst + " " + p.nameMiddle
								+ "\nCrew Position: " + p.crewPos + "\nShop: " + p.shop + "\nFlight: " + p.flight
								+ "\nPhone Number: " + p.phoneNumber + "\nAddress: " + p.address + "\nSocial: "
								+ p.social);
						System.out.println(p.calendar);
						System.out.println("((" + p.toString() + "//" + p.uuid + "))");
					}
				}
				if (!foundMatch)
					System.out.println("Failed to recognise input '" + localLN + "'.");
				break;
			}
		}
	}

	public static ArrayList<Person> crewAdd(ArrayList<Person> loadList) {
		System.out.print("Add to crew: Enter last name... ");

		String input = Main.sc.nextLine().toUpperCase();

		for (Person p : Main.personIndex) {
			if (p.nameLast.toUpperCase().contentEquals(input)) {
				loadList.add(p);

				System.out.println("Added " + p.nameLast + " to loadList");
				System.out.println(DataConvert.fromLoadListToString(loadList));
			}
		}

		for (Person p : Main.personIndex) {
			if (p.nameLast.toUpperCase().contentEquals(input)) {
				for (Person pe : loadList) {
					if (pe.uuid.toString().contentEquals(p.uuid.toString())) {
						System.out.println("error - removing due to duplication");
						loadList.remove(pe);
					}

				}
				/*
				 * loadList.add(p);
				 * 
				 * System.out.println("Added " + p.nameLast + " to loadList");
				 * System.out.println(DataConvert.fromLoadListToString(loadList));
				 */
			}
		}

		return loadList;
	}

	public static ArrayList<Person> crewRemove(ArrayList<Person> loadList) {
		System.out.print("Remove from crew: Enter last name... ");

		String input = Main.sc.nextLine().toUpperCase();

		for (Person p : Main.personIndex) {
			if (p.nameLast.toUpperCase().contentEquals(input)) {
				loadList.remove(p);
				System.out.println("Removed " + p.nameLast + " to loadList");
			}
		}

		return loadList;
	}

}