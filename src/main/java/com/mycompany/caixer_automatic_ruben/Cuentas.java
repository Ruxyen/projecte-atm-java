package com.mycompany.caixer_automatic_ruben;

/**
 *
 * Clase que representa la colección de cuentas del sistema. Contiene métodos
 * para cargar y guardar las cuentas desde un archivo CSV, así como para acceder
 * a las cuentas de un usuario específico y buscar una cuenta por su número.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cuentas {

    /**
     * Ruta del archivo CSV que almacena las cuentas.
     */
    private static final String Cuentas_csv = "/home/alumne/Escriptori/MazeBank/caixer_automatic_ruben/src/main/java/com/mycompany/caixer_automatic_ruben/csv/Cuentas.csv";

    /**
     * Lista de todas las cuentas del sistema.
     */
    public static ArrayList<Cuenta> ListadeCuentas = new ArrayList<Cuenta>();

    /**
     * Delimitador utilizado en el archivo CSV.
     */
    private static final String Delimitador = ";";

    /**
     * Carga las cuentas desde el archivo CSV.
     */
    public static void cargarCuentas() {
        try (BufferedReader reader = new BufferedReader(new FileReader(Cuentas_csv))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] celdas = line.split(Delimitador);
                int userId = Integer.parseInt(celdas[1]);
                int dinero = (int) Double.parseDouble(celdas[3]);
                if (celdas[2].equals("Corriente")) {
                    CuentaCorriente cc = new CuentaCorriente(celdas[0], userId, celdas[2], dinero);
                    cc.setMovimientos(Movimientos.getMovimientosCuentas(celdas[0]));
                    ListadeCuentas.add(cc);
                } else {
                    CuentaAhorro ce = new CuentaAhorro(celdas[0], userId, celdas[2], dinero);
                    ce.setMovimientos(Movimientos.getMovimientosCuentas(celdas[0]));
                    ListadeCuentas.add(ce);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    /**
     * Guarda las cuentas en el archivo CSV.
     */
    public static void guardarCuentas() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(Cuentas_csv));
            for (Cuenta cuenta : ListadeCuentas) {
                writer.write(String.valueOf(cuenta.getNumero()));
                writer.write(";");
                writer.write(String.valueOf(cuenta.getUserId()));
                writer.write(";");
                writer.write(String.valueOf(cuenta.getTipo()));
                writer.write(";");
                writer.write(String.valueOf(cuenta.getDinero()));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Devuelve una lista de todas las cuentas de un usuario específico.
     *
     * @param userId el ID del usuario cuyas cuentas se quieren obtener
     * @return una lista de todas las cuentas del usuario especificado
     */
    public static ArrayList<Cuenta> getCuentasUsuarios(int userId) {
        ArrayList<Cuenta> cuentasUsuario = new ArrayList<Cuenta>();

        for (Cuenta cuenta : ListadeCuentas) {

            if (cuenta.getUserId() == userId) {
                cuentasUsuario.add(cuenta);
            }
        }

        return cuentasUsuario;
    }

    /**
     * Devuelve una lista de los números de todas las cuentas de un usuario
     * específico.
     *
     * @param userId el ID del usuario cuyas cuentas se quieren obtener
     * @return una lista de los números de todas las cuentas del usuario
     * especificado
     */
    public static ArrayList<String> getCuentasUsuariosNumero(int userId) {
        ArrayList<String> cuentasUsuarioNumero = new ArrayList<String>();

        for (Cuenta cuenta : ListadeCuentas) {

            if (cuenta.getUserId() == userId) {
                cuentasUsuarioNumero.add(cuenta.getNumero());
            }
        }

        return cuentasUsuarioNumero;
    }

    /**
     * Devuelve una lista de los números de todas las cuentas corrientes de un
     * usuario específico.
     *
     * @param userId el ID del usuario cuyas cuentas corrientes se quieren
     * obtener
     * @return una lista de los números de todas las cuentas corrientes del
     * usuario especificado
     */
    public static ArrayList<String> getCuentasCorrientesNumero(int userId) {
        ArrayList<String> cuentasCorrientesUsuarioNumero = new ArrayList<String>();

        for (Cuenta cuenta : ListadeCuentas) {

            if (cuenta.getUserId() == userId && cuenta.getTipo().equals("Corriente")) {
                cuentasCorrientesUsuarioNumero.add(cuenta.getNumero());
            }
        }

        return cuentasCorrientesUsuarioNumero;
    }

    /**
     * Devuelve una cuenta con el número especificado.
     *
     * @param numeroCuenta el número de la cuenta que se desea obtener
     * @return la cuenta con el número especificado, o null si no se encuentra
     */
    public static Cuenta getNumeroCuenta(String numeroCuenta) {
        Cuenta cuentaUsuario = null;

        for (Cuenta cuenta : ListadeCuentas) {

            if (cuenta.getNumero().equals(numeroCuenta)) {
                cuentaUsuario = cuenta;
            }
        }

        return cuentaUsuario;
    }

    /**
     * Devuelve el tamaño de la lista de cuentas.
     *
     * @return el tamaño de la lista de cuentas
     */
    public static String getCuentaTamaño() {
        return String.valueOf(ListadeCuentas.size() + 1);
    }

}
