package Vista;

import java.util.Scanner;

public class VistaPrincipal {
    private Scanner scanner;

    public VistaPrincipal() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenuPrincipal() {
        System.out.println("\n----- Menú Principal -----");
        System.out.println("1. Ingresar como huésped");
        System.out.println("2. Ingresar como administrador");
        System.out.println("3. Crear un nuevo usuario");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        return leerNumero("Ingrese una opción válida");
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.next();
    }

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

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
