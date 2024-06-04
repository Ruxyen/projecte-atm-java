/**
 *
 * Controlador encargado de la vista de transferencias de dinero.
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
public class TransferirController {

    @FXML
    Button VolverBtn;
    @FXML
    ListView CuentasdeDestino;
    @FXML
    ListView CuentasdeOrigen;
    @FXML
    Button TransferirBtn;
    @FXML
    TextField Cantidad;
    @FXML
    Label mensaje;

    /**
     * Inicializa la vista con las cuentas actuales del usuario conectado.
     */
    @FXML
    private void initialize() {
        CuentasdeOrigen.getItems().setAll(Cuentas.getCuentasCorrientesNumero(App.banco.usuarioactivo.getId()));
        CuentasdeDestino.getItems().setAll(Cuentas.getCuentasCorrientesNumero(App.banco.usuarioactivo.getId()));
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
     * Realiza la operación de transferencia de dinero.
     */
    @FXML
    void Transferir() {
        String Origen = ("" + CuentasdeOrigen.getSelectionModel().getSelectedItem());
        String Destino = ("" + CuentasdeDestino.getSelectionModel().getSelectedItem());
        try {
            int cantidad = Integer.parseInt(Cantidad.getText());
        } catch (NumberFormatException e) {
            mensaje.setText("Por favor, ingrese un número válido.");
            return;
        }
        int cantidad = (int) Double.parseDouble(Cantidad.getText());
        App.banco.Transferir(Destino, Origen, cantidad);
        mensaje.setText(Banco.mostrarMensaje);
    }

}
