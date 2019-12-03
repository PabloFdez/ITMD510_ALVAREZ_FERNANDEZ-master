package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import controllers.LoginController;
import Dao.DaoModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import models.DataModel;

/**
 * @author Pablo Angel Alvarez Fernandez
 * @author Pablo Fernandez Diaz
 * SetGradesProfessorController class
 * Control the selection of the courses
 */
public class SetGradesProfessorController implements Initializable {
	
	@FXML GridPane grid;
	@FXML TextField pCourse;
	@FXML
	private Pane ChangingPane;
	
	public void selectStudents(){
		//System.out.println(pCourse.getText());
		LoginController.courseID = Integer.parseInt(pCourse.getText());
		setChangingPane("/views/professor/SelectStudentGradePane.fxml");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String[][] courses = DaoModel.selectCoursesTeachProfessor(LoginController.AClog.getId());
		int row = 0;
		// show curses grid
		for(int i = 0;i<courses.length;i++) {
			Label id = new Label(courses[i][0]);
			Label courseName = new Label(courses[i][1]);
			grid.addRow(row,id,courseName);
			row++;
		}
		
	}
	
	public void setChangingPane(String PanelNuevo) {
		// change pane to the window you want to go
		try {
			ChangingPane.getChildren().clear();
			ChangingPane.getChildren().add((Node) FXMLLoader.load(getClass().getResource(PanelNuevo)));
		} catch (IOException e) {
			DataModel.sendAlert("Show error", "Please talk to admin: "+e.toString().substring(0, 40));
			e.printStackTrace();
		}
	}

}
