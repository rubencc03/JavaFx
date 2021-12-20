package application;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;


public class Cntr1 {

	@FXML
	private ImageView img1;

	
	@FXML
	private Button btn1;
	
	@FXML
	private Button btn2;
	

	 public void initialize() {
	    	
	    	btn2.setDisable(true);

	    	EventHandler<MouseEvent> manejador = new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					GaussianBlur blur = new GaussianBlur();
			    	blur.setRadius(10);
			    	img1.setEffect(blur);
			    	btn1.setDisable(true);
			    	btn2.setDisable(false);
					
				}};
				
				btn1.addEventHandler(MouseEvent.MOUSE_CLICKED, manejador);
				
				
				
				
			 	EventHandler<MouseEvent> manejador2 = new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						KeyValue key = new
						    	KeyValue(img1.translateXProperty(), -500);
						    	KeyValue key2 = new
						    	KeyValue(img1.translateYProperty(), 0);
						    	KeyFrame keyFrame = new KeyFrame(Duration.seconds(4),
						    	key, key2);
						    	Timeline tl = new Timeline(keyFrame);
						    	tl.play();
						    	btn2.setDisable(true);
						
					}};
					
					btn2.addEventHandler(MouseEvent.MOUSE_CLICKED, manejador2);
	    }
	    
	   

}
