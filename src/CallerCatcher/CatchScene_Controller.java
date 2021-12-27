package CallerCatcher;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

public class CatchScene_Controller implements Initializable {
	static StackTraceElement method;

	@FXML
	private ListView<String> sourcesList;
	@FXML
	private Label callerSource;
	@FXML
	private Label callerNumber;
	@FXML
	private Label callerID;
	@FXML
	private Label callerAddress;
	@FXML
	private Label callerAreaCode;
	@FXML
	private Label callerRating;

	public static Label static_callerSource;
	public static Label static_callerNumber;
	public static Label static_callerID;
	public static Label static_callerAddress;
	public static Label static_callerRating;

	// private static StringProperty myTestValue = new SimpleStringProperty();

	String[] sources = { "Source 1", "Source 2", "Source 3" };

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		static_callerSource = callerSource;
		static_callerNumber = callerNumber;
		static_callerID = callerID;
		static_callerAddress = callerAddress;
		static_callerRating = callerRating;

		addSources();

		sourcesList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

				String selectedSource = sourcesList.getSelectionModel().getSelectedItem();

				System.out.println(selectedSource);

			}
		});

	}

	public void addSources() {
		sourcesList.getItems().addAll(sources);

	}

	// Read from JSON and assign to Strings
	public static void sourceWriting(String key) {
		String callerNumber = Driver.getPhoneNumber();
		String callerSource = Driver.readFromJson("source1", "callerSource");
		String callerID = Driver.readFromJson("source1", "callerID");
		String callerAddress = Driver.readFromJson("source1", "callerAddress");
		String callerRating = Driver.readFromJson("source1", "callerRating");

		writeToScene(callerNumber, callerSource, callerID, callerAddress, callerRating);
		
		
		// **** Console ****
		method = new Exception().getStackTrace()[0];
		console.log(method.getClassName(), method.getLineNumber(), method.getMethodName(), true, key);
	}

	// Write the Strings to their corresponding Label
	public static void writeToScene(String callerNumber, String callerSource, String callerID, String callerAddress,
			String callerRating) {

		Driver.writeToLabel(static_callerNumber, callerNumber);
		Driver.writeToLabel(static_callerSource, callerSource);
		Driver.writeToLabel(static_callerID, callerID);
		Driver.writeToLabel(static_callerAddress, callerAddress);
		Driver.writeToLabel(static_callerRating, callerRating);

		
		// **** Console ****
		method = new Exception().getStackTrace()[0];
		console.log(method.getClassName(), method.getLineNumber(), method.getMethodName(), true);
	}


}