package application;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Cntr3 {

	String datos = "";

	int total = 0;
	@FXML
	private ImageView hamburguesap;

	@FXML
	private ImageView hamburguesag;

	public void initialize() {

		hamburguesap.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

			try {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("Inicio.fxml"));
				Stage stage = (Stage) hamburguesap.getScene().getWindow();
				Scene scene;

				scene = new Scene(fxmlLoader.load());
				stage.setScene(scene);
				Cntr1 controler = (Cntr1) fxmlLoader.getController();
				datos += "\n-hamburguesa grande     2€";
				controler.setPedido(datos);
				total += 2;
				controler.setTotal(total);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		hamburguesag.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

			try {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("Inicio.fxml"));
				Stage stage = (Stage) hamburguesag.getScene().getWindow();
				Scene scene;

				scene = new Scene(fxmlLoader.load());
				stage.setScene(scene);
				Cntr1 controler = (Cntr1) fxmlLoader.getController();
				datos += "\n-hamburguesa     1€";
				controler.setPedido(datos);
				total += 1;
				controler.setTotal(total);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

	}

	public void setPedido(String pedido) {
		datos = pedido;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
