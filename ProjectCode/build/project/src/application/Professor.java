package application;
import models.AcademicMember;

public class Professor extends AcademicMember{
	String department;
	int officeNo;
	
	public Professor(String fName, String lName, String eM, String dept, int offNo) {
		super(fName, lName, eM, "@iit.edu");
		department = dept;
		officeNo = offNo;
	}
	
	public Professor(int id, String fName, String lName, String eM, String dept, int offNo) {
		super(id, fName, lName, eM, "@iit.edu");
		department = dept;
		officeNo = offNo;
	}

	@Override
	public void getMemberInfo() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @return the dept
	 */
	public String getDept() {
		return department;
	}


	/**
	 * @param gpa the dept to set
	 */
	public void setDept(String department) {
		this.department = department;
	}

	/**
	 * @return the officeNo
	 */
	public int getOfficeNo() {
		return officeNo;
	}

	/**
	 * @param officeNo the officeNo to set
	 */
	public void setOfficeNo(int officeNo) {
		this.officeNo = officeNo;
	}
	
	
}
