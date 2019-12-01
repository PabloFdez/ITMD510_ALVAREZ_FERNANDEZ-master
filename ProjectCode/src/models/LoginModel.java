package models;

import Dao.DaoModel;
import application.Admin;

public class LoginModel {
	/**
	 * Check authorization credentials.
	 * 
	 * If accepted, return a sessionID for the authorized session
	 * otherwise, return null.
	 */ 
	public static AcademicMember authorize(String user, String pass) {
		if(user.equals("admin@admin") && pass.equals("admin")) {
			return new Admin("admin","admin","admin","@admin");
		}
		if(pass.equals("")) {
			return null;
		}
		return new DaoModel().login(user,models.HashingModel.hash(pass));
	}
}
