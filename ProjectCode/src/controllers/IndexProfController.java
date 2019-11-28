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
		// cambiar panel pasando el nombre de la venta a la que se quiere ir
		try {
			ChangingPane.getChildren().clear();
			ChangingPane.getChildren().add((Node) FXMLLoader.load(getClass().getResource(PanelNuevo)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ChangingPaneProfArea(){
		setChangingPane("../views/professor/DataPane.fxml");
	}
	
	public void ChangingPaneSetGrade(){
		setChangingPane("../views/professor/SelectCoursePane.fxml");
	}
	
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

