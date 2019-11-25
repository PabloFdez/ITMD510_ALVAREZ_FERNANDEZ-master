package models;

import java.io.IOException;

import application.StartPage;
//import java.util.logging.Level;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ToolKitModel {
	String newPanel="";
	public void newWindow() {
		//application.Login.LOGGER.log(Level.INFO, PanelNuevo);
		AnchorPane root = null;
		try {
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/help/"+ newPanel));
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
		application.StartPage m = new StartPage();
		m.relaunch();
	}

	public void TKHelp() {
		//general help
		newPanel = "GeneralHelp.fxml";
		newWindow();
	}

	public void TKSpecificHelp() {
		if(controllers.LoginController.AClog.getMemberType()) {
			//help std
			newPanel = "StudentHelp.fxml";
			newWindow();
		} else {
			//help prof
			newPanel = "ProfessorHelp.fxml";
			newWindow();
		}
	}

	public void TKAboutUs() {
		newPanel = "AboutUs.fxml";
		newWindow();
	}
}
