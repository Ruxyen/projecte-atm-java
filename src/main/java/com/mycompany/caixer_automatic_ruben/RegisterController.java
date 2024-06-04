/**
 *
 * Controlador encargado de la vista de registro de usuarios.
 */
package com.mycompany.caixer_automatic_ruben;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *
 * @author Rubén
 */
public class RegisterController {

    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    PasswordField password_confirmada;
    @FXML
    Button iniciarSesionBtn;
    @FXML
    Button RegisterBtn;
    @FXML
    Label mensaje;
    @FXML
    RadioButton color_option;
    @FXML
    RadioButton bn_option;

    /**
     * Inicializa la vista con el tema de color predeterminado.
     */
    @FXML
    public void initialize() {
        tema_color();
    }

    /**
     * Establece el tema de color en la vista.
     */
    public void tema_color() {

        color_option.setStyle("-fx-text-fill: red;");
        iniciarSesionBtn.setStyle("-fx-background-color: red;");
        RegisterBtn.setStyle("-fx-background-color: red;");
    }

    /**
     * Establece el tema en blanco y negro en la vista.
     */
    public void tema_blanco_negro() {

        color_option.setStyle("-fx-text-fill: black;");
        iniciarSesionBtn.setStyle("-fx-background-color: black;");
        RegisterBtn.setStyle("-fx-background-color: black;");

    }

    /**
     * Regresa a la vista de inicio de sesión.
     *
     * @throws IOException si ocurre un error al cargar la vista.
     */
    @FXML
    private void iniciarSesion() throws IOException {
        Usuarios.ListadeUsuarios.clear();
        Cuentas.ListadeCuentas.clear();
        Billetes.ListadeBilletes.clear();
        Movimientos.ListadeMovimientos.clear();
        App.setRoot("login");
    }

    /**
     * Registra un nuevo usuario en el sistema.
     */
    @FXML
    private void registrarse() {
        String usuario = username.getText();
        String contraseña = password.getText();
        String confirmarContraseña = password_confirmada.getText();
        App.banco.Registrarse(usuario, contraseña, confirmarContraseña);
        mensaje.setText(Banco.mostrarMensaje);
    }

}
