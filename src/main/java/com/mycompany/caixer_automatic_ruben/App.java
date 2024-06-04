/**
 * La clase {@code App} es el punto de entrada principal de la aplicación. Extiende la clase 
 * {@code Application} y proporciona métodos para configurar la escena de JavaFX y cargar archivos 
 * FXML. También contiene un objeto {@code Banco} estático para gestionar las operaciones bancarias.
 * 
 * @author Rubén
 */
package com.mycompany.caixer_automatic_ruben;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.image.Image;

public class App extends Application {
    
    @FXML
    private void IniciarSesion() throws IOException {
        App.setRoot("login");
    }
    
    @FXML
    private void Registrarse() throws IOException {
        App.setRoot("register");
    }

    /** La escena principal de la aplicación. */
    private static Scene scene;

    /** El objeto {@code Banco} estático utilizado para gestionar las operaciones bancarias. */
    static Banco banco = new Banco();

    /**
     * Punto de entrada principal de la aplicación. Lanza la aplicación JavaFX.
     * 
     * @param args Los argumentos de línea de comandos pasados a la aplicación.
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Método llamado cuando se inicia la aplicación. Configura la escena principal y muestra la 
     * ventana.
     * 
     * @param stage La ventana principal de la aplicación.
     * @throws IOException Si se produce un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MazeBank"), 750, 550);
        stage.setScene(scene);
        // TITULO DEL ATM 
        stage.setTitle("MazeBank - ATM");
        
        //WINDOWS--------------------------------------------------------------------------------------------
        //stage.getIcons().add(new Image(getClass().getResourceAsStream("images\\icono.jpg")));
        
        //LINUX----------------------------------------------------------------------------------------------
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/icono.jpg")));

        stage.show();
      
    }

    /**
     * Cambia la raíz de la escena principal al archivo FXML especificado.
     * 
     * @param fxml El nombre del archivo FXML a cargar.
     * @throws IOException Si se produce un error al cargar el archivo FXML.
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Carga el archivo FXML con el nombre especificado.
     * 
     * @param fxml El nombre del archivo FXML a cargar.
     * @return El nodo raíz del archivo FXML cargado.
     * @throws IOException Si se produce un error al cargar el archivo FXML.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}
