package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class Cntr2 {

	@FXML
	private PieChart pieChart;

	public void initialize() throws IOException {

		String partidos[] = { "Ciudadanos", "Vox", "PP", "PSOE" };
		int contador = 1;
		String nombreFichero = "fichero.txt";
		File fichero = new File(nombreFichero);

		BufferedReader br = new BufferedReader(new FileReader(fichero));

		String votos = br.readLine();

		int votosInt2 = Integer.parseInt(votos);
		PieChart.Data barra2 = new PieChart.Data(partidos[0], Integer.parseInt(votos));
		pieChart.getData().add(barra2);

		while (votos != null) {
			votos = br.readLine();
			if (contador <= 3) {
				int votosInt = Integer.parseInt(votos);
				PieChart.Data barra = new PieChart.Data(partidos[contador], Integer.parseInt(votos));
				pieChart.getData().add(barra);
				contador++;
			}

		}
		br.close();

	}
}
