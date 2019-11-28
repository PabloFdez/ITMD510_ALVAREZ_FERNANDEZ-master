package application;

public class Grade {
	private Student std;
	private Course c;
	private Double grade;
	
	public Grade(Student student, Course course, Double egrade) {
		std = student;
		c = course;
		grade = egrade;
	}

	public Student getStd() {
		return std;
	}

	public void setStd(Student std) {
		this.std = std;
	}

	public Course getC() {
		return c;
	}

	public void setC(Course c) {
		this.c = c;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}
}
