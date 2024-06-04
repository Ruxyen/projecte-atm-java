/**
 *
 * Controlador encargado de la vista de retiro de dinero.
 */
package com.mycompany.caixer_automatic_ruben;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author Rubén
 */
public class RetirarController {

    @FXML
    Button VolverBtn;
    @FXML
    Button RetirarBtn;
    @FXML
    ListView ListaCuentas;
    @FXML
    TextField Cantidad;
    @FXML
    Label mensaje;

    /**
     * Inicializa la vista con las cuentas del usuario conectado.
     */
    @FXML
    private void initialize() {
        ListaCuentas.getItems().setAll(Cuentas.getCuentasUsuariosNumero(App.banco.usuarioactivo.getId()));
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
     * Realiza la operación de retiro de dinero.
     */
    @FXML
    private void retirar() {
        try {
            int cantidad = Integer.parseInt(Cantidad.getText());
        } catch (NumberFormatException e) {
            mensaje.setText("Por favor, ingrese un número válido!");
            return;
        }
        int cantidad = Integer.parseInt(Cantidad.getText());
        String cuenta = ("" + ListaCuentas.getSelectionModel().getSelectedItem());
        App.banco.Retirar(cantidad, cuenta);
        mensaje.setText(Banco.mostrarMensaje);
        Banco.detalleRetiro = "";
    }

}
