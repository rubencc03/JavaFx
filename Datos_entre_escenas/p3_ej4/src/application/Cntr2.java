package application;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Cntr2 {
	
	@FXML
	private Button avanzar;
	
	@FXML
	private Button volver;
	
	public void initialize() {
		
		EventHandler<MouseEvent> manEvent = new EventHandler<MouseEvent> () {
			
			@Override
			public void handle(MouseEvent event) {
				try {
					FXMLLoader fxmlLoader = new FXMLLoader();
					fxmlLoader.setLocation(getClass().getResource("Escena3.fxml"));
					Stage stage = (Stage) avanzar.getScene().getWindow();
					Scene scene = new Scene(fxmlLoader.load());
					stage.setScene(scene);
				}catch(IOException e) {
					e.printStackTrace();
				}
				
			}
			

			
		};
		
		EventHandler<MouseEvent> manEvent2 = (MouseEvent event) -> {
		
			try {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("vista.fxml"));
				Stage stage = (Stage) volver.getScene().getWindow();
				Scene scene = new Scene(fxmlLoader.load());
				stage.setScene(scene);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		};
		
		avanzar.addEventHandler(MouseEvent.MOUSE_CLICKED, manEvent);
		
		volver.addEventHandler(MouseEvent.MOUSE_CLICKED, manEvent2);
	}
	
}