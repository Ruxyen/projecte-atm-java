package com.mycompany.caixer_automatic_ruben;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase encargada de la gestión de los usuarios del sistema.
 * Permite cargar, guardar y buscar usuarios.
 * Además, cuenta con un ArrayList que almacena todos los usuarios registrados.
 * 
 * @author Rubén
 */
public class Usuarios {
  
  // Ruta del archivo CSV que contiene la información de los usuarios
  private static final String Usuarios_csv = "C:\\Users\\ruben\\OneDrive\\Escritorio\\PROYECTOS\\Java\\projecte-atm-java\\src\\main\\java\\com\\mycompany\\caixer_automatic_ruben\\csv\\Usuarios.csv";
  
  // ArrayList que almacena todos los usuarios registrados
  public static ArrayList<Usuario> ListadeUsuarios = new ArrayList<Usuario>();
  
  // Delimitador utilizado en el archivo CSV
  private static final String Delimitador = ";";
  
  /**
   * Carga los usuarios desde el archivo CSV y los almacena en el ArrayList.
   */
  public static void cargarUsuarios() {
    try (BufferedReader reader = new BufferedReader(new FileReader(Usuarios_csv))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] fields = line.split(Delimitador);
        int userId = Integer.parseInt(fields[0]);
        Usuario u = new Usuario(userId, fields[1], fields[2]);
        u.setCuentas(Cuentas.getCuentasUsuarios(userId));
        ListadeUsuarios.add(u);
      }
    } catch (FileNotFoundException e) {
      System.out.println("Archivo no encontrado.");
    } catch (IOException e) {
      System.out.println("Error al leer el archivo.");
    }
  }
  
  /**
   * Guarda los usuarios del ArrayList en el archivo CSV.
   */
  public static void guardarUsuarios() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(Usuarios_csv))) {
      for (Usuario usuario : ListadeUsuarios) {
        writer.write(String.valueOf(usuario.getId()));
        writer.write(Delimitador);
        writer.write(String.valueOf(usuario.getUsuario()));
        writer.write(Delimitador);
        writer.write(String.valueOf(usuario.getContraseña()));
        writer.write(Delimitador);
        writer.newLine();
      }
    } catch (IOException e) {
      System.out.println("Error al escribir en el archivo.");
    }
  }
    
  /**
   * Busca un usuario por su nombre de usuario.
   * @param username Nombre de usuario del usuario buscado.
   * @return El usuario con el nombre de usuario especificado, o null si no se encuentra.
   */
  public static Usuario getUsuarioNombre(String username) {
    Usuario u = null;
    for (Usuario usuario : ListadeUsuarios) {
      if (usuario.getUsuario().equals(username)) {
        u = usuario;
        break;
      }
    }
    return u;   
  }
    
  /**
   * Obtiene la cantidad de usuarios registrados.
   * @return La cantidad de usuarios registrados.
   */
  public static int getCantidadUsuarios() {
    return ListadeUsuarios.size();
  }  
}
