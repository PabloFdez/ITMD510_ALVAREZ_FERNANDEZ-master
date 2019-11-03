package application;
import models.AcademicMember;

public class Professor extends AcademicMember{
	String department;
	int officeNo;
	
	public Professor(String fName, String lName, String eM, String maj, String dept, int offNo) {
		super(fName, lName, eM, "@iit.edu");
		department = dept;
		officeNo = offNo;
	}

	@Override
	public void getMemberInfo() {
		// TODO Auto-generated method stub
		
	}
}
