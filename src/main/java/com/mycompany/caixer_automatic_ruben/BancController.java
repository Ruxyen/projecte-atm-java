/**
 * La clase {@code BancController} representa el controlador para la vista principal de la 
 * aplicación. Esta vista muestra las operaciones bancarias disponibles para el usuario 
 * conectado. El controlador incluye métodos para manejar las acciones del usuario en los 
 * diferentes botones y radio botones de la pantalla, como cerrar sesión, retirar dinero, ingresar 
 * dinero, transferir dinero, entre otros.
 * 
 * @author Rubén
 */
package com.mycompany.caixer_automatic_ruben;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class BancController {

    /** Etiqueta que muestra el usuario actualmente conectado. */
    @FXML
    Label usuario_actual;
    
    /** Botón para cerrar sesión del usuario. */
    @FXML
    Button cerrarSesionBtn;
    
    /** Botón para retirar dinero de una cuenta. */
    @FXML
    Button RetirarBtn;
    
    /** Botón para ingresar dinero en una cuenta. */
    @FXML
    Button IngresarBtn;
    
    /** Botón para transferir dinero entre cuentas. */
    @FXML
    Button TransferirBtn;
    
    /** Botón para acceder a otras operaciones bancarias. */
    @FXML
    Button OtrasOperacionesBtn;
    
    /** Radio botón para seleccionar euros como moneda de la cuenta. */
    @FXML
    RadioButton eur_option;
    
    /** Radio botón para seleccionar dólares como moneda de la cuenta. */
    @FXML
    RadioButton usd_option;
    
    /**
     * Inicializa el controlador. Este método se llama automáticamente después de cargar el archivo 
     * FXML y de inicializar los objetos {@code @FXML}. 
     */
    @FXML
    public void initialize(){
        usuario_actual.setText(App.banco.usuarioactivo.getUsuario());
    }
      
    /**
     * Cambia la moneda de la cuenta a euros.
     */
    public void cambiar_euro() {
       
    }
    
    /**
     * Cambia la moneda de la cuenta a dólares.
     */
    public void cambiar_dolar() {
    
    }
    
    /**
     * Cierra la sesión del usuario y vuelve a la pantalla de inicio de sesión.
     * 
     * @throws IOException Si se produce un error al cargar el archivo FXML de inicio de sesión.
     */
    @FXML
    private void cerrarSesion() throws IOException {
        App.banco.usuarioactivo=null;
        Usuarios.ListadeUsuarios.clear();
        Cuentas.ListadeCuentas.clear();
        Billetes.ListadeBilletes.clear();
        Movimientos.ListadeMovimientos.clear();
        App.setRoot("login");
    }
    
    /**
     * Abre la pantalla para retirar dinero de una cuenta.
     * 
     * @throws IOException Si se produce un error al cargar el archivo FXML de la pantalla de 
     * retirar dinero.
     */
    
    @FXML
    private void Retirar() throws IOException {
        App.setRoot("retirar");
    }
    
    /**
     * Abre la pantalla para ingresar dinero en una cuenta.
     * 
     * @throws IOException Si se produce un error al cargar el archivo FXML de la pantalla de 
     * ingresar dinero.
    */
    
    @FXML
    private void Ingresar() throws IOException {
        App.setRoot("ingresar");
    }
    
    /**
     * Abre la pantalla para tranferir dinero de una cuenta corriente a otra.
     * 
     * @throws IOException Si se produce un error al cargar el archivo FXML de la pantalla de 
     * transferir dinero.
     */
    
    @FXML
    private void Transferir() throws IOException {
        App.setRoot("transferir");
    }
    
    /**
     * Abre la pantalla para visualizar otras operaciones del cajero.
     * 
     * @throws IOException Si se produce un error al cargar el archivo FXML de la pantalla de 
     * otras operaciones del cajero.
     */
    
    @FXML
    private void OtrasOperaciones() throws IOException {
        App.setRoot("otras_operaciones");
    }
}
