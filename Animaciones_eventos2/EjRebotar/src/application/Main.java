package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Main extends Application {
	public static final double ANCHURA_ESCENA = 600;
	public static final double ALTURA_ESCENA = 500;
	public static final double RADIO_PELOTA = 20;
	public static double velocidad = 10;
	public int contador=0;
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Button boton = new Button("A rebotar!!");
		pane.getChildren().add(boton);

		EventHandler<MouseEvent> manejador2 = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				if(contador==0) {

				Circle ball = new Circle(RADIO_PELOTA,Color.rgb((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255)));
				ball.setTranslateX(ANCHURA_ESCENA * 0.5);
				ball.setTranslateY(ALTURA_ESCENA * 0.5);
				pane.getChildren().addAll(ball);

				// Game loop usando AnimationTimer
				AnimationTimer animationTimer = new AnimationTimer() {
					public void handle(long now) {
						// Cambiar la dirección de la bola si llega a los extremos
						if (ball.getTranslateX() < 0 || ball.getTranslateX() > ANCHURA_ESCENA) {
							velocidad *= -1;
						}
						ball.setTranslateX(ball.getTranslateX() + velocidad);
					}
				};
				animationTimer.start();
				
			}
				contador++;
			}
		};

		boton.addEventHandler(MouseEvent.MOUSE_ENTERED, manejador2);

		Scene scene = new Scene(pane, 600, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
