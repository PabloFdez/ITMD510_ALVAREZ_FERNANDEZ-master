package models;

public abstract class AcademicMember implements Member {
	String firstName;
	String lastName;
	int id;
	String email;
	String user;
	
	public AcademicMember(String fName,String lName, String us, String eM){
		firstName = fName;
		lastName = lName;
		user = us;
		email = us + eM;
	}
	
	
	
}
