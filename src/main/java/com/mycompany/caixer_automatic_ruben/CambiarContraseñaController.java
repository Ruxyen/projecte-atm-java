package com.mycompany.caixer_automatic_ruben;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

/**
 * El paquete com.mycompany.caixer_automatic_ruben contiene la clase CambiarContraseñaController, que se encarga de
 * manejar la pantalla de cambio de contraseña.
 *
 * La clase contiene métodos que se activan cuando se pulsan los botones de "Cambiar contraseña" y "Volver".
 *
 * También contiene campos para los campos de texto de la contraseña actual, la nueva contraseña y la confirmación de la
 * contraseña, así como una etiqueta de mensaje y botones de "Volver" y "Cambiar contraseña".
 *
 * Los campos de texto se encuentran en las constantes contraseña_actual, nueva_contraseña y confirmada_contraseña.
 *
 * La etiqueta de mensaje se encuentra en la constante mensaje.
 *
 * Los botones de "Volver" y "Cambiar contraseña" se encuentran en las constantes VolverBtn y CambiarContraseñaBtn,
 * respectivamente.
 *
 * @author Rubén
 */
public class CambiarContraseñaController {
    
    /** El campo de texto de la contraseña actual. */
    @FXML
    PasswordField contraseña_actual;

    /** El campo de texto de la nueva contraseña. */
    @FXML
    PasswordField nueva_contraseña;

    /** El campo de texto de la confirmación de la contraseña. */
    @FXML
    PasswordField confirmada_contraseña;

    /** La etiqueta de mensaje. */
    @FXML
    Label mensaje;

    /** El botón "Volver". */
    @FXML
    Button VolverBtn;

    /** El botón "Cambiar contraseña". */
    @FXML
    Button CambiarContraseñaBtn;

    /**
     * Cambia a la pantalla de otras operaciones cuando se pulsa el botón "Volver".
     *
     * @throws IOException si hay un error al cambiar a la pantalla de otras operaciones.
     */
    @FXML
    private void OtrasOperaciones() throws IOException {
        App.setRoot("otras_operaciones");
    }

    /**
     * Cambia la contraseña actual por una nueva contraseña cuando se pulsa el botón "Cambiar contraseña".
     *
     * Obtiene las contraseñas introducidas en los campos de texto y llama al método CambiarContraseña del objeto banco
     * de la clase App para cambiar la contraseña.
     *
     * Muestra el mensaje devuelto por el método CambiarContraseña en la etiqueta de mensaje.
     */
    @FXML
    private void cambiar_contraseña(){
        String ContraseñaActual=contraseña_actual.getText();
        String NuevaContraseña=nueva_contraseña.getText();
        String ConfirmarContraseña=confirmada_contraseña.getText();
        App.banco.CambiarContraseña(ContraseñaActual, NuevaContraseña, ConfirmarContraseña);
        mensaje.setText(Banco.mostrarMensaje);
    }
}
