package com.mycompany.caixer_automatic_ruben;

import java.util.ArrayList;

/**
 * La clase Cuenta representa una cuenta bancaria de un usuario.
 *
 * Contiene campos para el número de cuenta, el ID del usuario, el tipo de cuenta, el saldo de la cuenta y una lista de
 * movimientos de la cuenta.
 *
 * También contiene métodos getter y setter para cada campo y un método para obtener el formato del número de cuenta.
 *
 * @autor Rubén
 */
public class Cuenta {

    /** El número de cuenta. */
    private String numero;

    /** El ID del usuario. */
    private int userId;

    /** El tipo de cuenta (corriente o ahorro). */
    private String tipo;

    /** El saldo de la cuenta. */
    private int dinero;

    /** La lista de movimientos de la cuenta. */
    ArrayList<Movimiento> movimientos;

    /** El formato del número de cuenta. */
    private static final String Formato = "ES98 2038 5778 9800 0001 230";

    /**
     * Crea una nueva instancia de la clase Cuenta con el número de cuenta, el ID de usuario, el tipo de cuenta y el
     * saldo de la cuenta especificados.
     *
     * @param numero el número de cuenta.
     * @param userId el ID de usuario.
     * @param tipo el tipo de cuenta (corriente o ahorro).
     * @param dinero el saldo de la cuenta.
     */
    public Cuenta(String numero, int userId, String tipo, int dinero) {
        this.numero = numero;
        this.userId = userId;
        this.tipo = tipo;
        this.dinero = dinero;
    }

    /**
     * Devuelve el número de cuenta.
     *
     * @return el número de cuenta.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de cuenta.
     *
     * @param numero el número de cuenta.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Devuelve el ID de usuario.
     *
     * @return el ID de usuario.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Establece el ID de usuario.
     *
     * @param userId el ID de usuario.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Devuelve el tipo de cuenta.
     *
     * @return el tipo de cuenta (corriente o ahorro).
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de cuenta.
     *
     * @param tipo el tipo de cuenta (corriente o ahorro).
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve el saldo de la cuenta.
     *
     * @return el saldo de la cuenta.
     */
    public int getDinero() {
        return dinero;
    }

    /**
     * Establece el saldo de la cuenta.
     *
     * @param dinero el saldo de la cuenta.
     */
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    /**
     * Devuelve el formato del número de cuenta.
     *
     * @return el formato del número de cuenta.
     */
    public static String getFormato() {
        return Formato;
    }
    /**
     * Devuelve la lista de movimientos de la cuenta.
     *
     * @return la lista de movimientos de la cuenta.
     */
    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }

    /**
     * Establece la lista de movimientos de la cuenta.
     *
     * @param movimientos la lista de movimientos de la cuenta.
     */
    public void setMovimientos(ArrayList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

}
