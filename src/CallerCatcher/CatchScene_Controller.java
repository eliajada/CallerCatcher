package CallerCatcher;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

public class CatchScene_Controller implements Initializable {

	@FXML
	private ListView<String> sourcesList;

	String[] sources = { "Source 1", "Source 2", "Source 3" };

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
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

}