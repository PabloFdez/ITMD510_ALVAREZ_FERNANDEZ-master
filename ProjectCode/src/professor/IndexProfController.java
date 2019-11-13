package professor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class IndexProfController extends Application {

	@Override
	public void start(Stage secondaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("IndexProf.fxml"));
			Scene scene = new Scene(root,640, 480);
			secondaryStage.setTitle("Student Site");
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
