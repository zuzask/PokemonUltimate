package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TestController2 implements Initializable {


    @FXML

    private Button btnCapturar;

    @FXML
    private Button btnCombatir;

    private Stage stage;

    @FXML
    private void combatir(ActionEvent event) throws IOException{
    
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../vistas/VentanaCombate.fxml"));
    
                Parent root = loader.load();
    
                Combate controller = loader.getController();
    
                Scene scene = new Scene(root);
    
                Stage stage = new Stage();
    
                stage.initModality(Modality.APPLICATION_MODAL);
    
                stage.setScene(scene);
    
                stage.showAndWait();
    
                ((Stage) this.stage).close();
    
    
            

    }

    @FXML
    private void capturar(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../vistas/VentanaCapturar.fxml"));
    
        Parent root = loader.load();

        VentanaCapturar controller = loader.getController();

        Scene scene = new Scene(root);

        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setScene(scene);

        stage.showAndWait();

        ((Stage) this.stage).close();


    }

    @FXML
    private void mostrarEquipo(ActionEvent event) throws IOException{

    }

    @FXML
    private void mostrarCaja(ActionEvent event) throws IOException{

    }

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
    }


    
}
