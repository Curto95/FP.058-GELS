package gels.controlador;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class GestionVistaController {
    @FXML
    private Button btnGestArt;
    
    @FXML
    private Button btnGestPed;
    
    @FXML
    private Button btnGestClie;
   
    @FXML
    private Button btnGestSalir;

    @FXML
    void gestionArticulos(ActionEvent event) {
        try {
            // Cargar el nuevo FXML
            Parent menuArticulos = FXMLLoader.load(getClass().getResource("/gels/vista/Articulo/MenuArticuloVista.fxml"));
            
            // Crear la nueva escena
            Scene menuArticulosScene = new Scene(menuArticulos);
            
            // Obtener el escenario desde el evento y establecer la nueva escena
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(menuArticulosScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gestionPedidos(ActionEvent event) {
        try {
            // Cargar el nuevo FXML
            Parent menuPedidos = FXMLLoader.load(getClass().getResource("/gels/vista/Pedido/MenuPedidosVista.fxml"));
            
            // Crear la nueva escena
            Scene menuPedidosScene = new Scene(menuPedidos);
            
            // Obtener el escenario desde el evento y establecer la nueva escena
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(menuPedidosScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gestionClientes(ActionEvent event) {
        try {
            // Cargar el nuevo FXML
            Parent menuClientes = FXMLLoader.load(getClass().getResource("/gels/vista/Cliente/MenuClientesVista.fxml"));
            
            // Crear la nueva escena
            Scene menuClientesScene = new Scene(menuClientes);
            
            // Obtener el escenario desde el evento y establecer la nueva escena
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(menuClientesScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void salir(ActionEvent event) {
        // Código para cerrar la aplicación
        Stage stage = (Stage) btnGestSalir.getScene().getWindow();
        stage.close();
    }
}
