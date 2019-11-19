package student;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class DataController implements Initializable{
	private Student user = (Student) login.LoginController.AClog;
	@FXML
	private Pane ChangingPane;
	@FXML
	private Label fName;
	@FXML
	private Label lName;
	@FXML
	private Label email;
	@FXML
	private Label major;
	@FXML
	private Label gpa;
	@FXML
	private TextField TfName;
	@FXML
	private TextField TlName;
	@FXML
	private TextField Tmajor;
	@FXML
	private Button BUboton;
	
	public void setChangingPane(String PanelNuevo) {
		// cambiar panel pasando el nombre de la venta a la que se quiere ir
		try {
			ChangingPane.getChildren().clear();
			ChangingPane.getChildren().add((Node) FXMLLoader.load(getClass().getResource(PanelNuevo)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void EditUserData() {
		// pasar a vantana editar
		setChangingPane("EditPane.fxml");
	}

	public void SaveEdit() {
		// mandar datos correctos a la bbdd
		if (TfName.getText().length() <= 0) {
			Alert dialogoAlerta = new Alert(AlertType.WARNING);
			dialogoAlerta.setTitle("Warning");
			dialogoAlerta.setHeaderText("Save error");
			dialogoAlerta.setContentText("Please review the data");
			dialogoAlerta.showAndWait();
		} else {
			//DB.insertStudent(TfName.getText().....
			setChangingPane("DataPane.fxml");
		}
	}

	public static boolean isNumeric(String str) {
		return (str.matches("[+-]?\\d*(\\d+)?") || str.equals(""));
	}

	public void BackUpGeneral() {
		// mandar a la bbdd que clone la bd
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (location.toString().contains("DataPane.fxml")) {
			fName.setText(user.getFirstName());
			lName.setText(user.getLastName());
			email.setText(user.getEmail());
			major.setText(user.getMajor());
			gpa.setText(Double.toString(user.getGpa()));
		} else if (location.toString().contains("EditPane.fxml")) {
			TfName.setText(user.getFirstName());
			TlName.setText(user.getLastName());
			Tmajor.setText(user.getMajor());
		}
	}
}
