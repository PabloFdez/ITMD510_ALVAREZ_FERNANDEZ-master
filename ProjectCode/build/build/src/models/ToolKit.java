package models;

import java.io.IOException;
//import java.util.logging.Level;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import login.StartPage;

public class ToolKit {	
	public void newWindow(String newPanel) {
		//application.Login.LOGGER.log(Level.INFO, PanelNuevo);
		AnchorPane root = null;
		try {
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("/help/"+ newPanel));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Stage secondaryStage = new Stage();
		Scene scene = new Scene(root);
		secondaryStage.setResizable(false);
		secondaryStage.setTitle(newPanel.substring(0, newPanel.length()-5));
		secondaryStage.setScene(scene);
		secondaryStage.show();
	}

	public static void TKClose() {
		//close program
		javafx.application.Platform.exit();
		System.exit(0);
	}

	public static void TKSession() {
		//close session
		login.StartPage m = new StartPage();
		m.relaunch();
	}

	public void TKHelp() {
		//general help
		newWindow("GeneralHelp.fxml");
	}

	public void TKSpecificHelp() {
		if(login.LoginController.AClog.getMemberType()) {
			//help prof
			newWindow("ProfessorHelp.fxml");
		} else {
			//help std
			newWindow("StudentHelp.fxml");
		}
	}

	public void TKAboutUs() {
		newWindow("AboutUs.fxml");
	}
}