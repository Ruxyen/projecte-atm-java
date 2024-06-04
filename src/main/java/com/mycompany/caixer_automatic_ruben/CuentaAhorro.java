package com.mycompany.caixer_automatic_ruben;

 /* El paquete com.mycompany.caixer_automatic_ruben contiene la clase CuentaAhorro, que es una subclase de Cuenta y
 * representa una cuenta de ahorro.
 *
 * La clase hereda los campos y métodos de la clase Cuenta y no tiene campos o métodos adicionales.
 *
 * Cuando se crea una cuenta de ahorro, se llama al constructor de la superclase Cuenta con los mismos argumentos.
 *
 * @author Rubén
 */
public class CuentaAhorro extends Cuenta {

    /**
     * Crea una nueva cuenta de ahorro con el número de cuenta, el identificador de usuario, el tipo de cuenta y el
     * saldo especificados.
     *
     * @param numero el número de cuenta.
     * @param userId el identificador de usuario.
     * @param tipo el tipo de cuenta.
     * @param dinero el saldo de la cuenta.
     */
    public CuentaAhorro(String numero, int userId, String tipo, int dinero) {
        super(numero, userId, tipo, dinero);
    }

}

