package Modelo;

import java.util.LinkedList;

public class Huesped extends Usuario {
    private LinkedList<Reserva> historialReservas;

    // Constructor
    public Huesped(String nombre, String correo, String telefono, String usuario, String contrasena) {
        super(nombre, correo, telefono, usuario, contrasena);
        this.historialReservas = new LinkedList<>();
    }

    // Método para agregar una reserva al historial
    public void agregarReserva(Reserva reserva) {
        historialReservas.add(reserva);
    }

    // Método para ver el historial de reservas
    public LinkedList<Reserva> verHistorial() {
        return historialReservas;
    }

    // Implementación del método registrar (puede ser personalizado según la lógica de negocio)
    @Override
    public void registrar() {
        // Lógica para registrar un huésped (puede incluir guardar en base de datos, etc.)
        System.out.println("Huésped registrado: " + this.nombre);
    }
}