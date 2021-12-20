package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Cntr2 {

    @FXML
    private Label label2;

    @FXML
    private ComboBox<String> combo2;

    public void initialize() {
    	combo2.getItems().setAll("","Si", "No", "No sé,me he copiado todos los ejercicios");
    	combo2.getSelectionModel().select(0);
		
	}
    @FXML
    void Validar(ActionEvent event) {
    	
    	
    	if(combo2.getSelectionModel().getSelectedIndex() ==1) {
    		try {
        		FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Scena3.fxml"));
                Stage stage = (Stage) combo2.getScene().getWindow();
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);

               


        	} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    }

}