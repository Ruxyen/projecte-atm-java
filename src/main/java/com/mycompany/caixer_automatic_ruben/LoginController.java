/**
 *
 * Controlador encargado de manejar la pantalla de inicio de sesión del cajero automático.
 * Permite al usuario ingresar su nombre de usuario y contraseña para acceder a su cuenta bancaria.
 * También permite cambiar el tema de color de la interfaz.
 *
 * @author Rubén
 */
package com.mycompany.caixer_automatic_ruben;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LoginController {

    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Label mensaje;
    @FXML
    Label RegisterLabel;
    @FXML
    RadioButton color_option1;
    @FXML
    RadioButton bn_option2;
    @FXML
    Button iniciarSesionBtn;
    @FXML
    Button registrarseBtn;
    @FXML
    ImageView logo;

    /**
     * Carga los datos bancarios al iniciar la aplicación y establece el tema de
     * color por defecto.
     */
    @FXML
    public void initialize() {
        App.banco.leerdatos();
        tema_color();

    }
  
    /**
     * Establece el tema de color rojo en la interfaz gráfica.
     */
    
    public void tema_color() {

        color_option1.setStyle("-fx-text-fill: red;");
        iniciarSesionBtn.setStyle("-fx-background-color: red;");
        registrarseBtn.setStyle("-fx-background-color: red;");
    }

    /**
     * Establece el tema de color blanco y negro en la interfaz gráfica.
     */
    
    public void tema_blanco_negro() {

        color_option1.setStyle("-fx-text-fill: black;");
        iniciarSesionBtn.setStyle("-fx-background-color: black;");
        registrarseBtn.setStyle("-fx-background-color: black;");

    }

    /**
     * Maneja el evento de inicio de sesión. Verifica si el usuario y la
     * contraseña ingresados son correctos y muestra un mensaje en consecuencia.
     */
    @FXML
    void iniciarSesion() {

        String usuario = username.getText();
        String contraseña = password.getText();

        App.banco.Login(usuario, contraseña);
        mensaje.setText(Banco.mostrarMensaje);

    }

    /**
     * Permite al usuario acceder a la pantalla de registro para crear una nueva
     * cuenta bancaria.
     *
     * @throws IOException si hay un error al cambiar de pantalla.
     */
    @FXML
    private void Registrarse() throws IOException {
        App.setRoot("register");
    }

}
