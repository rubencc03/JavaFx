package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Cntr1 {
	
	@FXML
    private ComboBox combo;

	@FXML
    private Button button1;
	
	@FXML
    private TextField usu;
	
	@FXML
    private PasswordField password;

	@FXML
	public void initialize() {

		EventHandler<MouseEvent> handler1 = new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent event) {
		     
		    	if (usu.getText().equals("") || password.getText().equals("")){
					
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText("fallo");
					alert.setContentText("Usuario y Password son necesarios");
					alert.showAndWait();
				}
		    }
		};
		
		button1.addEventHandler(MouseEvent.MOUSE_CLICKED, handler1);
		
		
		
		
	 
	}
}
