package Controlador;

import Modelo.*;
import Vista.VistaHuesped;
import java.time.LocalDate;
import java.util.List;

public class ControladorReserva {
    private VistaHuesped vista;

    public ControladorReserva(VistaHuesped vista) {
        this.vista = vista;
    }

    public void crearReserva(Huesped huesped, List<Habitacion> habitaciones, List<Servicio> servicios) {
        try {
            LocalDate fechaEntrada = vista.pedirFecha("Ingrese la fecha de entrada");
            LocalDate fechaSalida = vista.pedirFecha("Ingrese la fecha de salida");

            if (!fechaEntrada.isBefore(fechaSalida)) {
                vista.mostrarMensaje("La fecha de salida debe ser posterior a la fecha de entrada.");
                return;
            }

            ValidadorReservas.validarFechasReserva(huesped, fechaEntrada, fechaSalida);

            vista.mostrarMensaje("Seleccione una habitación:");
            for (Habitacion habitacion : habitaciones) {
                if (habitacion.isDisponibilidad()) {
                    vista.mostrarMensaje(habitacion.mostrarInformacion());
                }
            }

            int seleccionHabitacion = vista.leerNumero("Ingrese el número de la habitación deseada") - 1;
            if (seleccionHabitacion < 0 || seleccionHabitacion >= habitaciones.size()) {
                vista.mostrarMensaje("Selección no válida. Operación cancelada.");
                return;
            }

            Habitacion habitacionSeleccionada = habitaciones.get(seleccionHabitacion);
            int noches = fechaSalida.getDayOfYear() - fechaEntrada.getDayOfYear();
            double precioTotal = habitacionSeleccionada.getPrecioNoche() * noches;

            vista.mostrarMensaje("El costo total para " + noches + " noches es: $" + precioTotal);

            Reserva nuevaReserva = new Reserva(
                    huesped.verHistorial().size() + 1,
                    huesped,
                    habitacionSeleccionada,
                    fechaEntrada,
                    fechaSalida
            );

            for (Servicio servicio : servicios) {
                if (vista.confirmarServicio(servicio.getNombreServicio())) {
                    nuevaReserva.agregarServicio(servicio);
                }
            }

            huesped.agregarReserva(nuevaReserva);
            habitacionSeleccionada.setDisponibilidad(false);
            vista.mostrarMensaje("Reserva creada con éxito:");
            nuevaReserva.mostrarInformacionReserva();

        } catch (Exception e) {
            vista.mostrarMensaje("Error al crear la reserva: " + e.getMessage());
        }
    }
}
