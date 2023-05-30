
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;


public class VerArticulosVistaController{

    @FXML
    private TableView<?> tblVerArt;
    @FXML
    private TableColumn<?, ?> colVerIdArt;
    @FXML
    private TableColumn<?, ?> colVerDescArt;
    @FXML
    private TableColumn<?, ?> colVerPrecArt;
    @FXML
    private TableColumn<?, ?> colVerGastEnvi;
    @FXML
    private TableColumn<?, ?> colVerPrepArt;
    @FXML
    private Button btnVolvVerArt;

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
