
package gels.controlador.Articulo;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ModificarArticuloVistaController{

    @FXML
    private TextField txtModArt;
    @FXML
    private Label lblModArt;
    @FXML
    private Button btnModBuscArt;
    @FXML
    private TextField tvtModDescArt;
    @FXML
    private TextField txtModPrecArt;
    @FXML
    private TextField txtModEnvArt;
    @FXML
    private TextField txtModPrepArt;
    @FXML
    private Label lblModDesArt;
    @FXML
    private Label lblModPrecArt;
    @FXML
    private Label lblModEnvArt;
    @FXML
    private Label lblModPrepArt;
    @FXML
    private Button btnModGuardArt;
    @FXML
    private Button btnModVolvArt;

 @FXML
    void volverMenArt(ActionEvent event) {
         try {
        // Cargar el FXML de GestionVista
        Parent gestionVista = FXMLLoader.load(getClass().getResource("/gels/vista/Articulo/MenuArticuloVista.fxml"));

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
