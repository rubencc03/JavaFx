package application;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.stage.*;


public class Cntr1 implements Initializable {
	
	//variables locales
	boolean estaGuardado = false;									
	boolean sePuedeSalvar = true;									
	String nombreDocumento = "ElPutoMejorDocumento ";     		
	File fichero;											    
	FileChooser interfazFC;							    	
	String txtModificable = "";									
	Clipboard instanciaClipBoard = Clipboard.getSystemClipboard();
	ClipboardContent portaPapeles = new ClipboardContent();			
	
	//Funcionar funciona sin declararlas,pero medioPeta(el de copiar y pegar si lo utilizamos ya que desabilitamos los botones)
	@FXML
	private MenuItem menuNuevoArchivo,menuAbrir,menuGuardar,menuGuardarComo,menuSalir,menuCopiar,menuPegar,menuCortar,Help;
	
	//Le ponemos nombres descriptivos a los botones (probablemente tengamos las mismas id de botones 90 alumnos)
	@FXML
	private Button btnNuevo,btnAbrir,btnGuardar,btnCortar,btnCopiar,btnPegar,btnSalir;
	
	@FXML
	private TextArea textoTA;
	
	@FXML
	private ImageView hayQueGuardar;
	
	@FXML
	private Label nombreArchivo;
	
	public void initialize(URL url, ResourceBundle resourceBundle) {
		//No te voy a mentir,metodo semiCopiado de internet por que no sabia como utilizar un changeListener,la url y el resourceBundle no se para que sirve  por que no lo he utilizado,investigación pendiente
			nombreArchivo.setStyle("-fx-font-weight: bold; -fx-padding: 10 20 10 20;");
			//Se le añade un listener al texto del textarea
	        textoTA.textProperty().addListener(new ChangeListener<String>() {

	        	
	        	//Creamos un metodo Que hace el cambio,tiene que llamarse changed por que si no peta 
				@Override
				public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
					
					//si el texto se cambia podemos guardar y le recordamos al usuario que debe guardar mediante la imagen disco
					hayQueGuardar.setVisible(true);
					sePuedeSalvar = true;
					
					//Si el texto sigue siendo el mismo,lo contrario a lo anterior
					if(txtModificable.equals(arg2)) {
						hayQueGuardar.setVisible(false);
						sePuedeSalvar = false;
					}
				}
	        });
	    }
	
	
	@FXML
	void newDocumentEvent(ActionEvent event) {
		//Como creas otro documento lo que hay se borra(teoria respaldada por el Writter de libreoffice)
		textoTA.setText("");
			
		//Le asignamos al nombre del archivo el nombre del documento :)
		nombreArchivo.setText(nombreDocumento);
			
		//No esta guardado
		estaGuardado = false;
		//Ocultamos el disco
		hayQueGuardar.setVisible(false);
		//Le decimos que hay algo que se puede guardar
		sePuedeSalvar = true;
		
	}
	

