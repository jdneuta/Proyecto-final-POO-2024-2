/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package jd.proyectofinalpoo;
import Modelo.*;
import Vista.*;



/**
 *
 * @author User
 */
public class Proyectofinalpoo {

    public static void main(String[] args) {
        //1.creo la clase Usuario en el package de modelo
        //2.creo la vista del usuario 
        //creacion del usuario 
        Usuario  us1 = new Usuario("Alan", "alan@unicauca.edu", "3132789213", "1", "03121");
        //creacion de la vista del usuario
        vista_usuario vus1 = new vista_usuario();
        //mostramos los detalles del usuario creando la vista
        vus1.mostrar_datos_usuario(us1);
        //Creacion de un servicio adicional
        Servicio serv1 = new Servicio("Spa", "Relajate en nuestro exclusivo spa, donde encontraras tratamientos revitalizantes, masajes relajantes y un ambiente disenado para tu bienestar total.", 10000, true);
        //Creacion de la vista del servicio
        Vista_servicio vser1= new Vista_servicio();
        vser1.vista_servicios(serv1);
        //PRUEBA 5
        // creamos una habitacion
        Habitacion habit1 = new Habitacion(0, "Suit de rey", 100000, 5, true, "Suite de lujo con diseno exclusivo, vistas panoramicas, jacuzzi privado y amenidades premium para una experiencia inolvidable.");
        //Creacion de la vista 
        Vista_Habitacion Vhabit1 = new Vista_Habitacion();
        Vhabit1.vista_habitacion(habit1);
        //pUERBA 6
    }
}
