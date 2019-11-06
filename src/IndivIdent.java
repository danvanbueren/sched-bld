
public class IndivIdent {

	String nameFirst, nameLast, uuid;
	int appointment[];

	public IndivIdent() {

		// Constructor so that objects can be created.
		
		}
	
	public void createIdentityInDatabase(String nameFirst, String nameLast, String uuid, int appointment[]) {

		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.uuid = uuid;
		this.appointment = appointment;
	}
	
	public void loadIdentityFromDatabase(String uuid) {

		this.uuid = uuid;
		
		switch(uuid) {
		case "1234u5":
			System.out.println("UUID " + uuid + " selected. Loading...");
			break;
		default:
			System.out.println("defaulted");
			break;
		}
	}

}
