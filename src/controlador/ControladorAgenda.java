package controlador;
import java.awt.Button;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;

import agenda.modelo.AgendaContactos;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import jdk.tools.jlink.internal.Platform;
/*
public class PleaseProvideControllerClassName {

   

}
*/

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
    void ayuda(ActionEvent event) {
		
    }

    @FXML
    void botonPulsar(ActionEvent event) {

    }

    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void clear(ActionEvent event) {

    }

    @FXML
    void exportar(ActionEvent event) {

    }

    @FXML
    void felicitar(ActionEvent event) {

    }

    @FXML
    void importar(ActionEvent event) {
    	agenda.importarAgenda();
    }

    @FXML
    void listar(ActionEvent event) {

    }

    @FXML
    void personalesFecha(ActionEvent event) {

    }

    @FXML
    void personalesLetra(ActionEvent event) {
    	agenda.contactosEnLetra((char)event);
    }

    @FXML
    void salir(ActionEvent event) {
    	Platform.exit();
    }


	@FXML
	public void initialize() {

	}
	

}

