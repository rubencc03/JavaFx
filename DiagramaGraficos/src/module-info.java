module Graficas_vocation {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.graphics;
	requires jdk.internal.le;
	requires java.xml;
	
	opens application to javafx.graphics, javafx.fxml;
}
