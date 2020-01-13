import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static ArrayList<Person> personIndex = new ArrayList<>();
	public static ArrayList<Sortie> sortieIndex = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {

		DatabaseComposer.load();
		
		Window.build();
		// doMenu();
		sc.close();

	}

	public static void doMenu() {

		// WHILE LOOP CONTROL VARIABLES
		String menuSelect = "";
		boolean menuRunning = true;

		do {
			// RESET MENU SELECT VARIABLE BEFORE REQUESTING NEW INPUT
			menuSelect = "";

			System.out.print(
					"\nMENU\n[0] SAVE & EXIT\n[1] NEW PERSON\n[2] NEW SORTIE\n[3] VIEW SORTIES\n[4] VIEW PEOPLE\n - Development -\n[A] FORCE WRITE\n[B] FORCE READ\n[C] PRINT INDEX ARRAYS\n[D] FIND OBJECT\nEnter character: ");

			try {
				menuSelect = sc.nextLine().toUpperCase();
			} catch (Exception e) {
				System.out.println(e);
			}

			switch (menuSelect) {
			// EXIT
			case "0":
				DatabaseComposer.save();
				menuRunning = false;
				break;

			// NEW PERSON
			case "1":
				ObjectFunctions.userCreatePerson();
				break;

			// NEW SORTIE
			case "2":
				ObjectFunctions.userCreateSortie();
				break;

			// VIEW SORTIES
			case "3":
				ObjectFunctions.printAllSorties();
				break;

			// VIEW PEOPLE
			case "4":
				ObjectFunctions.printAllPersons();
				break;

			// FORCE WRITE
			case "A":
				DatabaseComposer.save();
				break;

			// FORCE READ
			case "B":
				DatabaseComposer.load();
				break;

			// PRINT INDEX ARRAYS
			case "C":
				System.out.println(personIndex.size() + personIndex.toString() + "\n" + sortieIndex.size()
						+ sortieIndex.toString());
				break;

			// FIND OBJECT
			case "D":
				// System.out.print("findSortieObject: Enter sortie number... ");
				// Sortie.findSortieObject(sc.nextLine());
				break;

			// UNDEFINED CASE
			default:
				System.out.println("\nUndefined case '" + menuSelect + "'");
				break;
			}

			// GARBAGE COLLECTION
			sc.reset();

		} while (menuRunning);
	}

}

/* HOW TO DO DATE STUFF */
// x[0] = new Date(120, 0, 01);
// System.out.println(x[0]);