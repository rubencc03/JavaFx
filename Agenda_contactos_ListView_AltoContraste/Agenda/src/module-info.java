module Agenda {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
}
