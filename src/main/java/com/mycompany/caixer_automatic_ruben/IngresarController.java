/**
 *
 * Controlador encargado de manejar la pantalla de ingreso de dinero en el cajero automático.
 * Permite ingresar billetes de diferentes denominaciones en una cuenta bancaria seleccionada.
 *
 * @author Rubén
 */
package com.mycompany.caixer_automatic_ruben;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class IngresarController {

    @FXML
    Button VolverBtn;
    @FXML
    Button IngresarBtn;
    @FXML
    ListView ListadeCuentas;
    @FXML
    TextField billete_200;
    @FXML
    TextField billete_100;
    @FXML
    TextField billete_50;
    @FXML
    TextField billete_20;
    @FXML
    TextField billete_10;
    @FXML
    TextField billete_5;
    @FXML
    Label mensaje;

    /**
     * Inicializa la lista de cuentas disponibles para el usuario conectado.
     */
    @FXML
    private void initialize() {
        ListadeCuentas.getItems().setAll(Cuentas.getCuentasUsuariosNumero(App.banco.usuarioactivo.getId()));
    }

    /**
     * Permite al usuario volver a la pantalla de operaciones bancarias.
     *
     * @throws IOException si hay un error al cambiar de pantalla.
     */
    @FXML
    private void volverBanc() throws IOException {
        App.setRoot("banc");
    }

    /**
     * Maneja el evento de ingreso de dinero en la cuenta seleccionada. Lee la
     * cantidad de billetes ingresados por el usuario y los deposita en la
     * cuenta correspondiente. Si algún campo de billetes contiene un valor no
     * numérico, muestra un mensaje de error.
     */
    @FXML
    private void ingresar_dinero() {

        try {
            int billete200 = Integer.parseInt(billete_200.getText());
            int billete100 = Integer.parseInt(billete_100.getText());
            int billete50 = Integer.parseInt(billete_50.getText());
            int billete20 = Integer.parseInt(billete_20.getText());
            int billete10 = Integer.parseInt(billete_10.getText());
            int billete5 = Integer.parseInt(billete_5.getText());
        } catch (NumberFormatException e) {
            mensaje.setText("Por favor, ingrese un número válido en todos los campos de billetes.");
            return;
        }

        String cuenta = ("" + ListadeCuentas.getSelectionModel().getSelectedItem());

        int billete200 = Integer.parseInt(billete_200.getText());
        int billete100 = Integer.parseInt(billete_100.getText());
        int billete50 = Integer.parseInt(billete_50.getText());
        int billete20 = Integer.parseInt(billete_20.getText());
        int billete10 = Integer.parseInt(billete_10.getText());
        int billete5 = Integer.parseInt(billete_5.getText());

        App.banco.Ingresar(cuenta, billete200, billete100, billete50, billete20, billete10, billete5);

        mensaje.setText(Banco.mostrarMensaje);

    }

}
