/**
 *
 * Clase encargada de la gestión de los movimientos bancarios del sistema.
 */
package com.mycompany.caixer_automatic_ruben;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Rubén
 */
public class Movimientos {

    // Ruta del archivo csv que contiene los movimientos bancarios.
    private static final String Movimientos_csv = "C:\\Users\\ruben\\OneDrive\\Escritorio\\PROYECTOS\\Java\\projecte-atm-java\\src\\main\\java\\com\\mycompany\\caixer_automatic_ruben\\csv\\Movimientos.csv";

// Lista que contiene todos los movimientos bancarios.
    public static ArrayList<Movimiento> ListadeMovimientos = new ArrayList<Movimiento>();

// Separador utilizado en el archivo csv.
    private static final String Delimitador = ";";

    /**
     * Carga los movimientos bancarios desde el archivo csv a la lista de
     * movimientos.
     */
    public static void cargarMovimientos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(Movimientos_csv))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] celdas = line.split(Delimitador);
                int id = Integer.parseInt(celdas[0]);
                int dinero = (int) Double.parseDouble(celdas[3]);
                ListadeMovimientos.add(new Movimiento(id, celdas[1], celdas[2], dinero));
            }
        } catch (IOException e) {
            System.out.println("Error cargando movimientos");
        }
    }

    /**
     * Guarda los movimientos bancarios de la lista de movimientos en el archivo
     * csv.
     */
    public static void guardarMovimientos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Movimientos_csv))) {
            for (Movimiento movimiento : ListadeMovimientos) {
                writer.write(String.valueOf(movimiento.getId()));
                writer.write(";");
                writer.write(movimiento.getNumCuenta());
                writer.write(";");
                writer.write(movimiento.getTipo());
                writer.write(";");
                writer.write(String.valueOf(movimiento.getImporte()));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error guardando movimientos");
        }
    }

    /**
     * Obtiene todos los movimientos bancarios de una cuenta determinada.
     *
     * @param NumeroCuenta número de cuenta de la que se quieren obtener los
     * movimientos.
     * @return lista de los movimientos de la cuenta.
     */
    public static ArrayList<Movimiento> getMovimientosCuentas(String NumeroCuenta) {
        ArrayList<Movimiento> movimientosCuenta = new ArrayList<Movimiento>();

        for (Movimiento movimiento : ListadeMovimientos) {
            if (movimiento.getNumCuenta().equals(NumeroCuenta)) {
                movimientosCuenta.add(movimiento);
            }
        }
        return movimientosCuenta;
    }

    /**
     * Obtiene la cantidad de movimientos bancarios registrados.
     *
     * @return cantidad de movimientos bancarios registrados.
     */
    public static int getCantidadMovimientos() {
        return ListadeMovimientos.size() + 1;
    }

}
