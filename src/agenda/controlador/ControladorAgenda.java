package agenda.controlador;
import java.awt.Button;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.io.File;

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

    }

    @FXML
    void exportar() {

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
    	if (f != null) {
        	AgendaIO.importar(agenda, f.getName());
    	}	
    }

    @FXML
    void listar() {

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

