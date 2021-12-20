package application;



import java.io.FileInputStream;

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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Ej1 extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			BorderPane bp = new BorderPane();
			BorderPane rigth = new BorderPane();
			CheckBox chBox = new CheckBox("PEPE");
			CheckBox chBox2 = new CheckBox("PSOE");
			CheckBox chBox3 = new CheckBox("CIUDADANOS");
			CheckBox chBox4 = new CheckBox("VOX");
			CheckBox chBox5 = new CheckBox("ANIMALISTAS");
			FileInputStream input = new FileInputStream("src\\espanya.png"); ;
			Image image = new Image(input);
			 ImageView imageView = new ImageView(image);
			 imageView.setFitHeight(100);
			 imageView.setFitWidth(100);
			 
			 FileInputStream input2 = new FileInputStream("src\\flecha.png"); ;
				Image image2 = new Image(input2);
				 ImageView imageView2 = new ImageView(image2);
				 imageView2.setFitHeight(100);
				 imageView2.setFitWidth(100);
			 
				 FileInputStream input3 = new FileInputStream("src\\v.png"); ;
					Image image3 = new Image(input3);
					 ImageView imageView3 = new ImageView(image3);
					 imageView3.setFitHeight(100);
					 imageView3.setFitWidth(100);
			 
			 
			
			 VBox vbox = new VBox();
			 vbox.getChildren().addAll(chBox, chBox2,chBox3,chBox4,chBox5);
			
			 VBox rigthbox = new VBox(imageView);
			 HBox bottombox = new HBox(280,imageView2,imageView3);

			 
				 bp.setLeft(vbox);
				 bp.setRight(rigthbox);
				 bp.setBottom(bottombox);
			
			 Scene scene = new Scene(bp, 500, 600);
			primaryStage.setScene(scene);
			primaryStage.show();
			}
		
		
		 catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}