/**
 *
 * Controlador encargado de la gestión de las operaciones adicionales del sistema.
 */
package com.mycompany.caixer_automatic_ruben;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Rubén
 */
public class OtrasOperacionesController {

    @FXML
    Button VolverBancBtn;
    @FXML
    Button ConsultarCuentasBtn;
    @FXML
    Button CrearNuevaCuentaBtn;
    @FXML
    Button CambiarContraseñaBtn;
    @FXML
    Label usuario_actual;

    /**
     * Inicializa la vista con el usuario conectado.
     */
    @FXML
    public void initialize() {
        usuario_actual.setText(App.banco.usuarioactivo.getUsuario());
    }

    /**
     * Regresa a la vista principal del banco.
     *
     * @throws IOException si ocurre un error al cargar la vista.
     */
    @FXML
    private void volverBanc() throws IOException {
        App.setRoot("banc");
    }

    /**
     * Carga la vista de cambio de contraseña.
     *
     * @throws IOException si ocurre un error al cargar la vista.
     */
    @FXML
    private void cambiarContraseña() throws IOException {
        App.setRoot("cambiar_contraseña");
    }

    /**
     * Carga la vista de creación de cuenta.
     *
     * @throws IOException si ocurre un error al cargar la vista.
     */
    @FXML
    private void crearCuenta() throws IOException {
        App.setRoot("crear_cuenta");
    }

    /**
     * Carga la vista de consulta de cuentas.
     *
     * @throws IOException si ocurre un error al cargar la vista.
     */
    @FXML
    private void consultarCuentas() throws IOException {
        App.setRoot("consultar_cuentas");
    }

}
