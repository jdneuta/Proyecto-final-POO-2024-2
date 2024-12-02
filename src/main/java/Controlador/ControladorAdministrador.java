package Controlador;

import Modelo.*;
import Vista.VistaAdministrador;
import java.util.List;

public class ControladorAdministrador {
    private VistaAdministrador vista;

    public ControladorAdministrador(VistaAdministrador vista) {
        this.vista = vista;
    }

    // Método para acceder a la vista
    public VistaAdministrador getVista() {
        return this.vista;
    }

    // Método para gestionar el menú del administrador
    public void gestionarMenu(List<Habitacion> habitaciones, List<Servicio> servicios) {
        boolean continuar = true;

        while (continuar) {
            int opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1: // Gestionar habitaciones
                    gestionarHabitaciones(habitaciones);
                    break;

                case 2: // Gestionar servicios
                    gestionarServicios(servicios);
                    break;

                case 3: // Generar reportes
                    generarReportes(habitaciones, servicios);
                    break;

                case 4: // Salir
                    continuar = false;
                    vista.mostrarMensaje("Saliendo del menú de administrador.");
                    break;

                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
    }

    // Método para gestionar habitaciones
    private void gestionarHabitaciones(List<Habitacion> habitaciones) {
        vista.mostrarMensaje("Gestión de habitaciones:");
        for (Habitacion habitacion : habitaciones) {
            vista.mostrarMensaje("ID: " + habitacion.getId() + ", Tipo: " + habitacion.getTipo() +
                    ", Precio por noche: $" + habitacion.getPrecioNoche() +
                    ", Capacidad: " + habitacion.getCapacidadMaxima() +
                    ", Descripción: " + habitacion.getDescripcion());
        }

        vista.mostrarMensaje("Esta funcionalidad puede ampliarse para agregar, modificar o eliminar habitaciones.");
    }

    // Método para gestionar servicios
    private void gestionarServicios(List<Servicio> servicios) {
        vista.mostrarMensaje("Gestión de servicios:");
        for (Servicio servicio : servicios) {
            vista.mostrarMensaje("Servicio: " + servicio.getNombreServicio() +
                    ", Descripción: " + servicio.getDescripcion() +
                    ", Precio adicional: $" + servicio.getCostoAdicional() +
                    ", Disponibles: " + servicio.getCantidadDisponible());
        }

        vista.mostrarMensaje("Esta funcionalidad puede ampliarse para agregar, modificar o eliminar servicios.");
    }

    // Método para generar reportes
    private void generarReportes(List<Habitacion> habitaciones, List<Servicio> servicios) {
        vista.mostrarMensaje("--- Reporte de Habitaciones ---");
        for (Habitacion habitacion : habitaciones) {
            vista.mostrarMensaje("ID: " + habitacion.getId() +
                    ", Tipo: " + habitacion.getTipo() +
                    ", Estado: " + (habitacion.isDisponibilidad() ? "Disponible" : "Ocupada"));
        }

        vista.mostrarMensaje("--- Reporte de Servicios ---");
        for (Servicio servicio : servicios) {
            vista.mostrarMensaje("Servicio: " + servicio.getNombreServicio() +
                    ", Disponibles: " + servicio.getCantidadDisponible());
        }

        vista.mostrarMensaje("Esta funcionalidad puede ampliarse con estadísticas avanzadas.");
    }
}
