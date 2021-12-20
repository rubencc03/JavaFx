package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Definimos los botones
			
			Label lbNombre = new Label("Nombre: ");
			TextField txtNombre = new TextField();
			Label lbNombre2 = new Label("Apellido: ");
			TextField txtNombre2 = new TextField();
			Button btn1 = new Button("Polsa ací: ");
			Label mensaje = new Label("");
			
			// Creamos un HBox con los botones dentro
			VBox vbox = new VBox(lbNombre,txtNombre,lbNombre2,txtNombre2,btn1,mensaje);
			// Creamos escena de 300x100 píxeles
			Scene scene = new Scene(vbox, 500, 100);
			primaryStage.setTitle("Contenedor HBox");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			btn1.setOnAction(value -> {
				
				if (txtNombre.getText().equals("") && txtNombre.getText().equals("")) {
					mensaje.setText("No has puesto nada ");
					
				} else if (txtNombre.getText().equals("")) {
					
					mensaje.setText("No has puesto el nombre ");
					
				} else if (txtNombre2.getText().equals("")) {
				
				mensaje.setText("No has puesto el apellido ");
			}
				
				
				
			});
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
