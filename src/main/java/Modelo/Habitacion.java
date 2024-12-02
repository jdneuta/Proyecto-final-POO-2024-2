package Modelo;

public abstract class Habitacion {
    private int id;
    private int capacidadMaxima;
    private boolean disponibilidad;
    private String descripcion;

    public Habitacion(int id, int capacidadMaxima, String descripcion) {
        this.id = id;
        this.capacidadMaxima = capacidadMaxima;
        this.descripcion = descripcion;
        this.disponibilidad = true; // Por defecto, la habitación está disponible
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Métodos abstractos que serán implementados por las subclases
    public abstract double getPrecioNoche();
    public abstract String getTipo();

    // Método para mostrar información de la habitación (puede ser sobreescrito por subclases)
    public String mostrarInformacion() {
        return "ID: " + id + ", Capacidad: " + capacidadMaxima +
                ", Descripción: " + descripcion +
                ", Disponible: " + (disponibilidad ? "Sí" : "No");
    }
}
