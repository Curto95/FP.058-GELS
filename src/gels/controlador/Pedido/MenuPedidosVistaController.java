
package gels.controlador.Pedido;

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
import javafx.stage.Stage;


public class MenuPedidosVistaController{

    @FXML
    private Label lblMenuPed;
    @FXML
    private Button btnMenVerPed;
    @FXML
    private Button btnMenAñaPedi;
    @FXML
    private Button btnMenEnviPedi;
    @FXML
    private Button btnMenElimPedi;
    @FXML
    private Button btnMenVolvPedi;

   
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
