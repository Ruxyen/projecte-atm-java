package com.mycompany.caixer_automatic_ruben;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 * La clase ConsultarCuentasController se encarga de manejar la pantalla de consulta de cuentas.
 *
 * Contiene métodos que se activan cuando se pulsan los botones de "Consultar" y "Volver".
 *
 * También contiene campos para la lista de cuentas, el cuadro de detalles, los botones de "Volver" y "Consultar",
 * las etiquetas de mensaje y saldo total, así como un cuadro de texto de movimientos.
 *
 * La lista de cuentas se encuentra en la constante ListaCuentas.
 *
 * El cuadro de detalles se encuentra en la constante Detalles.
 *
 * Los botones de "Volver" y "Consultar" se encuentran en las constantes VolverBtn y ConsultarBtn, respectivamente.
 *
 * La etiqueta de mensaje se encuentra en la constante Mensaje.
 *
 * La etiqueta de saldo total se encuentra en la constante SaldoTotal.
 *
 * El cuadro de texto de movimientos se encuentra en la constante Movimientos.
 *
 * También contiene los métodos initialize, OtrasOperaciones, Consultar y calcularSaldoCuentas.
 *
 * El método initialize se ejecuta al inicio para mostrar la lista de cuentas y el saldo total.
 *
 * El método OtrasOperaciones cambia a la pantalla de otras operaciones cuando se pulsa el botón "Volver".
 *
 * El método Consultar consulta una cuenta seleccionada en la lista de cuentas y muestra los detalles y movimientos en
 * los cuadros de detalles y movimientos, respectivamente.
 *
 * El método calcularSaldoCuentas calcula el saldo total de las cuentas del usuario conectado.
 *
 * @autor Rubén
 */
public class ConsultarCuentasController {

    /** La lista de cuentas. */
    @FXML
    ListView ListaCuentas;

    /** El cuadro de detalles. */
    @FXML
    Label Detalles;

    /** El botón "Volver". */
    @FXML
    Button VolverBtn;

    /** El botón "Consultar". */
    @FXML
    Button ConsultarBtn;

    /** La etiqueta de mensaje. */
    @FXML
    Label Mensaje;

    /** La etiqueta de saldo total. */
    @FXML
    Label SaldoTotal;

    /** El cuadro de texto de movimientos. */
    @FXML
    TextArea Movimientos;

    /**
     * Inicializa la lista de cuentas y muestra el saldo total.
     */

    @FXML
    private void initialize() {
        ListaCuentas.getItems().setAll(Cuentas.getCuentasUsuariosNumero(App.banco.usuarioactivo.getId()));
        SaldoTotal.setText("Saldo Total: " + calcularSaldoCuentas()+" €");
    }
    
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
     * Consulta una cuenta seleccionada en la lista de cuentas y muestra los detalles y movimientos en los cuadros de
     * detalles y movimientos, respectivamente.
     */

    @FXML
    private void Consultar() {

        String cuenta = ("" + ListaCuentas.getSelectionModel().getSelectedItem());
        App.banco.Consultar(cuenta);
        Mensaje.setText(Banco.mostrarMensaje);
        Detalles.setText(Banco.detalleConsulta);
        Movimientos.setText(Banco.detalleMovimientos);
        Banco.detalleConsulta = "";
        Banco.detalleMovimientos = "";

    }
    
    /**
 * Calcula el saldo total de las cuentas del usuario conectado.
 *
 * @return el saldo total de las cuentas del usuario conectado.
 */

    private int calcularSaldoCuentas() {
        int saldo = 0;
        for (Cuenta cuenta : Cuentas.getCuentasUsuarios(App.banco.usuarioactivo.getId())) {
            saldo += cuenta.getDinero();
        }
        return saldo;
    }

}
