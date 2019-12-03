package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.DataModel;

/**
 * @author Pablo Angel Alvarez Fernandez
 * @author Pablo Fernandez Diaz
 * DBConnect class
 * allow an object to connect / close a database connection
 */
public class DBConnect {
	static final String url = "jdbc:mysql://www.papademas.net:3307/510fp?autoReconnect=true&useSSL=false";
	static final String username = "fp510";
	static final String password = "510";
	
	DBConnect() {
		getConnection();
	}
	
	public static Connection getConnection(){	
		Connection connection = null;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		connection = DriverManager.getConnection(url,username,password);
    		//System.out.println("Connection Successfull");
    	}
    	catch (ClassNotFoundException ex) {
    		Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE,null,ex);
			DataModel.sendAlert("conection to DB error", "Sending automatic report");
    	}
    	catch (SQLException ex) {
    		Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE,null,ex);
			DataModel.sendAlert("conection to DB error", "Sending automatic report");
    	}
		return connection;
    }
}