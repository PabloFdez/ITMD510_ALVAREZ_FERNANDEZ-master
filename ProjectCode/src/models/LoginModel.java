package models;

public class LoginModel {
	/**
	 * Check authorization credentials.
	 * 
	 * If accepted, return a sessionID for the authorized session
	 * otherwise, return null.
	 */ 
	public static AcademicMember authorize(String user, String pass) {
		return new DaoModel().login(user,pass);
	}
}
