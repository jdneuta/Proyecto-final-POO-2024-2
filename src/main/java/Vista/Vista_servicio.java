/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author Stiven
 */
import Modelo.Servicio;
public class Vista_servicio {
    public void vista_servicios (Servicio servicio){
        System.out.println("Servicios Disponibles");
        System.out.println("Nombre: " + servicio.getNombreServicio());
        System.out.println("Descriocion: " + servicio.getDescripcion());
        System.out.println("Costo adicional: " + servicio.getCostoAdicional());
        System.out.println("Disponibilidad: " + servicio.isDisponibilidad());
    }
    
}
