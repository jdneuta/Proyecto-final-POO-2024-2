/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Stiven
 */
public class Habitacion {
    
    // Atributos
    private int id;
    private String tipo;
    private double precioNoche;
    private int capacidadMaxima;
    private boolean disponibilidad;
    private String descripcion;
    
    //getters y setter

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

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    //constructos parametrizado
    public Habitacion(int id, String tipo, double precioNoche, int capacidadMaxima, boolean disponibilidad, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.precioNoche = precioNoche;
        this.capacidadMaxima = capacidadMaxima;
        this.disponibilidad = disponibilidad;
        this.descripcion = descripcion;
    }
    
    //constructor sin parametros
    public Habitacion() {
    }
    
    
    
   
    
    
}
