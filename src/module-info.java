module CallerCatcher {
	requires javafx.controls;
	requires okio;
	requires javafx.graphics;
	requires javafx.fxml;
	
	opens CallerCatcher to javafx.graphics, javafx.fxml;
}
