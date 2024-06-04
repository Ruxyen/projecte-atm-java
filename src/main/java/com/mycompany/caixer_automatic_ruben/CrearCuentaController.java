package com.mycompany.caixer_automatic_ruben;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

/**
 * La clase CrearCuentaController se encarga de manejar la pantalla de creación de cuenta.
 *
 * Contiene métodos que se activan cuando se pulsan los botones de "Crear cuenta" y "Volver".
 *
 * También contiene campos para los botones de "Volver" y "Crear cuenta", la etiqueta de mensaje y los botones de
 * selección de tipo de cuenta.
 *
 * Los botones de "Volver" y "Crear cuenta" se encuentran en las constantes VolverBtn y CrearCuentaBtn, respectivamente.
 *
 * La etiqueta de mensaje se encuentra en la constante mensaje.
 *
 * Los botones de selección de tipo de cuenta se encuentran en las constantes AhorroBtn y CorrienteBtn, respectivamente.
 *
 * También contiene los métodos OtrasOperaciones y CrearNuevaCuenta.
 *
 * El método OtrasOperaciones cambia a la pantalla de otras operaciones cuando se pulsa el botón "Volver".
 *
 * El método CrearNuevaCuenta crea una nueva cuenta con el tipo de cuenta seleccionado y muestra el mensaje devuelto por
 * el método CrearCuenta en la etiqueta de mensaje.
 *
 * @autor Rubén
 */
public class CrearCuentaController {
    
    /** El botón "Volver". */
    @FXML
    Button VolverBtn;

    /** El botón "Crear cuenta". */
    @FXML
    Button CrearCuentaBtn;

    /** La etiqueta de mensaje. */
    @FXML
    Label mensaje;

    /** El botón de selección de cuenta de ahorro. */
    @FXML
    RadioButton AhorroBtn;

    /** El botón de selección de cuenta corriente. */
    @FXML
    RadioButton CorrienteBtn;

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
     * Crea una nueva cuenta con el tipo de cuenta seleccionado y muestra el mensaje devuelto por el método CrearCuenta
     * en la etiqueta de mensaje.
     */
    @FXML
    private void CrearNuevaCuenta(){
        
        String tipo_de_cuenta="";
        
        if(CorrienteBtn.isSelected()){tipo_de_cuenta="Corriente";}
        
        else {tipo_de_cuenta="Ahorro";}
        
        App.banco.CrearCuenta(tipo_de_cuenta);
        mensaje.setText(Banco.mostrarMensaje);
        
    }
}
