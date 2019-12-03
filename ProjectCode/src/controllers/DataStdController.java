package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Dao.DaoModel;
import application.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import models.DataModel;

/**
 * @author Pablo Angel Alvarez Fernandez
 * @author Pablo Fernandez Diaz
 * DataStdController class
 * Control the personal data for the student page
 */
public class DataStdController implements Initializable{
	private Student user = (Student) controllers.LoginController.AClog;
	@FXML private Pane ChangingPane;
	@FXML private Label fName;
	@FXML private Label lName;
	@FXML private Label email;
	@FXML private Label major;
	@FXML private Label gpa;
	@FXML private TextField TfName;
	@FXML private TextField TlName;
	@FXML private TextField Tmajor;
	
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

	public void EditUserData() {
		// go to edit window
		setChangingPane("../views/student/EditPane.fxml");
	}

	public void SaveEdit() {
		// send correct data to db
		if ((TfName.getText().length() <= 0) || (TlName.getText().length() <= 0) || 
				(Tmajor.getText().length()) <= 0) {
			DataModel.sendAlert("Save error", "Please review the data");
		} else {
			// Updating DB
			DaoModel.updateStudent(user.getId(), TfName.getText(), TlName.getText(), Tmajor.getText());
			
			// Updating App
			user.setFirstName(TfName.getText());
			user.setLastName(TlName.getText());
			user.setMajor(Tmajor.getText());
			
			// view data pane
			setChangingPane("../views/student/DataPane.fxml");
		}
	}

	// set the db data
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// view
		if (location.toString().contains("DataPane.fxml")) {
			fName.setText(user.getFirstName());
			lName.setText(user.getLastName());
			email.setText(user.getEmail());
			major.setText(user.getMajor());
			gpa.setText(Double.toString(user.getGpa()));
		// edit
		} else if (location.toString().contains("EditPane.fxml")) {
			TfName.setText(user.getFirstName());
			TlName.setText(user.getLastName());
			Tmajor.setText(user.getMajor());
		}
	}
}
