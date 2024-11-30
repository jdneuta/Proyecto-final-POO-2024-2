/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Stiven
 */
public class Servicio {
    //Atributos 
    private String nombreServicio;
    private String descripcion;
    private double costoAdicional;
    private boolean disponibilidad;
    
    //getters y setters

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
    
    //Constructor parametrizado
    public Servicio(String nombreServicio, String descripcion, double costoAdicional, boolean disponibilidad) {
        this.nombreServicio = nombreServicio;
        this.descripcion = descripcion;
        this.costoAdicional = costoAdicional;
        this.disponibilidad = disponibilidad;
    }
    
    //Constructor sin parametros
    public Servicio() {
    }
    
    
    
        //prueba 7

}
