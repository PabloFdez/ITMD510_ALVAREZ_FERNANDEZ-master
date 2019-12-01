package controllers;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.ToolKitModel;

/**
 * @author Pablo Angel Alvarez Fernandez
 * @author Pablo Fernandez Diaz
 * IndexStdController class
 * Iniciates the student page
 */
public class IndexStdController extends Application {
	@FXML
	private Pane ChangingPane;
	
	@Override
	public void start(Stage secondaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../views/student/IndexStd.fxml"));
			Scene scene = new Scene(root,640, 480);
			secondaryStage.setTitle("Student Site");
			secondaryStage.setScene(scene);
			secondaryStage.setMaximized(true);
			secondaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setChangingPane(String PanelNuevo) {
		// change pane to the window you want to go
		try {
			ChangingPane.getChildren().clear();
			ChangingPane.getChildren().add((Node) FXMLLoader.load(getClass().getResource(PanelNuevo)));
			//System.out.println("nevo contro");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ChangingPaneStudentArea(){
		// go to personal data feature
		setChangingPane("../views/student/DataPane.fxml");
	}
	
	public void ChangingPaneCourses(){
		// go to see grades feature
		setChangingPane("../views/student/GradesPane.fxml");
	}
	
	// toolbar methods
	public void TKClose() {
		ToolKitModel.TKClose();
	}
	
	public void TKSession() {
		ToolKitModel.TKSession();
	}
	
	public void TKSpecificHelp(){
		new ToolKitModel().TKSpecificHelp();
	}
	
	public void TKAboutUs(){
		new ToolKitModel().TKAboutUs();
	}
}