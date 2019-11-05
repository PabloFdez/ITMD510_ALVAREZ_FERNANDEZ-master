package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.Professor;
import application.Student;

/**
 * @author Pablo Angel Alvarez Fernandez
 * @author Pablo Fernandez Diaz
 * DaoModel class
 * Dao stands for Data Access Object, defines 
 * CRUD (Create Read Update Delete) like operations
 */
public class DaoModel {
	Connection con = null;
	static DaoModel DB = null;

	/**
	 * constructor
	 * @return 
	 */
	public DaoModel() { // create db object instance
		if (DB == null) {
			DB = new DaoModel();
			con = new DBConnect().connection;
		}
	}
		
	/**
	 * @param robjs (list of records)
	 * INSERT INTO METHOD
	 */
	public void insertStudent(Student objs) {
		try {
			// Execute a query
			System.out.println("Inserting records into the table...");
			Statement stmt = DB.con.createStatement();
			String sql = null;
					  
			// Include all object data to the database table
			sql = "INSERT INTO students(id,income,pep) " + 
				"VALUES ('"+objs.getFirstName()+"', '"+objs.getLastName()+"', '"+objs.getLastName()+"')";
			stmt.executeUpdate(sql);
			System.out.println("Insertion correct");
			DB.con.close();
		} catch (SQLException se) { se.printStackTrace();  }
	}
	
	/**
	 * @param robjs (list of records)
	 * INSERT INTO METHOD
	 */
	public void insertProfessor(Professor objs) {
		try {
			// Execute a query
			System.out.println("Inserting records into the table...");
			Statement stmt = DB.con.createStatement();
			String sql = null;
					  
			// Include all object data to the database table
			sql = "INSERT INTO professors(id,income,pep) " + 
				"VALUES ('"+objs.getFirstName()+"', '"+objs.getLastName()+"', '"+objs.getLastName()+"')";
				stmt.executeUpdate(sql);
			System.out.println("Insertion correct");
			DB.con.close();
		} catch (SQLException se) { se.printStackTrace();  }
	}
	
	/**
	 * @param robjs (list of records)
	 * INSERT INTO METHOD
	 */
	public void insertUniversity(Univeristy objs) {
		try {
			// Execute a query
			System.out.println("Inserting records into the table...");
			Statement stmt = DB.con.createStatement();
			String sql = null;
					  
			// Include all object data to the database table
			sql = "INSERT INTO university(id,income,pep) " + 
				"VALUES ('"+objs.getFirstName()+"', '"+objs.getLastName()+"', '"+objs.getLastName()+"')";
				stmt.executeUpdate(sql);
			System.out.println("Insertion correct");
			DB.con.close();
		} catch (SQLException se) { se.printStackTrace();  }
	}
	
	/**
	 * @param robjs (list of records)
	 * INSERT INTO METHOD
	 */
	public void insertCourse(Course objs) {
		try {
			// Execute a query
			System.out.println("Inserting records into the table...");
			Statement stmt = DB.con.createStatement();
			String sql = null;
					  
			// Include all object data to the database table
			sql = "INSERT INTO courses(id,income,pep) " + 
				"VALUES ('"+objs.getFirstName()+"', '"+objs.getLastName()+"', '"+objs.getLastName()+"')";
				stmt.executeUpdate(sql);
			System.out.println("Insertion correct");
			DB.con.close();
		} catch (SQLException se) { se.printStackTrace();  }
	}	

	/**
	 * @return record retrieved
	 * retrieveRecords
	 */
	public ResultSet retrieveStudentInfo() {//always close out of your connections 
		 ResultSet rs = null;
		 try {
			Statement stmt = DB.con.createStatement();
			System.out.println("Retrieving Records...");
			String sql = "";//select pid, id,income, pep from p_alva_tab order by pep desc, income desc";
			System.out.println("Records are now retrieved");
			
			rs = stmt.executeQuery(sql);
			DB.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return rs;
	}
	
	/**
	 * @return record retrieved
	 * retrieveRecords
	 */
	public ResultSet retrieveProfessorInfo() {//always close out of your connections 
		 ResultSet rs = null;
		 try {
			Statement stmt = DB.con.createStatement();
			System.out.println("Retrieving Records...");
			String sql = "";//select pid, id,income, pep from p_alva_tab order by pep desc, income desc";
			System.out.println("Records are now retrieved");
			
			rs = stmt.executeQuery(sql);
			DB.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return rs;
	}
	
	/**
	 * @return record retrieved
	 * retrieveRecords
	 */
	public ResultSet retrieveUniversityInfo() {//always close out of your connections 
		 ResultSet rs = null;
		 try {
			Statement stmt = DB.con.createStatement();
			System.out.println("Retrieving Records...");
			String sql = "";//select pid, id,income, pep from p_alva_tab order by pep desc, income desc";
			System.out.println("Records are now retrieved");
			
			rs = stmt.executeQuery(sql);
			DB.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return rs;
	}
	
	/**
	 * @return record retrieved
	 * retrieveRecords
	 */
	public ResultSet retrieveCourseInfo() {//always close out of your connections 
		 ResultSet rs = null;
		 try {
			Statement stmt = DB.con.createStatement();
			System.out.println("Retrieving Records...");
			String sql = "";//select pid, id,income, pep from p_alva_tab order by pep desc, income desc";
			System.out.println("Records are now retrieved");
			
			rs = stmt.executeQuery(sql);
			DB.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return rs;
	}
	
	public ResultSet QueryResu(String sentencia) {
		// querys que devuelven resultados
		try {
			Statement stmt = DB.con.createStatement();
			ResultSet result = stmt.executeQuery(sentencia);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean QueryUpd(String sentencia) {
		// querys que no devuelven resultados
		try {
			Statement stmt = DB.con.createStatement();
			stmt.executeUpdate(sentencia);
			stmt.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
