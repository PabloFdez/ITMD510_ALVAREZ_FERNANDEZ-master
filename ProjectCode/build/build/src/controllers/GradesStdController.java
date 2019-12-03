package controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import controllers.LoginController;
import Dao.DaoModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import models.DataModel;

/**
 * @author Pablo Angel Alvarez Fernandez
 * @author Pablo Fernandez Diaz
 * GradesStdController class
 * Control the input data for the grades student page
 */
public class GradesStdController implements Initializable {
	@FXML GridPane grid;
	
	// set the db data
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ResultSet rs = DaoModel.getStudentGrades(LoginController.AClog.getId());
		try {
			int row = 0;
			// add grades rows dinamically
			while(rs.next()) {
				Label courseName = new Label(DaoModel.selectCourseName(rs.getInt(1)));
				Label grade = new Label(Double.toString(rs.getDouble(2)));
				grid.addRow(row,courseName,grade);
				row++;
			}
		} catch (SQLException e) {
			DataModel.sendAlert("Show error", "Please talk to admin: "+e.toString().substring(0, 40));
			e.printStackTrace();
		}
	}

}
