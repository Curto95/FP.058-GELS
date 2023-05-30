package gels.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GestionOS extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            // Cambia la ruta a la ubicación correcta de tu archivo FXML
            AnchorPane root = FXMLLoader.load(getClass().getResource("/gels/vista/GestionVista.fxml"));
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Este método puede ser llamado para iniciar la interfaz gráfica
    public void inicio() {
        launch();
    }
}
