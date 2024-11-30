package Modelo;

public abstract class Usuario {
    protected String nombre;
    protected String correo;
    protected String telefono;
    protected String usuario;
    protected String contrasena;

    // Constructor
    public Usuario(String nombre, String correo, String telefono, String usuario, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

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

    public String getContrasena() {
        return contrasena;
    }

    // Setters
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

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Método para registrar al usuario (puede ser implementado en subclases)
    public abstract void registrar();

    // Método para iniciar sesión
    public boolean iniciarSesion(String correo, String contrasena) {
        return this.correo.equals(correo) && this.contrasena.equals(contrasena);
    }

    // Método para cerrar sesión
    public void cerrarSesion() {
        System.out.println("Sesión cerrada para el usuario: " + this.nombre);
    }
}