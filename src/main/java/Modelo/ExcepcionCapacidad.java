package Modelo;

public class ExcepcionCapacidad extends Exception {
    private String mensaje;

    // Constructor
    public ExcepcionCapacidad(String mensaje) {
        this.mensaje = mensaje;
    }

    // Método para obtener el mensaje de la excepción
    public String getMensaje() {
        return mensaje;
    }
}