package com.mycompany.caixer_automatic_ruben;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * El paquete com.mycompany.caixer_automatic_ruben contiene la clase Billetes, que se encarga de cargar y guardar los
 * billetes en un archivo CSV.
 *
 * También contiene una lista de objetos Billete.
 *
 * El archivo CSV debe tener una columna con los valores de los billetes.
 *
 * El delimitador que separa las columnas en el archivo CSV es ";"
 *
 * La ruta del archivo CSV se encuentra en la constante Billetes_csv.
 *
 * La lista de billetes se encuentra en la constante ListadeBilletes.
 *
 * @author Rubén
 */

public class Billetes {

    /** La ruta del archivo CSV de los billetes. */
    private static final String Billetes_csv = "C:\\Users\\ruben\\OneDrive\\Escritorio\\PROYECTOS\\Java\\projecte-atm-java\\src\\main\\java\\com\\mycompany\\caixer_automatic_ruben\\csv\\Billets.csv";

    /** La lista de billetes. */
    public static ArrayList<Billete> ListadeBilletes = new ArrayList<Billete>();

    /** El delimitador utilizado en el archivo CSV. */
    private static final String Delimitador = ";";

    /**
     * Carga los billetes desde el archivo CSV y los agrega a la lista de billetes.
     *
     * Si el archivo no existe o hay un error al leer el archivo, se mostrará un mensaje en la consola.
     */
    public static void cargarBilletes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(Billetes_csv))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] celdas = line.split(Delimitador);
                int valor = Integer.parseInt(celdas[0]);
                ListadeBilletes.add(new Billete(valor));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo CSV no encontrado, cambia la ruta");
        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    /**
     * Guarda los billetes de la lista de billetes en el archivo CSV.
     *
     * Si hay un error al escribir en el archivo, se mostrará un mensaje en la consola.
     */
    public static void guardarBilletes() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(Billetes_csv));
            for (Billete billet : ListadeBilletes) {
                writer.write(String.valueOf(billet.getValor()));
                writer.write(Delimitador);
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

}
