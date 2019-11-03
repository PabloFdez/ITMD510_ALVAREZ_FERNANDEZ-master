package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnect {
	Connection connection;
	String url = "jdbc:mysql://www.papademas.net:3307/510labs?autoReconnect=true&useSSL=false";
	String username = "db510";
	String password = "510";
	
	DBConnect() {
		getConnection();
	}
	
	private void getConnection(){	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		connection = DriverManager.getConnection(url,username,password);
    		// USER = "db510" PASS = "510";
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