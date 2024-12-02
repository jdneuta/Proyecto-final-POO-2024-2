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
        return leerNumero("Seleccione una opción");
    }

    // Mostrar un mensaje
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Leer texto completo
    public String leerTexto(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine().trim();
    }

    // Leer un número entero
    public int leerNumero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje + ": ");
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }
    }
}
