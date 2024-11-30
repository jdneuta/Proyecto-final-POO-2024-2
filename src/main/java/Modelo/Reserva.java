package Modelo;

import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private Huesped huesped;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    // Constructor
    public Reserva(int idReserva, Huesped huesped, Habitacion habitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.idReserva = idReserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    // Getters
    public int getIdReserva() {
        return idReserva;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    // Método para realizar la reserva
    public void realizarReserva() {
        try {
            // Validación de capacidad
            if (habitacion.getCapacidadMaxima() <= 0) {
                throw new ExcepcionCapacidad("La habitación no tiene capacidad disponible.");
            }

            // Validación de fechas
            if (fechaEntrada.isAfter(fechaSalida)) {
                throw new ExcepcionFecha("La fecha de entrada no puede ser después de la fecha de salida.");
            }

            // Simulación de un proceso de pago
            boolean pagoRealizado = false; // Cambia esto según la lógica de tu aplicación
            if (!pagoRealizado) {
                throw new ExcepcionPago("El pago no se ha realizado correctamente.");
            }

            // Lógica para realizar la reserva (por ejemplo, guardar en base de datos)
            System.out.println("Reserva realizada con éxito: " + idReserva);

        } catch (ExcepcionCapacidad e) {
            System.out.println("Error de capacidad: " + e.getMensaje());
        } catch (ExcepcionFecha e) {
            System.out.println("Error de fecha: " + e.getMensaje());
        } catch (ExcepcionPago e) {
            System.out.println("Error de pago: " + e.getMensaje());
        }
    }

    // Método para mostrar información de la reserva (opcional)
    public void mostrarInformacionReserva() {
        System.out.println("ID Reserva: " + idReserva);
        System.out.println("Huésped: " + (huesped != null ? huesped.getNombre() : "No asignado"));
        System.out.println("Habitación ID: " + (habitacion != null ? habitacion.getId() : "No asignada"));
        System.out.println("Fecha de Entrada: " + fechaEntrada);
        System.out.println("Fecha de Salida: " + fechaSalida);
    }
}