package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Servicio {
    private String nombreServicio;
    private String descripcion;
    private double costoAdicional;
    private boolean disponibilidad;
    private int cantidadDisponible;

    // Relación de asociación con Administrador
    private List<Administrador> administradores;

    // Relación de asociación con Reserva
    private List<Reserva> reservas;

    // Constructor
    public Servicio(String nombreServicio, String descripcion, double costoAdicional, int cantidadDisponible) {
        this.nombreServicio = nombreServicio;
        this.descripcion = descripcion;
        this.costoAdicional = costoAdicional;
        this.disponibilidad = cantidadDisponible > 0; // El servicio está disponible si hay cantidad
        this.cantidadDisponible = cantidadDisponible;
        this.administradores = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCostoAdicional() {
        return costoAdicional;
    }

    public void setCostoAdicional(double costoAdicional) {
        this.costoAdicional = costoAdicional;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
        this.disponibilidad = cantidadDisponible > 0; // Actualiza la disponibilidad
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