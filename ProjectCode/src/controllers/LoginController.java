package controllers;

import application.StartPage;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.AcademicMember;
import models.LoginModel;
import models.ToolKitModel;

/** Controls the login screen */
public class LoginController {
	@FXML private TextField user;
	@FXML private TextField password;
	public static AcademicMember AClog = null;

	public void initManager() {
		AClog = LoginModel.authorize(user.getText(),password.getText());
		if (AClog != null){
			authenticated();			
		}
	}

	/**
	 * Callback method invoked to notify that a user has been authenticated. Will
	 * show the main application screen.
	 */
	public void authenticated() {
		// debug proposes
		AClog.getMemberInfo();
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
		new ToolKitModel().TKHelp();
	}
}