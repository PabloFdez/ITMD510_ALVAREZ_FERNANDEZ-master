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

public class GradesStdController implements Initializable {
	@FXML GridPane grid;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ResultSet rs = DaoModel.getStudentGrades(LoginController.AClog.getId());
		try {
			int row = 0;
			while(rs.next()) {
				Label courseName = new Label(DaoModel.selectCourseName(rs.getInt(1)));
				Label grade = new Label(Double.toString(rs.getDouble(2)));
				grid.addRow(row,courseName,grade);
				row++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
