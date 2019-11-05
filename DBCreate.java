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
	 * Create the table p_alva_p_fern_final
	 */
	public void createTable() {
			String sql = "CREATE TABLE students" + "(id INTEGER not NULL AUTO_INCREMENT, "
			+" eFName VARCHAR(20), " + " eLName VARCHAR(30), " + " eEMail VARCHAR(30), " + " eMaj VARCHAR(30), " + " eGPA numeric(2,2), " + " PRIMARY KEY ( id ));";
			
			String sql1 = "CREATE TABLE professors" + "(id INTEGER not NULL AUTO_INCREMENT, "
			+" pFName VARCHAR(20), " + " pLName VARCHAR(30), " + " pEMail VARCHAR(30), " + " pDept VARCHAR(30), " + " pOffi INTEGER, " + " PRIMARY KEY ( id ));";
			
			String sql2 = "CREATE TABLE university" + "(uniID INTEGER not NULL AUTO_INCREMENT, "
			+" uniAcronym VARCHAR(10), " + " uniName VARCHAR(30), " + " uniCity VARCHAR(20), " + " uniZipCode INTEGER, " + " PRIMARY KEY ( uniID ));";
			
			String sql3 = "CREATE TABLE courses" + "(id INTEGER not NULL AUTO_INCREMENT, "
			+" eFName VARCHAR(20), " + " eGPA numeric(2,2), " + " eLName VARCHAR(30), " + " eEMail VARCHAR(30), " + " PRIMARY KEY ( id ));";
			
			DB.QueryResu(sql);
			DB.QueryResu(sql1);
			DB.QueryResu(sql2);
			DB.QueryResu(sql3);
			
			// Inserting students on the data base
			insertDummyRecordsStudents();
			// Inserting professors on the data base
			insertDummyRecordsProfessors();
			// Inserting universities on the data base
			insertDummyRecordsUniversity();
			// Inserting courses on the data base
			insertDummyRecordsCourses();
		
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
		
		DB.insertStudent(s1);
		DB.insertStudent(s2);
		DB.insertStudent(s3);
		DB.insertStudent(s4);
		DB.insertStudent(s5);
		System.out.println("Insertion completed");
	}
	
	/**
	 * INSERT INTO METHOD for dummy initial records
	 */
	public void insertDummyRecordsProfessors() {
		// Execute a query
		System.out.println("Inserting dummy records of professors into the table...");

		Professor p1 = new Professor("Luke", "Papademas", "lpapademas","ITM",342);
		Professor p2 = new Professor("James", "Papademas", "lpapademas","ITM",163);
		Professor p3 = new Professor("Dr", "Mo", "dmo","ITM",643);
		Professor p4 = new Professor("Ramesh", "Rao", "rrao","ITM",281);
		Professor p5 = new Professor("Jeremy", "Hajek", "jhajek","ITM",207);
		
		DB.insertProfessor(p1);
		DB.insertProfessor(p2);
		DB.insertProfessor(p3);
		DB.insertProfessor(p4);
		DB.insertProfessor(p5);
		System.out.println("Insertion completed");
	}
	
	/**
	 * INSERT INTO METHOD for dummy initial records
	 */
	public void insertDummyRecordsUniversity() {
		// Execute a query
		System.out.println("Inserting dummy records of university into the table...");

		University u1 = new University("IIT", "Illinois Institute of Technology", "Chicago","60616");
		University u2 = new University("UPM", "Universidad Politecnica de Madrid", "Madrid","28882");
		
		DB.insertUniversity(u1);
		DB.insertUniversity(u2);
		System.out.println("Insertion completed");
	}
	
		/**
	 * INSERT INTO METHOD for dummy initial records
	 */
	@SuppressWarnings("unused")
	public void insertDummyRecordsCourses() {
		// Execute a query
		System.out.println("Inserting dummy records of courses into the table...");
		
		Professor p1 = new Professor("Luke", "Papademas", "lpapademas","ITM",342);
		Professor p2 = new Professor("James", "Papademas", "lpapademas","ITM",163);
		Professor p3 = new Professor("Dr", "Mo", "dmo","ITM",643);
		Professor p4 = new Professor("Ramesh", "Rao", "rrao","ITM",281);
		Professor p5 = new Professor("Jeremy", "Hajek", "jhajek","ITM",207);
		
		University u1 = new University(100, "IIT", "Illinois Institute of Technology", "Chicago","60616");
		University u2 = new University(200, "UPM", "Universidad Politecnica de Madrid", "Madrid","28882");

		Course c1 = new Course("Database Security", 101, 3, p3,u1);
		Course c2 = new Course("Programacion Concurrente", 201, 6, p2,u2);
		Course c3 = new Course("Security Topics", 102, 3, p3,u1);
		Course c4 = new Course("Inteligencia Artifical", 202, 3, p5,u2);
		Course c5 = new Course("Vendor Management", 103, 3, p4,u1);
		
		DB.insertCourse(c1);
		DB.insertCourse(c2);
		DB.insertCourse(c3);
		DB.insertCourse(c4);
		DB.insertCourse(c5);
		System.out.println("Insertion completed");
	}
}
