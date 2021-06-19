package CallerCatcher;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainScene_Controller {

	@FXML
	private Button searchButton;
	@FXML
	private TextField numberInput;

	String phoneNumber;
	Alert invalidInput = new Alert(AlertType.ERROR);

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

		System.out.println("Number: " + phoneNumber);
	}

}
