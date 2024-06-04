/**
 *
 * La clase Banco representa el modelo de un cajero automático y contiene métodos para realizar operaciones bancarias y gestiona los mensajes.
 *
 * @author Rubén
 */
package com.mycompany.caixer_automatic_ruben;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class Banco {

    /**
     * Usuario que ha iniciado sesión en el cajero automático.
     */
    public Usuario usuarioactivo = null;

    /**
     * Mensaje que se muestra en la interfaz de usuario.
     */
    public static String mostrarMensaje;

    /**
     * Detalle de la operación de retiro.
     */
    public static String detalleRetiro;

    /**
     * Detalle de la operación de consulta.
     */
    public static String detalleConsulta;

    /**
     * Detalle de los movimientos de la cuenta.
     */
    public static String detalleMovimientos;

    /**
     * Lee los datos de las cuentas, billetes, usuarios y movimientos desde sus
     * respectivos archivos.
     */
    public void leerdatos() {
        Cuentas.cargarCuentas();
        Billetes.cargarBilletes();
        Usuarios.cargarUsuarios();
        Movimientos.cargarMovimientos();
    }

    /**
     * Inicia sesión en el cajero automático con un usuario y una contraseña.
     *
     * @param Username nombre de usuario.
     * @param Password contraseña.
     */
    @FXML
    public void Login(String Username, String Password) {
        Usuario user = Usuarios.getUsuarioNombre(Username);
        if (user == null) {
            mostrarMensaje = "El usuario no existe.";
            return;
        }
        if (user.estaBloqueado()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Usuario bloqueado");
            alert.setHeaderText("Has excedido el número máximo de intentos fallidos.");
            alert.setContentText("Por favor, contacta con el servicio de soporte para desbloquear tu cuenta.");
            alert.showAndWait();

            return;
        }

        if (!Password.equals(user.getContraseña())) {
            mostrarMensaje = "Contraseña incorrecta.";
            user.aumentarIntentosFallidos();
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error de autenticación del usuario");
            alerta.setHeaderText("Usuario o contraseña incorrectos");
            alerta.setContentText("Por favor, inténtalo de nuevo");
            alerta.showAndWait();
            return;
        }

        user.reiniciarIntentosFallidos();
        Usuarios.guardarUsuarios();
        try {
            usuarioactivo = user;
            App.setRoot("banc");

        } catch (IOException e) {
            System.out.println("error.");
        }
    }

    /**
     * Transfiere dinero entre dos cuentas corrientes.
     *
     * @param Destino número de cuenta destino.
     * @param Origen número de cuenta origen.
     * @param Cantidad cantidad de dinero a transferir.
     */
    protected void Transferir(String Destino, String Origen, int Cantidad) {
        if (usuarioactivo == null) {
            return;
        }

        Cuenta cDestino = Cuentas.getNumeroCuenta(Destino);
        Cuenta cOrigen = Cuentas.getNumeroCuenta(Origen);

        if (cOrigen == null) {
            mostrarMensaje = "Por favor seleccione una cuenta.";
            return;
        }

        if (cDestino == null) {
            mostrarMensaje = "No se ha encontrado la cuenta destino";
            return;
        }

        if (!cDestino.getTipo().equals("Corriente")) {
            mostrarMensaje = "Solo se permiten transferencias entre cuentas corrientes.";
            return;
        }
        if (Cantidad == 0) {
            mostrarMensaje = "La cantidad a transferir no puede ser 0.";
            return;
        }

        if (cOrigen.getDinero() < Cantidad) {
            mostrarMensaje = "No tienes suficiente dinero.";
            return;
        }

        cOrigen.setDinero(cOrigen.getDinero() - Cantidad);
        cDestino.setDinero(cDestino.getDinero() + Cantidad);
        Movimientos.ListadeMovimientos.add(new Movimiento(Movimientos.getCantidadMovimientos(), cOrigen.getNumero(), "Transferencia", -Cantidad));
        Movimientos.ListadeMovimientos.add(new Movimiento(Movimientos.getCantidadMovimientos(), cDestino.getNumero(), "Transferencia", +Cantidad));
        Movimientos.guardarMovimientos();
        Cuentas.guardarCuentas();
        mostrarMensaje = "Transferencia realizada con exito.";

    }

    /**
     * Ingresa dinero en una cuenta.
     *
     * @param cuenta número de cuenta.
     * @param b200 cantidad de billetes de 200.
     * @param b100 cantidad de billetes de 100.
     * @param b50 cantidad de billetes de 50.
     * @param b20 cantidad de billetes de 20.
     * @param b10 cantidad de billetes de 10.
     * @param b5 cantidad de billetes de 5.
     */
    protected void Ingresar(String cuenta, int b200, int b100, int b50, int b20, int b10, int b5) {
        Cuenta CuentaSeleccionada;

        int dinero = b200 * 200 + b100 * 100 + b50 * 50 + b20 * 20 + b10 * 10 + b5 * 5;

        CuentaSeleccionada = Cuentas.getNumeroCuenta(cuenta);

        if (CuentaSeleccionada == null) {
            mostrarMensaje = "Por favor, seleccione una cuenta.";
            return;
        }
        if (dinero == 0) {
            mostrarMensaje = "La cantidad a ingresar no puede ser 0.";
            return;
        }
        CuentaSeleccionada.setDinero(CuentaSeleccionada.getDinero() + dinero);

        Movimientos.ListadeMovimientos.add(new Movimiento(Movimientos.getCantidadMovimientos(), CuentaSeleccionada.getNumero(), "Ingreso", dinero));
        Cuentas.guardarCuentas();
        Movimientos.guardarMovimientos();
        mostrarMensaje = "Ingreso realizado con exito.";
    }

    /**
     * Retira dinero de una cuenta.
     *
     * @param amount cantidad de dinero a retirar.
     * @param cuenta número de cuenta.
     */
    protected void Retirar(int amount, String cuenta) {
        Cuenta CuentaSeleccionada;
        CuentaSeleccionada = Cuentas.getNumeroCuenta(cuenta);
        if (CuentaSeleccionada == null) {
            mostrarMensaje = "Por favor, seleccione una cuenta";
            return;
        }
        if (amount == 0) {
            mostrarMensaje = "La cantidad a retirar no puede ser 0!";
            return;
        }

        if (CuentaSeleccionada.getDinero() < amount) {
            mostrarMensaje = "No tienes suficiente dinero!";
            return;
        }
        if (amount % 5 != 0 && amount % 10 != 0) {
            mostrarMensaje = "El cajero no acepta monedas!";
            return;
        }

        Movimientos.ListadeMovimientos.add(new Movimiento(Movimientos.getCantidadMovimientos(), CuentaSeleccionada.getNumero(), "Retiro", -amount));
        Cuentas.guardarCuentas();
        Movimientos.guardarMovimientos();
        mostrarMensaje = "El retiro ha sido realizado :)";

    }

    /**
     * Cambia la contraseña del usuario conectado.
     *
     * @param ActualPass contraseña actual del usuario.
     * @param NewPass nueva contraseña a establecer.
     * @param ConfirmPass confirmación de la nueva contraseña.
     */
    protected void CambiarContraseña(String ActualPass, String NewPass, String ConfirmPass) {
        if (!ActualPass.equals(usuarioactivo.getContraseña())) {
            mostrarMensaje = "Contraseña actual incorrecta!";
            return;
        }
        if (NewPass.equals("")) {
            mostrarMensaje = "No has introducido nueva contraseña!";
            return;
        }

        if (ActualPass.equals(NewPass)) {
            mostrarMensaje = "La nueva contraseña no puede ser la misma que la contraseña actual!";
            return;
        }
        if (!NewPass.equals(ConfirmPass)) {
            mostrarMensaje = "Las contraseñas deben coincidir!";
            return;
        }
        usuarioactivo.setContraseña(NewPass);
        Usuarios.guardarUsuarios();
        mostrarMensaje = "Se ha cambiado la contraseña correctamente.";

    }

    /**
     * Crea una cuenta de un determinado tipo para el usuario conectado.
     *
     * @param tipo tipo de cuenta a crear.
     */
    protected void CrearCuenta(String tipo) {
        String Numero = Cuenta.getFormato() + Cuentas.getCuentaTamaño();
        int UserId = usuarioactivo.getId();
        String Tipo = tipo;
        int Dinero = 0;
        Cuenta nuevaCuenta = new Cuenta(Numero, UserId, Tipo, Dinero);
        Cuentas.ListadeCuentas.add(nuevaCuenta);
        Cuentas.guardarCuentas();
        mostrarMensaje = "Cuenta creada.";

    }

    /**
     * Registra un nuevo usuario.
     *
     * @param Username nombre de usuario.
     * @param Contraseña contraseña del usuario.
     * @param ConfirmarContraseña confirmación de la contraseña.
     */
    protected void Registrarse(String Username, String Contraseña, String ConfirmarContraseña) {
        if (Username.isEmpty() || Contraseña.isEmpty() || ConfirmarContraseña.isEmpty()) {
            mostrarMensaje = "Faltan datos de registro!";
            return;
        }

        for (Usuario usuario : Usuarios.ListadeUsuarios) {
            if (Username.equals(usuario.getUsuario())) {
                mostrarMensaje = "El usuario ya existe!";
                return;
            }
        }

        if (!Contraseña.equals(ConfirmarContraseña)) {
            mostrarMensaje = "Las contraseñas deben coincidir!";
            return;
        }

        int userId = Usuarios.getCantidadUsuarios();    
        Usuario nuevoUsuario = new Usuario(userId, Username, Contraseña);
        Usuarios.ListadeUsuarios.add(nuevoUsuario);
        Usuarios.guardarUsuarios();
        mostrarMensaje = "Usuario creado correctamente.";
    }

    /**
     * Consulta la información de una cuenta.
     *
     * @param Cuenta número de cuenta a consultar.
     */

    protected void Consultar(String Cuenta) {
        Cuenta CuentaSeleccionada;
        CuentaSeleccionada = Cuentas.getNumeroCuenta(Cuenta);
        if (CuentaSeleccionada == null) {
            mostrarMensaje = "Por favor, seleccione una cuenta.";
            return;
        }
        detalleConsulta = "Cuenta: " + CuentaSeleccionada.getNumero() + "\n\nTipo: " + CuentaSeleccionada.getTipo() + "\n\nSaldo Actual: " + CuentaSeleccionada.getDinero() + " €";

        String mensajeMovimientos = "";
        for (Movimiento movimiento : Movimientos.getMovimientosCuentas(CuentaSeleccionada.getNumero())) {
            mensajeMovimientos += movimiento.getTipo() + "       " + movimiento.getImporte() + "\n";
        }
        mostrarMensaje = "";
        detalleMovimientos = mensajeMovimientos;

    }

}
