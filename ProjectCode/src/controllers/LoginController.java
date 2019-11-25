package controllers;

import application.StartPage;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.AcademicMember;
import models.DaoModel;
import models.ToolKit;

/** Controls the login screen */
public class LoginController {

	@FXML private TextField user;
	@FXML private TextField password;
	public static AcademicMember AClog = null;
	public DaoModel DB;

	// public void initialize() {}

	public void initManager() {
		DB = new DaoModel();
		AClog = authorize();
		if (AClog != null){
			authenticated();			
		}
	}

	/**
	 * Check authorization credentials.
	 * 
	 * If accepted, return a sessionID for the authorized session
	 * otherwise, return null.
	 */ 
	// offline option
	/*private String authorize() {
		return "open".equals(user.getText()) && "sesame".equals(password.getText()) 
				? generateSessionID() 
						: null;
	}*/
	
	private AcademicMember authorize() {
		return DB.login(user.getText(),password.getText());
	}

	/**
	 * Callback method invoked to notify that a user has been authenticated. Will
	 * show the main application screen.
	 */
	public void authenticated() {
		System.out.println("User " + AClog.getFirstName() + " has been registered, proproceding to user page.");
		//showMainView(sessionID);
		if(AClog.getMemberType()){
			System.out.println("go to student page");
			StartPage.changeToStd();
		} else {
			System.out.println("go to prof page");
			StartPage.changeToProf();
		}
	}
	
	public void initRegManager() {
		StartPage.launch();
	}
	
	public void initHelp() {
		new ToolKit().TKHelp();
	}

	/**
	 * Callback method invoked to notify that a user has logged out of the main
	 * application. Will show the login application screen.
	 */
	public void logout() {
		StartPage.launch();
	}
}