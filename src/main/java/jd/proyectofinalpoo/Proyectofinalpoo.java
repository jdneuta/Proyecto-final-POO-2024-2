package jd.proyectofinalpoo;

import Modelo.*;
import Vista.*;
import Controlador.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Proyectofinalpoo {
    // Listas para almacenar usuarios
    private static ArrayList<Huesped> huespedes = new ArrayList<>();
    private static ArrayList<Administrador> administradores = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear vistas y controladores
        VistaHuesped vistaHuesped = new VistaHuesped();
        VistaAdministrador vistaAdministrador = new VistaAdministrador();
        ControladorHuesped controladorHuesped = new ControladorHuesped(vistaHuesped);
        ControladorAdministrador controladorAdministrador = new ControladorAdministrador(vistaAdministrador);

        // Datos iniciales
        administradores.add(new Administrador("Admin Hotel", "admin@hotel.com", "0987654321", "admin", "admin123"));
        huespedes.add(new Huesped("Juan Pérez", "juan.perez@example.com", "1234567890", "juanp", "1234"));

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n----- Menú Principal -----");
            System.out.println("1. Ingresar como huésped");
            System.out.println("2. Ingresar como administrador");
            System.out.println("3. Crear un nuevo usuario");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1: // Ingresar como huésped
                    System.out.print("Ingrese su usuario: ");
                    String usuarioH = scanner.nextLine();
                    System.out.print("Ingrese su contraseña: ");
                    String contrasenaH = scanner.nextLine();
                    Huesped huesped = validarHuesped(usuarioH, contrasenaH);

                    if (huesped != null) {
                        menuHuesped(huesped, controladorHuesped, scanner);
                    } else {
                        System.out.println("Usuario o contraseña incorrectos.");
                    }
                    break;

                case 2: // Ingresar como administrador
                    System.out.print("Ingrese su usuario: ");
                    String usuarioA = scanner.nextLine();
                    System.out.print("Ingrese su contraseña: ");
                    String contrasenaA = scanner.nextLine();
                    Administrador admin = validarAdministrador(usuarioA, contrasenaA);

                    if (admin != null) {
                        menuAdministrador(admin, controladorAdministrador, scanner);
                    } else {
                        System.out.println("Usuario o contraseña incorrectos.");
                    }
                    break;

                case 3: // Crear un nuevo usuario
                    System.out.println("Seleccione el tipo de usuario:");
                    System.out.println("1. Huesped");
                    System.out.println("2. Administrador");
                    int tipoUsuario = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    crearUsuario(tipoUsuario, scanner);
                    break;

                case 4: // Salir
                    continuar = false;
                    System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    // Validar huésped
    private static Huesped validarHuesped(String usuario, String contrasena) {
        for (Huesped h : huespedes) {
            if (h.getUsuario().equals(usuario) && h.getContrasena().equals(contrasena)) {
                return h;
            }
        }
        return null;
    }

    // Validar administrador
    private static Administrador validarAdministrador(String usuario, String contrasena) {
        for (Administrador a : administradores) {
            if (a.getUsuario().equals(usuario) && a.getContrasena().equals(contrasena)) {
                return a;
            }
        }
        return null;
    }

    // Crear un nuevo usuario
    private static void crearUsuario(int tipoUsuario, Scanner scanner) {
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su correo: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese su teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese su usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        if (tipoUsuario == 1) { // Crear huésped
            Huesped nuevoHuesped = new Huesped(nombre, correo, telefono, usuario, contrasena);
            huespedes.add(nuevoHuesped);
            System.out.println("Huésped creado con éxito.");
        } else if (tipoUsuario == 2) { // Crear administrador
            Administrador nuevoAdmin = new Administrador(nombre, correo, telefono, usuario, contrasena);
            administradores.add(nuevoAdmin);
            System.out.println("Administrador creado con éxito.");
        } else {
            System.out.println("Tipo de usuario no válido.");
        }
    }

    // Menú del huésped
    private static void menuHuesped(Huesped huesped, ControladorHuesped controlador, Scanner scanner) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menú de Huésped ---");
            System.out.println("1. Ver historial de reservas");
            System.out.println("2. Modificar perfil");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    controlador.vistaHuesped().mostrarHistorialReservas();
                    break;
                case 2:
                    controlador.vistaHuesped().modificar();
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // Menú del administrador
    private static void menuAdministrador(Administrador admin, ControladorAdministrador controlador, Scanner scanner) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menú de Administrador ---");
            System.out.println("1. Gestionar habitaciones");
            System.out.println("2. Gestionar servicios");
            System.out.println("3. Generar reporte");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    admin.gestionarHabitaciones();
                    break;
                case 2:
                    admin.gestionarServicios();
                    break;
                case 3:
                    admin.generarReporte();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
