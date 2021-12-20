package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Vista.fxml"));
			Scene scene = new Scene(root,800,530);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setTitle("Notepad");
			primaryStage.getIcons().add(new Image("file:icoJava.png"));
			primaryStage.setResizable(true);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
