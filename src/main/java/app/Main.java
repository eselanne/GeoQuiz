package app;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
//import fi.utu.tech.gui.javafx.FXMLController;
//import fi.utu.tech.gui.javafx.ResourceLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/MainMenu.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("GeoQuiz - Best Game Ever");
		stage.setScene(scene);
        stage.show();
		
	}

}
