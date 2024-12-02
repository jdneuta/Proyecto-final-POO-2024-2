package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private int idReserva;
    private Huesped huesped;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private List<Servicio> servicios; // Lista de servicios adicionales

    // Constructor
    public Reserva(int idReserva, Huesped huesped, Habitacion habitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.idReserva = idReserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.servicios = new ArrayList<>();
    }

    // Getters para las fechas de entrada y salida
    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    // Otros getters y métodos que ya tienes implementados

    // Método para manejar servicios
    public void agregarServicio(Servicio servicio) {
        if (servicio.isDisponibilidad() && servicio.getCantidadDisponible() > 0) {
            servicios.add(servicio);
            servicio.setCantidadDisponible(servicio.getCantidadDisponible() - 1);
            System.out.println("Servicio añadido: " + servicio.getNombreServicio());
        } else {
            System.out.println("El servicio no está disponible: " + servicio.getNombreServicio());
        }
    }

    // Método para calcular el costo total
    public double calcularCostoTotal() {
        // Calcular el número de noches
        long noches = java.time.temporal.ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);

        // Calcular costo base
        double costoBase = noches * habitacion.getPrecioNoche();

        // Sumar costos de servicios
        double costoServicios = servicios.stream().mapToDouble(Servicio::getCostoAdicional).sum();

        // Descuentos (ejemplo: 10% para estancias de más de 5 noches)
        double descuento = (noches > 5) ? costoBase * 0.1 : 0;

        // Costo total
        return costoBase + costoServicios - descuento;
    }

    // Método para mostrar información de la reserva
    public void mostrarInformacionReserva() {
        System.out.println("ID Reserva: " + idReserva);
        System.out.println("Huésped: " + huesped.getNombre());
        System.out.println("Habitación: " + habitacion.getTipo());
        System.out.println("Fechas: " + fechaEntrada + " a " + fechaSalida);
        System.out.println("Servicios adicionales:");
        for (Servicio servicio : servicios) {
            System.out.println("- " + servicio.getNombreServicio() + " ($" + servicio.getCostoAdicional() + ")");
        }
        System.out.println("Costo total: $" + calcularCostoTotal());
    }
}
