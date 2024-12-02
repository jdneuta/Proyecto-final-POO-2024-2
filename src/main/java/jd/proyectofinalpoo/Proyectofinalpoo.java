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

        // Datos iniciales
        huespedes.add(new Huesped("Juan Pérez", "juan.perez@example.com", "1234567890", "juanp", "1234"));
        administradores.add(new Administrador("Admin Hotel", "admin@hotel.com", "0987654321", "admin", "admin123"));
        servicios.add(new Servicio("Spa", "Acceso al spa por 1 día", 30.0, 10));
        servicios.add(new Servicio("Desayuno", "Desayuno continental incluido", 10.0, 20));
        habitaciones.add(new Habitacion(1, "Doble", 100.0, 2, "Habitación doble con vista al mar."));
        habitaciones.add(new Habitacion(2, "Suite", 200.0, 4, "Suite de lujo con vista panorámica y jacuzzi."));

        // Crear vistas y controladores
        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        VistaHuesped vistaHuesped = new VistaHuesped();
        VistaAdministrador vistaAdministrador = new VistaAdministrador();
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
