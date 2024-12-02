package Vista;

import java.time.LocalDate;
import java.util.Scanner;

public class VistaHuesped {
    private Scanner scanner;

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
        System.out.print("Seleccione una opción: ");
        return leerNumero("Ingrese una opción válida");
    }

    // Pedir fecha al usuario
    public LocalDate pedirFecha(String mensaje) {
        LocalDate fecha = null;
        boolean fechaValida = false;

        while (!fechaValida) {
            try {
                System.out.print(mensaje + " (YYYY-MM-DD): ");
                String inputFecha = scanner.next();
                fecha = LocalDate.parse(inputFecha);
                fechaValida = true;
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Intente nuevamente.");
            }
        }
        return fecha;
    }

    // Confirmar selección de un servicio
    public boolean confirmarServicio(String nombreServicio) {
        System.out.print("¿Desea agregar el servicio " + nombreServicio + "? (S/N): ");
        String respuesta = scanner.next();
        return respuesta.equalsIgnoreCase("S");
    }

    // Leer un número entero con validación
    public int leerNumero(String mensaje) {
        int numero = -1;
        boolean numeroValido = false;

        while (!numeroValido) {
            try {
                System.out.print(mensaje + ": ");
                numero = Integer.parseInt(scanner.next());
                numeroValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }

        return numero;
    }

    // Mostrar mensaje
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
