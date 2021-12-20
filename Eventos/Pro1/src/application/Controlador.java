package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.WindowEvent;
public class Controlador {

	@FXML
	private Button heTerminado;
	
	@FXML
	private TextField textfield;
	
	@FXML
	private Label labelIni,newLabel;
	
	
	@FXML
	void Validar(ActionEvent event) {
		
		if(textfield.getLength()<100) {
			newLabel.setText("");
		Alert alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setContentText("No trates de engañarme");
				alerta.showAndWait();
		} else {
			
			newLabel.setText("");
			Alert alerta = new Alert(Alert.AlertType.ERROR);
					alerta.setContentText("Trabajo acabado");
					alerta.showAndWait();
					Platform.exit();
					
		}
	}
	
		@FXML
		void tocartf(ActionEvent event) {
			
		}
			
			@FXML
			void tocarteclas(KeyEvent event) {
				if(textfield.getLength()<50) {
					
					newLabel.setText("Todavíate queda bastante");
				} else if(textfield.getLength()<100) {
					newLabel.setText("Te queda menos de la mitad");
				}else if(textfield.getLength()>=100) {
					newLabel.setText("Has acadado el trabajo");
				}
				
				
				
		
	}
}
