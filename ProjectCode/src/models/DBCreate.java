package models;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.*;

public class DBCreate {
	DaoModel DB;
	
	DBCreate() {
		DB = DaoModel.DB;
		if(!checkcreation()) createTable();
	}
	
	/**
	 * @return if "p_alva_tab" table is there
	 */
	public boolean checkcreation(){
		boolean check = false;
		try{
			DatabaseMetaData dbm = DB.con.getMetaData();
			// check if "p_alva_tab" table is there
			System.out.println("Checking previous creation...");
			ResultSet looktable = dbm.getTables(null, null, "p_alva_p_fern_final", null);
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
			String sql = "CREATE TABLE students" + "(eID INTEGER not NULL AUTO_INCREMENT, "
			+" eFName VARCHAR(20), " + " eLName VARCHAR(30), " + " eEMail VARCHAR(30), " + " ePassword VARCHAR(30), " + " eMaj VARCHAR(30), " + " eGPA numeric(2,2), " + " PRIMARY KEY ( eID ));";
			
			String sql1 = "CREATE TABLE professors" + "(pID INTEGER not NULL AUTO_INCREMENT, "
			+" pFName VARCHAR(20), " + " pLName VARCHAR(30), " + " pEMail VARCHAR(30), " + " pPassword VARCHAR(30), " + " pDept VARCHAR(30), " + " pOffi INTEGER, " + " PRIMARY KEY ( pID ));";
			
			String sql2 = "CREATE TABLE universities" + "(uAcronym VARCHAR(10), " + " uName VARCHAR(30), " + " uCity VARCHAR(20), " + " uZipCode INTEGER, " + " PRIMARY KEY ( uAcronym ));";
			
			String sql3 = "CREATE TABLE courses" + "(cID INTEGER not NULL AUTO_INCREMENT, "
			+" cName VARCHAR(30), " + " cCredits INTEGER, " + " cProf INTEGER, " + " cUni VARCHAR(10), " + " PRIMARY KEY ( cID )"+
			"CONSTRAINT FK_ProfFOREIGN KEY (cProf) REFERENCES professors(pID),"+
			"CONSTRAINT FK_Uni FOREIGN KEY (cUni) REFERENCES universities(uID));";
			
			String sql4 = "CREATE TABLE courseStudents (cID INTGER not NULL, eID INTEGER not NULL ,CONSTRAINT PK_cS PRIMARY KEY (cID,eID),"+ 
			"CONSTRAINT FK_Courses FOREIGN KEY (cID) REFERENCES courses(cID),"+
			"CONSTRAINT FK_Students FOREIGN KEY (eID) REFERENCES students(eID));";
					
			
			DB.QueryResu(sql);
			DB.QueryResu(sql1);
			DB.QueryResu(sql2);
			DB.QueryResu(sql3);
			DB.QueryResu(sql4);
			
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
		String sql = "Update students SET ePassword = 'pass'  WHERE eEMail = 'pfernandezdiaz@hawk.iit.edu';";
		String sql2 = "Update students SET ePassword = 'pass'  WHERE eEMail = 'palvarezfernandez@hawk.iit.edu';";
		String sql3 = "Update students SET ePassword = 'pass'  WHERE eEMail = 'jjonnes20@hawk.iit.edu';";
		String sql4 = "Update students SET ePassword = 'pass'  WHERE eEMail = 'shernandez8@hawk.iit.edu';";
		String sql5 = "Update students SET ePassword = 'pass'  WHERE eEMail = 'lrajoy@hawk.iit.edu';";
						
		// Insert Students
		DB.insertStudent(s1);
		DB.insertStudent(s2);
		DB.insertStudent(s3);
		DB.insertStudent(s4);
		DB.insertStudent(s5);
		
		// Insert Passwords
		DB.QueryResu(sql);
		DB.QueryResu(sql2);
		DB.QueryResu(sql3);
		DB.QueryResu(sql4);
		DB.QueryResu(sql5);
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
		String sql = "Update students SET ePassword = 'pass'  WHERE eEMail = 'lpapademas@iit.edu';";
		String sql2 = "Update students SET ePassword = 'pass'  WHERE eEMail = 'jpapademas@iit.edu';";
		String sql3 = "Update students SET ePassword = 'pass'  WHERE eEMail = 'dmo@iit.edu';";
		String sql4 = "Update students SET ePassword = 'pass'  WHERE eEMail = 'rrao@iit.edu';";
		String sql5 = "Update students SET ePassword = 'pass'  WHERE eEMail = 'jhajek@iit.edu';";
		
		DB.insertProfessor(p1);
		DB.insertProfessor(p2);
		DB.insertProfessor(p3);
		DB.insertProfessor(p4);
		DB.insertProfessor(p5);
		
		// Insert Passwords
		DB.QueryResu(sql);
		DB.QueryResu(sql2);
		DB.QueryResu(sql3);
		DB.QueryResu(sql4);
		DB.QueryResu(sql5);
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
		
		DB.insertUniversity(u1);
		DB.insertUniversity(u2);
		System.out.println("Insertion completed");
	}
	
		/**
	 * INSERT INTO METHOD for dummy initial records
	 */

	public void insertDummyRecordsCourseStudentsTable() {
		// Execute a query
		System.out.println("Inserting dummy records of courses and students into the table...");
		
		Student s1 = DB.selectStudent("Fernandez");
		Student s2 = DB.selectStudent("Alvarez");
		Student s3 = DB.selectStudent("Jonnes");
		
		Course c1 = DB.selectCourse("Database Security");
		Course c2 = DB.selectCourse("Programacion Concurrente");

		DB.insertCourseStudents(c1.getcID(),s1.getId());
		DB.insertCourseStudents(c1.getcID(),s2.getId());
		DB.insertCourseStudents(c2.getcID(),s2.getId());
		DB.insertCourseStudents(c2.getcID(),s3.getId());
		System.out.println("Insertion completed");
	}
	/**
 * INSERT INTO METHOD for dummy initial records
 */

public void insertDummyRecordsCourses() {
	// Execute a query
	System.out.println("Inserting dummy records of courses into the table...");
	
	University u1 = DB.selectUniversity("IIT");
	University u2 = DB.selectUniversity("UPM");
	
	Professor p1 = DB.selectProfesor(643);
	Professor p2 = DB.selectProfesor(163);
	Professor p3 = DB.selectProfesor(281);
	Professor p4 = DB.selectProfesor(207);
	

	Course c1 = new Course("Database Security", 3, p1,u1);
	Course c2 = new Course("Programacion Concurrente", 6, p2,u2);
	Course c3 = new Course("Security Topics", 3, p1,u1);
	Course c4 = new Course("Inteligencia Artifical", 3, p4,u2);
	Course c5 = new Course("Vendor Management", 3, p3,u1);
	
	DB.insertCourse(c1);
	DB.insertCourse(c2);
	DB.insertCourse(c3);
	DB.insertCourse(c4);
	DB.insertCourse(c5);
	System.out.println("Insertion completed");
}
}
