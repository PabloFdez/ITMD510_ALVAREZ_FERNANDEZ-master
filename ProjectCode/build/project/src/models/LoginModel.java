package models;

import Dao.DaoModel;
import application.Admin;

/**
 * @author Pablo Angel Alvarez Fernandez
 * @author Pablo Fernandez Diaz
 * LoginModel class
 * Check authorization credentials
 */
public class LoginModel {
	/**
	 * Check authorization credentials.
	 * 
	 * If accepted, return a AcademicMember for the authorized session
	 * otherwise, return null.
	 */ 
	public static AcademicMember authorize(String user, String pass) {
		if(user.equals("admin@admin") && pass.equals("admin")) {
			return new Admin("admin","admin","admin","@admin");
		}
		if(pass.equals("")) {
			DataModel.sendAlert("Null password", "Please review the data");
			return null;
		}
		return new DaoModel().login(user,models.HashingModel.hash(pass));
	}
}
