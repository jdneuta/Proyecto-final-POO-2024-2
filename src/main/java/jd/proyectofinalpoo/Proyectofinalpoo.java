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
        System.out.println("Hello World!");
        // prueba 2
        //Prueba 3
        System.out.println("Olacarebola");
        //Prueba numero 4
        //Stiven:
        //1.creo la clase Usuario en el package de modelo
        //2.creo la vista del usuario 
        //creacion del usuario 
        Usuario  us1 = new Usuario("Alan", "alan@unicauca.edu", "3132789213", "1", "03121");
        //creacion de la vista del usuario
        vista_usuario vus1 = new vista_usuario();
        //mostramos los detalles del usuario creando la vista
        vus1.mostrar_datos_usuario(us1);
        //Creacion de un servicio adicional
        Servicio serv1 = new Servicio("Spa", "Relájate en nuestro exclusivo spa, donde encontrarás tratamientos revitalizantes, masajes relajantes y un ambiente diseñado para tu bienestar total.", 10000, true);
        //Creacion de la vista del servicio
        Vista_servicio vser1= new Vista_servicio();
        vser1.vista_servicios(serv1);
    }
}
