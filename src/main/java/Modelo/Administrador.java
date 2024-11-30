package Modelo;

public class Administrador extends Usuario {

    // Constructor
    public Administrador(String nombre, String correo, String telefono, String usuario, String contrasena) {
        super(nombre, correo, telefono, usuario, contrasena);
    }

    // Método para gestionar habitaciones
    public void gestionarHabitaciones() {
        // Lógica para gestionar habitaciones (agregar, eliminar, modificar, etc.)
        System.out.println("Gestión de habitaciones realizada por: " + this.nombre);
    }

    // Método para gestionar servicios
    public void gestionarServicios() {
        // Lógica para gestionar servicios (agregar, eliminar, modificar, etc.)
        System.out.println("Gestión de servicios realizada por: " + this.nombre);
    }

    // Método para ver reservas
    public void verReservas() {
        // Lógica para ver reservas (puede incluir mostrar reservas actuales, pasadas, etc.)
        System.out.println("Visualizando reservas por: " + this.nombre);
    }

    // Método para generar reporte
    public void generarReporte() {
        // Lógica para generar un reporte (puede incluir estadísticas, informes, etc.)
        System.out.println("Generando reporte por: " + this.nombre);
    }

    // Implementación del método registrar (puede ser personalizado según la lógica de negocio)
    @Override
    public void registrar() {
        // Lógica para registrar un administrador (puede incluir guardar en base de datos, etc.)
        System.out.println("Administrador registrado: " + this.nombre);
    }
}
