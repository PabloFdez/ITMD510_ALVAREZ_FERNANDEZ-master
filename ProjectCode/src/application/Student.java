package application;
import models.AcademicMember;

public class Student extends AcademicMember{
	double gpa;
	String major;
	
	
	public Student(String fName, String lName, String eM, String maj) {
		super(fName, lName, eM, "@hawk.iit.edu");
		major = maj;
		gpa = 0;
	}


	@Override
	public void getMemberInfo() {
		// TODO Auto-generated method stub
		
	}
}
