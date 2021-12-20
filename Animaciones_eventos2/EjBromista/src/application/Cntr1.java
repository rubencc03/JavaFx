package application;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;


public class Cntr1 {

	@FXML
	private Button btn1;

	@FXML
	private Button btn2;

	boolean poder = false;
	double guardar = 0;

	public void initialize() {

		guardar = btn2.getLayoutX();

		EventHandler<MouseEvent> manejador = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText("PARA DE PROGRAMAR,PESAO");
				alert.setContentText("Ya puedes pulsar el otro boton crack,bien hecho");
				alert.showAndWait();
				poder = true;
				btn2.setLayoutX(guardar);

			}
		};

		btn1.addEventHandler(MouseEvent.MOUSE_CLICKED, manejador);

		EventHandler<MouseEvent> manejador2 = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (!poder) {

					btn2.setLayoutX(btn2.getLayoutX() + 10000);

					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setHeaderText("TRABAJO ANTES QUE OCIO");
					alert.setContentText(
							"¿No querías trabajar? pues ahora por listo reinicias el programa.\n Y no me mientas,se notaba que ibas a clickar");
					alert.showAndWait();

				}

			}
		};

		btn2.addEventHandler(MouseEvent.MOUSE_ENTERED, manejador2);

		EventHandler<MouseEvent> manejador3 = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				System.exit(0);
			}
		};

		btn2.addEventHandler(MouseEvent.MOUSE_CLICKED, manejador3);

	}

}
