package Controlador;

import Modelo.*;
import Vista.*;
import java.util.ArrayList;

public class ControladorPrincipal {
    private VistaPrincipal vistaPrincipal;
    private ControladorHuesped controladorHuesped;
    private ControladorAdministrador controladorAdministrador;
    private ArrayList<Huesped> huespedes;
    private ArrayList<Administrador> administradores;
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Servicio> servicios;

    public ControladorPrincipal(VistaPrincipal vistaPrincipal,
                                ControladorHuesped controladorHuesped,
                                ControladorAdministrador controladorAdministrador,
                                ArrayList<Huesped> huespedes,
                                ArrayList<Administrador> administradores,
                                ArrayList<Habitacion> habitaciones,
                                ArrayList<Servicio> servicios) {
        this.vistaPrincipal = vistaPrincipal;
        this.controladorHuesped = controladorHuesped;
        this.controladorAdministrador = controladorAdministrador;
        this.huespedes = huespedes;
        this.administradores = administradores;
        this.habitaciones = habitaciones;
        this.servicios = servicios;
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            int opcion = vistaPrincipal.mostrarMenuPrincipal();

            switch (opcion) {
                case 1: // Ingresar como huésped
                    ingresarComoHuesped();
                    break;

                case 2: // Ingresar como administrador
                    ingresarComoAdministrador();
                    break;

                case 3: // Crear un nuevo usuario
                    crearNuevoUsuario();
                    break;

                case 4: // Salir
                    continuar = false;
                    vistaPrincipal.mostrarMensaje("Saliendo del sistema. ¡Hasta pronto!");
                    break;

                default:
                    vistaPrincipal.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void ingresarComoHuesped() {
        String usuarioH = vistaPrincipal.leerTexto("Ingrese su usuario");
        String contrasenaH = vistaPrincipal.leerTexto("Ingrese su contraseña");
        Huesped huesped = validarHuesped(usuarioH, contrasenaH);

        if (huesped != null) {
            controladorHuesped.getVista().mostrarMensaje("Bienvenido, " + huesped.getNombre());
            controladorHuesped.crearReserva(huesped, habitaciones, servicios);
        } else {
            vistaPrincipal.mostrarMensaje("Usuario o contraseña incorrectos.");
        }
    }

    private void ingresarComoAdministrador() {
        String usuarioA = vistaPrincipal.leerTexto("Ingrese su usuario");
        String contrasenaA = vistaPrincipal.leerTexto("Ingrese su contraseña");
        Administrador admin = validarAdministrador(usuarioA, contrasenaA);

        if (admin != null) {
            controladorAdministrador.getVista().mostrarMensaje("Bienvenido, " + admin.getNombre());
            controladorAdministrador.gestionarMenu(habitaciones, servicios);
        } else {
            vistaPrincipal.mostrarMensaje("Usuario o contraseña incorrectos.");
        }
    }

    private void crearNuevoUsuario() {
        vistaPrincipal.mostrarMensaje("Seleccione el tipo de usuario:");
        vistaPrincipal.mostrarMensaje("1. Huésped");
        vistaPrincipal.mostrarMensaje("2. Administrador");
        int tipoUsuario = Integer.parseInt(vistaPrincipal.leerTexto("Ingrese su opción"));

        String nombre = vistaPrincipal.leerTexto("Ingrese su nombre");
        String correo = vistaPrincipal.leerTexto("Ingrese su correo");
        String telefono = vistaPrincipal.leerTexto("Ingrese su teléfono");
        String usuario = vistaPrincipal.leerTexto("Ingrese su usuario");
        String contrasena = vistaPrincipal.leerTexto("Ingrese su contraseña");

        if (tipoUsuario == 1) { // Crear huésped
            Huesped nuevoHuesped = new Huesped(nombre, correo, telefono, usuario, contrasena);
            huespedes.add(nuevoHuesped);
            vistaPrincipal.mostrarMensaje("Huésped creado con éxito.");
        } else if (tipoUsuario == 2) { // Crear administrador
            Administrador nuevoAdmin = new Administrador(nombre, correo, telefono, usuario, contrasena);
            administradores.add(nuevoAdmin);
            vistaPrincipal.mostrarMensaje("Administrador creado con éxito.");
        } else {
            vistaPrincipal.mostrarMensaje("Tipo de usuario no válido.");
        }
    }

    private Huesped validarHuesped(String usuario, String contrasena) {
        for (Huesped h : huespedes) {
            if (h.getUsuario().equals(usuario) && h.getContrasena().equals(contrasena)) {
                return h;
            }
        }
        return null;
    }

    private Administrador validarAdministrador(String usuario, String contrasena) {
        for (Administrador a : administradores) {
            if (a.getUsuario().equals(usuario) && a.getContrasena().equals(contrasena)) {
                return a;
            }
        }
        return null;
    }
}
