package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Pablo Angel Alvarez Fernandez
 * @author Pablo Fernandez Diaz
 * DBConnect class
 * allow an object to connect / close a database connection
 */
public class DBConnect {
	public Connection connection;
	static final String url = "jdbc:mysql://www.papademas.net:3307/510labs?autoReconnect=true&useSSL=false";
	static final String username = "db510";
	static final String password = "510";
	
	DBConnect() {
		getConnection();
		new DBCreate();
	}
	
	private void getConnection(){	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		connection = DriverManager.getConnection(url,username,password);
    		System.out.println("Connection Successfull");
    	}
    	catch (ClassNotFoundException ex) {
    		Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE,null,ex);
    	}
    	catch (SQLException ex) {
    		Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE,null,ex);
    	}
    }
}