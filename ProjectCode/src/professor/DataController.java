package professor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Professor;
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
	private Professor professor = (Professor) login.LoginController.AClog;
	@FXML
	private Pane ChangingPane;
	@FXML
	private Label fName;
	@FXML
	private Label lName;
	@FXML
	private Label email;
	@FXML
	private Label department;
	@FXML
	private Label office;
	@FXML
	private TextField TfName;
	@FXML
	private TextField TlName;
	@FXML
	private TextField Temail;
	@FXML
	private TextField Tdepartment;
	@FXML
	private TextField Toffice;
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
		int len = TfName.getText().length();
		if (TfName.getText().length() <= 0
				|| isNumeric(Toffice.getText())) {
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
		return str.equals(""); //(str.matches("[+-]?\\d*(\\d+)?") &&    )
	}

	public void BackUpGeneral() {
		// mandar a la bbdd que clone la bd
	}

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
			Temail.setText(professor.getEmail());
			Tdepartment.setText(professor.getDept());
			Toffice.setText(Integer.toString(professor.getOfficeNo()));
		}
	}
}
