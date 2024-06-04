/**
 *
 * Clase que representa un usuario del sistema.
 */
package com.mycompany.caixer_automatic_ruben;

import java.util.ArrayList;

/**
 *
 * @author Rubén
 */
public class Usuario {

    private int id;
    private String usuario;
    private String contraseña;
    private int intentosFallidos;
    ArrayList<Cuenta> cuentas;

    /**
     * Constructor de la clase Usuario.
     *
     * @param id Identificador del usuario.
     * @param usuario Nombre de usuario.
     * @param contraseña Contraseña del usuario.
     */
    public Usuario(int id, String usuario, String contraseña) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.intentosFallidos = 0;
    }

    /**
     * Devuelve el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param Usuario El nombre de usuario a establecer.
     */
    public void setUsuario(String Usuario) {
        this.usuario = Usuario;
    }

    /**
     * Devuelve la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param Contraseña La contraseña del usuario a establecer.
     */
    public void setContraseña(String Contraseña) {
        this.contraseña = Contraseña;
    }

    /**
     * Devuelve el identificador del usuario.
     *
     * @return El identificador del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del usuario.
     *
     * @param id El identificador del usuario a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece las cuentas asociadas al usuario.
     *
     * @param cuentas Las cuentas asociadas al usuario.
     */
    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    /**
     * Devuelve las cuentas asociadas al usuario.
     *
     * @return Las cuentas asociadas al usuario.
     */
    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    /**
     * Incrementa en 1 el contador de intentos fallidos de inicio de sesión.
     */
    public void aumentarIntentosFallidos() {
        intentosFallidos++;
    }

    /**
     * Reinicia el contador de intentos fallidos de inicio de sesión.
     */
    public void reiniciarIntentosFallidos() {
        intentosFallidos = 0;
    }

    /**
     * Indica si el usuario está bloqueado por exceso de intentos fallidos de
     * inicio de sesión.
     *
     * @return true si el usuario está bloqueado, false en caso contrario.
     */
    public boolean estaBloqueado() {
        return intentosFallidos >= 3;
    }

}
