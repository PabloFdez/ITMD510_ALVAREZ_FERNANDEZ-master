package application;

public class Course {
	String cName;
	int cID;
	int nCredits;
	Professor prof;
	University uni;
	Student[] stds;
	
	public Course(String name, int credits, Professor pro, University university) {
		cName = name;
		nCredits = credits;
		prof = pro;
		uni = university;
	}
	
	public Course(int i_d, String name, int credits, Professor pro, University university) {
		cID = i_d;
		cName = name;
		nCredits = credits;
		prof = pro;
		uni = university;
	}

	/**
	 * @return the cName
	 */
	public String getcName() {
		return cName;
	}

	/**
	 * @param cName the cName to set
	 */
	public void setcName(String cName) {
		this.cName = cName;
	}

	/**
	 * @return the cID
	 */
	public int getcID() {
		return cID;
	}

	/**
	 * @param cID the cID to set
	 */
	public void setcID(int cID) {
		this.cID = cID;
	}

	/**
	 * @return the nCredits
	 */
	public int getnCredits() {
		return nCredits;
	}

	/**
	 * @param nCredits the nCredits to set
	 */
	public void setnCredits(int nCredits) {
		this.nCredits = nCredits;
	}

	/**
	 * @return the prof
	 */
	public Professor getProf() {
		return prof;
	}

	/**
	 * @param prof the prof to set
	 */
	public void setProf(Professor prof) {
		this.prof = prof;
	}

	/**
	 * @return the uni
	 */
	public University getUni() {
		return uni;
	}

	/**
	 * @param uni the uni to set
	 */
	public void setUni(University uni) {
		this.uni = uni;
	}

	/**
	 * @return the stds
	 */
	public Student[] getStds() {
		return stds;
	}

	/**
	 * @param stds the stds to set
	 */
	public void setStds(Student[] stds) {
		this.stds = stds;
	}
}
