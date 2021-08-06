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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main {

	public static void main(String[] args) {
 
		Application.launch(Gui.class, args);
		
		


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
