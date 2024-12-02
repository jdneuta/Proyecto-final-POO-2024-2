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

    public VistaHuesped getVista() {
        return this.vista;
    }

    public void crearReserva(Huesped huesped, List<Habitacion> habitaciones, List<Servicio> servicios) {
        try {
            // Pedir fechas al usuario
            LocalDate fechaEntrada = vista.pedirFecha("Ingrese la fecha de entrada");
            LocalDate fechaSalida = vista.pedirFecha("Ingrese la fecha de salida");

            if (!fechaEntrada.isBefore(fechaSalida)) {
                vista.mostrarMensaje("La fecha de salida debe ser posterior a la fecha de entrada.");
                return;
            }

            // Mostrar habitaciones disponibles
            vista.mostrarMensaje("Seleccione una habitación:");
            for (Habitacion habitacion : habitaciones) {
                if (habitacion.isDisponibilidad()) {
                    vista.mostrarMensaje(habitacion.mostrarInformacion());
                }
            }

            // Seleccionar una habitación
            int seleccionHabitacion = vista.leerNumero("Ingrese el número de la habitación deseada") - 1;
            if (seleccionHabitacion < 0 || seleccionHabitacion >= habitaciones.size()) {
                vista.mostrarMensaje("Selección no válida. Operación cancelada.");
                return;
            }

            Habitacion habitacionSeleccionada = habitaciones.get(seleccionHabitacion);

            // Calcular noches
            int noches = fechaSalida.getDayOfYear() - fechaEntrada.getDayOfYear();

            // Calcular precio
            double precioTotal = habitacionSeleccionada.calcularPrecio(noches);
            vista.mostrarMensaje("El costo total para " + noches + " noches es: $" + precioTotal);

            // Crear reserva
            Reserva nuevaReserva = new Reserva(
                    huesped.verHistorial().size() + 1,
                    huesped,
                    habitacionSeleccionada,
                    fechaEntrada,
                    fechaSalida
            );

            // Agregar servicios adicionales
            for (Servicio servicio : servicios) {
                if (vista.confirmarServicio(servicio.getNombreServicio())) {
                    nuevaReserva.agregarServicio(servicio);
                }
            }

            // Agregar reserva al huésped
            huesped.agregarReserva(nuevaReserva);
            habitacionSeleccionada.setDisponibilidad(false);
            vista.mostrarMensaje("Reserva creada con éxito:");
            nuevaReserva.mostrarInformacionReserva();

        } catch (Exception e) {
            vista.mostrarMensaje("Error al crear la reserva: " + e.getMessage());
        }
    }
}
