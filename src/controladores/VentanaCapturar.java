package controladores;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Caja;
import modelo.DbConexion;
import modelo.Entrenador;
import modelo.Pokemon;

public class VentanaCapturar implements Initializable {

    private Entrenador entrenador;
    private Pokemon pokemon;
    private Caja caja;
    private Pokemon equipo1[];

    @FXML
    private ImageView CapturarPokemon;

    @FXML
    private Button btnCapturar;

    @FXML
    private Button btnGenerarPokemon;

    @FXML
    private Button btnSalir;

    private Stage stage;

    @FXML
    private void capturar(ActionEvent event) throws IOException{

        entrenador.captura(pokemon);

      
    }

    @FXML
    private void generarPokemon(ActionEvent event) throws IOException{

        pokemon = Pokemon.generarPokemon();
        System.out.println(pokemon.mostrarPokemon());

    }


    @FXML
    private void salir(ActionEvent event) throws IOException{

        System.out.println("La caza ha terminado.");

        

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

      
        pokemon = new Pokemon();


        
        
    }

}
