package Controlador;

import Modelo.*;
import Vista.VistaHuesped;
import java.time.LocalDate;
import java.util.List;

public class ControladorHuesped {
    private VistaHuesped vista;

    public ControladorHuesped(VistaHuesped vista) {
        this.vista = vista;
    }

    // Método para acceder a la vista
    public VistaHuesped getVista() {
        return this.vista;
    }

    // Mostrar el historial de reservas del huésped
    public void verHistorialReservas(Huesped huesped) {
        List<Reserva> historial = huesped.verHistorial();
        if (historial.isEmpty()) {
            vista.mostrarMensaje("No tiene reservas en el historial.");
        } else {
            vista.mostrarMensaje("----- Historial de Reservas -----");
            for (Reserva reserva : historial) {
                reserva.mostrarInformacionReserva();
            }
        }
    }

    // Crear una nueva reserva
    public void crearReserva(Huesped huesped, List<Habitacion> habitaciones, List<Servicio> servicios) {
        try {
            // Pedir fechas al usuario
            LocalDate fechaEntrada = vista.pedirFecha("Ingrese la fecha de entrada");
            LocalDate fechaSalida = vista.pedirFecha("Ingrese la fecha de salida");

            // Validar fechas
            if (!fechaEntrada.isBefore(fechaSalida)) {
                vista.mostrarMensaje("La fecha de salida debe ser posterior a la fecha de entrada.");
                return;
            }

            // Mostrar habitaciones disponibles
            vista.mostrarMensaje("Seleccione una habitación:");
            for (int i = 0; i < habitaciones.size(); i++) {
                Habitacion habitacion = habitaciones.get(i);
                vista.mostrarMensaje((i + 1) + ". " + habitacion.getDescripcion() + " - $" + habitacion.getPrecioNoche() + "/noche");
            }

            // Seleccionar una habitación
            int seleccionHabitacion = vista.leerNumero("Ingrese el número de la habitación deseada") - 1;
            if (seleccionHabitacion < 0 || seleccionHabitacion >= habitaciones.size()) {
                vista.mostrarMensaje("Selección no válida. Operación cancelada.");
                return;
            }

            Habitacion habitacionSeleccionada = habitaciones.get(seleccionHabitacion);

            // Crear reserva
            Reserva nuevaReserva = new Reserva(huesped.verHistorial().size() + 1, huesped, habitacionSeleccionada, fechaEntrada, fechaSalida);

            // Seleccionar servicios adicionales
            for (Servicio servicio : servicios) {
                if (vista.confirmarServicio(servicio.getNombreServicio())) {
                    nuevaReserva.agregarServicio(servicio);
                }
            }

            // Agregar reserva al huésped
            huesped.agregarReserva(nuevaReserva);
            vista.mostrarMensaje("Reserva creada con éxito:");
            nuevaReserva.mostrarInformacionReserva();

        } catch (Exception e) {
            vista.mostrarMensaje("Error al crear la reserva: " + e.getMessage());
        }
    }
}
