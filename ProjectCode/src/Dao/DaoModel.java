package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.*;
import models.AcademicMember;

/**
 * @author Pablo Angel Alvarez Fernandez
 * @author Pablo Fernandez Diaz
 * DaoModel class
 * Dao stands for Data Access Object, defines 
 * CRUD (Create Read Update Delete) like operations
 */
public class DaoModel {
	//static Connection con = null;
	//static DaoModel DB = null;
	//private boolean created = false;

	/**
	 * constructor
	 * @return 
	 */
	public DaoModel() { // create db object instance
		//if(!created) new DBCreate(); created = true;
	}

	public static void createTables(){

		//QueryUpd("ALTER TABLE papf_courseStudents ADD eGrade numeric(2,2);");

		/*ResultSet rs = null;
		rs = QueryResu("SELECT * FROM papf_courseStudents;");
		try {
			while(rs.next()){
				System.out.println(rs.getInt(1)+"   "+rs.getInt(2)+"   "+rs.getDouble(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		new DBCreate();
	}

	/**
	 * @param robjs (list of records)
	 * INSERT INTO METHOD
	 */
	public static void insertStudent(Student objs) {
		System.out.println("Inserting records into the table...");
		String sql = "INSERT INTO papf_students(eFName, eLName, eEMail, ePassword, eMaj, eGPA) " + 
				"VALUES ('"+objs.getFirstName()+"', '"+objs.getLastName()+"', '"+objs.getEmail()+"','', '"+objs.getMajor()+"', "+objs.getGpa()+")";
		if(QueryUpd(sql)){
			System.out.println("Element inserted.");
		}
	}

	/**
	 * @param robjs (list of records)
	 * INSERT INTO METHOD
	 */
	public static void insertProfessor(Professor objs) {
		System.out.println("Inserting records into the table...");
		String sql = "INSERT INTO papf_professors(pFName, pLName, pEMail,pPassword, pDept, pOffi) " + 
				"VALUES ('"+objs.getFirstName()+"', '"+objs.getLastName()+"', '"+objs.getEmail()+"','', '"+objs.getDept()+"', "+objs.getOfficeNo()+")";
		if(QueryUpd(sql)){
			System.out.println("Element inserted.");
		}
	}

	/**
	 * @param robjs (list of records)
	 * INSERT INTO METHOD
	 */
	public static void insertUniversity(University objs) {
		System.out.println("Inserting records into the table...");
		String sql = "INSERT INTO papf_universities( uAcronym, uName, uCity, uZipCode) " + 
				"VALUES ('"+objs.getUniAcronym()+"','"+objs.getUniName()+"','"+objs.getUniCity()+"',"+objs.getUniZipCode()+");";
		if(QueryUpd(sql)){
			System.out.println("Element inserted.");
		}
	}

	/**
	 * @param robjs (list of records)
	 * INSERT INTO METHOD
	 */
	public static void insertCourse(Course objs) {
		System.out.println("Inserting records into the table...");
		String sql = "INSERT INTO papf_courses(cName, cCredits, cProf, cUni)"+ 
				"VALUES ('"+objs.getcName()+"', "+objs.getnCredits()+", "+objs.getProf().getId()+", '"+objs.getUni().getUniAcronym()+"')";
		if(QueryUpd(sql)){
			System.out.println("Element inserted.");
		}
	}	

	/**
	 * @param eGrade 
	 * @param robjs (list of records)
	 * INSERT INTO METHOD
	 */
	public static void insertCourseStudents(int cID, int eID, double eGrade) {
		System.out.println("Inserting records into the table...");
		String sql = "INSERT INTO papf_courseStudents(cID, eID, eGrade) VALUES ("+cID+", "+eID+","+eGrade+")";
		if(QueryUpd(sql)){
			System.out.println("Element inserted.");
		}
	}	


	public static University selectUniversity(String nombreUni) {
		ResultSet rs = null;
		String sql = "SELECT * FROM papf_universities WHERE uAcronym = '"+nombreUni+"';";
		rs = QueryResu(sql);
		try {
			if(rs.next()){
				return new University(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}

	public static Professor selectProfessor(int offN) {
		ResultSet rs = null;
		String sql = "SELECT * FROM papf_professors WHERE pOffi = "+offN+";";
		rs = QueryResu(sql);		
		try {
			if(rs.next()){
				return new Professor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}

	public static Professor selectProfessor2(int pID) {
		ResultSet rs = null;
		String sql = "SELECT * FROM papf_professors WHERE pID = "+pID+";";
		rs = QueryResu(sql);
		try {
			if(rs.next()){
				return new Professor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getInt(7));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}

	public static Student selectStudent(String lName) {
		ResultSet rs = null;
		String sql = "SELECT * FROM papf_students WHERE eLName = '"+lName+"';";
		rs = QueryResu(sql);
		try {
			if(rs.next()){
				return new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(6));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}

	public static Course selectCourse(String cName) {
		ResultSet rs = null;
		String sql = "SELECT * FROM papf_courses WHERE cName = '"+cName+"';";
		rs = QueryResu(sql);
		try {
			if(rs.next()){
				return new Course(rs.getInt(1),rs.getString(2),rs.getInt(3),selectProfessor2(rs.getInt(4)),selectUniversity(rs.getString(5))); // Sacar los estudiantes del curso				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}

	public static String selectCourseName(int id) {
		ResultSet rs = null;
		String sql = "SELECT cName FROM papf_courses WHERE cID = '"+id+"';";
		rs = QueryResu(sql);
		try {
			if(rs.next()){
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Seleccionamos los Profesores que imparten un curso determinado
	public static String[][] selectCoursesTeachProfessor(int cProf) {	
		ResultSet rs = null;
		String sql = "SELECT cID, cName FROM papf_courses WHERE cProf = "+cProf+";";
		rs = QueryResu(sql);
		String[][] cursos = new String[100][2];
		int aux = 0;
		try {
			while(rs.next()){

				cursos[aux][0] = Integer.toString(rs.getInt(1));
				cursos[aux][1] = rs.getString(2);

				aux++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cursos;				
	}
	
	public static String selectStudentsNameOfCourse(int eID) {	
		ResultSet rs = null;
		String sql = "SELECT eFName, eLName FROM papf_students WHERE eID = "+eID+";";
		rs = QueryResu(sql);
		
		//String[] studentsName = new String[100];
		String studentsName="";
		
		//int aux = 0;
		try {

			while(rs.next()){
				//studentsName[aux] = rs.getString(1) +" "+ rs.getString(2);
				studentsName = rs.getString(1) +" "+ rs.getString(2);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentsName;	
	}

	public static String[] selectStudentsOfCourse(int cID) {	
		ResultSet rs = null;
		String sql = "SELECT eID FROM papf_courseStudents WHERE cID = "+cID+";";
		rs = QueryResu(sql);
		
		String[] students = new String[100];
		
		int aux = 0;
		try {
			while(rs.next()){
				students[aux] = Integer.toString(rs.getInt(1));
				aux++;
			}				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;				
	}
	
	/**
	 * @return record retrieved
	 * retrieveRecords
	 */
	public ResultSet retrieveStudentInfo() {//always close out of your connections 
		System.out.println("Retrieving Records...");
		String sql = "SELECT * FROM papf_students";
		System.out.println("Records are now retrieved");

		return QueryResu(sql);
	}

	/**
	 * @return record retrieved
	 * retrieveRecords
	 */
	public ResultSet retrieveProfessorInfo() {//always close out of your connections 
		System.out.println("Retrieving Records...");
		String sql = "SELECT * FROM papf_professors";
		System.out.println("Records are now retrieved");

		return QueryResu(sql);
	}

	/**
	 * @return record retrieved
	 * retrieveRecords
	 */
	public ResultSet retrieveUniversityInfo() {//always close out of your connections 
		System.out.println("Retrieving Records...");
		String sql = "SELECT * FROM papf_universities";
		System.out.println("Records are now retrieved");

		return QueryResu(sql);
	}

	/**
	 * @return record retrieved
	 * retrieveRecords
	 */
	public ResultSet retrieveCourseInfo() {//always close out of your connections 
		System.out.println("Retrieving Records...");
		String sql = "SELECT * FROM papf_courses";
		System.out.println("Records are now retrieved");

		return QueryResu(sql);
	}

	/**
	 * @return record retrieved
	 * retrieveRecords
	 */
	public ResultSet retrieveCourseStudentInfo() {//always close out of your connections 
		System.out.println("Retrieving Records...");
		String sql = "SELECT * FROM papf_courseStudents";
		System.out.println("Records are now retrieved");

		return QueryResu(sql);
	}

	public static void updateStudent(int id, String fName, String lName, String major) {
		String sql = "UPDATE papf_students SET eFName='"+fName+"', eLName='"+lName+"', eMaj='"+major+"' WHERE eID="+id+";";
		QueryUpd(sql);
	}

	public static void updateProfessor(int id, String fName, String lName, String department, int office) {
		String sql = "UPDATE papf_professors SET pFName='"+fName+"', pLName='"+lName+"', pDept='"+department+"', pOffi="+office+" WHERE pID="+id+";";
		QueryUpd(sql);
	}

	public static void updateCourseStudentGrade(int cID, int eID, double eGrade) {
		String sql = "UPDATE papf_courseStudents SET eGrade="+Double.toString(eGrade)+" WHERE eID="+eID+" AND cID="+cID+";";
		QueryUpd(sql);
	}

	public static ResultSet getStudentGrades(int id){
		String sql = "SELECT cID, eGrade FROM papf_courseStudents WHERE eID = "+id+";";
		return QueryResu(sql);
	}

	public static ResultSet QueryResu(String sentencia) {
		// querys que devuelven resultados
		Connection con = DBConnect.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sentencia);
			// con.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean QueryUpd(String sentencia) {
		// querys que no devuelven resultados
		Connection con = DBConnect.getConnection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sentencia);
			stmt.close();
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public AcademicMember login(String user, String pass) {
		// TODO
		ResultSet rs = null;
		AcademicMember AMaux = null;

		rs = QueryResu("SELECT * FROM papf_students WHERE eEMail = '"+user+"' AND ePassword ='"+ pass +"';");
		try {
			if(rs.next()){
				AMaux = new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6));	
				AMaux.setEmail(AMaux.getEmail().substring(0,AMaux.getEmail().length()-13));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(AMaux == null){
			rs = QueryResu("SELECT * FROM papf_professors WHERE pEMail = '"+user+"' AND pPassword ='"+ pass +"';");
			try {
				if(rs.next()){
					AMaux = new Professor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getInt(7));
					AMaux.setEmail(AMaux.getEmail().substring(0,AMaux.getEmail().length()-8));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return AMaux; 
	}
}
