package CallerCatcher;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Gui extends Application {
	private static Stage guiStage;

	public static Stage getStage() {
		return guiStage;
	}

	private static Scene catchScene;

	@Override
	public void start(Stage primaryStage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		FXMLLoader catchLoader = new FXMLLoader(getClass().getResource("CatchScene.fxml"));
		Parent catchRoot = catchLoader.load();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		
		//Parent catchLoader = FXMLLoader.load(getClass().getResource("CatchScene.fxml"));
		
		catchScene = new Scene(catchRoot);
		
		guiStage = primaryStage;
		guiStage.show();
	}

	public static void switchSceneToCatch() throws IOException {
		guiStage.setScene(catchScene);
		guiStage.show();
	}
}
