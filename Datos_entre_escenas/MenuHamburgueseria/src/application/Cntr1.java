package application;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Cntr1 {

	@FXML
	private Button cogerBebida;

	@FXML
	private Button hacerComanda;

	String datos2 = "";

	int total = 0;

	@FXML
	private Button cogerHambur;

	@FXML
	private Label queHaPedido;

	public void initialize() {

		EventHandler<MouseEvent> manejador = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				try {
					FXMLLoader fxmlLoader = new FXMLLoader();
					fxmlLoader.setLocation(getClass().getResource("Beguda.fxml"));
					Stage stage = (Stage) cogerBebida.getScene().getWindow();
					Scene scene = new Scene(fxmlLoader.load());
					stage.setScene(scene);
					Cntr2 controler = (Cntr2) fxmlLoader.getController();
					controler.setPedido(getPedido());
					datos2 += getPedido();

					controler.setTotal(getTotal());
					total += getTotal();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		};
		cogerBebida.addEventHandler(MouseEvent.MOUSE_CLICKED, manejador);

		EventHandler<MouseEvent> manejador2 = new EventHandler<MouseEvent>() {
 
			@Override
			public void handle(MouseEvent event) {
				try {
					FXMLLoader fxmlLoader = new FXMLLoader();
					fxmlLoader.setLocation(getClass().getResource("Comida2.fxml"));
					Stage stage = (Stage) cogerHambur.getScene().getWindow();
					Scene scene = new Scene(fxmlLoader.load());
					stage.setScene(scene);
					Cntr3 controler = (Cntr3) fxmlLoader.getController();
					controler.setPedido(getPedido());
					datos2 += getPedido();

					controler.setTotal(getTotal());
					total += getTotal();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		};
		cogerHambur.addEventHandler(MouseEvent.MOUSE_CLICKED, manejador2);

		EventHandler<MouseEvent> manejador3 = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (total !=0) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText("TOTAL");
				alert.setContentText("El total es: "+ total+ "€");
				alert.showAndWait();
				}
			}

		};
		hacerComanda.addEventHandler(MouseEvent.MOUSE_CLICKED, manejador3);

	}

	public void setPedido(String pedido) {
		queHaPedido.setText(queHaPedido.getText() + pedido);
	}

	public String getPedido() {

		return queHaPedido.getText();
	}

	public int getTotal() {

		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
