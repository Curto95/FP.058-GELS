
package gels.controlador.Cliente;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MenuClientesVistaController{

    @FXML
    private AnchorPane lblMenuClien;
    @FXML
    private Button btnMenVerCli;
    @FXML
    private Button btnMenAñaClie;
    @FXML
    private Button btnMenModClien;
    @FXML
    private Button btnMenEliClien;
    @FXML
    private Button btnMenVolvClien;

   
    @FXML
    void volverGestion(ActionEvent event) {
         try {
        // Cargar el FXML de GestionVista
        Parent gestionVista = FXMLLoader.load(getClass().getResource("/gels/vista/MenuGestion/GestionVista.fxml"));

        // Crear la nueva escena
        Scene gestionVistaScene = new Scene(gestionVista);

        // Obtener el escenario desde el evento y establecer la nueva escena
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(gestionVistaScene);
        window.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }    
    
}
