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

/**
 * @author Pablo Angel Alvarez Fernandez
 * @author Pablo Fernandez Diaz
 * SetGradesSelectStudentProfessorController class
 * Control the insertion of the grade of a student on a course
 */
public class SetGradesSelectStudentProfessorController implements Initializable {
	
	@FXML GridPane grid;
	@FXML TextField pStudent;
	@FXML TextField pGrade;
	@FXML private Pane ChangingPane;
	
	public void setGradeStudent(){
		//System.out.println(pStudent.getText());
		DaoModel.updateCourseStudentGrade(LoginController.courseID, Integer.parseInt(pStudent.getText()), Double.parseDouble(pGrade.getText())); 
		DaoModel.updateStudentGPA(Integer.parseInt(pStudent.getText())); 
		// Update of the student's grade
		setChangingPane("../views/professor/SelectStudentGradePane.fxml");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String[] students = DaoModel.selectStudentsOfCourse(LoginController.courseID);
		
		int row = 0;
		String studentsName = "";
		while(students[row] != null) {
			studentsName = DaoModel.selectStudentsNameOfCourse(Integer.parseInt(students[row]));
			Label id = new Label(students[row]);
			Label name = new Label(studentsName);
			grid.addRow(row,id,name);
			row++;
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

}
