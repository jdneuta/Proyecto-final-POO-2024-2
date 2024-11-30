/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author Stiven
 */
import Modelo.Habitacion;
public class Vista_Habitacion {
    public void vista_habitacion (Habitacion habitacion){
        System.out.println("Habitación ID: " + habitacion.getId());
        System.out.println("Tipo: " + habitacion.getTipo());
        System.out.println("Precio por noche: $" + habitacion.getPrecioNoche());
        System.out.println("Capacidad máxima: " + habitacion.getCapacidadMaxima());
        System.out.println("Descripción: " + habitacion.getDescripcion());
        System.out.println("Disponible: " + habitacion.isDisponibilidad());
    }
    
}
