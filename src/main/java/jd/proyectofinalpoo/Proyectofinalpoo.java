package jd.proyectofinalpoo;

import Modelo.*;
import Vista.*;
import Controlador.*;
import java.util.ArrayList;

public class Proyectofinalpoo {
    public static void main(String[] args) {
        // Crear listas para los datos iniciales
        ArrayList<Huesped> huespedes = new ArrayList<>();
        ArrayList<Administrador> administradores = new ArrayList<>();
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        ArrayList<Servicio> servicios = new ArrayList<>();

        // Datos iniciales de huéspedes y administradores
        huespedes.add(new Huesped("Juan Pérez", "juan.perez@example.com", "1234567890", "juanp", "1234"));
        administradores.add(new Administrador("Admin Hotel", "admin@hotel.com", "0987654321", "admin", "admin123"));

        // Datos iniciales de habitaciones usando subclases
        habitaciones.add(new HabitacionIndividual(1, "Habitación individual con vista al jardín."));
        habitaciones.add(new HabitacionDoble(2, "Habitación doble con balcón."));
        habitaciones.add(new Suite(3, "Suite de lujo con jacuzzi y vista panorámica."));

        // Datos iniciales de servicios
        servicios.add(new Servicio("Spa", "Acceso al spa por 1 día", 30.0, 10));
        servicios.add(new Servicio("Desayuno", "Desayuno continental incluido", 10.0, 20));

        // Crear vistas
        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        VistaHuesped vistaHuesped = new VistaHuesped();
        VistaAdministrador vistaAdministrador = new VistaAdministrador();

        // Crear controladores
        ControladorHuesped controladorHuesped = new ControladorHuesped(vistaHuesped);
        ControladorAdministrador controladorAdministrador = new ControladorAdministrador(vistaAdministrador);

        // Crear controlador principal
        ControladorPrincipal controladorPrincipal = new ControladorPrincipal(
                vistaPrincipal,
                controladorHuesped,
                controladorAdministrador,
                huespedes,
                administradores,
                habitaciones,
                servicios
        );

        // Iniciar la aplicación
        controladorPrincipal.iniciar();
    }
}
