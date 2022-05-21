package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
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
import modelo.Caja;
import modelo.Combat;
import modelo.Entrenador;
import modelo.Pokemon;
import modelo.Turno;

public class Combate implements Initializable {

    private Stage stage;
    private Entrenador entrenador;
    private Entrenador rival;
    private Caja caja;
    private Pokemon equipo1[];
    private Pokemon equiporival[];
    


    @FXML
    private Button btnAtaque;

    @FXML
    private Button btnRendirse;

    @FXML
    private Button btnGenerarRival;

    @FXML
    private void generarRival(ActionEvent event) throws IOException{

       rival = Entrenador.generarRival(entrenador);
        
    }
    

    @FXML
    private void ataque(ActionEvent event) throws IOException{

        

        System.out.println(equipo1[0].atacar(equiporival[0]));
        System.out.println(equiporival[0].atacar(equipo1[0]));
    }
    
    @FXML
    private void rendirse(ActionEvent event) throws IOException{

        System.out.println("Has abandonado el combate.");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../vistas/SegundaVentana.fxml"));
    
        Parent root = loader.load();

        TestController2 controller = loader.getController();

        Scene scene = new Scene(root);

        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setScene(scene);

        stage.showAndWait();

        ((Stage) this.stage).close();

    }
  

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        caja = new Caja();
        equipo1 = new Pokemon [4];
        entrenador  = new Entrenador(1,equipo1, caja,"pedro",50);
        
        
    }
    
}
