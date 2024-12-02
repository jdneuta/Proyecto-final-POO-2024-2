package Vista;

import java.util.Scanner;

public class VistaAdministrador {
    private Scanner scanner;

    public VistaAdministrador() {
        this.scanner = new Scanner(System.in);
    }

    // Mostrar el menú del administrador
    public int mostrarMenu() {
        System.out.println("\n--- Menú de Administrador ---");
        System.out.println("1. Gestionar habitaciones");
        System.out.println("2. Gestionar servicios");
        System.out.println("3. Generar reportes");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    // Mostrar mensaje para el administrador
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Leer texto para operaciones administrativas
    public String leerTexto(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.next();
    }

    // Leer número para operaciones administrativas
    public int leerNumero(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextInt();
    }
}
