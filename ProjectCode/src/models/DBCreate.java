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
			insertDummyRecords();
	}
	
	/**
	 * INSERT INTO METHOD for dummy initial records
	 */
	public void insertDummyRecords() {
		// Execute a query
		System.out.println("Inserting dummy records into the table...");
		
		Student s1 = new Student("Pablo", "Fernandez", "pfernandezdiaz@hawk.iit.edu", "ITM");
		Student s2 = new Student("Pablo", "Alvarez", "paalvarezfernandez@hawk.iit.edu", "ITM");
		Student s3 = new Student("John", "Jonnes", "jjonnes20@hawk.iit.edu", "CFS");
		Student s4 = new Student("Sarah", "Hernandez", "shernandez8@hawk.iit.edu", "SAC");
		Student s5 = new Student("Luis", "Rajoy", "lrajoy@hawk.iit.edu", "MCS");
		
		DB.insertStudent(s1);
		DB.insertStudent(s2);
		DB.insertStudent(s3);
		DB.insertStudent(s4);
		DB.insertStudent(s5);
		System.out.println("Insertion correct");
	}
}
