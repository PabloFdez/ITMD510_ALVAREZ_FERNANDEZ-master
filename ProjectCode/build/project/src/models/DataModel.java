package models;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * @author Pablo Angel Alvarez Fernandez
 * @author Pablo Fernandez Diaz
 * DataModel class
 * Defines data control and alert model
 */
public class DataModel {
	// reflect if the string introduced is numeric
	public static boolean isNumeric(String str) {
		return str.matches("[+-]?\\d*(\\d+)?");
	}
	
	// sent the correspondig alert to user interface
	public static void sendAlert(String header, String message) {
		Alert dialogoAlerta = new Alert(AlertType.WARNING);
		dialogoAlerta.setTitle("Warning");
		dialogoAlerta.setHeaderText(header);
		dialogoAlerta.setContentText(message);
		dialogoAlerta.showAndWait();
	}
}
