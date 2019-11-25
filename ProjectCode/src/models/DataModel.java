package models;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DataModel {
	public static boolean isNumeric(String str) {
		return str.matches("[+-]?\\d*(\\d+)?");
	}
	
	public static void sendAlert(String header, String message) {
		Alert dialogoAlerta = new Alert(AlertType.WARNING);
		dialogoAlerta.setTitle("Warning");
		dialogoAlerta.setHeaderText(header);
		dialogoAlerta.setContentText(message);
		dialogoAlerta.showAndWait();
	}
}
