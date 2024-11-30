/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author Stiven
 */
import Modelo.Usuario;
//Clase vista para mostrar los datos del usuario 
public class vista_usuario  {
    //Ingresamos como parametro un dato de tipo "Usuario" junto con una intancia la cual se llama usuario
    //esto con el fin de usar los atributos de usuario que se encuentran en otro pakage
    
    //Metodo para mostar los datos del usuario  
    public void mostrar_datos_usuario (Usuario usuario ){
        System.out.println("Datos del usuario");
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Email:" + usuario.getCorreo());
        System.out.println("Numero de usuario: " + usuario.getUsuario());
        System.out.println("Contraseña: " + usuario.getContraseña());
    
}
}
