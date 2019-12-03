package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.DataModel;
import Dao.DaoModel;
import controllers.IndexAdminController;
import controllers.IndexProfController;
import controllers.IndexStdController;

/**
 * @author Pablo Angel Alvarez Fernandez
 * @author Pablo Fernandez Diaz
 * StartPage class
 * Defines the aplication start and redirects to user sites
 */
public class StartPage  extends Application {
	protected static Stage GeneralStage = null;

	@Override
	public void start(Stage primaryStage) {
		GeneralStage = primaryStage;
		try {
			DaoModel.createTables();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/views/login/Login.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Login Site");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			DataModel.sendAlert("start error", "Sending automatic report");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void relaunch() {
		start(GeneralStage);
	}

	/**
	 * redirects to student site
	 */
	public static void changeToStd() {
		IndexStdController StdWindow = new IndexStdController();
		StdWindow.start(GeneralStage);
	}
	
	/**
	 * redirects to professor site
	 */
	public static void changeToProf() {
		IndexProfController ProfWindow = new IndexProfController();
		ProfWindow.start(GeneralStage);
	}

	/**
	 * redirects to admin site
	 */
	public static void changeToAdmin() {
		IndexAdminController AdmWindow = new IndexAdminController();
		AdmWindow.start(GeneralStage);
	}
}