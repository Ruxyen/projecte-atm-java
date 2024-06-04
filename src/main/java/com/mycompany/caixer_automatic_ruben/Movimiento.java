/*
Clase que representa un movimiento bancario en una cuenta.
Contiene información como el identificador del movimiento, el número de cuenta afectada,
el tipo de movimiento (ingreso o retirada) y el importe de la operación.
@author Rubén
 */
package com.mycompany.caixer_automatic_ruben;

public class Movimiento {

    private int id;
    private String numCuenta;
    private String tipo;
    private int importe;

    /**
     * Crea un objeto Movimiento con los datos proporcionados.
     *
     * @param id el identificador del movimiento.
     * @param numCuenta el número de cuenta afectada por el movimiento.
     * @param tipo el tipo de movimiento (ingreso o retirada).
     * @param importe el importe de la operación.
     */
    public Movimiento(int id, String numCuenta, String tipo, int importe) {
        this.id = id;
        this.numCuenta = numCuenta;
        this.tipo = tipo;
        this.importe = importe;
    }

    /**
     * Devuelve el identificador del movimiento.
     *
     * @return el identificador del movimiento.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del movimiento.
     *
     * @param id el identificador del movimiento a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el número de cuenta afectada por el movimiento.
     *
     * @return el número de cuenta afectada por el movimiento.
     */
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * Establece el número de cuenta afectada por el movimiento.
     *
     * @param numCuenta el número de cuenta a establecer.
     */
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    /**
     * Devuelve el tipo de movimiento (ingreso o retirada).
     *
     * @return el tipo de movimiento.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de movimiento (ingreso o retirada).
     *
     * @param tipo el tipo de movimiento a establecer.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve el importe de la operación.
     *
     * @return el importe de la operación.
     */
    public int getImporte() {
        return importe;
    }

    /**
     * Establece el importe de la operación.
     *
     * @param importe el importe de la operación a establecer.
     */
    public void setImporte(int importe) {
        this.importe = importe;
    }

}
