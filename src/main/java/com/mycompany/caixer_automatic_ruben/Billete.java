package com.mycompany.caixer_automatic_ruben;

/**
 * El paquete com.mycompany.caixer_automatic_ruben contiene la clase Billete, que representa un billete con un valor
 * y una cantidad determinada.
 *
 * @author Rubén
 */

public class Billete {

    int valor; // El valor del billete.
    int cantidad; // La cantidad de billetes disponibles.

    /**
     * Crea un objeto Billete con el valor especificado y una cantidad inicial de cero.
     *
     * @param valor El valor del billete.
     */
    public Billete(int valor) {
        this.valor = valor;
    }

    /**
     * Obtiene el valor del billete.
     *
     * @return El valor del billete.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Establece el valor del billete.
     *
     * @param valor El valor del billete.
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

}
