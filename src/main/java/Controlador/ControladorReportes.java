package Controlador;

import Modelo.Habitacion;
import Modelo.Servicio;
import Vista.VistaAdministrador;
import java.util.List;

public class ControladorReportes {
    private VistaAdministrador vista;

    public ControladorReportes(VistaAdministrador vista) {
        this.vista = vista;
    }

    public void generarReportes(List<Habitacion> habitaciones, List<Servicio> servicios) {
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

        vista.mostrarMensaje("Reporte generado con éxito.");
    }
}
