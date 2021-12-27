package CallerCatcher;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import com.google.gson.Gson;

import Sources.NumberSource1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main {

	public static void main(String[] args) throws IOException {

		Application.launch(Gui.class, args);

	}

	public static void startProgram() {

		// Hide the phone input stage
		Gui.getStage().hide();

		// Start Chromedriver
		Driver.initializeDriver();
	}

	public static void phoneFetch() {

		// If Program can proceed (Number is Valid)
		if (Driver.getProceedProgram()) {

			// Run the number through Source 1
			NumberSource1.source1(Driver.getPhoneNumber());

		}
	}

	public static void endProgram() throws IOException {

		// Quit Chromedriver
		Driver.quit();

		// Switch to Catch Scene for the results
		Gui.switchSceneToCatch();

		// Write Source  results to Catch Scene
		CatchScene_Controller.sourceWriting("source1");

	}

//	private static Stage pStage;
//
//	@Override
//	public void start(Stage primaryStage) {
//		try {
//
//			Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
//			// Parent root = FXMLLoader.load(getClass().getResource("CatchScene.fxml"));
//			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
