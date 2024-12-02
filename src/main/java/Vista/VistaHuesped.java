package Vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class VistaHuesped {
    private Scanner scanner;

    // Constructor
    public VistaHuesped() {
        this.scanner = new Scanner(System.in);
    }

    // Mostrar el menú del huésped
    public int mostrarMenu() {
        System.out.println("\n--- Menú de Huésped ---");
        System.out.println("1. Ver historial de reservas");
        System.out.println("2. Crear nueva reserva");
        System.out.println("3. Modificar perfil");
        System.out.println("4. Salir");
        return leerNumero("Seleccione una opción");
    }

    // Mostrar un mensaje en pantalla
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Leer texto completo del usuario
    public String leerTexto(String mensaje) {
        System.out.print(mensaje + ": ");
        String input = scanner.nextLine();
        return input.trim(); // Elimina espacios en blanco al inicio y al final
    }

    // Leer un número entero del usuario con validación
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

    // Pedir una fecha al usuario y validarla
    public LocalDate pedirFecha(String mensaje) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (true) {
            try {
                System.out.print(mensaje + " (formato: yyyy-MM-dd): ");
                String input = scanner.nextLine().trim();
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha no válida. Por favor, ingrese una fecha en el formato correcto (yyyy-MM-dd).");
            }
        }
    }

    // Confirmar si el usuario desea agregar un servicio
    public boolean confirmarServicio(String nombreServicio) {
        while (true) {
            System.out.print("¿Desea agregar el servicio " + nombreServicio + "? (S/N): ");
            String respuesta = scanner.nextLine().trim();
            if (respuesta.equalsIgnoreCase("S")) {
                return true;
            } else if (respuesta.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Entrada no válida. Por favor, responda con 'S' o 'N'.");
            }
        }
    }
}
