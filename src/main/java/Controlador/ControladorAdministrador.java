package Controlador;

import Modelo.Habitacion;
import Modelo.Servicio;
import Vista.VistaAdministrador;
import java.util.List;

public class ControladorAdministrador {
    private VistaAdministrador vista;
    private ControladorHabitaciones controladorHabitaciones;
    private ControladorServicios controladorServicios;
    private ControladorReportes controladorReportes;

    public ControladorAdministrador(VistaAdministrador vista) {
        this.vista = vista;
        this.controladorHabitaciones = new ControladorHabitaciones(vista);
        this.controladorServicios = new ControladorServicios(vista);
        this.controladorReportes = new ControladorReportes(vista);
    }

    public VistaAdministrador getVista() {
        return this.vista;
    }

    public void gestionarMenu(List<Habitacion> habitaciones, List<Servicio> servicios) {
        boolean continuar = true;

        while (continuar) {
            int opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1: // Gestionar habitaciones
                    controladorHabitaciones.gestionarHabitaciones(habitaciones);
                    break;

                case 2: // Gestionar servicios
                    controladorServicios.gestionarServicios(servicios);
                    break;

                case 3: // Generar reportes
                    controladorReportes.generarReportes(habitaciones, servicios);
                    break;

                case 4: // Salir
                    continuar = false;
                    vista.mostrarMensaje("Saliendo del menú de administrador.");
                    break;

                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
