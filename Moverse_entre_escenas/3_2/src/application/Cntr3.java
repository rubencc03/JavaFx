package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Cntr3 {

    @FXML
    private Label label3;

    @FXML
    private ComboBox<String> combo3;

    public void initialize() {
    	combo3.getItems().setAll("","Si", "No", "¿Quién es Grass?");
    	combo3.getSelectionModel().select(0);
		
	}
    @FXML
    void Valida(ActionEvent event) {
    	
    	
    	if(combo3.getSelectionModel().getSelectedIndex() ==1) {
    		try {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
       		 alert.setTitle("Acierto");
       		 alert.setHeaderText("La respuesta es correcta!!!");
       		 alert.show();

       		Node source = (Node) event.getSource();
       	    Stage stage = (Stage) source.getScene().getWindow();
       	    stage.close();
               


        	} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    }


}
