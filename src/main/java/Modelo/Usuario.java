/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class Usuario {

    //Atributoss del usuario
    String nombre;
    String correo;
    String telefono;
    String usuario;
    String contraseña;
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getUsuario() {
        return usuario;
    }
    public String getContraseña() {
        return contraseña;
    }
    
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    //Constructor con parametros (Atributos)
    public Usuario(String nombre, String correo, String telefono, String usuario, String contraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    //Constructor sin parametros
    public Usuario() {
    }
    
    
    //prueba 7

}
