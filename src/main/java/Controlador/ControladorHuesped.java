package Controlador;

import Modelo.*;
import Vista.VistaHuesped;
import java.util.List;

public class ControladorHuesped {
    private VistaHuesped vista;
    private ControladorReserva controladorReserva;
    private ControladorPerfil controladorPerfil;

    public ControladorHuesped(VistaHuesped vista) {
        this.vista = vista;
        this.controladorReserva = new ControladorReserva(vista);
        this.controladorPerfil = new ControladorPerfil(vista);
    }

    public VistaHuesped getVista() {
        return this.vista;
    }

    public void gestionarMenuHuesped(Huesped huesped, List<Habitacion> habitaciones, List<Servicio> servicios) {
        boolean continuar = true;

        while (continuar) {
            int opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1: // Ver historial de reservas
                    verHistorialReservas(huesped);
                    break;

                case 2: // Crear nueva reserva
                    controladorReserva.crearReserva(huesped, habitaciones, servicios);
                    break;

                case 3: // Modificar perfil
                    controladorPerfil.modificarPerfil(huesped);
                    break;

                case 4: // Salir
                    continuar = false;
                    vista.mostrarMensaje("Saliendo del menú de huésped.");
                    break;

                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void verHistorialReservas(Huesped huesped) {
        List<Reserva> historial = huesped.verHistorial();
        if (historial.isEmpty()) {
            vista.mostrarMensaje("No tiene reservas en el historial.");
        } else {
            for (Reserva reserva : historial) {
                reserva.mostrarInformacionReserva();
            }
        }
    }
}
