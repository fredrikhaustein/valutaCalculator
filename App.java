package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ValutaKalkulator");
		primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ValutaCalculatorGUI.fxml"))));
		primaryStage.show();

	}

	public static void main(final String[] args) {
		App.launch(args);
	}
}