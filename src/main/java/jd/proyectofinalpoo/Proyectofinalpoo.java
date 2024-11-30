import Vista.VistaHuesped;
import Vista.VistaAdministrador;
import Controlador.ControladorHuesped;
import Controlador.ControladorAdministrador;
import Modelo.Hotel;

public class Proyectofinalpoo {
    public static void main(String[] args) {
        // Crear la instancia del hotel
        Hotel hotel = new Hotel();

        // Crear instancias de las vistas
        VistaHuesped vistaHuesped = new VistaHuesped();
        VistaAdministrador vistaAdministrador = new VistaAdministrador();

        // Crear instancias de los controladores
        ControladorHuesped controladorHuesped = new ControladorHuesped(vistaHuesped, hotel);
        ControladorAdministrador controladorAdministrador = new ControladorAdministrador(vistaAdministrador, hotel);

        // Simulación de interacciones
        System.out.println("=== Bienvenido al Sistema de Gestión de Reservas del Hotel ===");

        // Ejemplo de uso del controlador de huésped
        System.out.println("\n=== Controlador Huesped ===");
        controladorHuesped.mostrarDisponibilidad(); // Muestra habitaciones disponibles
        controladorHuesped.realizarReserva(); // Realiza una reserva
        controladorHuesped.verHistorial(); // Muestra el historial de reservas

        // Ejemplo de uso del controlador de administrador
        System.out.println("\n=== Controlador Administrador ===");
        controladorAdministrador.registrarHabitacion(); // Registra una nueva habitación
        controladorAdministrador.modificarHabitacion(); // Modifica una habitación existente
        controladorAdministrador.gestionarReservas(); // Gestiona reservas

        // Aquí puedes agregar más lógica para simular el funcionamiento del sistema
    }
}