
package Modelo;

public class Huesped extends Usuario {

    // Constructor
    public Huesped(String nombre, String correo, String contrasena, String telefono) {
        super(nombre, correo, contrasena, telefono);
    }

    @Override
    public void registrar() {
        // Lógica para registrar un huésped
        System.out.println("Huésped registrado: " + nombre);
    }

    @Override
    public boolean iniciarSesion(String correo, String contrasena) {
        // Lógica para iniciar sesión
        return this.correo.equals(correo) && this.contrasena.equals(contrasena);
    }

    @Override
    public void cerrarSesion() {
        // Lógica para cerrar sesión
        System.out.println("Sesión cerrada para: " + nombre);
    }
}
