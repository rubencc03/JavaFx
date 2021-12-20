package application;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Cntr3 {
	
	@FXML
	private Button cerrar;
	
	public void initialize() {
		
		EventHandler<MouseEvent> manEvent = new EventHandler<MouseEvent> () {
			
			@Override
			public void handle(MouseEvent event) {
				try {
					FXMLLoader fxmlLoader = new FXMLLoader();
					fxmlLoader.setLocation(getClass().getResource("Escena3.fxml"));
					Stage stage = (Stage) cerrar.getScene().getWindow();
					Scene scene = new Scene(fxmlLoader.load());
					stage.setScene(scene);
					stage.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
				
			}
			
		};
		
		cerrar.addEventHandler(MouseEvent.MOUSE_CLICKED, manEvent);
	}
}
