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
 * IndexProfController class
 * Iniciates the professor page
 */
public class IndexProfController extends Application {
	@FXML
	private Pane ChangingPane;
	
	@Override
	public void start(Stage secondaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../views/professor/IndexProf.fxml"));
			Scene scene = new Scene(root,640, 480);
			secondaryStage.setTitle("Professor Site");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ChangingPaneProfArea(){
		// go to personal data feature
		setChangingPane("../views/professor/DataPane.fxml");
	}
	
	public void ChangingPaneSetGrade(){
		// go to set grade feature 
		setChangingPane("../views/professor/SelectCoursePane.fxml");
	}
	
	// toolbar methods
	public void TKClose() {
		ToolKitModel.TKClose();
	}
	
	public void TKSession() {
		ToolKitModel.TKSession();
	}
	
	public void TKHelp() {
		new ToolKitModel().TKHelp();
	}
	
	public void TKSpecificHelp(){
		new ToolKitModel().TKSpecificHelp();
	}
	
	public void TKAboutUs(){
		new ToolKitModel().TKAboutUs();
	}
}

