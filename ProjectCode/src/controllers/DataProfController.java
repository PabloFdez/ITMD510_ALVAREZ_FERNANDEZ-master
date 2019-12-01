package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Dao.DaoModel;
import application.Professor;
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
 * DataProfController class
 * Control the personal data for the professor page
 */
public class DataProfController implements Initializable{
	private Professor professor = (Professor) controllers.LoginController.AClog;
	@FXML private Pane ChangingPane;
	@FXML private Label fName;
	@FXML private Label lName;
	@FXML private Label email;
	@FXML private Label department;
	@FXML private Label office;
	@FXML private TextField TfName;
	@FXML private TextField TlName;
	@FXML private TextField Tdepartment;
	@FXML private TextField Toffice;

	public void setChangingPane(String PanelNuevo) {
		// change pane to the window you want to go
		try {
			ChangingPane.getChildren().clear();
			ChangingPane.getChildren().add((Node) FXMLLoader.load(getClass().getResource(PanelNuevo)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void EditUserData() {
		// go to edit panel
		setChangingPane("../views/professor/EditPane.fxml");
	}

	public void SaveEdit() {
		// send correct data to db
		if ((TfName.getText().length() <= 0) || (TlName.getText().length() <= 0) || 
				(Tdepartment.getText().length()) <= 0 || !DataModel.isNumeric(Toffice.getText()) || Toffice.getText().length()<=0) {
			DataModel.sendAlert("Save error", "Please review the data");
		} else {
			// Updating DB
			DaoModel.updateProfessor(professor.getId(), TfName.getText(), TlName.getText(), Tdepartment.getText(),Integer.parseInt(Toffice.getText()));
			
			// Updating App
			professor.setFirstName(TfName.getText());
			professor.setLastName(TlName.getText());
			professor.setDept(Tdepartment.getText());
			professor.setOfficeNo(Integer.parseInt(Toffice.getText()));
			setChangingPane("../views/professor/DataPane.fxml");
		}
	}

	// set the db data
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (location.toString().contains("DataPane.fxml")) {
			fName.setText(professor.getFirstName());
			lName.setText(professor.getLastName());
			email.setText(professor.getEmail());
			department.setText(professor.getDept());
			office.setText(Integer.toString(professor.getOfficeNo()));
		} else if (location.toString().contains("EditPane.fxml")) {
			TfName.setText(professor.getFirstName());
			TlName.setText(professor.getLastName());
			Tdepartment.setText(professor.getDept());
			Toffice.setText(Integer.toString(professor.getOfficeNo()));
		}
	}
}
