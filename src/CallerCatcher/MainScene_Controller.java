package CallerCatcher;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainScene_Controller {

	@FXML
	private Button searchButton;
	@FXML
	private TextField numberInput;

	String phoneNumber;
	Alert invalidInput = new Alert(AlertType.ERROR);
	boolean proceed = false;

	public void search(ActionEvent e) {

		System.out.println("Starting search");

		phoneNumber = numberInput.getText();

		// Alert:
		// Number is too short or too long
		if (phoneNumber.length() < 10 || phoneNumber.length() > 15) {
			invalidInput.setTitle("Invalid Number");
			invalidInput.setHeaderText("The number you entered is invalid.");
			invalidInput.setContentText("Please enter a 10-digit number.");
			invalidInput.show();
		}

		// Alert:
		// Number contains any character that is not a number
		else if (phoneNumber.matches("[0-9]+") == false) {
			invalidInput.setTitle("Invalid Number");
			invalidInput.setHeaderText("The number you entered is invalid.");
			invalidInput.setContentText("Please remove any characters that are not numbers.");
			invalidInput.show();
		}

		else {
			proceed = true;
		}

		System.out.println("Number: " + phoneNumber);

		// Launch Chromedriver and continue only if number input is valid.
		if (proceed) {
			Driver.initializeDriver();

			numberSource1.source1(phoneNumber);
		}
	}

	private Stage stage;
	private Scene scene;
	private Parent root;

	// Switch to the Catch Scene
	public void switchToCatchScene(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("CatchScene.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setX(300);
			stage.setY(50);
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
