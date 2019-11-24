package login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.DaoModel;
import professor.IndexProfController;
import student.IndexStdController;

public class StartPage  extends Application {
	protected static Stage GeneralStage = null;

	@Override
	public void start(Stage primaryStage) {
		GeneralStage = primaryStage;
		try {
			DaoModel.createTables();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void relaunch() {
		start(GeneralStage);
	}

	public static void changeToStd() {
		IndexStdController StdWindow = new IndexStdController();
		StdWindow.start(GeneralStage);
	}
	
	public static void changeToProf() {
		IndexProfController ProfWindow = new IndexProfController();
		ProfWindow.start(GeneralStage);
	}
}