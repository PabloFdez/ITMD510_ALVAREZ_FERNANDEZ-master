package models;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Student;

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
			String sql = "";//CREATE TABLE p_alva_tab" + "(pid INTEGER not NULL AUTO_INCREMENT, "
			// +" id VARCHAR(10), " + " income numeric(8,2), " + " pep VARCHAR(3), " + " PRIMARY KEY ( pid ))";
			DB.QueryResu(sql);
			// Inserting students on the data base
			insertDummyRecordsStudents();
			// Inserting professors on the data base
			insertDummyRecordsProfessors();
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

		Professor p1 = new Professor(null);
		Professor p2 = new Professor(null);
		Professor p3 = new Professor(null);
		Professor p4 = new Professor(null);
		Professor p5 = new Professor(null);
		
		DB.insertProfessor(p1);
		DB.insertProfessor(p2);
		DB.insertProfessor(p3);
		DB.insertProfessor(p4);
		DB.insertProfessor(p5);
		System.out.println("Insertion completed");
	}
}