//revisar este
	@FXML
	void abrirDocumentoEvent(ActionEvent event) {
		
		//Todo el rollo de FileChooser
		interfazFC = new FileChooser();
		interfazFC.setTitle("Abrir Documento Fachero");
		interfazFC.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("archivos TXT (.txt)", "*txt*"));

	        //Guardar el fichero seleccionado
	        fichero = interfazFC.showOpenDialog(new Stage());
	        
	        //si se ha seleccionado algo
	        if(fichero!=null){
	        					
				//creamos una cadena donde volcaremos temporalmente los datos. Ponemos en blanco el area de texto
				String texto = "";
				textoTA.setText("");
				
				
				try {
					//Todo el rollo de leer ficheros que hemos hecho 12mil veces
					FileReader fr = new FileReader(fichero);
					BufferedReader br = new BufferedReader(fr);
					String linea = br.readLine();
					while (linea != null) {
						texto = texto + linea + "\n";
						linea = br.readLine();
					}
					//IMPORTANTE CERRAR
					fr.close();
				} catch (Exception e) {}
				
				//Es como un setText
				textoTA.appendText(texto);
				//Añadimos al texto que nos permite saber si un texto ha sido cambiadp
				txtModificable = texto;
				
				//Nombre del fichero abajo
				nombreArchivo.setText(fichero.getName().toString());
				
				//Es descriptivo y mas abajo esta explicado ¿Deberia explicar mi trabajo conforme lo hago y no al final? tal vez 
				estaGuardado = true;
				hayQueGuardar.setVisible(false);
				sePuedeSalvar = false;
			      
	        }

	        
	}
	
	@FXML
	void guardarDocEvent(ActionEvent event) {
		//Si no esta guardado,invoca guardarcomo por que hay que crear el fichero y si si lo esta invoca al otro metodo 
		if(!estaGuardado) guardarComoEvent(event);
		else guardarFicherosMetod();
	}

	
	@FXML
	void guardarComoEvent(ActionEvent event) {
		
		//Creamos un FileChooser,le damos un nombre,un título y le añadimos la extensión .txt por defecto :)
		interfazFC = new FileChooser();
		interfazFC.setTitle("Guardar Documento Como : ");
		interfazFC.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("archivos TXT", "*txt*"));
	    fichero = interfazFC.showSaveDialog(new Stage());
	    
	    //LLamamos al metodo engargado de guardar ficheros
	    guardarFicherosMetod();
	    
	}
	
	@FXML
	void salirProgramaEvent(ActionEvent event) {
		//Salimos y ya,aquí añadire un alert de que si quiere guardaar o algo
		System.exit(0);
		
	}
	
	@FXML
	void copiarTextoEvent(ActionEvent event) {

		//Este metodo es muy fácil y deberia ser el todo exámen *guiño guiño* ,básicamente si hay texto en el TextArea le ponemos a la instancia de ClipBoardContent el texto y despues
		//le decimos a la instancia de ClipBoard que su contenido será el mencionado
		String textoACopiar = textoTA.getSelectedText();
				if(textoACopiar.length() > 0) {
			portaPapeles.putString(textoACopiar);
			instanciaClipBoard.setContent(portaPapeles);
		}
		
		
	}
	
	@FXML
	void pegarTextoEvent(ActionEvent event) {
		
		//¿Por que utilizamos aquí un rango? por que cabe la posibilidad de que tu pegues un texto teniendo seleccionado parte del otro,es decir,
		//Si tu tienes el texto 'Manolo Reina es un mal portero' y quieres pegar y 'Casillas' mientras tienes seleccioado a Manolo,deberia quitar el nombre de Manolo y reemplazarlo por Casillas
		//Para que el resultado final fuera 'casillas reina es un mal portero'
		  IndexRange rango = textoTA.getSelection();
		  String textoTextArea = textoTA.getText();
		  
		  //Lo mismp que en el cortarm,utilizando el rango, podemos saber que NO esta copiando
		  String firstPart = textoTA.getText().substring( 0, rango.getStart() );
		  String lastPart = textoTA.getText().substring( rango.getEnd(), textoTextArea.length() );
		  
		  //Aquí simplemente juntamos lo NO copiado con el portapapeles?(no se si se llamaba asi) ,para ello utilizamos  nuestra instancia de ClipBoard
		  textoTA.setText( firstPart + instanciaClipBoard.getString() + lastPart );
		 
	}
	
	
	@FXML
	void cortarTextoEvent(ActionEvent event) {
		  //Esta parte se la he preguntado a un compañero por que no sabía como afrontarla,por si prefieres no contarla :-)
		
		  //Creamos un String donde guardamos el texto del text area para posteriormente copiarlo en el portaPapeles del sistema
		  String textoACopiar = textoTA.getSelectedText();
		  portaPapeles.putString(textoACopiar);
		  instanciaClipBoard.setContent(portaPapeles);
		  
		  //Creamos un instancia de la clase IndexRange que básicamente guarda diversas posiciones del texto seleccionado ,p.ej
		  //Si tenemos la palabra Desesperación y seleccionamos pera,nos dira que el principio es en la posicion 6 y el final en la 9
		  IndexRange rango = textoTA.getSelection();
		  String origText = textoTA.getText();
		  
		  //Utilizando dos metodos,accedemos a la posicion del inicio y el final de la seleccion,tal como he explicado antes
		  String principio = textoTA.getText().substring( 0, rango.getStart() );
		  String finall = textoTA.getText().substring( rango.getEnd(), origText.length() );
		  
		  //En este punto con las variables que tenemos ,podemos cambiar el texto del TextArea por todo el texto - la selección
		  textoTA.setText( principio + finall );
		 
		
	}
	

	//Querido alert(Querido por que no esta hecho en javascript) que sale en el Acerca de
	@FXML
	void acercaDe(ActionEvent event) {
		
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setHeaderText("Notepad del crack de Rubén Cerrillo,Harvard Student");
		alerta.setTitle("Notepad");
		alerta.setContentText("Autor: El que suspendio kotlin y python teniendo media de notable en las practicas ,dejenme solo :( ");
		alerta.show();
		
	}
	
	
	//Me he currado un nombre descriptivo,no creo que haga falta explicarlo
  	@FXML
	void habilitarBtns (MouseEvent event) {
		
  		//Lo único que todo el tema de la activación lo englobo dentro de un if encargado de decirme si hay texto o no
		if(textoTA.getSelectedText().length() > 0) {
			menuCortar.setDisable(false);
			btnCortar.setDisable(false);
			btnCopiar.setDisable(false);
			menuCopiar.setDisable(false);

		} else {
			btnCopiar.setDisable(true);
			menuCortar.setDisable(true);
			btnCortar.setDisable(true);
			menuCopiar.setDisable(true);
		}
	}
	

//El nombre ya es lo bastante descriptivo
	private void guardarFicherosMetod() {
		
		//Nos aseguramos de que el fichero no este vacio para que no de error
	    if(fichero!=null){
	    FileWriter fw = null;
		BufferedWriter bw = null;		
		try {
			//Lo único importante de aqui es el false para que no sobreescriba el archivo,¿Cómo lo se? Me lo chivaron ;)
			fw = new FileWriter(fichero, false);	
		    bw = new BufferedWriter(fw);

		    //Aquí se crea una  variable para guardar el texto en el file y le pasamos el texto a la variable que indica si el texto ha sido modificado
		    //¿Por que no casteas a String y ahorras una variable? por que queda un código más complejo
			String txtoNewFile = textoTA.getText();
			txtModificable = txtoNewFile;
			
			//Escribimos y cerramos el fichero,importante cerrarlo,si no,pasa lo que pasa xd
			bw.write(txtoNewFile, 0, txtoNewFile.length());
			bw.close();
			} catch (Exception e) {} 
				
				
		    //ponemos el indicador de estaGuardado, ocultamos el diskette y cambiamos el nombre del fichero
			estaGuardado = true;
			hayQueGuardar.setVisible(false);
			nombreArchivo.setText(fichero.getName().toString());
		
	    }
	}
	
	
	}
	
	
	
	
	

