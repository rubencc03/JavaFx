package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			// Definimos los botones
			
			CheckBox chBox = new CheckBox("Café solo");
			CheckBox chBox2 = new CheckBox("Leche");

			
			
			
			
						Button btn1 = new Button("Dibuixa ");
						
						Label mensaje = new Label("");
						
						// Creamos un HBox con los botones dentro
						VBox vbox = new VBox(chBox,chBox2,btn1,mensaje);
						// Creamos escena de 300x100 píxeles
						Scene scene = new Scene(vbox, 500, 100);
						primaryStage.setTitle("Contenedor HBox");
						primaryStage.setScene(scene);
						primaryStage.show();
						
						btn1.setOnAction(value -> {
							
							
							
							
							if(chBox.isSelected() && chBox2.isSelected()) {
								
								
								try {
									FileInputStream input = new FileInputStream("src\\cafeconleche.png"); ;
									Image image = new Image(input);
									
									 ImageView imageView = new ImageView(image);
									
									   vbox.getChildren().add(imageView);

								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							
								
								
							}else if(chBox.isSelected()) {
								
								
							
								try {
									

									FileInputStream input = new FileInputStream("src\\cafesolo.png"); ;
									Image image = new Image(input);
									 ImageView imageView = new ImageView(image);
									
									   vbox.getChildren().add(imageView);

								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							
						         
							} else if(chBox2.isSelected()) {
							
								

								FileInputStream input = null;
								try {
									input = new FileInputStream("src\\leche.png");
									Image image = new Image(input);
									 ImageView imageView = new ImageView(image);
							            vbox.getChildren().add(imageView);
									
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
							
						});
						
						
					
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
