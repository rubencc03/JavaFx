package application;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Cntr1 {

    @FXML
    private TextField vCiudadanos;

    @FXML
    private TextField vVox;

    @FXML
    private TextField vPp;

    @FXML
    private TextField vPsoe;

    @FXML
    private Button btnGenerar;



    public void initialize() {
    	
    	EventHandler<MouseEvent> manejador = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				String[] arrayInt = new String[4];
				arrayInt[0]=vCiudadanos.getText();
				arrayInt[1]=vVox.getText();
				arrayInt[2]=vPp.getText();
				arrayInt[3]=vPsoe.getText();
			
		
				String sFichero = "fichero.txt";
				File fichero = new File(sFichero);
				
					BufferedWriter bw;
					try {
						bw = new BufferedWriter(new FileWriter(fichero));
		

						for (int x=0;x<arrayInt.length;x++) {
							   bw.write(arrayInt[x] + "\n");
						}
						
						bw.close();
						System.out.println("Voy a cambiar de escena");
						FXMLLoader fxmlLoader = new FXMLLoader();
						fxmlLoader.setLocation(getClass().getResource("VistaVotacion.fxml"));
						Stage stage = (Stage) btnGenerar.getScene().getWindow();
						Scene scene;
						scene = new Scene(fxmlLoader.load());
						stage.setScene(scene);
						
						System.out.println("He cambiado de escena");

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					

				
				
			}
		
		
		
		};
		btnGenerar.addEventHandler(MouseEvent.MOUSE_CLICKED, manejador);
    	
    	
    }
    
    
}

