package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.*;

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
			sql = "INSERT INTO students(eFName, eLName, eEMail, eMaj, eGPA) " + 
				"VALUES ('"+objs.getFirstName()+"', '"+objs.getLastName()+"', '"+objs.getEmail()+"', '"+objs.getMajor()+"', "+objs.getGpa()+")";
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
			sql = "INSERT INTO professors(pFName, pLName, pEMail, pDept, pOffi) " + 
				"VALUES ('"+objs.getFirstName()+"', '"+objs.getLastName()+"', '"+objs.getEmail()+"', '"+objs.getEmail()+"', '"+objs.getDept()+"', "+objs.getOfficeNo()+")";
				stmt.executeUpdate(sql);
			System.out.println("Insertion correct");
			DB.con.close();
		} catch (SQLException se) { se.printStackTrace();  }
	}
	
	/**
	 * @param robjs (list of records)
	 * INSERT INTO METHOD
	 */
	public void insertUniversity(University objs) {
		try {
			// Execute a query
			System.out.println("Inserting records into the table...");
			Statement stmt = DB.con.createStatement();
			String sql = null;
					  
			// Include all object data to the database table
			sql = "INSERT INTO universities( uAcronym, uName, uCity, uZipCode) " + 
				"VALUES ('"+objs.getUniAcronym()+"','"+objs.getUniName()+"','"+objs.getUniCity()+"',"+objs.getUniZipCode()+",)";
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
			sql = "INSERT INTO courses(cName, cCredits, cProf, cUni)"+ 
				"VALUES ('"+objs.getcName()+"', "+objs.getnCredits()+", "+objs.getProf().getId()+", '"+objs.getUni().getUniAcronym()+"')";
				stmt.executeUpdate(sql);
			System.out.println("Insertion correct");
			DB.con.close();
		} catch (SQLException se) { se.printStackTrace();  }
	}	

	/**
	 * @param robjs (list of records)
	 * INSERT INTO METHOD
	 */
	public void insertCourseStudents(int cID, int eID) {
		try {
			// Execute a query
			System.out.println("Inserting records into the table...");
			Statement stmt = DB.con.createStatement();
			String sql = null;
					  
			// Include all object data to the database table
			sql = "INSERT INTO courseStudents(cID, eID)"+ 
				"VALUES ("+cID+", "+eID+")";
				stmt.executeUpdate(sql);
			System.out.println("Insertion correct");
			DB.con.close();
		} catch (SQLException se) { se.printStackTrace();  }
	}	

	
	public University selectUniversity(String nombreUni) {
		 ResultSet rs = null;
		 University uAux = null;
		try {
			// Execute a query
			Statement stmt = DB.con.createStatement();
			String sql = null;
					  
			// Include all object data to the database table
			sql = "SELECT * FROM universities WHERE uAcronym = "+nombreUni+";";
			rs = stmt.executeQuery(sql);
			DB.con.close();
		} catch (SQLException se) { se.printStackTrace();  }
		 try {
			rs.next();
			uAux = new University(rs.getString(0),rs.getString(1),rs.getString(2),rs.getInt(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return uAux; 
	}
	
	public Professor selectProfesor(int offN) {
		 ResultSet rs = null;
		 Professor pAux = null;
		try {
			// Execute a query
			Statement stmt = DB.con.createStatement();
			String sql = null;
					  
			// Include all object data to the database table
			sql = "SELECT * FROM professors WHERE pOffi = "+offN+";";
			rs = stmt.executeQuery(sql);
			DB.con.close();
		} catch (SQLException se) { se.printStackTrace();  }
		 try {
			rs.next();
			pAux = new Professor(rs.getString(0),rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return pAux; 
	}
	
	public Professor selectProfesor2(int pID) {
		 ResultSet rs = null;
		 Professor pAux = null;
		try {
			// Execute a query
			Statement stmt = DB.con.createStatement();
			String sql = null;
					  
			// Include all object data to the database table
			sql = "SELECT * FROM professors WHERE pID = "+pID+";";
			rs = stmt.executeQuery(sql);
			DB.con.close();
		} catch (SQLException se) { se.printStackTrace();  }
		 try {
			rs.next();
			pAux = new Professor(rs.getString(0),rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return pAux; 
	}
	
	public Student selectStudent(String lName) {
		 ResultSet rs = null;
		 Student sAux = null;
		try {
			// Execute a query
			Statement stmt = DB.con.createStatement();
			String sql = null;
					  
			// Include all object data to the database table
			sql = "SELECT * FROM students WHERE eLName = "+lName+";";
			rs = stmt.executeQuery(sql);
			DB.con.close();
		} catch (SQLException se) { se.printStackTrace();  }
		 try {
			rs.next();
			sAux = new Student(rs.getString(0),rs.getString(1),rs.getString(2),rs.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return sAux; 
	}
	
	public Course selectCourse(String cName) {
		 ResultSet rs = null;
		 Course cAux = null;
		try {
			// Execute a query
			Statement stmt = DB.con.createStatement();
			String sql = null;
					  
			// Include all object data to the database table
			sql = "SELECT * FROM courses WHERE eLName = "+cName+";";
			rs = stmt.executeQuery(sql);
			DB.con.close();
		} catch (SQLException se) { se.printStackTrace();  }
		 try {
			rs.next();
			cAux = new Course(rs.getString(0),rs.getInt(1),selectProfesor2(rs.getInt(2)),selectUniversity(rs.getString(3))); // Sacar los estudiantes del curso
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return cAux; 
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
			String sql = "SELECT * FROM students";
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
			String sql = "SELECT * FROM professors";
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
			String sql = "SELECT * FROM universities";
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
			String sql = "SELECT * FROM courses";
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
	public ResultSet retrieveCourseStudentInfo() {//always close out of your connections 
		 ResultSet rs = null;
		 try {
			Statement stmt = DB.con.createStatement();
			System.out.println("Retrieving Records...");
			String sql = "SELECT * FROM courseStudents";
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
