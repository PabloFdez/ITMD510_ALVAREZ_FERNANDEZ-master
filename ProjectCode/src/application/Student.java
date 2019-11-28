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
	
	public Student(int id, String fName, String lName, String eM, String maj) {
		super(id, fName, lName, eM, "@hawk.iit.edu");
		major = maj;
		gpa = 0;
	}
	
	public Student(int id, String fName, String lName, String eM, String maj, double GPA) {
		super(id, fName, lName, eM, "@hawk.iit.edu");
		major = maj;
		gpa = GPA;
	}


	@Override
	public void getMemberInfo() {
		System.out.println("Student named "+getFirstName()+" with last name "+getLastName()+" and email "+getEmail());
	}


	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}


	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}


	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}


	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
}
