package application;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Cntr1 {
	
	@FXML
	private Button boton;
	
	public void initialize() {
		
		EventHandler<MouseEvent> manejador = new EventHandler<MouseEvent> () {
			
			@Override
			public void handle(MouseEvent event) {
				try {
					FXMLLoader fxmlLoader = new FXMLLoader();
					fxmlLoader.setLocation(getClass().getResource("Escena2.fxml"));
					Stage stage = (Stage) boton.getScene().getWindow();
					Scene scene = new Scene(fxmlLoader.load());
					stage.setScene(scene);
				}catch(IOException e) {
					e.printStackTrace();
				}
				
			}
		
		};
		boton.addEventHandler(MouseEvent.MOUSE_CLICKED, manejador);
	
	}
		
		
	}
	

