module CallerCatcher {
	requires javafx.controls;
	requires okio;
	requires javafx.graphics;
	requires javafx.fxml;
	requires json.simple;
	requires com.google.gson;
	requires com.fasterxml.jackson.databind;
	requires javafx.base;

	
	opens CallerCatcher to javafx.graphics, javafx.fxml;
}
