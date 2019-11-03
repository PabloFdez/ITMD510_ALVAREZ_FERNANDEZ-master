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
