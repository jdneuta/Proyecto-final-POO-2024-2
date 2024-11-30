package Modelo;

public class ExcepcionFecha extends Exception {
    private String mensaje;

    // Constructor
    public ExcepcionFecha(String mensaje) {
        this.mensaje = mensaje;
    }

    // Método para obtener el mensaje de la excepción
    public String getMensaje() {
        return mensaje;
    }
}