package models;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.*;

public class DBCreate {
	//Connection con = null;
	//DaoModel DB;
	
	DBCreate() {
		//con = DaoModel.con;
		if(!checkcreation()) createTable();
	}
	
	/**
	 * @return if "p_alva_tab" table is there
	 */
	public boolean checkcreation(){
		boolean check = false;
		try{
			DatabaseMetaData dbm = DBConnect.getConnection().getMetaData();
			// check if "p_alva_tab" table is there
			System.out.println("Checking previous creation...");
			ResultSet looktable = dbm.getTables(null, null, "papf_courseStudents", null);
			if (looktable.next()) {
				// Table exists
				check = true;
				System.out.println("Database was previously created");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	/**
	 * Create the different tables with the structure 
	 */
	public void createTable() {
			String sql = "CREATE TABLE papf_students" + "(eID INTEGER not NULL AUTO_INCREMENT, "
			+" eFName VARCHAR(20), " + " eLName VARCHAR(30), " + " eEMail VARCHAR(30), " + " ePassword VARCHAR(30), " + " eMaj VARCHAR(30), " + " eGPA numeric(2,2), " + " PRIMARY KEY ( eID ));";
			
			String sql1 = "CREATE TABLE papf_professors" + "(pID INTEGER not NULL AUTO_INCREMENT, "
			+" pFName VARCHAR(20), " + " pLName VARCHAR(30), " + " pEMail VARCHAR(30), " + " pPassword VARCHAR(30), " + " pDept VARCHAR(30), " + " pOffi INTEGER, " + " PRIMARY KEY ( pID ));";
			
			String sql2 = "CREATE TABLE papf_universities" + "(uAcronym VARCHAR(10), " + " uName VARCHAR(50), " + " uCity VARCHAR(20), " + " uZipCode INTEGER, " + " PRIMARY KEY ( uAcronym ));";
			
			String sql3 = "CREATE TABLE papf_courses" + "(cID INTEGER not NULL AUTO_INCREMENT, "
			+" cName VARCHAR(30), " + " cCredits INTEGER, " + " cProf INTEGER, " + " cUni VARCHAR(10), " + "CONSTRAINT PK_couses PRIMARY KEY ( cID ),"+
			"CONSTRAINT FK_Prof FOREIGN KEY (cProf) REFERENCES papf_professors(pID),"+
			"CONSTRAINT FK_Uni FOREIGN KEY (cUni) REFERENCES papf_universities(uAcronym));";
			
			String sql4 = "CREATE TABLE papf_courseStudents (cID INTEGER not NULL, eID INTEGER not NULL, CONSTRAINT PK_cS PRIMARY KEY (cID,eID),"+ 
			"CONSTRAINT FK_Courses FOREIGN KEY (cID) REFERENCES papf_courses(cID),"+
			"CONSTRAINT FK_Students FOREIGN KEY (eID) REFERENCES papf_students(eID));";
			
			DaoModel.QueryUpd(sql);
			DaoModel.QueryUpd(sql1);
			DaoModel.QueryUpd(sql2);
			DaoModel.QueryUpd(sql3);
			DaoModel.QueryUpd(sql4);
			
			// Inserting students on the data base
			insertDummyRecordsStudents();
			// Inserting professors on the data base
			insertDummyRecordsProfessors();
			// Inserting universities on the data base
			insertDummyRecordsUniversity();
			// Inserting courses on the data base
			insertDummyRecordsCourses();
			// Inserting students on courses on the data base
			insertDummyRecordsCourseStudentsTable();
		
	}
	
	/**
	 * INSERT INTO METHOD for dummy initial records
	 */
	public void insertDummyRecordsStudents() {
		// Execute a query
		System.out.println("Inserting dummy records of students into the table...");
		
		Student s1 = new Student("Pablo", "Fernandez", "pfernandezdiaz", "ITM");
		Student s2 = new Student("Pablo", "Alvarez", "palvarezfernandez", "ITM");
		Student s3 = new Student("John", "Jonnes", "jjonnes20", "CFS");
		Student s4 = new Student("Sarah", "Hernandez", "shernandez8", "SAC");
		Student s5 = new Student("Luis", "Rajoy", "lrajoy", "MCS");
		
		// Update Passwords
		String sql = "Update papf_students SET ePassword = 'pass'  WHERE eEMail = 'pfernandezdiaz@hawk.iit.edu';";
		String sql2 = "Update papf_students SET ePassword = 'pass'  WHERE eEMail = 'palvarezfernandez@hawk.iit.edu';";
		String sql3 = "Update papf_students SET ePassword = 'pass'  WHERE eEMail = 'jjonnes20@hawk.iit.edu';";
		String sql4 = "Update papf_students SET ePassword = 'pass'  WHERE eEMail = 'shernandez8@hawk.iit.edu';";
		String sql5 = "Update papf_students SET ePassword = 'pass'  WHERE eEMail = 'lrajoy@hawk.iit.edu';";
						
		// Insert Students
		DaoModel.insertStudent(s1);
		DaoModel.insertStudent(s2);
		DaoModel.insertStudent(s3);
		DaoModel.insertStudent(s4);
		DaoModel.insertStudent(s5);
		
		// Insert Passwords
		DaoModel.QueryUpd(sql);
		DaoModel.QueryUpd(sql2);
		DaoModel.QueryUpd(sql3);
		DaoModel.QueryUpd(sql4);
		DaoModel.QueryUpd(sql5);
		System.out.println("Insertion completed");
	}
	
	/**
	 * INSERT INTO METHOD for dummy initial records
	 */
	public void insertDummyRecordsProfessors() {
		// Execute a query
		System.out.println("Inserting dummy records of professors into the table...");

		Professor p1 = new Professor("Luke", "Papademas", "lpapademas","ITM",342);
		Professor p2 = new Professor("James", "Papademas", "jpapademas","ITM",163);
		Professor p3 = new Professor("Dr", "Mo", "dmo","ITM",643);
		Professor p4 = new Professor("Ramesh", "Rao", "rrao","ITM",281);
		Professor p5 = new Professor("Jeremy", "Hajek", "jhajek","ITM",207);
		
		// Update Passwords
		String sql = "Update papf_professors SET pPassword = 'pass'  WHERE pEMail = 'lpapademas@iit.edu';";
		String sql2 = "Update papf_professors SET pPassword = 'pass'  WHERE pEMail = 'jpapademas@iit.edu';";
		String sql3 = "Update papf_professors SET pPassword = 'pass'  WHERE pEMail = 'dmo@iit.edu';";
		String sql4 = "Update papf_professors SET pPassword = 'pass'  WHERE pEMail = 'rrao@iit.edu';";
		String sql5 = "Update papf_professors SET pPassword = 'pass'  WHERE pEMail = 'jhajek@iit.edu';";
		
		DaoModel.insertProfessor(p1);
		DaoModel.insertProfessor(p2);
		DaoModel.insertProfessor(p3);
		DaoModel.insertProfessor(p4);
		DaoModel.insertProfessor(p5);
		
		// Insert Passwords
		DaoModel.QueryUpd(sql);
		DaoModel.QueryUpd(sql2);
		DaoModel.QueryUpd(sql3);
		DaoModel.QueryUpd(sql4);
		DaoModel.QueryUpd(sql5);
		System.out.println("Insertion completed");
	}
	
	/**
	 * INSERT INTO METHOD for dummy initial records
	 */
	public void insertDummyRecordsUniversity() {
		// Execute a query
		System.out.println("Inserting dummy records of university into the table...");

		University u1 = new University("IIT", "Illinois Institute of Technology", "Chicago",60616);
		University u2 = new University("UPM", "Universidad Politecnica de Madrid", "Madrid",28882);
		
		DaoModel.insertUniversity(u1);
		DaoModel.insertUniversity(u2);
		System.out.println("Insertion completed");
	}
	
		/**
	 * INSERT INTO METHOD for dummy initial records
	 */

	public void insertDummyRecordsCourseStudentsTable() {
		// Execute a query
		System.out.println("Inserting dummy records of courses and students into the table...");
		
		Student s1 = DaoModel.selectStudent("Fernandez");
		Student s2 = DaoModel.selectStudent("Alvarez");
		Student s3 = DaoModel.selectStudent("Jonnes");
		
		Course c1 = DaoModel.selectCourse("Database Security");
		Course c2 = DaoModel.selectCourse("Programacion Concurrente");

		DaoModel.insertCourseStudents(c1.getcID(),s1.getId());
		DaoModel.insertCourseStudents(c1.getcID(),s2.getId());
		DaoModel.insertCourseStudents(c2.getcID(),s2.getId());
		DaoModel.insertCourseStudents(c2.getcID(),s3.getId());
		System.out.println("Insertion completed");
	}
	/**
 * INSERT INTO METHOD for dummy initial records
 */

public void insertDummyRecordsCourses() {
	// Execute a query
	System.out.println("Inserting dummy records of courses into the table...");
	
	University u1 = DaoModel.selectUniversity("IIT");
	University u2 = DaoModel.selectUniversity("UPM");
	
	Professor p1 = DaoModel.selectProfessor(643);
	Professor p2 = DaoModel.selectProfessor(163);
	Professor p3 = DaoModel.selectProfessor(281);
	Professor p4 = DaoModel.selectProfessor(207);
	

	Course c1 = new Course("Database Security", 3, p1,u1);
	Course c2 = new Course("Programacion Concurrente", 6, p2,u2);
	Course c3 = new Course("Security Topics", 3, p1,u1);
	Course c4 = new Course("Inteligencia Artifical", 3, p4,u2);
	Course c5 = new Course("Vendor Management", 3, p3,u1);
	
	DaoModel.insertCourse(c1);
	DaoModel.insertCourse(c2);
	DaoModel.insertCourse(c3);
	DaoModel.insertCourse(c4);
	DaoModel.insertCourse(c5);
	System.out.println("Insertion completed");
}
}
