package models;

public abstract class AcademicMember implements Member {
	int id;
	String firstName;
	String lastName;
	String email;
	String user;
	
	public AcademicMember(String fName,String lName, String us, String eM){
		firstName = fName;
		lastName = lName;
		user = us;
		email = us + eM;
	}
	
	public AcademicMember(int i_d, String fName,String lName, String us, String eM){
		id=i_d;
		firstName = fName;
		lastName = lName;
		user = us;
		email = us + eM;
	}
	
	@Override
	public boolean getMemberType() {
		// TODO Auto-generated method stub
		if(this.getEmail().contains("hawk.iit.edu")) {
			return true;
		}
		return false;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	
	
	
}
