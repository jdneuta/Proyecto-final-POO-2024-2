package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Habitacion {
    private int id;
    private String tipo;
    private double precioNoche;
    private int capacidadMaxima;
    private boolean disponibilidad;
    private String descripcion;
    
    // Relación de asociación con Administrador
    private List<Administrador> administradores;
    
    // Relación de asociación con Reserva
    private List<Reserva> reservas;

    // Constructor
    public Habitacion(int id, String tipo, double precioNoche, int capacidadMaxima, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.precioNoche = precioNoche;
        this.capacidadMaxima = capacidadMaxima;
        this.descripcion = descripcion;
        this.disponibilidad = true; // Por defecto, la habitación está disponible
        this.administradores = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    // Método para definir la disponibilidad de la habitación
    public boolean definirDisponibilidad() {
        return this.disponibilidad;
    }

    // Método para actualizar el precio de la habitación
    public void actualizarPrecio(double precio) {
        this.precioNoche = precio;
    }

    // Métodos para gestionar administradores
    public void agregarAdministrador(Administrador administrador) {
        administradores.add(administrador);
    }

    public void eliminarAdministrador(Administrador administrador) {
        administradores.remove(administrador);
    }

    // Métodos para gestionar reservas
    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}