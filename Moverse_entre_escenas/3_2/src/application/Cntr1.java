package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Cntr1 {
	
	
	@FXML
	private Label label;
	  
    @FXML
    private ComboBox<String> combo1;
    public void initialize() {
    	combo1.getItems().setAll("","Si", "No", "Debería haber sido peluquero");
    	combo1.getSelectionModel().select(0);	
	}
    
    @FXML
    void Validar(ActionEvent event) {
    	
    	
    	if(combo1.getSelectionModel().getSelectedIndex() ==1) {
    		try {
        		
    			FXMLLoader fxmlLoad = new FXMLLoader();
                fxmlLoad.setLocation(getClass().getResource("Scena2.fxml"));
                Stage stage = (Stage) combo1.getScene().getWindow();
                Scene scene = new Scene(fxmlLoad.load());
                stage.setScene(scene);

        	} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    }

}