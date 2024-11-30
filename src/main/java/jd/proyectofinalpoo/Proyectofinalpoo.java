package jd.proyectofinalpoo;

import Modelo.*;
import Vista.*;
import Controlador.*;
import java.time.LocalDate;

public class Proyectofinalpoo {
    public static void main(String[] args) {
        // 1. Crear vistas
        VistaHuesped vistaHuesped = new VistaHuesped();
        VistaAdministrador vistaAdministrador = new VistaAdministrador();

        // 2. Crear controladores
        ControladorHuesped controladorHuesped = new ControladorHuesped(vistaHuesped);
        ControladorAdministrador controladorAdministrador = new ControladorAdministrador(vistaAdministrador);

        // 3. Crear datos iniciales (habitaciones, servicios, huéspedes)
        Habitacion habitacion1 = new Habitacion(1, "Individual", 50.0, 1, "Habitación sencilla con TV y WiFi.");
        Habitacion habitacion2 = new Habitacion(2, "Doble", 100.0, 2, "Habitación doble con vista al mar.");
        Servicio servicioSpa = new Servicio("Spa", "Acceso al spa por 1 día", 30.0, 10);
        Servicio desayuno = new Servicio("Desayuno", "Desayuno continental incluido", 10.0, 20);

        // Crear un huésped
        Huesped huesped1 = new Huesped("Juan Pérez", "juan.perez@example.com", "1234567890", "juanp", "1234");
        
        // Crear un administrador
        Administrador admin1 = new Administrador("Admin Hotel", "admin@hotel.com", "0987654321", "admin", "admin123");

        // 4. Probar funcionalidades principales
        System.out.println("----- Bienvenido al Sistema de Gestión de Reservas -----");

        // Registrar un huésped
        controladorHuesped.registrarHuesped();

        // Mostrar historial del huésped (vacío inicialmente)
        vistaHuesped.mostrarHistorialReservas();

        // Crear una reserva
        Reserva reserva1 = new Reserva(101, huesped1, habitacion1, LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 5));
        huesped1.agregarReserva(reserva1);

        // Mostrar información de la reserva
        reserva1.mostrarInformacionReserva();

        // Probar la interacción del administrador
        controladorAdministrador.registrarAdministrador();
        admin1.gestionarHabitaciones();
        admin1.gestionarServicios();

        System.out.println("----- Fin de la prueba del sistema -----");
    }
}
