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
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AñadirArticuloVistaController{

    @FXML
    private Button btnAñadirArt;
    @FXML
    private TextField txtIdArt;
    @FXML
    private TextField txtDescArt;
    @FXML
    private TextField txtPvpArt;
    @FXML
    private TextField txtEnvioArt;
    @FXML
    private TextField txtTiempArt;
    @FXML
    private TableView<?> tablArti;
    @FXML
    private TableColumn<?, ?> colidArt;
    @FXML
    private TableColumn<?, ?> coldesArt;
    @FXML
    private TableColumn<?, ?> colpvpArt;
    @FXML
    private TableColumn<?, ?> colenvArti;
    @FXML
    private TableColumn<?, ?> colenviArti;

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
