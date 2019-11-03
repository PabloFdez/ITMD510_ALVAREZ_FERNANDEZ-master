package application;

public class Course {
	String cName;
	int cID;
	int nCredits;
	Professor prof;
	University uni;
	Student[] stds;
	
	public Course(String name, int ID, int credits, Professor pro, University university) {
		cName = name;
		cID = ID;
		nCredits = credits;
		prof = pro;
		uni = university;
	}
}
