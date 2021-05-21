package agenda.controlador;
import java.awt.Button;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeParseException;

import agenda.io.AgendaIO;
import agenda.modelo.AgendaContactos;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
/*
public class PleaseProvideControllerClassName {


   

}
*/
import javafx.stage.FileChooser.ExtensionFilter;

public class ControladorAgenda {
	private AgendaContactos agenda; // el modelo;
	
	 @FXML
	    private MenuBar barraMenu;

	    @FXML
	    private MenuItem itmImportarAgenda;

	    @FXML
	    private MenuItem itmExportarPersonales;

	    @FXML
	    private MenuItem itmSalir;

	    @FXML
	    private MenuItem itmBuscar;

	    @FXML
	    private MenuItem itmFelicitar;

	    @FXML
	    private MenuItem itmMenu;

	    @FXML
	    private GridPane panelLetras;

	    @FXML
	    private TextField txtBuscar;

	    @FXML
	    private RadioButton rbtListarAgenda;

	    @FXML
	    private RadioButton rbtListarContacos;

	    @FXML
	    private Button btnListar;

	    @FXML
	    private Button btnContactosLetra;

	    @FXML
	    private Button btnContactosFecha;

	    @FXML
	    private Button btnClear;

	    @FXML
	    private Button btnSalir;

	    @FXML
	    private TextArea areaTexto;

	
	public ControladorAgenda() {
		this.agenda = new AgendaContactos();
		this.areaTexto = new TextArea();
		this.barraMenu = new MenuBar();
		this.btnClear = new Button();
		this.btnContactosFecha = new Button();
		this.btnContactosLetra = new Button();
		this.btnListar = new Button();
		this.btnSalir = new Button();
		this.itmBuscar = new MenuItem();
		this.itmExportarPersonales = new MenuItem();
		this.itmFelicitar = new MenuItem();
		this.itmImportarAgenda = new MenuItem();
		this.itmMenu = new MenuItem();
		this.itmSalir = new MenuItem();
		this.panelLetras = new GridPane();
		this.rbtListarAgenda = new RadioButton();
		this.rbtListarContacos = new RadioButton();
		this.txtBuscar = new TextField();
		}
	
	@FXML
	void ayuda() {
		
    }

    @FXML
    void botonPulsar() {

    }

    @FXML
    void buscar() {

    }

    @FXML
    void clear() {
		areaTexto.setText("");
    }

    @FXML
    void exportar() {
    	FileChooser selector = new FileChooser();
    	selector.setTitle("Guardar fichero");
    	selector.setInitialDirectory(new File("."));
    	selector.getExtensionFilters()
    	.addAll(new ExtensionFilter("txt",
    	"*.txt"));
    	File f = selector.showSaveDialog(null);
    	try {
    	AgendaIO.exportarPersonales(agenda, f.getName());
    	areaTexto.setText("Exportados contactos personales");
    	}
    	catch (IOException e) {
    		System.out.println(e.getMessage());
    	}
    	catch (NullPointerException e) {
    		System.out.println(e.getMessage());
    	}
    }

    @FXML
    void felicitar() {

    }

    @FXML
    public void importar() {
    	FileChooser selector = new FileChooser();
    	selector.setTitle("Abrir fichero de datos");
    	selector.setInitialDirectory(new File("."));
    	selector.getExtensionFilters()
    	.addAll(new ExtensionFilter("csv",
    	"*.csv"));
    	File f = selector.showOpenDialog(null);
    	int errores = 0;
    	if (f != null) {
        	errores = AgendaIO.importar(agenda, f.getName());
            clear();
            areaTexto.setText("Errores: " + errores);
            itmImportarAgenda.setEnabled(false);
            itmExportarPersonales.setEnabled(false);
        }
    		
    }

    @FXML
    void listar() {
    	if (areaTexto.getText().isEmpty()) {
    		areaTexto.setText("Importe antes la agenda");
    	}
    	else {
    		if (rbtListarAgenda.isSelected()) {
    			areaTexto.setText(agenda.toString());
    		}
    		else {
    			areaTexto.setText("Total contactos en la agenda: " + agenda.totalContactos());
    		}
    	}
    }

    @FXML
    void personalesFecha() {

    }

    @FXML
    void personalesLetra() {
    	//agenda.contactosEnLetra((char)event);
    }

    @FXML
    void salir() {
    	Platform.exit();
    }


	@FXML
	public void initialize() {

	}
	

}

