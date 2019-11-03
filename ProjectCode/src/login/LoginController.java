package login;

import javafx.fxml.FXML;
import javafx.scene.control.*;

/** Controls the login screen */
public class LoginController {

	@FXML private TextField user;
	@FXML private TextField password;
	@FXML private Button loginButton;

	// public void initialize() {}

	public void initManager() {
		String sessionID = authorize();
		if (sessionID != null) 
			authenticated(sessionID);
	}

	/**
	 * Check authorization credentials.
	 * 
	 * If accepted, return a sessionID for the authorized session
	 * otherwise, return null.
	 */   
	private String authorize() {
		return "open".equals(user.getText()) && "sesame".equals(password.getText()) 
				? generateSessionID() 
						: null;
	}

	private static int sessionID = 0;

	private String generateSessionID() {
		sessionID++;
		return "finalProj - session " + sessionID;
	}

	/**
	 * Callback method invoked to notify that a user has been authenticated. Will
	 * show the main application screen.
	 */
	public void authenticated(String sessionID) {
		System.out.println(sessionID);
		//showMainView(sessionID);
	}

	/**
	 * Callback method invoked to notify that a user has logged out of the main
	 * application. Will show the login application screen.
	 */
	public void logout() {
		StartPage.launch();
	}
}
