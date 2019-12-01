package application;

import models.AcademicMember;

/**
 * @author Pablo Angel Alvarez Fernandez
 * @author Pablo Fernandez Diaz
 * Admin class
 * Defines Admin Type User
 */
public class Admin extends AcademicMember {

	public Admin(String fName, String lName, String us, String eM) {
		super(fName, lName, us, eM);
	}

	@Override
	public void getMemberInfo() {
		
	}

}
