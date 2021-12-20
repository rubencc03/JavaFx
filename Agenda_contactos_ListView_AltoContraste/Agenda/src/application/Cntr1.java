package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ObservableValue;
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
	private TextField nombre;

	@FXML
	private TextField numero;

	@FXML
	private Button guardar;

	@FXML
	private Button btnBorrar;

	@FXML
	private TextField correo;

	@FXML
	private ListView<String> listaDinamica;

	@FXML
	private MenuItem importar;

	// btnEditEvent
	@FXML
	public void handleMouseClick(MouseEvent event) {

		if (listaDinamica.getSelectionModel().getSelectedIndex() >= 0) {

			try {
				String[] newStr = listaDinamica.getSelectionModel().getSelectedItem().split("\\s+");
				nombre.setText(newStr[0]);
				numero.setText(newStr[1]);
				correo.setText(newStr[2]);
			} catch (Exception e) {
				// Este bug ha sido parcheado :)
			}
		}

	}

	@FXML
	public void btnEditEvent(MouseEvent event) {

		int cualModify = listaDinamica.getSelectionModel().getSelectedIndex();

		if (cualModify > -1) {
			listaDinamica.setEditable(true);
			listaDinamica.getItems().add(cualModify,
					nombre.getText() + " " + numero.getText().toString() + " " + correo.getText());

			borrar();

		}

	}

	public void initialize() {

		// EVENTO GUARDAR
		EventHandler<MouseEvent> manejador = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				if (nombre.getText().equals("") && numero.getText().equals("") && correo.getText().equals("")) {
					Alert alerta = new Alert(Alert.AlertType.INFORMATION);
					alerta.setHeaderText("ERROR DE GUARDADO");
					alerta.setContentText("Ya me dirás que quieres guardar si no has escrito nada,maquina");
					alerta.showAndWait();
				} else {
					listaDinamica.getItems()
							.add(nombre.getText() + " " + numero.getText().toString() + " " + correo.getText());

					nombre.setText("");
					numero.setText("");
					correo.setText("");

				}
			}
		};

		guardar.addEventHandler(MouseEvent.MOUSE_CLICKED, manejador);

		// EVENTO BORRAR
		EventHandler<MouseEvent> manejador2 = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				borrar();
			}
		};

		btnBorrar.addEventHandler(MouseEvent.MOUSE_CLICKED, manejador2);

	}

	// EVENTO IMPORTAR
	@FXML
	void impEvent(ActionEvent event) throws IOException {

		JFileChooser guardar = new JFileChooser();
		guardar.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
		guardar.showSaveDialog(null);
		guardar.setFileSelectionMode(JFileChooser.FILES_ONLY);
		File archivo = guardar.getSelectedFile();

		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);

		String linea;
		while ((linea = br.readLine()) != null) {
			listaDinamica.getItems().add(linea);
		}

	}

	// EVENTO EXPORTAR

	@FXML
	void expEvent(ActionEvent event) throws IOException {

		JFileChooser guardar = new JFileChooser();
		guardar.showSaveDialog(null);
		guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		File archivo = guardar.getSelectedFile();

		if (!archivo.exists()) {
			archivo.createNewFile();
		}
		FileWriter fw = new FileWriter(archivo);
		BufferedWriter bw = new BufferedWriter(fw);

		int count = listaDinamica.getItems().size();

		for (int i = 0; i < count; i++) {
			bw.write(listaDinamica.getItems().get(i) + "\n");

		}
		bw.close();

		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setHeaderText("FICHERO EXPORTADO CON EXITO");
		alerta.setContentText("Tu fichero ya ha sido exportado crack :O");
		alerta.showAndWait();
	}
	
	@FXML
	void aboutEvent(ActionEvent event) throws IOException {
		
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setHeaderText("INFORMACIÓN APLICACIÓN");
		alerta.setContentText("Actividad mandada por :Jose Grass\nRelizada por: Rubén Cerrillo Chica \nGracias :)");
		alerta.showAndWait();
		
	}

	public void borrar() {

		if (listaDinamica.getSelectionModel().getSelectedIndex() >= 0) {
			listaDinamica.getItems().remove(listaDinamica.getSelectionModel().getSelectedIndex());
			nombre.setText("");
			numero.setText("");
			correo.setText("");
		} else {
			Alert alerta = new Alert(Alert.AlertType.INFORMATION);
			alerta.setHeaderText("ERROR DE SELECCION");
			alerta.setContentText(
					"Disculpa señor retrasado,acaso usted no ve que no ha seleccionado ningun item? esta bobo");
			alerta.showAndWait();
		}
	}

}
