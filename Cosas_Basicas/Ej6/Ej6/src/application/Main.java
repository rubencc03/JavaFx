package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			ObservableList<String> items = FXCollections.observableArrayList();
			items.addAll("Windows", "El mejor Sistema(Linux)", "Mac");

			ComboBox<String> cbx = new ComboBox<>(items);
			
			Button btn = new Button("Pulsa aqui");
			
			Label lb = new Label("");
			lb.setVisible(false);
			
			btn.setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			    	lb.setText("Has elegido " + cbx.getValue());
			    	lb.setVisible(true);
			    	
			    	
			    	
			    	if (lb.getText().equals("Has elegido El mejor Sistema(Linux)") ) {
			    		
			    		lb.setText(lb.getText() + " ,Enorabuena, José te va a poner un positivo");
			    		
			    	} else if (lb.getText().equals("Has elegido Windows") ) {
			    		
			    		lb.setText(lb.getText() + " , Te va a consumir todos los recursos");
			    		
			    	}else if (lb.getText().equals("Has elegido Mac") ) {
			    		
			    		lb.setText(lb.getText() + " , Joder,si te sobra la pasta");
			    		
			    	}else if (lb.getText().equals("Has elegido null") ) {
			    		
			    		lb.setText(" No creo que haya que ser muy listo para marcar una opción eh");
			    		
			    	}
			    	
			    	
			    	
			    }
			    
			   
			    
			});
			
			VBox vbox = new VBox(cbx, btn, lb);
			Scene scena = new Scene(vbox, 500,300);
			primaryStage.setScene(scena);
			primaryStage.show();
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
